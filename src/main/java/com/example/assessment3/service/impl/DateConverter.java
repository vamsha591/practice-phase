package com.example.assessment3.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

	public int getMonth(String date)
	{
		try {
		SimpleDateFormat formatter = new SimpleDateFormat("MMM-yyyy");
		Date date1 = formatter.parse(date);
		return (date1.getMonth()+1);
		}
		catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		
	}
	public int getYear(String date) 
	{
		try
		{
		SimpleDateFormat formatter = new SimpleDateFormat("MMM-yyyy");
		Date date1 = formatter.parse(date);
		return (date1.getYear()+1900);
		}
		catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
}
