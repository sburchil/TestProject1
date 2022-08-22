package com.sym.tracking.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sym.tracking.DAO.CourierDAO;
import com.sym.tracking.Entity.Courier;
import com.sym.tracking.service.CourierService;

@Service
public class CourierServiceImpl implements CourierService {

	@Autowired
	CourierDAO objCourierDao;
	
	@Override
	public Courier addCourier(Courier objCourier) {
		return objCourierDao.addCourier(objCourier);
	}

	@Override
	public Courier getCourierById(long id) {
		return objCourierDao.getCourierById(id);
	}

	@Override
	public int updateCourier(Courier objCourier) {
		return objCourierDao.updateCourier(objCourier);
	}

	@Override
	public List<Courier> getAllCouriers(String searchedCourier) {
		return objCourierDao.getAllCouriers(searchedCourier);
	}

}
