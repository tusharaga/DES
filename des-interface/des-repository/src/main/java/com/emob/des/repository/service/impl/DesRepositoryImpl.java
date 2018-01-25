package com.emob.des.repository.service.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.emob.des.repository.model.IntegrationDetailRowMapper;
import com.emob.des.repository.model.IntegrationEntityRowMapper;
import com.emob.des.repository.model.IntegrationLogRowMapper;
import com.emob.des.repository.model.QBDesktopDetailRowMapper;
import com.emob.des.rest.model.EventContext;
import com.emob.des.rest.model.IntegrationDetail;
import com.emob.des.rest.model.IntegrationDetailWrapper;
import com.emob.des.rest.model.IntegrationEntityDetail;
import com.emob.des.rest.model.IntegrationEntitySearch;
import com.emob.des.rest.model.IntegrationLog;
import com.emob.des.rest.model.IntegrationLogDetail;
import com.emob.des.rest.model.IntegrationResponse;
import com.emob.des.rest.model.QBDesktopDetails;
import com.emob.des.rest.model.QBWrapper;
import com.emob.des.rest.service.DesRepository;
import com.emob.des.rest.utils.StringUtils;

public class DesRepositoryImpl implements DesRepository {

	public DesRepositoryImpl() {
		logger.info("DATA SOURCE : " + dataSource);
	}
	
	DataSourceTransactionManager transactionManager;
	private DataSource dataSource;
	private static Logger logger = LoggerFactory.getLogger(DesRepositoryImpl.class);

	public DataSourceTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(
			DataSourceTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		logger.info("DATA SOURCE SET: " + dataSource);
		this.dataSource = dataSource;
	}

	/**
	 * Method to create Integration log and Integration log detail entry used
	 * for keeping track of request and response messages and also used for
	 * retrying the process if fails. Insertion for both tables is done in same
	 * transaction.
	 */

	@Override
	public void createIntegrationlog(final IntegrationLogDetail logDetail) {
		TransactionTemplate transactionTemplate = new TransactionTemplate(
				transactionManager);
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(
					dataSource);

			@Override
			public void doInTransactionWithoutResult(TransactionStatus status) {
				// First create Integration Log and get the id to create entry
				// in Integration log detail
				String SQL = "INSERT INTO des_integration_log ("
						+ " 		org_id, workflow_id,"
						+ "		url,"
						+ "		success,"
						+ "		retry,"
						+ "		retry_count,"
						+ "		ticket_id,"
						+ "		event,"
						+ "		activity)"
						+ "		VALUES (:orgId,:workflowId,:url,:success,:retry,:retryCount,:ticketId,:event,:activity)";

				IntegrationLog log = logDetail.getIntegrationLog();
				SqlParameterSource fileParameters = new BeanPropertySqlParameterSource(
						log);
				KeyHolder keyHolder = new GeneratedKeyHolder();

				jdbcTemplate.update(SQL, fileParameters, keyHolder);
				int logId = keyHolder.getKey().intValue();
				log.setId(logId);
				if (logId > 0) {
					// create Integration Log Detail Entry for this Integration
					// Log
					SQL = "INSERT INTO des_integration_log_detail("
							+ " 		integration_log_fk,"
							+ "		request_body,"
							+ "		response_body)"
							+ "		VALUES (:integrationLog.id,:requestBody,:responseBody)";
					fileParameters = new BeanPropertySqlParameterSource(
							logDetail);

					jdbcTemplate.update(SQL, fileParameters);
				}
			}
		});
	}

	@Override
	public void updateResponse(EventContext eventContext) {
		final IntegrationLogDetail logDetail = eventContext
				.getIntegrationLogDetail();
		final IntegrationResponse integrationResponse = eventContext
				.getIntegrationResponse();
		if(integrationResponse != null) {
			// get the integration log id from logDetail and the response message
			// from integrationResponse and update it to the database
			TransactionTemplate transactionTemplate = new TransactionTemplate(
					transactionManager);
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(
						dataSource);

				@Override
				public void doInTransactionWithoutResult(TransactionStatus status) {
					String sql = "UPDATE des_integration_log SET"
							+ " success=1,retry=0 WHERE id = :id";
					MapSqlParameterSource paramMap = new MapSqlParameterSource(
							"id", logDetail.getIntegrationLog().getId());

					jdbcTemplate.update(sql, paramMap);

					sql = "UPDATE des_integration_log_detail"
							+ " SET response_body=:responseBody WHERE"
							+ " integration_log_fk=:integrationLogId";

					paramMap = new MapSqlParameterSource("responseBody",
							integrationResponse.getResponseMessage()).addValue(
									"integrationLogId", logDetail.getIntegrationLog()
									.getId());
					jdbcTemplate.update(sql, paramMap);
				}
			});
		}
	}

	@Override
	public List<IntegrationLogDetail> findFailedRequests() {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		String sql = "SELECT * FROM des_integration_log_detail ild,des_integration_log il"
				+ " WHERE il.success=0 AND il.retry_count < 5 AND il.retry=1"
				+ " AND ild.id = il.id" + " ORDER BY il.id ASC";

		List<IntegrationLogDetail> ildList = jdbcTemplate.query(sql,
				new IntegrationLogRowMapper());
		return ildList;
	}

	@Override
	public boolean isPreviousAttempsFailed(String tickedNo, int orgId) {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		String sql = "SELECT id FROM des_integration_log WHERE retry = 1 AND ticket_id=:ticketId AND org_id =:orgId";
		MapSqlParameterSource paramMap = new MapSqlParameterSource("ticketId",
				tickedNo).addValue("orgId", orgId);
		SqlRowSet queryForRowSet = jdbcTemplate.queryForRowSet(sql, paramMap);
		if (queryForRowSet != null && queryForRowSet.getRow() > 0)
			return true;
		return false;
	}

	@Override
	public void createIntegrationEntityDetail(
			final IntegrationEntityDetail integrationDetail) {
		if(integrationDetail != null) {
			TransactionTemplate transactionTemplate = new TransactionTemplate(
					transactionManager);
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(
						dataSource);
				@Override
				public void doInTransactionWithoutResult(TransactionStatus status) {
					String SQL = "INSERT INTO des_integration_entity_detail ("
							+ " 		org_id, workflow_id,"
							+ "		fieldez_entity_id,"
							+ "		external_entity_id,"
							+ "		entity_type,"
							+ "		attribute1,"
							+ "		attribute2,"
							+ "		attribute3,"
							+ "		attribute4,"
							+ "		attribute5)"
							+ "		VALUES (:orgId,:workflowId,:fieldezEntityId,"
							+ "		:externalEntityId,:entityType,:attribute1,"
							+ "		:attribute2,:attribute3,:attribute4,:attribute5)";

					SqlParameterSource fileParameters = new BeanPropertySqlParameterSource(
							integrationDetail);
					KeyHolder keyHolder = new GeneratedKeyHolder();
					jdbcTemplate.update(SQL, fileParameters, keyHolder);
				}
			});
		}
	}

	@Override
	public IntegrationEntityDetail getIntegrationEntityDetailByType(IntegrationEntitySearch entitySearch) {
		if(entitySearch != null) {
			if(entitySearch.getOrgId() > 0 ) {
				NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(
						dataSource);
				StringBuilder sb = new StringBuilder("SELECT * FROM des_integration_entity_detail WHERE org_id=:orgId");
				MapSqlParameterSource paramMap = new MapSqlParameterSource("orgId", entitySearch.getOrgId());
				if(entitySearch.getWorkflowId() > 0) {
					sb.append(" AND workflow_id=:workflowId");
					paramMap.addValue("workflowId", entitySearch.getWorkflowId());
				}
				if(StringUtils.hasText(entitySearch.getEntityType())) {
					sb.append(" AND entity_type=:entityType");					
					paramMap.addValue("entityType", entitySearch.getEntityType());
				}
				if(entitySearch.getFieldezEntityId() > 0) {
					sb.append(" AND fieldez_entity_id=:fieldezEntityId");
					paramMap.addValue("fieldezEntityId", entitySearch.getFieldezEntityId());
				}
				if(StringUtils.hasText(entitySearch.getExternalEntityId())) {
					sb.append(" AND external_entity_id=:externalEntityId");
					paramMap.addValue("externalEntityId", entitySearch.getExternalEntityId());
				}
				if(StringUtils.hasText(entitySearch.getAttribute1())) {
					sb.append(" AND attribute1=:attribute1");
					paramMap.addValue("attribute1", entitySearch.getAttribute1());
				}
				if(StringUtils.hasText(entitySearch.getAttribute2())) {
					sb.append(" AND attribute2=:attribute2");
					paramMap.addValue("attribute2", entitySearch.getAttribute2());
				}
				if(StringUtils.hasText(entitySearch.getAttribute3())) {
					sb.append(" AND attribute3=:attribute3");
					paramMap.addValue("attribute3", entitySearch.getAttribute3());
				}
				if(StringUtils.hasText(entitySearch.getAttribute4())) {
					sb.append(" AND attribute4=:attribute4");
					paramMap.addValue("attribute4", entitySearch.getAttribute4());
				}
				if(StringUtils.hasText(entitySearch.getAttribute5())) {
					sb.append(" AND attribute5=:attribute5");
					paramMap.addValue("attribute5", entitySearch.getAttribute5());
				}
				
				List<IntegrationEntityDetail> iedList = jdbcTemplate.query(sb.toString(), paramMap, new IntegrationEntityRowMapper());
				if(iedList != null && iedList.size() > 0) 
					return
							iedList.get(0);
			}
		}
		return null;
	}
	
	//Added by Ashwani Patel
	@Override
	public IntegrationDetail getIntegrationDetailByOrgId(String orgId) {
		logger.info("org id : " + orgId);
		if((orgId != null) && (!orgId.isEmpty())) {
			NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(
					dataSource);
			StringBuilder sb = new StringBuilder("SELECT * FROM des_integration_details WHERE org_id=:orgId");
			MapSqlParameterSource paramMap = new MapSqlParameterSource("orgId", orgId);
			List<IntegrationDetail> integrationDetalsList=null;
			try {
				integrationDetalsList = jdbcTemplate.query(sb.toString(), paramMap, new IntegrationDetailRowMapper());
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
			}
//			logger.info("integrationDetalsList : " + integrationDetalsList);
			if(integrationDetalsList != null && integrationDetalsList.size() > 0)
//				logger.info("integrationDetalsList size : " + integrationDetalsList.size());
				return	integrationDetalsList.get(0);
		}
		return null;
	}
	
	@Override
	public IntegrationDetailWrapper getIntegrationDetailByName(String name) {
		IntegrationDetailWrapper wrapper = new IntegrationDetailWrapper();
		if((name != null) && (!name.isEmpty())) {
			NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(
					dataSource);
			StringBuilder sb = new StringBuilder("SELECT * FROM des_integration_details WHERE name=:name");
			MapSqlParameterSource paramMap = new MapSqlParameterSource("name", name);
			List<IntegrationDetail> integrationDetailsList = jdbcTemplate.query(sb.toString(), paramMap, new IntegrationDetailRowMapper());
//			logger.info("qbDesktopDetailsList : " + qbDesktopDetailsList);
			if(integrationDetailsList != null && integrationDetailsList.size() > 0)
//				logger.info("integrationDetalsList size : " + qbDesktopDetailsList.size());
				wrapper.setList(integrationDetailsList);				
		}
		return wrapper;
	}

	@Override
	public QBWrapper getQBDetailsByOrgId(String orgId) {
//		logger.info("getting qbDetailsByOrgId :" + orgId);
		QBWrapper qbWrapper = new QBWrapper();
		if((orgId != null) && (!orgId.isEmpty())) {
			NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(
					dataSource);
			StringBuilder sb = new StringBuilder("SELECT * FROM qb_desktop_details WHERE orgId=:orgId");
			MapSqlParameterSource paramMap = new MapSqlParameterSource("orgId", orgId);
			List<QBDesktopDetails> qbDesktopDetailsList = jdbcTemplate.query(sb.toString(), paramMap, new QBDesktopDetailRowMapper());
			logger.info("qbDesktopDetailsList : " + qbDesktopDetailsList);
			if(qbDesktopDetailsList != null && qbDesktopDetailsList.size() > 0)
				logger.info("integrationDetalsList size : " + qbDesktopDetailsList.size());
				qbWrapper.setList(qbDesktopDetailsList);				
		}
		return qbWrapper;
	}

	@Override
	public QBWrapper getQBDetailsByName(String name) {
		QBWrapper qbWrapper = new QBWrapper();
		if((name != null) && (!name.isEmpty())) {			
			NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(
					dataSource);
			StringBuilder sb = new StringBuilder("SELECT * FROM qb_desktop_details WHERE name=:name");
			MapSqlParameterSource paramMap = new MapSqlParameterSource("name", name);
			List<QBDesktopDetails> qbDesktopDetailsList = jdbcTemplate.query(sb.toString(), paramMap, new QBDesktopDetailRowMapper());
//			logger.info("qbDesktopDetailsList : " + qbDesktopDetailsList);
			if(qbDesktopDetailsList != null && qbDesktopDetailsList.size() > 0)
//				logger.info("integrationDetalsList size : " + qbDesktopDetailsList.size());
				qbWrapper.setList(qbDesktopDetailsList);
		}
		return qbWrapper;
	}

	@Override
	public QBWrapper getQBDetailsByName(String name, Boolean active) {
		QBWrapper qbWrapper = new QBWrapper();
		if((name != null) && (!name.isEmpty())) {
			NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(
					dataSource);
			StringBuilder sb = new StringBuilder("SELECT * FROM qb_desktop_details WHERE name=:name and qb_active = :active");
			MapSqlParameterSource paramMap = new MapSqlParameterSource("name", name);
			paramMap.addValue("active", active);
			List<QBDesktopDetails> qbDesktopDetailsList=null;
			try {
				qbDesktopDetailsList = jdbcTemplate.query(sb.toString(), paramMap, new QBDesktopDetailRowMapper());
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
			}
//			logger.info("qbDesktopDetailsList : " + qbDesktopDetailsList);
			if(qbDesktopDetailsList != null && qbDesktopDetailsList.size() > 0)
//				logger.info("integrationDetalsList size : " + qbDesktopDetailsList.size());
				qbWrapper.setList(qbDesktopDetailsList);
		}
		return qbWrapper;
	}

	@Override
	public void saveQBDesktopDetails(String orgId, String name, String qbxmlReguest,String qbxmlResponse,boolean qb_active,Boolean emob_active) {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		String sql = "INSERT INTO qb_desktop_details (orgId,name,qbxmlReguest,qbxmlResponse,qb_active,emob_active) values(:orgId,:name,:qbxmlReguest,:qbxmlResponse,:qb_active,:emob_active)";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgId", orgId);
		map.put("name", name);
		map.put("qbxmlReguest", qbxmlReguest);
		map.put("qbxmlResponse", qbxmlResponse);
		map.put("qb_active", qb_active);
		map.put("emob_active", emob_active);
		try {
			jdbcTemplate.execute(sql, map, new PreparedStatementCallback<Object>() {

				@Override
				public Object doInPreparedStatement(PreparedStatement ps)
						throws SQLException, DataAccessException {
					
					return ps.executeUpdate();
				}
			});
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
	}

	@Override
	public void updateQBDesktopDetailsQBRef(String id, String name, String qbxmlResponse,Boolean qb_active) {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		String sql = "UPDATE qb_desktop_details SET qbxmlResponse =:qbxmlResponse,qb_active =:qb_active WHERE id=:id AND name=:name";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", name);
		map.put("qbxmlResponse", qbxmlResponse);
		map.put("qb_active", qb_active);
		try {
			jdbcTemplate.execute(sql, map, new PreparedStatementCallback<Object>() {

				@Override
				public Object doInPreparedStatement(PreparedStatement ps)
						throws SQLException, DataAccessException {
					
					return ps.executeUpdate();
				}
			});
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
	}
	
	@Override
	public void updateQBDesktopDetailsEmobRef(String id, String name, String qbxmlResponse,Boolean emob_active) {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		String sql = "UPDATE qb_desktop_details SET emob_active =:emob_active WHERE id=:id AND name=:name";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", name);
		map.put("emob_active", emob_active);
		try {
			jdbcTemplate.execute(sql, map, new PreparedStatementCallback<Object>() {

				@Override
				public Object doInPreparedStatement(PreparedStatement ps)
						throws SQLException, DataAccessException {
					
					return ps.executeUpdate();
				}
			});
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
	}

	@Override
	public void updateLastsyncTime(String name, String password, String timeStamp) {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
//		Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());
		String sql = "UPDATE des_integration_details SET last_sync_time =:currentTimestamp WHERE password=:password AND name=:name";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("password", password);
		map.put("name", name);
		map.put("currentTimestamp", timeStamp);
		try {
			jdbcTemplate.execute(sql, map, new PreparedStatementCallback<Object>() {

				@Override
				public Object doInPreparedStatement(PreparedStatement ps)
						throws SQLException, DataAccessException {
					
					return ps.executeUpdate();
				}
			});
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
	}

	
}