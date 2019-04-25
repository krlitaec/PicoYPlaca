package com.ec.model;

/**
 * Model class to simulate a database table 
 * Simulating the plate_range table 
 * @author Karla
 * @since 24-04-2019
 *
 */
public class PlateRange {	
	
	private String day;
	private Integer startNumber;
	private Integer endNumber;
	
	/**
	 * Constructor
	 * @param day
	 * @param startNumber
	 * @param endNumber
	 */
	public PlateRange(String day, Integer startNumber, Integer endNumber) {
		this.day = day;
		this.startNumber = startNumber;
		this.endNumber = endNumber;
	}
	
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