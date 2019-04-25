package com.ec.service;

import java.util.Arrays;
import java.util.List;

import com.ec.model.PlateRange;

public class PlateService {

	public List<PlateRange> getPlateRanges () {
		List<PlateRange> ranges = Arrays.asList(
	            new PlateRange("Monday", 00001, 10000),
	            new PlateRange("Tuesday", 10001, 20000),
	            new PlateRange("Wednesday", 20001, 30000),
	            new PlateRange("Thursday", 30001, 40000),
	            new PlateRange("Friday", 40001, 50000)
		);		
		return ranges;
	}
	
	public Boolean checkPlate (Integer plate, String day) {
		Boolean canDrive = false;
		List<PlateRange> ranges = getPlateRanges();
		for (PlateRange plateRange : ranges) {
			if (day.contentEquals(plateRange.getDay()) && plate >= plateRange.getStartNumber() && plate <= plateRange.getEndNumber()) {
				canDrive = true;
				break;
			}
		}
		return canDrive;		
	}
}
