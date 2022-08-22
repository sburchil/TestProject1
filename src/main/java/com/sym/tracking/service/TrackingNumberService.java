package com.sym.tracking.service;

import java.util.List;

import com.sym.tracking.Entity.StatusCode;
import com.sym.tracking.Entity.TrackingNumber;

public interface TrackingNumberService {
	public List<TrackingNumber> getAllItemsWithOrderId(String orderId);

	public List<TrackingNumber> getAllItems();

	public List<StatusCode> getStatusCodes();

	public List<String> getAllCouriers();
	
}
