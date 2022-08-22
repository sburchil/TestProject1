package com.sym.tracking.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sym.tracking.DAO.TrackingNumberDAO;
import com.sym.tracking.Entity.StatusCode;
import com.sym.tracking.Entity.TrackingNumber;
import com.sym.tracking.service.TrackingNumberService;

@Service
public class TrackingNumberServiceImpl implements TrackingNumberService{

	@Autowired
	TrackingNumberDAO objTrackingNumberDAO;
	
	@Override
	public List<TrackingNumber> getAllItemsWithOrderId(String orderId) {
		return objTrackingNumberDAO.getAllItemsWithOrderId(orderId);
	}

	@Override
	public List<TrackingNumber> getAllItems() {
		return objTrackingNumberDAO.getAllItems();
	}
	
	@Override
	public List<StatusCode> getStatusCodes() {
		return objTrackingNumberDAO.getStatusCodes();
	}

	@Override
	public List<String> getAllCouriers() {
		return objTrackingNumberDAO.getAllCouriers();
	}

}
