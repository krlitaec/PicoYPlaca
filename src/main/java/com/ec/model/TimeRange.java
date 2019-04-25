package com.ec.model;

/**
 * Model class to simulate a database table 
 * Simulating the time_range table 
 * @author Karla
 * @since 24-04-2019
 *
 */
public class TimeRange {
	
	private String startTime;
	private String endTime;
	private Boolean status;
	
	/**
	 * Constructor
	 * @param startTime
	 * @param endTime
	 * @param status
	 */
	public TimeRange(String startTime, String endTime, Boolean status) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}