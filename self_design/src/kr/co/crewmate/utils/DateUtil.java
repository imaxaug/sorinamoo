package kr.co.crewmate.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getTimestamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmsss");
		String formattedDate = sdf.format(date);

		return formattedDate;
	}
}
