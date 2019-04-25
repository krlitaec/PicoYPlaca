package com.ec.controller;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.ec.model.PlateRange;
import com.ec.service.PlateService;
import com.ec.service.TimeRangeService;

/**
 * Controller class to manage the frontend
 * @author Karla
 * @since 25-04-2019
 *
 */
@ManagedBean (name = "predictorMB")
@RequestScoped  
public class PredictorController {
	private Boolean canDrive = false;
	private Integer plate;
	private String day = "Monday";
	private Date time = Calendar.getInstance().getTime();
	private String message;
	private List<String> days;

	private PlateService plateService;
	private TimeRangeService rangeService;
	
	/**
	 * Method that verifies if a plate is registered with a particular day and at a time indicated by the user
	 * @return
	 */
	public String checkPlate () {
		String type = "Successful";
		if (plate  == null || day == null || time == null) {
			type = "Error";
			message = "Please enter all info!";
		} else {
			getPlateService();
			getRangeService();
			message = "You can drive! Get on the road!";
			canDrive = true;
			Boolean plateCorrect = plateService.checkPlate(plate, day);
			if (plateCorrect.equals(true)) {
				Boolean onTime = rangeService.checkTime(time);
				if (onTime.equals(false)) {
					canDrive = false;
					message = "You can not drive!";
					type = "Error";
				}
			}
		}
		saveMessage(type);
		return "/faces/index.xhtml";
	}
	
	public void saveMessage(String typeMessage) {
        FacesContext context = FacesContext.getCurrentInstance();         
        context.addMessage(null, new FacesMessage(typeMessage,  message) );
    }

	public Boolean getCanDrive() {
		return canDrive;
	}

	public void setCanDrive(Boolean canDrive) {
		this.canDrive = canDrive;
	}

	public Integer getPlate() {
		return plate;
	}

	public void setPlate(Integer plate) {
		this.plate = plate;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public PlateService getPlateService() {
		if (plateService == null) {
			plateService = new PlateService();
		}
		return plateService;
	}
	
	public TimeRangeService getRangeService() {
		if (rangeService == null) {
			rangeService = new TimeRangeService();
		}
		return rangeService;
	}

	public List<String> getDays() {
		days = Arrays.asList("Monday",
				"Tuesday",
				"Wednesday",
				"Thursday",
				"Friday",
				"Saturday",
				"Sunday"
		);		
		return days;
	}

	public void setDays(List<String> days) {
		this.days = days;
	}
	
}
