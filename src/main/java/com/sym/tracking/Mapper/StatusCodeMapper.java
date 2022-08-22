package com.sym.tracking.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sym.tracking.Entity.StatusCode;

public class StatusCodeMapper implements RowMapper<StatusCode> {

	@Override
	public StatusCode mapRow(ResultSet rs, int rowNum) throws SQLException {
		StatusCode statusCode = new StatusCode();
		
		statusCode.setStatusCodeId(rs.getInt("statusCodeId"));
		statusCode.setShortDescription(rs.getString("ShortDescription"));
		
		return statusCode;
	}

}
