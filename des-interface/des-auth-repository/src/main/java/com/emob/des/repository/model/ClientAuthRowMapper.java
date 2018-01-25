package com.emob.des.repository.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.emob.des.rest.model.ClientAuth;

public class ClientAuthRowMapper implements RowMapper<ClientAuth> {

	public ClientAuth mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String accessToken = rs.getString("access_token");
		String accessTokenSecret = rs.getString("access_token_secret");
		Date expiryDate = rs.getDate("expiry_date");
		Date createDate = rs.getDate("created_date");
		Date updatedDate = rs.getDate("updated_date");
		String updatedBy = rs.getString("updated_by");
		int orgId = rs.getInt("org_id");
		int workflowId = rs.getInt("workflow_id");
		String attribute1 = rs.getString("attribute1");
		String attribute2 = rs.getString("attribute2");
		String attribute3 = rs.getString("attribute3");
		String attribute4 = rs.getString("attribute4");
		String attribute5 = rs.getString("attribute5");
		boolean active = rs.getBoolean("active");

		ClientAuth ud = new ClientAuth(id,accessToken, accessTokenSecret,
				expiryDate, createDate, updatedDate, updatedBy, orgId,
				workflowId, attribute1, attribute2, attribute3, attribute4,
				attribute5, active);
		
		return ud;
	}

}