package com.sym.tracking.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sym.tracking.Entity.TrackingNumber;

public class TrackingNumberMapper implements RowMapper<TrackingNumber> {

	@Override
	public TrackingNumber mapRow(ResultSet rs, int rowNum) throws SQLException {
		TrackingNumber trackingNumber = new TrackingNumber();
		
		trackingNumber.setOrderId(rs.getString("OrderId"));
		trackingNumber.setRecordIdentifier(rs.getString("RecordIdentifier"));
		trackingNumber.setCourier(rs.getString("Courier"));
		trackingNumber.setTrackingNumber(rs.getString("TrackingNumber"));
		trackingNumber.setRecordType(rs.getString("RecordType"));
		
		return trackingNumber;
	}

}
