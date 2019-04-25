package com.ec.test;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ec.model.PlateRange;
import com.ec.model.TimeRange;
import com.ec.service.PlateService;
import com.ec.service.TimeRangeService;

public class PredictorTest {
	private PlateService plateService;
	private TimeRangeService timeRangeService;
	
	@Before
    public void setup() throws Exception {
		plateService = new PlateService();
		timeRangeService = new TimeRangeService();
    }

	@Test
	public void getPlateRanges() {
		List<PlateRange> plateRanges = plateService.getPlateRanges();
		assertNotNull(plateRanges);
	}
	
	@Test
	public void getTimeRanges() {
		List<TimeRange> timeRanges = timeRangeService.getTimeRanges();
		assertNotNull(timeRanges);
	}

	@Test
	public void checkPlate() {
		String day = "Monday";
		Integer plate = 234;
		Date time = Calendar.getInstance().getTime();
		Boolean test = false;
		Boolean plateCorrect = plateService.checkPlate(plate, day);
		if (plateCorrect.equals(true)) {
			test = timeRangeService.checkTime(time);
		}
		assertEquals(test, true);
		day = "Saturday";
		test = false;
		plateCorrect = plateService.checkPlate(plate, day);
		if (plateCorrect.equals(true)) {
			test = timeRangeService.checkTime(time);
		}
		assertEquals(test, true);
	}
}