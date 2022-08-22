package com.sym.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.sym.tracking.service.CourierService;
import com.sym.tracking.service.TrackingNumberService;

public abstract class AbstractController {

	@Autowired
	TrackingNumberService objTrackingNumberService;
	
	@Autowired
	CourierService objCourierService;
}
