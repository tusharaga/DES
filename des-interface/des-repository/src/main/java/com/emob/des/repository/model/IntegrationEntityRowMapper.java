package com.emob.des.repository.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.emob.des.rest.model.IntegrationEntityDetail;

public class IntegrationEntityRowMapper implements
		RowMapper<IntegrationEntityDetail> {

	public IntegrationEntityDetail mapRow(ResultSet rs, int rowNum)
			throws SQLException {

		int id = rs.getInt("id");
		int orgId = rs.getInt("org_id");
		int workflowId = rs.getInt("workflow_id");
		int fieldezEntityId = rs.getInt("fieldezEntityId");
		String externalEntityId = rs.getString("externalEntityId");
		String entityType = rs.getString("entityType");
		String attribute1 = rs.getString("attribute1");
		String attribute2 = rs.getString("attribute2");
		String attribute3 = rs.getString("attribute3");
		String attribute4 = rs.getString("attribute4");
		String attribute5 = rs.getString("attribute5");

		IntegrationEntityDetail ied = new IntegrationEntityDetail(id, orgId,
				workflowId, fieldezEntityId, externalEntityId, entityType,
				attribute1, attribute2, attribute3, attribute4, attribute5);

		return ied;
	}

}
