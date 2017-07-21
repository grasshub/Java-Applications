package org.hong.javafundamental.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class CalendarRunner {
	
	public static void main(String[] arg) {
		
		// the milliseconds for one hour
		int HOUR_IN_MILLISECOND = 60 * 60 * 1000;
		String NEW_YORK = "America/New_York";
		
		// get the supported ids for GMT-05:00 (Eastern Standard Time)
		String[] ids = TimeZone.getAvailableIDs(-5 * HOUR_IN_MILLISECOND);
		// if no ids were returned, something is wrong. get out.
		if (ids.length == 0)
			System.exit(0);
		/*
		else 
			for (String id : ids)
				System.out.println(id);
			*/

		// create a Eastern Standard Time time zone, the DST could be different among different time zones 
		SimpleTimeZone est = new SimpleTimeZone(-5 * HOUR_IN_MILLISECOND, NEW_YORK);

		// set up rules for daylight savings time as you needed
		est.setStartRule(Calendar.MARCH, 2, Calendar.SUNDAY, 2 * HOUR_IN_MILLISECOND);
		est.setEndRule(Calendar.NOVEMBER, 1, Calendar.SUNDAY, 2 * HOUR_IN_MILLISECOND);

		// create a GregorianCalendar with the Eastern Daylight time zone
		// and the current date and time
		Calendar calendar = new GregorianCalendar(est);
		calendar.setTime(new Date());
		calendar.set(Calendar.MONTH, Calendar.APRIL);
		
		System.out.println("ERA: " + calendar.get(Calendar.ERA));
		System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
		System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
		System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
		System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
		System.out.println("DATE: " + calendar.get(Calendar.DATE));
		System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
		System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println("DAY_OF_WEEK_IN_MONTH: "
		                   + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
		System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
		System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
		System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
		System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
		System.out.println("ZONE_OFFSET: "
		                   + (calendar.get(Calendar.ZONE_OFFSET)/(HOUR_IN_MILLISECOND)));
		System.out.println("DST_OFFSET: "
					       +(calendar.get(Calendar.DST_OFFSET)/(HOUR_IN_MILLISECOND)));
		
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM dd yyyy G 'at' hh:mm:ss:SSS a z");
		System.out.println(sdf.format(calendar.getTime()));

	}

}
