package com.co.transactions.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	@SuppressWarnings("deprecation")
	public boolean isSameYearAndMonth(String firstDate, String secondDate) throws ParseException{
		
		SimpleDateFormat correctFormat = new SimpleDateFormat("yyyy-mm-dd");
		
		String firstDateStr = firstDate.substring(0, 10);
		String secondDateStr = secondDate.substring(0, 10);
		
		//System.out.println(firstDateStr + " " + secondDateStr);
		
		Date date1 = correctFormat.parse(firstDate);
		Date date2 = correctFormat.parse(secondDate);
		
		//System.out.println("date1 year "+date1.getYear() + "date1 month " + date1.getMonth() + "date2 year " + date2.getYear() + "date2 month "+date2.getMonth());
		
		if(date1.getYear() == date2.getYear()){
			if(date1.getMonth() == date2.getMonth()){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
