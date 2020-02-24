package ck.AdditionalFiles;

import java.util.Calendar;
import java.util.Date;

	
	
public class WorkingDaysBetweenTwoDates {
	
	public static void main(String[] args) {
		
		Date stDate = new Date(2014, 5, 30);
		Date enDate = new Date(2014, 8, 2);
		
		int noofworkdays = getWorkingDaysBetweenTwoDates(stDate,enDate);
		System.out.println("Number of Business days :"+noofworkdays);
		
		int noofcaldays = getCalendardatesBetweenTwoDates(stDate,enDate);
		System.out.println("Number of Calendar days :"+noofcaldays);
	}

	public static int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);        

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		int workDays = 0;

		//Return 0 if start and end are the same
		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}

		do {
			//excluding start date
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				++workDays;
			}
		} while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); //including end date

		return workDays;
	}
	
	
	public static int getCalendardatesBetweenTwoDates(Date startDate, Date endDate) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);        

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		int workDays = 0;

		//Return 0 if start and end are the same
		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}

		do {
			//excluding start date
			startCal.add(Calendar.DAY_OF_MONTH, 1);
		/*	if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {*/
				++workDays;
//			}
		} while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); //including end date

		return workDays;
	}

}
