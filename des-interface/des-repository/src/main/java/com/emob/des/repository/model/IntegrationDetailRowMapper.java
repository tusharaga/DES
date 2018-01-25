package com.emob.des.repository.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.emob.des.rest.model.IntegrationDetail;

public class IntegrationDetailRowMapper implements RowMapper<IntegrationDetail> {

	@Override
	public IntegrationDetail mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		int id = rs.getInt("id");
		int orgId = rs.getInt("org_id");
		int workflowId = rs.getInt("workflow_id");
		String qbparent_xml = rs.getString("qbparent_xml");
		String service_type = rs.getString("service_type");
		String name= rs.getString("name");
		String password= rs.getString("password");
		String last_sync_time = rs.getString("last_sync_time");
		String apiKey = rs.getString("apiKey");
		String apiToken = rs.getString("apiToken");
		IntegrationDetail integrationDetail = new IntegrationDetail(id, orgId,
				workflowId, qbparent_xml,service_type,name,password,last_sync_time,apiKey,apiToken);
		return integrationDetail;
	}

}
