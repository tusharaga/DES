package com.emob.des.repository.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.emob.des.rest.model.IntegrationLog;
import com.emob.des.rest.model.IntegrationLogDetail;

public class IntegrationLogRowMapper implements RowMapper<IntegrationLogDetail> {

	public IntegrationLogDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int integrationLogId = rs.getInt("integration_log_fk");
		int orgId = rs.getInt("org_id");
		int workflowId = rs.getInt("workflow_id");
		String requestBody = rs.getString("request_body");
		String responseBody = rs.getString("response_body");
		String url = rs.getString("url");
		boolean success = rs.getBoolean("success");
		boolean retry = rs.getBoolean("retry");
		int retryCount = rs.getInt("retry_count");
		String ticketId = rs.getString("ticket_id");
		String event = rs.getString("event");
		String activity = rs.getString("activity");

		IntegrationLog integrationLog = new IntegrationLog(integrationLogId,orgId, workflowId,
				ticketId, url, event, activity, retry, success, retryCount);

		IntegrationLogDetail ild = new IntegrationLogDetail(integrationLog,
				requestBody, responseBody);

		return ild;
	}

}
