package com.sym.tracking.Entity;

import java.util.Date;

public class Courier {
	private long courierId;
	private String courierName;
	private String courierCode;
	private String courierContactName;
	private String courierWebSite;
	private String courierContactNumber;
	private String courierAddress;
	private String courierContactEmail;
	private String courierNotes;
	private String courierSLA;
	private String courierStatus;
	private String courierTrackingIdFormat;
	private String courierTrackingIdMsg;
	private String createdDate;
	private String modifiedDate;
	
	@Override
	public String toString(){
		return "Courier [courierId=" + courierId + ", courierName=" + courierName + ", courierCode=" + courierCode
				+ ", courierContactName=" + courierContactName + ", courierWebSite=" + courierWebSite
				+ ", courierContactNumber=" + courierContactNumber + ", courierAddress=" + courierAddress
				+ ", courierContactEmail=" + courierContactEmail + ", courierNotes=" + courierNotes + ", courierSLA="
				+ courierSLA + ", courierStatus=" + courierStatus + ", courierTrackingIdFormat=" + courierTrackingIdFormat
				+ ", courierTrackingIdMsg=" + courierTrackingIdMsg + ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + "]";
	}

	public Long getCourierId() {
		return courierId;
	}
	public void setCourierId(Long courierId) {
		this.courierId = courierId;
	}
	public String getCourierName() {
		return courierName;
	}
	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}
	public String getCourierCode() {
		return courierCode;
	}
	public void setCourierCode(String courierCode) {
		this.courierCode = courierCode;
	}
	public String getCourierContactName() {
		return courierContactName;
	}
	public void setCourierContactName(String courierContactName) {
		this.courierContactName = courierContactName;
	}
	public String getCourierWebSite() {
		return courierWebSite;
	}
	public void setCourierWebSite(String courierWebSite) {
		this.courierWebSite = courierWebSite;
	}
	public String getCourierContactNumber() {
		return courierContactNumber;
	}
	public void setCourierContactNumber(String courierContactNumber) {
		this.courierContactNumber = courierContactNumber;
	}
	public String getCourierAddress() {
		return courierAddress;
	}
	public void setCourierAddress(String courierAddress) {
		this.courierAddress = courierAddress;
	}
	public String getCourierContactEmail() {
		return courierContactEmail;
	}
	public void setCourierContactEmail(String courierContactEmail) {
		this.courierContactEmail = courierContactEmail;
	}
	public String getCourierNotes() {
		return courierNotes;
	}
	public void setCourierNotes(String courierNotes) {
		this.courierNotes = courierNotes;
	}
	public String getCourierSLA() {
		return courierSLA;
	}
	public void setCourierSLA(String courierSLA) {
		this.courierSLA = courierSLA;
	}
	public String getCourierStatus() {
		return courierStatus;
	}
	public void setCourierStatus(String courierStatus) {
		this.courierStatus = courierStatus;
	}
	public String getCourierTrackingIdFormat() {
		return courierTrackingIdFormat;
	}
	public void setCourierTrackingIdFormat(String courierTrackingIdFormat) {
		this.courierTrackingIdFormat = courierTrackingIdFormat;
	}
	public String getCourierTrackingIdMsg() {
		return courierTrackingIdMsg;
	}
	public void setCourierTrackingIdMsg(String courierTrackingIdMsg) {
		this.courierTrackingIdMsg = courierTrackingIdMsg;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
}
