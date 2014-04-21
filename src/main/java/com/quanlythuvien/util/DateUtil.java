package com.quanlythuvien.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lvhuy08t2@gmail.com
 *
 */
public class DateUtil {
	public static Date convertStringToDate(String strDate, String format) {
		DateFormat df = new SimpleDateFormat(format);
		try {
			Date date = df.parse(strDate);
			return date;
		} catch (ParseException e) {
			return null;
		}
	}

}
