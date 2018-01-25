package com.emob.des.repository.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.emob.des.rest.model.QBDesktopDetails;

public class QBDesktopDetailRowMapper implements RowMapper<QBDesktopDetails> {

	@Override
	public QBDesktopDetails mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		int id = rs.getInt("id");
		int orgId = rs.getInt("orgId");
		String name = rs.getString("name");
		String qbxmlReguest = rs.getString("qbxmlReguest");
		String qbxmlResponse = rs.getString("qbxmlResponse");
		Boolean qb_active = rs.getBoolean("qb_active");
		Boolean emob_active = rs.getBoolean("emob_active");

		QBDesktopDetails desktopDetails = new QBDesktopDetails(id, orgId, name,
				qbxmlReguest, qbxmlResponse, qb_active,emob_active);
		return desktopDetails;
	}
}
