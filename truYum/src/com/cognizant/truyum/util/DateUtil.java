package com.cognizant.truyum.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	public Date convertToDate(String dob) throws ParseException {
		SimpleDateFormat obj = new SimpleDateFormat("dd/MM/yyyy");
		Date date = obj.parse(dob);
		return date;

	}

}
