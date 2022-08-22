package com.sym.tracking.DAO;

import java.util.List;

import com.sym.tracking.Entity.Courier;

public interface CourierDAO {

	public Courier addCourier(Courier objCourier);

	public Courier getCourierById(long id);

	public int updateCourier(Courier objCourier);

	public List<Courier> getAllCouriers(String searchedCourier);
}
