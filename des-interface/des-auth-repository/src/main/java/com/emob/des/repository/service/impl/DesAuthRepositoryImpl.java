package com.emob.des.repository.service.impl;

import java.sql.Types;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.emob.des.repository.model.ClientAuthRowMapper;
import com.emob.des.rest.model.ClientAuth;
import com.emob.des.rest.service.DesAuthRepository;

public class DesAuthRepositoryImpl implements DesAuthRepository {

	private JdbcTemplate jdbcTemplate;
	DataSourceTransactionManager transactionManager;
	
	public DesAuthRepositoryImpl() {
		System.out.println("DesAuthRepositoryImpl..Constructor");
	}
	public DataSourceTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(
			DataSourceTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("DesAuthRepositoryImpl Init jdbcTemplate : " + jdbcTemplate);
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public ClientAuth getClientAuth(int orgId, int workflowId) {
		String SQL = "";
		Object[] params = null;
		if(workflowId > 0) {
			SQL = "select * from des_integration_auth where  org_id= ? AND workflow_id = ?"; 
			params = new Object[] {orgId, workflowId};
		} else {
			SQL = "select * from des_integration_auth where  org_id= ?"; 
			params = new Object[] {orgId};

		}
		List<ClientAuth> lst=jdbcTemplate.query(SQL,new ClientAuthRowMapper(),params);
		if(lst != null && lst.size() > 0) 
			return lst.get(0);
		else
			return null;
	}

	@Override
	public void updateClientAuth(final ClientAuth ca) {
		TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				String SQL = 
						"UPDATE des_integration_auth"+
								"   SET "+
								"       access_token = ?,"+
								"       access_token_secret = ?,"+
								"       attribute1 = ?,"+
								"       attribute2 = ?,"+
								"       attribute3 = ?,"+
								"       attribute4 = ?,"+
								"       attribute5 = ?,"+
								"       expiry_date = ?,"+
								"       updated_date = ?,"+
								"       updated_by = ?"+
								" WHERE id = ?";

				Object[] params = new Object[] { ca.getAccessToken(),
						ca.getAccessTokenSecret(), ca.getAttribute1(),
						ca.getAttribute2(), ca.getAttribute3(), ca.getAttribute4(),
						ca.getAttribute5(), ca.getExpiryDate(), new Date(),
						ca.getUpdatedBy(), ca.getId() };

				int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
						Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
						Types.DATE, Types.DATE, Types.VARCHAR, Types.INTEGER };

				jdbcTemplate.update(SQL, params, types);
			}
		});
	}
}