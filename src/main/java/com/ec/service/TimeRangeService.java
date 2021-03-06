package com.ec.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ec.model.TimeRange;

/**
 * Service class to manage TimeRange backend
 * @author Karla
 * @since 24-04-2019
 *
 */
public class TimeRangeService {

	/**
	 * Method to simulate the get of the ranges of times of the database.
	 * @return
	 */
	public List<TimeRange> getTimeRanges() {
		List<TimeRange> grupos = Arrays.asList(new TimeRange("07:00", "09:30", true),
				new TimeRange("16:00", "19:30", true), new TimeRange("11:00", "12:30", false));
		return grupos;
	}

	/**
	 * Method that verifies if a plate is on time
	 * @param plate
	 * @param day
	 * @return
	 */
	public Boolean checkTime(Date time) {
		Boolean isOnTime = true;
		List<TimeRange> times = getTimeRanges();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);

		for (TimeRange t : times) {
			if (t.getStatus().equals(true)) {
				int hour1 = Integer.valueOf(t.getStartTime().substring(0, 2));
				int minute1 = Integer.valueOf(t.getStartTime().substring(3, 5));
				int hour2 = Integer.valueOf(t.getEndTime().substring(0, 2));
				int minute2 = Integer.valueOf(t.getEndTime().substring(3, 5));
				if (hour >= hour1 && hour <= hour2) {
					if (hour == hour1) {
						if (minute >= minute1 && ((hour < hour2) || (hour == hour2 && minute <= minute2))) {
							isOnTime = false;
							break;
						}
					} else {
						if (hour == hour2) {
							if (minute <= minute2) {
								isOnTime = false;
								break;
							}
						} else {
							isOnTime = false;
							break;
						}
					}
				}
			}
		}
		return isOnTime;
	}

	public static void main(String[] args) {
		String hora = "15:48";
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		String timeFormatted = String.format("%02d", hour) + ":" + String.format("%02d", minute);
		System.out.println("Hora; " + timeFormatted);
		System.out.println("compare; " + hora.compareTo(timeFormatted));

		int hour1 = Integer.valueOf(hora.substring(0, 2));
		int minute1 = Integer.valueOf(hora.substring(3, 5));
		System.out.println("hour1: " + hour1 + " minute1: " + minute1);
	}

}