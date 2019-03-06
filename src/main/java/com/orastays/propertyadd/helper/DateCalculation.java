
package com.orastays.propertyadd.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class DateCalculation {

	public List<String> findDate(int year, int month) {

		String currentMonth = "";
		String previousMonth = "";
		List<String> dates = new ArrayList<String>();

		YearMonth yearMonthObject = YearMonth.of(year, month);
		int daysInMonth = yearMonthObject.lengthOfMonth(); // 28

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String currentDate = dateFormat.format(date);

		String months = "";
		if (month == 1 || month == 2 || month == 3 || month == 4 || month == 5
				|| month == 6 || month == 7 || month == 8 || month == 9) {
			months = "0" + month;
		} else {
			months = String.valueOf(month);
		}
		
		if(month == 1) {
			
			currentMonth = "January";
			previousMonth = "December";
			
		} else if(month == 2) {
			
			currentMonth = "February";
			previousMonth = "January";
			
		} else if(month == 3) {
			
			currentMonth = "March";
			previousMonth = "February";
			
		} else if(month == 4) {
			
			currentMonth = "April";
			previousMonth = "March";
			
		} else if(month == 5) {
			
			currentMonth = "May";
			previousMonth = "April";
			
		} else if(month == 6) {
			
			currentMonth = "June";
			previousMonth = "May";
			
		} else if(month == 7) {
			
			currentMonth = "July";
			previousMonth = "June";
			
		} else if(month == 8) {
			
			currentMonth = "August";
			previousMonth = "July";
			
		} else if(month == 9) {
			
			currentMonth = "September";
			previousMonth = "August";
			
		} else if(month == 10) {
			
			currentMonth = "October";
			previousMonth = "September";
			
		} else if(month == 11) {
			
			currentMonth = "November";
			previousMonth = "October";
			
		} else {
			
			currentMonth = "December";
			previousMonth = "November";
			
		}
		
		String startDate = year + "-" + months + "-0" + 1;
		String endDate = year + "-" + months + "-" + daysInMonth;

		Date date1 = null;
		Date date2 = null;
		try {
			date1 = dateFormat.parse(currentDate);
			date2 = dateFormat.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (date1.before(date2)) {
			endDate = currentDate;
		}

		dates.add(startDate);
		dates.add(endDate);
		dates.add(String.valueOf(daysInMonth));
		dates.add(currentMonth);
		dates.add(previousMonth);

		return dates;
	}

	public int findDaysBetween(String startDate, String endDate) {

		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		int days = 0;
		try {
			Date date1 = myFormat.parse(startDate);
			Date date2 = myFormat.parse(endDate);
			long diff = date2.getTime() - date1.getTime();
			days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			days = days + 1;
			// System.out.println("Days: " + days);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return days;
	}

	public List<String> findDatesBetween(String startDate) {

		List<String> datesBetween = null;
		
		try {
			
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateFormat.parse(startDate));
		cal.add(Calendar.DATE, -29);
		

		
			String endDate = dateFormat.format(cal.getTime());
			//System.out.println(" startDate is ..." + startDate);
			//System.out.println(" endDate is ..." + endDate);
			List<Date> dates = new ArrayList<Date>();

			DateFormat formatter;

			formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate1 = (Date) formatter.parse(endDate);
			Date endDate1 = (Date) formatter.parse(startDate);
			long interval = 24 * 1000 * 60 * 60; // 1 hour in millis
			long endTime = endDate1.getTime(); // create your endtime here,
												// possibly using Calendar or
												// Date
			long curTime = startDate1.getTime();
			while (curTime <= endTime) {
				dates.add(new Date(curTime));
				curTime += interval;
			}

			datesBetween = new ArrayList<String>();
			for (int i = 0; i < dates.size(); i++) {
				Date lDate = (Date) dates.get(i);
				String ds = formatter.format(lDate);
				//System.out.println(" Date is ..." + ds);
				datesBetween.add(ds);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return datesBetween;
	}
	
	public List<String> findDatesBetween(String startDate, String endDate) {

		List<String> datesBetween = null;
		
		try {
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateFormat.parse(startDate));

		
			//String endDate = dateFormat.format(cal.getTime());
			//System.out.println(" startDate is ..." + startDate);
			//System.out.println(" endDate is ..." + endDate);
			List<Date> dates = new ArrayList<Date>();

			DateFormat formatter;

			formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate1 = (Date) formatter.parse(startDate);
			Date endDate1 = (Date) formatter.parse(endDate);
			long interval = 24 * 1000 * 60 * 60; // 1 hour in millis
			long endTime = endDate1.getTime(); // create your endtime here,
												// possibly using Calendar or
												// Date
			long curTime = startDate1.getTime();
			while (curTime <= endTime) {
				dates.add(new Date(curTime));
				curTime += interval;
			}

			datesBetween = new ArrayList<String>();
			for (int i = 0; i < dates.size(); i++) {
				Date lDate = (Date) dates.get(i);
				String ds = formatter.format(lDate);
				//System.out.println(" Date is ..." + ds);
				datesBetween.add(ds);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return datesBetween;
	}
}