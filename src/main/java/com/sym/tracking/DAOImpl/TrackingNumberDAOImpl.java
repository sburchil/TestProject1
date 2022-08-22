package com.sym.tracking.DAOImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sym.tracking.DAO.TrackingNumberDAO;
import com.sym.tracking.Entity.StatusCode;
import com.sym.tracking.Entity.TrackingNumber;
import com.sym.tracking.Mapper.StatusCodeMapper;
import com.sym.tracking.Mapper.TrackingNumberMapper;

@Repository
public class TrackingNumberDAOImpl implements TrackingNumberDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("deprecation")
	@Override
	public List<TrackingNumber> getAllItemsWithOrderId(String orderId) {
		
		String query = "SELECT * FROM tracking_number.couriertracking WHERE OrderId = ?";
	
		List<TrackingNumber> result = jdbcTemplate.query(query, new Object[] {orderId}, new TrackingNumberMapper());
	
		return result;
	}
	
	@Override
	public List<StatusCode> getStatusCodes(){
		String query = "SELECT * FROM status_codes";
		
		List<StatusCode> result = jdbcTemplate.query(query, new StatusCodeMapper());
		
		return result;
	}

	@Override
	public List<TrackingNumber> getAllItems() {
		String getAllItems = "SELECT OrderId,Courier,TrackingNumber,RecordIdentifier,RecordType FROM couriertracking";
		
		List<TrackingNumber> result = jdbcTemplate.query(getAllItems, new TrackingNumberMapper());
		
		return result;
	}

	@Override
	public List<String> getAllCouriers() {
		String getAllCouriers = "SELECT CourierName FROM courier";
		
		List<String> result = jdbcTemplate.queryForList(getAllCouriers, String.class);
		return result;
	}
	
	
}
