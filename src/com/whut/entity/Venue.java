package com.whut.entity;

public class Venue {
	private int venueId;
	private String country;
	private String province;
	private String city;
	private String addr;
	private String capacity;//容量
	
	public Venue (){}

	public Venue(int venueId, String country, String province, String city, String addr, String capacity) {
		super();
		this.venueId = venueId;
		this.country = country;
		this.province = province;
		this.city = city;
		this.addr = addr;
		this.capacity = capacity;
	}

	public int getVenueId() {
		return venueId;
	}

	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Venue [venueId=" + venueId + ", country=" + country + ", province=" + province + ", city=" + city
				+ ", addr=" + addr + ", capacity=" + capacity + "]";
	}
	
	
}
