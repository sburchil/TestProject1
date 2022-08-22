package com.sym.tracking.Mapper;

import org.springframework.jdbc.core.RowMapper;

import com.sym.tracking.Entity.Courier;

public class CourierRowMapper implements RowMapper<Courier> {

    @Override
    public Courier mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
        Courier objCourier = new Courier();
        objCourier.setCourierId(rs.getLong("courierId"));
        objCourier.setCourierName(rs.getString("courierName"));
        objCourier.setCourierContactName(rs.getString("courierContactName"));
        objCourier.setCourierWebSite(rs.getString("courierWebSite"));
        objCourier.setCourierContactNumber(rs.getString("courierContactNumber"));
        objCourier.setCourierAddress(rs.getString("courierAddress"));
        objCourier.setCourierContactEmail(rs.getString("courierContactEmail"));
        objCourier.setCourierNotes(rs.getString("courierNotes"));
        objCourier.setCourierSLA(rs.getString("courierSLA"));
        objCourier.setCourierStatus(rs.getString("courierStatus"));
        objCourier.setCourierTrackingIdFormat(rs.getString("courierTrackingIdFormat"));
        objCourier.setCourierTrackingIdMsg(rs.getString("courierTrackingIdMsg"));
        objCourier.setCreatedDate(rs.getString("createdDate"));
        objCourier.setModifiedDate(rs.getString("modifiedDate"));

        return objCourier;
    }

}

