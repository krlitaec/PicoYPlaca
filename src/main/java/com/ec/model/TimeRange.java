package com.ec.model;

public class TimeRange {
	
	private String startTime;
	private String endTime;
	private Boolean status;
	
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