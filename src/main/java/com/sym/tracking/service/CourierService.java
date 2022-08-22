package com.sym.tracking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sym.tracking.Entity.Courier;

public interface CourierService {

	public Courier addCourier(Courier objCourier);

	public Courier getCourierById(long id);

	public int updateCourier(Courier objCourier);

	public List<Courier> getAllCouriers(String searchedCourier);

}
