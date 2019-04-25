package com.ec.model;

public class PlateRange {
	
	public PlateRange(String day, Integer startNumber, Integer endNumber) {
		this.day = day;
		this.startNumber = startNumber;
		this.endNumber = endNumber;
	}
	
	private String day;
	private Integer startNumber;
	private Integer endNumber;
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public Integer getStartNumber() {
		return startNumber;
	}
	public void setStartNumber(Integer startNumber) {
		this.startNumber = startNumber;
	}
	public Integer getEndNumber() {
		return endNumber;
	}
	public void setEndNumber(Integer endNumber) {
		this.endNumber = endNumber;
	}

}