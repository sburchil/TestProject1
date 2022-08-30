package com.sym.tracking.Mapper;

import org.springframework.jdbc.core.RowMapper;

import com.sym.tracking.Entity.Courier;

public class CourierRowMapper implements RowMapper<Courier> {

    @Override
    public Courier mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
        Courier objCourier = new Courier();
        objCourier.setCourierId(rs.getLong("courierId"));
        
        if(rs.getString("courierName") != null) {
            objCourier.setCourierName(rs.getString("courierName"));
        }
        if(rs.getString("courierContactName") != null) {
            objCourier.setCourierContactName(rs.getString("courierContactName"));
        }
        if(rs.getString("courierWebSite") != null) {
            objCourier.setCourierWebSite(rs.getString("courierWebSite"));
        }
        if(rs.getString("courierContactNumber") != null) {
            objCourier.setCourierContactNumber(rs.getString("courierContactNumber"));
        }
        if(rs.getString("courierAddress") != null) {
            objCourier.setCourierAddress(rs.getString("courierAddress"));
        }
        if(rs.getString("courierContactEmail") != null) {
            objCourier.setCourierContactEmail(rs.getString("courierContactEmail"));
        }
        if(rs.getString("courierNotes") != null) {
            objCourier.setCourierNotes(rs.getString("courierNotes"));
        }
        if(rs.getString("courierStatus") != null) {
            objCourier.setCourierStatus(rs.getString("courierStatus"));
        }
        if(rs.getString("courierSLA") != null) {
            objCourier.setCourierSLA(rs.getString("courierSLA"));
        }
        if(rs.getString("courierTrackingIdFormat") != null) {
            objCourier.setCourierTrackingIdFormat(rs.getString("courierTrackingIdFormat"));
        }
        if(rs.getString("courierTrackingIdMsg") != null) {
            objCourier.setCourierTrackingIdMsg(rs.getString("courierTrackingIdMsg"));
        }
        if(rs.getString("createdDate") != null) {
            objCourier.setCreatedDate(rs.getString("createdDate"));
        }
        if(rs.getString("modifiedDate") != null) {
            objCourier.setModifiedDate(rs.getString("modifiedDate"));
        }

        return objCourier;
    }

}

