package com.niit.model;

import javax.persistence.Embeddable;

@Embeddable

public class Address {
	private String city;
	private String state;
	private String pincode;
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String i) {
		this.pincode = i;
	}
	

}
