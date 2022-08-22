package com.sym.tracking.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sym.tracking.Entity.Courier;
import com.sym.tracking.Entity.StatusCode;
import com.sym.tracking.Entity.TrackingNumber;

@Controller
public class CourierController extends AbstractController{
	
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showIndex(HttpServletRequest req, Model model) {
		
		List<TrackingNumber> trackingNumberByOrderId = objTrackingNumberService.getAllItemsWithOrderId("5117");
		List<String> allCouriers = objTrackingNumberService.getAllCouriers();
		
		model.addAttribute("CartonItems", trackingNumberByOrderId);
		model.addAttribute("Couriers", allCouriers);
		
		
		return "index";
	}

	@RequestMapping(value = "/courier", method = RequestMethod.GET)
	public String showCourier(HttpServletRequest reques, Model model) {
		List<StatusCode> statusCodes = objTrackingNumberService.getStatusCodes();
		model.addAttribute("StatusCodes", statusCodes);
		model.addAttribute("addMessage" , "");
		return "courier";
	}
	
	@RequestMapping(value = "/addcourier", method = RequestMethod.POST)
	public String addCourier(@RequestParam Map<String, String> params, Model model) {
		List<StatusCode> statusCodes = objTrackingNumberService.getStatusCodes();
		model.addAttribute("StatusCodes", statusCodes);

		Courier objCourier = createCourier(params);
		Courier returnedCourier = objCourierService.addCourier(objCourier);
		if(returnedCourier != null) {
			StringBuilder sb = new StringBuilder("Courier '" + returnedCourier.getCourierName() + "' added successfully");
			model.addAttribute("Courier", objCourier);
			model.addAttribute("addMessage", sb.toString());
			model.addAttribute("showUpdate", true);
			model.addAttribute("courierId", returnedCourier.getCourierId());
			return "courier";
		} else {
			model.addAttribute("addMessage", "Courier not added");
			model.addAttribute("showAdd", true);
			return "courier";
		}
	}

	@RequestMapping(value = "/updatecourier", method = RequestMethod.POST)
	public String updateCourier(@RequestParam Map<String, String> params, Model model){
		List<StatusCode> statusCodes = objTrackingNumberService.getStatusCodes();
		model.addAttribute("StatusCodes", statusCodes);

		String courierId = params.get("courierId");
		if(courierId.isEmpty()){
			System.out.println("Courier Id is empty");
		} 
		Courier objCourier = updateCourierObject(params, Long.valueOf(courierId));
		int updateCount = objCourierService.updateCourier(objCourier);	

		if(updateCount > 0){
			Courier updatedCourier = objCourierService.getCourierById(Long.valueOf(courierId));
			StringBuilder sb = new StringBuilder("Courier '" + objCourier.getCourierName() + "' updated successfully");
			model.addAttribute("Courier", updatedCourier);
			model.addAttribute("updateMessage", sb.toString());
			model.addAttribute("showUpdate", true);
			model.addAttribute("courierId", updatedCourier.getCourierId());
		} else {
			model.addAttribute("updateMessage", "Courier not updated");
			model.addAttribute("showUpdate", true);
			model.addAttribute("courierId", objCourier.getCourierId());

		}
		return "courier";
	}
	
	@RequestMapping(value = "/searchcourier", method = RequestMethod.POST)
	public String searchCourier(@RequestParam(name="SearchedQuery") String searchedCourier, Model model){
		List<StatusCode> statusCodes = objTrackingNumberService.getStatusCodes();
		model.addAttribute("StatusCodes", statusCodes);

		List<Courier> couriers = objCourierService.getAllCouriers(searchedCourier + "%");
		if(couriers.size() > 0){
			model.addAttribute("Couriers", couriers);
			model.addAttribute("searchResults", true);
			model.addAttribute("searchCrit", "<li>Results for "+searchedCourier+"</li>");
		} else {
			model.addAttribute("searchMessage", "No couriers found");
			model.addAttribute("failedSearch", true);
		}
		return "courier";
	}

	@RequestMapping(value = "/submitform", method = RequestMethod.POST)
	public String submitForm(@RequestParam Map<String, String> requestParams, Model model) {
		
		requestParams.forEach((key, value) -> {
			System.out.println(key + ": " + value);
		});
		return  "index";
	}
	
	public Courier createCourier(Map<String, String> params) {
		Courier objCourier = new Courier();
		
		params.forEach((key, value) -> {
			switch (key) {
			case "CourierName":
				objCourier.setCourierName(value);
				break;
			case "CourierCode":
				objCourier.setCourierCode(value);
				break;
			case "CourierContactName":
				objCourier.setCourierContactName(value);
				break;
			case "CourierContactNumber":
				objCourier.setCourierContactNumber(value);
				break;
			case "CourierWebSite":
				objCourier.setCourierWebSite(value);
				break;
			case "CourierContactEmail":
				objCourier.setCourierContactEmail(value);
				break;
			case "CourierAddress":
				objCourier.setCourierAddress(value);
				break;
			case "CourierNotes":
				objCourier.setCourierNotes(value);
				break;
			case "CourierStatus":
				objCourier.setCourierStatus(value);
				break;
			case "CourierSLA":
				objCourier.setCourierSLA(value);
				break;
			case "CourierTrackingFormat":
				objCourier.setCourierTrackingIdFormat(value);
				break;
			case "CourierTrackingMsg":
				objCourier.setCourierTrackingIdMsg(value);
				break;
			}
		});
		
		objCourier.setCreatedDate(sdf.format(new Date()));
		return objCourier;
	}

	public Courier updateCourierObject(Map<String, String> params, long courierId) {
		Courier objCourier = new Courier();
		
		params.forEach((key, value) -> {
			switch (key) {
			case "CourierName":
				objCourier.setCourierName(value);
				break;
			case "CourierCode":
				objCourier.setCourierCode(value);
				break;
			case "CourierContactName":
				objCourier.setCourierContactName(value);
				break;
			case "CourierContactNumber":
				objCourier.setCourierContactNumber(value);
				break;
			case "CourierWebSite":
				objCourier.setCourierWebSite(value);
				break;
			case "CourierContactEmail":
				objCourier.setCourierContactEmail(value);
				break;
			case "CourierAddress":
				objCourier.setCourierAddress(value);
				break;
			case "CourierNotes":
				objCourier.setCourierNotes(value);
				break;
			case "CourierStatus":
				objCourier.setCourierStatus(value);
				break;
			case "CourierSLA":
				objCourier.setCourierSLA(value);
				break;
			case "CourierTrackingFormat":
				objCourier.setCourierTrackingIdFormat(value);
				break;
			case "CourierTrackingMsg":
				objCourier.setCourierTrackingIdMsg(value);
				break;
			}
		});
		objCourier.setCourierId(courierId);
		objCourier.setModifiedDate(sdf.format(new Date()));
		return objCourier;
	}
	
}
