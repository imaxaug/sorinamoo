/*
 * @(#)DateUtil.java	1.0  2004/03/15
 *
 * Copyright 2001 - 2004 Bestech, Inc. All rights reserved.
 * This software is the proprietary information of Bestech, Inc.
 * Use is subject to license terms.
 */

package kr.co.crewmate.site.utils.paybridge;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 날짜(DATE) 관련 Utility.
 * 날짜 정보를 원하는 형태로 얻기 위한 다양한 메소드를 제공한다.
 *
 * @author  Lee YongSun
 * @version 1.0, 2004/03/15
 * @since   1.0
 */
public class DateUtil
{
	public static void main(String p[])
	{
		
		DateUtil dateUtil = new DateUtil();
		try
		{
//			System.out.println( dateUtil.getDateStr("YYYYMMDD") );
//			System.out.println( dateUtil.getNowFullTime("yyyy-MM-dd HH:mm:ss:SSS"));
			System.out.println( dateUtil.getNowFullBeijingTime("yyyy-MM-dd HH:mm:ss:SSS"));
			System.out.println( dateUtil.getKRDate2CNDate("20131123145519", "yyyyMMddHHmmss" , "yyyy-MM-dd") );
			System.out.println( dateUtil.getKRDate2CNDate("20131123145519", "yyyyMMddHHmmss", "yyyy-MM-dd") );
//			System.out.println( DateUtil.getIncrementMonth(DateUtil.getDateStr("YYYYMMDD"),-1,"yyyyMMdd") );
//			System.out.println( DateUtil.getIncrementMonth(DateUtil.getDateStr("YYYYMMDD"),-3,"yyyyMMdd") );
//			System.out.println( DateUtil.getIncrementMonth(DateUtil.getDateStr("YYYYMMDD"),1,"yyyyMMdd") );
//			System.out.println( DateUtil.getIncrementMonth(DateUtil.getDateStr("YYYYMMDD"),3,"yyyyMMdd") );

		}catch(Exception e){}
	}
	
	public Date str2Date(String strDate, String format) throws Exception {
		Date date = new SimpleDateFormat(format).parse(strDate);
		return date;
	}	
	
	public String date2Str(Date date, String format) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);	
		return dateFormat.format(date);
	}
	
	public String getKRDate2CNDate(String strDate, String krFormat, String cnFormat) throws Exception {
		Date krDate = new SimpleDateFormat(krFormat).parse(strDate);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(cnFormat);	
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(krDate);
		long cnTime = calendar.getTime().getTime() - 1000*60*60*1;
		return dateFormat.format(new Date(cnTime));
	}	
	
	public String getNowFullTime(String format){
		//yyyyMMddHHmmssSSS
		//yyyy-MM-dd HH:mm:ss:SSS
		Calendar calendar = Calendar.getInstance(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);	
		return dateFormat.format(calendar.getTime());
	}
	
	public String getNowFullBeijingTime(String format){
		//yyyyMMddHHmmssSSS
		//yyyy-MM-dd HH:mm:ss:SSS
		Calendar calendar = Calendar.getInstance(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);	
		long chinaTime = calendar.getTime().getTime() -  1000*60*60;
		return dateFormat.format(new Date(chinaTime));
	}
	
	public String getYesterday(){
		//yyyy-MM-dd HH:mm:ss:SSS
		Calendar calendar = Calendar.getInstance(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");	
		long tarketTime = calendar.getTime().getTime() - 1000*60*60*24*1;
		return dateFormat.format(new Date(tarketTime));
	}
	
	public String getBeforeYesterday(){
		//yyyy-MM-dd HH:mm:ss:SSS
		Calendar calendar = Calendar.getInstance(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");	
		long tarketTime = calendar.getTime().getTime() - 1000*60*60*24*2;
		return dateFormat.format(new Date(tarketTime));
	}
	
	public String getTommorrow(){
		//yyyy-MM-dd HH:mm:ss:SSS
		Calendar calendar = Calendar.getInstance(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");	
		long tarketTime = calendar.getTime().getTime() + 1000*60*60*24;
		return dateFormat.format(new Date(tarketTime));
	}
	
	public static String getFullTime(String format, Date date){
		//yyyyMMddHHmmssSSS
		//yyyy-MM-dd HH:mm:ss:SSS
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);	
		return dateFormat.format(date);
	}

	/**
	 * 입력한 날짜(형식YYYYMMDD)가 어떤 요일인지 얻는다.
	 *
	 * @param sYYYYMMDD 요일을 얻고자 하는 날짜(예:20040314)
	 * @return 1:SUNDAY 2:MONDAY 3:TUESDAY 4:WEDNESDAY 5:THURSDAY 6:FRIDAY 7:SATURDAY
	 */
    public static int getAnyDayForDate(String sYYYYMMDD)
    {
        int iYYYY   =   Integer.parseInt(sYYYYMMDD.substring(0,4));
        int iMM     =   Integer.parseInt(sYYYYMMDD.substring(4,6));
        int iDD     =   Integer.parseInt(sYYYYMMDD.substring(6,8));

        Calendar c = Calendar.getInstance(Locale.KOREA);
        c.set(iYYYY,iMM-1,iDD);
        return c.get(Calendar.DAY_OF_WEEK);
    }


	/**
	 * 윤년인지 평년인지를 체크한다.
	 *
	 * @param year 년도(예 : 2004)
	 * @return 윤년(2월이 29일까지) : true, 평년(2월이 28일까지) : false
	 */
	public static boolean isBissextileYear(int year)
	{
		int fst;

		--year;
		fst = year + year / 4 - year / 100 + year / 400 + 1;
		++year;

		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			return true;
		else
			return false;
	}



	/**
	 * 선택한 달의 최종 날짜를 구한다.
	 *
	 * @param sYYYYMM 최종날짜를 구하고자 하는 달(예:200403)
	 * @return 해당월의 마지막 일자
	 */
	public static int getMonthLastDay(String sYYYYMM)
	{
		int iYYYY, iMM;

		int mm_day[][] = {
			{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //평년
			{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}  //윤년
		};

		iYYYY   = Integer.parseInt(sYYYYMM.substring(0,4));
		iMM     = Integer.parseInt(sYYYYMM.substring(4,6));

		if(iMM > 12)
			return -1;

		int iNext_month_last_day;

		if( isBissextileYear(iYYYY) != true)
			iNext_month_last_day = mm_day[0][iMM-1];
		else
			iNext_month_last_day = mm_day[1][iMM-1];

		return iNext_month_last_day;
	}


	/**
	 * 입력한 날짜(형식YYYYMMDD)가 정상적인 날짜인지 확인한다.
	 *
	 * @param sYYYYMMDD 날짜 (예:20040314)
	 * @return true(정상), false(비정상)
	 */
	public static boolean isValidDate(String sYYYYMMDD)
	{
		int iYYYY, iMM, iDD;

		int mm_day[][] = {
			{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //평년
			{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}  //윤년
		};

		iYYYY   = Integer.parseInt(sYYYYMMDD.substring(0,4));
		iMM     = Integer.parseInt(sYYYYMMDD.substring(4,6));
		iDD     = Integer.parseInt(sYYYYMMDD.substring(6,8));

		if(iMM > 12)
			return false;

		int iNext_month_last_day;

		if( isBissextileYear(iYYYY) != true)
			iNext_month_last_day = mm_day[0][iMM-1];
		else
			iNext_month_last_day = mm_day[1][iMM-1];

		if(iDD > iNext_month_last_day)
			return false;
		else
			return true;
	} 

	/**
	 * sDateNTimeForm 형식의 현재 시각 문자열을 얻는다.
	 * @param sDateNTimeForm 현재시각 Formatting 문자열(년도:yyyy 월:MM 일:dd 시:HH 분:mm 초:ss)<br>
	 * example - yyyyMMddHHmmss, yyyy년 MM월 dd일 HH시 mm분 ss초
	 * @return 현재 시간 문자열
	 */
	public static String getDateNTimeByForm(String sDateNTimeForm)
	{
		Calendar Today = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat(sDateNTimeForm);
		String sDateNTime = sdf.format(Today.getTime() );

		return sDateNTime;
	}

	/**
	 * sDateNTimeForm 형식의 임의의 시간 문자열을 얻는다.
	 * @param lDate 	 전달된임의의 Long형 Date
	 * @param sDateNTimeForm 현재시각 Formatting 문자열(년도:yyyy 월:MM 일:dd 시:HH 분:mm 초:ss)<br>
	 * example - yyyyMMddHHmmss, yyyy년 MM월 dd일 HH시 mm분 ss초
	 * @return  임의의 시간 문자열
	 */
	public static String getDateNTimeByForm(long lDate, String sDateNTimeForm)
	{
		java.util.Date dateNow = new Date(lDate);
		SimpleDateFormat sdf = new SimpleDateFormat(sDateNTimeForm);
		String sDateNTime = sdf.format(dateNow);

		return sDateNTime;
	}

	/**
     * 시스템의 오늘의 날짜를 문자열로 얻는다.
     *
     * @param   strType  반환할 문자열 형태<br>
	 *  example - YYYY,YYYYMM,YYYYMMDD,YYYYMMDDHH,YYYYMMDDHHNN,YYYYMMDDHHNNSS 의 6가지 형태<br>
	 *  (YYYY: 년도, YYYYMM: 년월, YYYYMMDD: 년월일, YYYYMMDDHH: 년월일시, YYYMMDDHHNN: 년월일시분, YYYYMMDDHHNNSS: 년월일시분초)
     * @return 지정된 형태의 문자열
     */
    public static String getDateStr(String strDateType)
    {
        Calendar today= new GregorianCalendar();
        String strYear, strMonth, strDay, strHour, strMin, strSec;
        String strDate;
        String strErrCode;
        int nYear, nMonth, nDay, nHour, nMin, nSec;

        nYear= (int)(today.get(Calendar.YEAR));
        strYear= "" + nYear;

        nMonth= (int)(today.get(Calendar.MONTH)+1);
        if(nMonth < 10) strMonth= "0" + nMonth;
        else strMonth= "" + nMonth;

        nDay= (int)(today.get(Calendar.DAY_OF_MONTH));
        if(nDay < 10) strDay= "0" + nDay;
        else strDay= "" + nDay;

        nHour= (int)today.get(Calendar.HOUR_OF_DAY);
        if(nHour < 10) strHour= "0" + nHour;
        else strHour= "" + nHour;

        nMin= (int)today.get(Calendar.MINUTE);
        if(nMin < 10) strMin= "0" + nMin;
        else strMin= "" + nMin;

        nSec= (int)today.get(Calendar.SECOND);
        if(nSec < 10) strSec= "0" + nSec;
        else strSec= "" + nSec;

        if(strDateType.equalsIgnoreCase("YYYY"))
            strDate= strYear;
        else if(strDateType.equalsIgnoreCase("YYYYMM"))
            strDate= strYear + strMonth;
        else if(strDateType.equalsIgnoreCase("YYYYMMDD"))
            strDate= strYear + strMonth + strDay;
        else if(strDateType.equalsIgnoreCase("YYYYMMDDHH"))
            strDate= strYear + strMonth + strDay + strHour;
        else if(strDateType.equalsIgnoreCase("YYYYMMDDHHNN"))
            strDate= strYear + strMonth + strDay + strHour + strMin;
        else if(strDateType.equalsIgnoreCase("YYYYMMDDHHNNSS"))
            strDate= strYear + strMonth + strDay + strHour + strMin + strSec;
        else
        {
            strErrCode= "01-00-003-0";
            return null;
        }
        return strDate;
    }

	/**
	 * date가 Date 형태일 경우 sNewForm형식의 시각문자열을 구하고,  date가 String 형태일 경우  sOldForm형식의 시각문자열을 sNewForm형식으로 재구성한 시각문자열을 얻는다. <br>
	 * (사용예 : getDateNTimeByForm("1999-12-04 12:14:02", "yyyy-MM-dd HH:mm:ss", "yyyy년 M월 d일 HH시 mm분 ss초"))
	 * @param date 시각 Object(Date, String instance)
	 * @param sOldForm date(String instance일경우)의 문자열 형식(년도:yyyy 월:MM 일:dd 시:HH 분:mm 초:ss)
	 * @param sNewForm 얻고자 하는 시각 문자열 형식(SimpleDateFormat형식을 따른다.)
	 * @return 원하는 형식의 시각문자열
	 * @exception  InstantiationException
	 * @exception  Exception
	 */
	public static String getDateNTimeByForm(	Object date, String sOldForm, String sNewForm)
	throws InstantiationException, Exception
    {
        Calendar Today = new GregorianCalendar();
		int iIndex = 0;

		if( date instanceof String && date != null && sOldForm != null )
		{
			String sDate = (String)date;
			// 년도 
			if( sOldForm.indexOf("y") > 0 )
			{
				iIndex = sOldForm.indexOf("y");
				Today.set(Calendar.YEAR,
					Integer.parseInt(
						sDate.substring(iIndex, iIndex+4)
					)
				);
			}

			// 월 
			if( sOldForm.indexOf("M") > 0 )
			{
				iIndex = sOldForm.indexOf("M");
				Today.set(Calendar.MONTH,
					Integer.parseInt(
						sDate.substring(iIndex, iIndex+2)
					) - 1
				);
			}

			// 일
			if( sOldForm.indexOf("d") > 0 )
			{
				iIndex = sOldForm.indexOf("d");
				Today.set(Calendar.DAY_OF_MONTH,
					Integer.parseInt(
						sDate.substring(iIndex, iIndex+2)
					)
				);
			}

			// 시간
			if( sOldForm.indexOf("H") > 0 )
			{
				iIndex = sOldForm.indexOf("H");
				Today.set(Calendar.HOUR_OF_DAY,
					Integer.parseInt(
						sDate.substring(iIndex, iIndex+2)
					)
				);
			}

			// 분
			if( sOldForm.indexOf("m") > 0 )
			{
				iIndex = sOldForm.indexOf("m");
				Today.set(Calendar.MINUTE,
					Integer.parseInt(
						sDate.substring(iIndex, iIndex+2)
					)
				);
			}

			// 초 
			if( sOldForm.indexOf("s") > 0 )
			{
				iIndex = sOldForm.indexOf("s");
				Today.set(Calendar.SECOND,
					Integer.parseInt(
						sDate.substring(iIndex, iIndex+2)
					)
				);
			}
		}
		else if( date instanceof Date )
		{
			Today.setTime((Date)date);
		}
		else
			throw new InstantiationException("date is not instance of String or Date");

		SimpleDateFormat sdf = new SimpleDateFormat(sNewForm);
        String sDateNTime = sdf.format(Today.getTime() );

        return sDateNTime;
    } // End : String getDateNTimeByForm(Object, String, String)


	/**
	 * 지정된 날짜가 해당 월의 몇번째 주차에 해당하는지 조회하고 그 값을 반환한다.
	 * @param sDate 날짜 (예: 20040315)
	 * @return 주차에 해당하는 값(1: 1주, 2: 2주, 3: 3주, 4:4주, 5:5주)
	 */
	public static int getWeekth(String sDate) {

		if (sDate == null || sDate.length() != 8)
			return -1;

		Calendar c = Calendar.getInstance(Locale.KOREA);
		c.set( Integer.parseInt(sDate.substring(0, 4)), Integer.parseInt(sDate.substring(4, 6)) - 1, Integer.parseInt(sDate.substring(6)) );

		GregorianCalendar gc = new GregorianCalendar(Locale.KOREA);
		gc.setTime(c.getTime());

		return c.get(Calendar.WEEK_OF_MONTH);
	}


	/**	
	 * 지정된 날짜에서 지정된 일 수 만큼 더하거나 뺀 날짜(Date) 를 반환한다.
	 * 
	 * @param strDate 날짜 (예: 2004-03-15,  2004-03-15 12:45:59)
	 * @param int 더하거나 빼고자 하는 일 수 
	 * @return 지정된 날짜에서 지정된 일 수 만큼 더하거나 뺀 날짜(Date) Object
	 * @exception Exception
	 */	
	public static Date getIncrementDays(String strDate, int days) throws Exception {
		
		SimpleDateFormat sdf = null;
		Calendar calendar = new GregorianCalendar();
		Date date = null;
		
		int year = 0;
		int month = 0;
		int day = 0;
		int hour = 0;
		int minute = 0;
		int second = 0;		
		
		
		if(strDate.length() == 10 ) {
			sdf = new SimpleDateFormat("yyyy-MM-dd", java.util.Locale.KOREA);
		} else {
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.KOREA);
		}
				
		try {
			Date tmpDate = sdf.parse(strDate);
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
				
				
		try {
			
			year = Integer.parseInt(strDate.substring(0,4));
			month = Integer.parseInt(strDate.substring(5,7));
			day = Integer.parseInt(strDate.substring(8,10));
			hour = Integer.parseInt(strDate.substring(11,13));
			minute = Integer.parseInt(strDate.substring(14,16));
			second = Integer.parseInt(strDate.substring(17,19));			
			
		} catch(Exception e) {
					
			hour = 0;
			minute = 0;
			second = 0;
			//	throw new Exception(e.getMessage()+"Here");	
		}		
		
		
		calendar.set(year, month-1, day + days, hour, minute, second);		

		try {			
			date = calendar.getTime();	
		}catch(Exception e) {}							
		
		return date;
	}
	

	/**	
	 * 지정된 날짜에서 지정된 초 만큼 더하거나 뺀 날짜(Date) 를 반환한다.
	 * 
	 * @param strDate 날짜 (예: 20040315(yyyyMMdd),  20040315124559(yyyyMMddHHmmss))
	 * @param int 더하거나 빼고자 하는 일 수 
	 * @return 지정된 날짜에서 지정된 초 만큼 더하거나 뺀 날짜(Date) Object
	 * @exception Exception
	 */	
	public static Date getIncrementDaysSecond(String strDate, int sec) throws Exception {
		
		SimpleDateFormat sdf = null;
		Calendar calendar = new GregorianCalendar();
		Date date = null;
		
		int year = 0;
		int month = 0;
		int day = 0;
		int hour = 0;
		int minute = 0;
		int second = 0;		
		
		
		if(strDate.length() == 10 ) {
			sdf = new SimpleDateFormat("yyyyMMdd", java.util.Locale.KOREA);
		} else {
			sdf = new SimpleDateFormat("yyyyMMddHHmmss", java.util.Locale.KOREA);
		}
				
		try {
			Date tmpDate = sdf.parse(strDate);
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
				
				
		try {
			
			year = Integer.parseInt(strDate.substring(0,4));
			month = Integer.parseInt(strDate.substring(4,6));
			day = Integer.parseInt(strDate.substring(6,8));
			hour = Integer.parseInt(strDate.substring(8,10));
			minute = Integer.parseInt(strDate.substring(10,12));
			second = Integer.parseInt(strDate.substring(12,14));			
			
		} catch(Exception e) {
					
			hour = 0;
			minute = 0;
			second = 0;
			//	throw new Exception(e.getMessage()+"Here");	
		}		
		
		
		calendar.set(year, month-1, day, hour, minute, second + sec);		

		try {			
			date = calendar.getTime();	
		}catch(Exception e) {}							
		
		return date;
	}

	/**
	 * 입력한 날짜(형식 yyyy-MM-dd)기준으로 +,- 일 후의 날짜를 표시한다.
	 *
	 * @param strDate 기준날짜.(null일 경우 오늘 날짜가 된다.)
	 * @param days   증가,또는 감소한 일
	 * @param sDateNTimeForm  결과 출력 날짜 포멧
	 * @return  +,- 일 후의 날짜를 표시하는 문자열.
	 * @exception Exception
	 */
	public static String getIncrementDays(String strDate, int days, String sDateNTimeForm) throws Exception
	{
		if(strDate == null || strDate.length() == 0)
			strDate = getDateNTimeByForm("yyyy-MM-dd");

		Date dt = getIncrementDays(strDate, days);
		SimpleDateFormat sdf = new SimpleDateFormat(sDateNTimeForm);
		String sDateNTime = sdf.format(dt);

		return sDateNTime;
	}

	/**
	 * 입력한 Date형의 Fromat을 새로운 String으로 변환한다.
	 *
	 * @param date 기준날짜.
	 * @param sDateNTimeForm  결과 출력 날짜 포멧
	 * (사용예 : getDateNTimeByForm("1999-12-04 12:14:02", "yyyy-MM-dd HH:mm:ss", "yyyy년 M월 d일 HH시 mm분 ss초"))
	 * @return  null or String
	 * @exception Exception
	 */
	public String getDateNTimeByForm(Date date, String sDateNTimeForm) throws Exception
	{
		if(date == null) return null;

		SimpleDateFormat sdf = new SimpleDateFormat(sDateNTimeForm);
		String sDateNTime = sdf.format(date);

		return sDateNTime;
	}


	/**
	 * 입력한 날짜(형식 yyyyMMdd)기준으로 +,- 월 후의 날짜를 표시한다.
	 *
	 * @param strDate : 기준날짜.(null일 경우 오늘 날짜가 된다.)
	 * @param days 	  : 증가,또는 감소한 월
	 * @param sDateNTimeForm : 결과 출력 날짜 포멧
	 * @return  +,- 월 후의 날짜를 표시한다.
	 * @exception Exception
	 */
	public static String getIncrementMonth(String strDate, int cmonth, String sDateNTimeForm) throws Exception
	{

		if(strDate == null || strDate.length() == 0)
			strDate = getDateNTimeByForm("yyyyMMdd");

		int	year 	= Integer.parseInt(strDate.substring(0,4));
		int	month	= Integer.parseInt(strDate.substring(4,6));
		int	day		= Integer.parseInt(strDate.substring(6,8));

		Calendar calendar = new GregorianCalendar();

		calendar.set(year, month-1+cmonth, day, 0, 0, 0);		
		Date date = calendar.getTime();	

		SimpleDateFormat sdf = new SimpleDateFormat(sDateNTimeForm);
		String sDateNTime = sdf.format(date);

		return sDateNTime;
	}
	
	/**
	 * 거치기간 계산
	 * @param endDate yyyyMMdd
	 * @param startDate yyyyMMdd
	 * @return int 거치일수
	 * @throws Exception
	 */
	public int getDefermentPeriod(String endDate, String startDate) throws Exception{
		Date dToday = new SimpleDateFormat("yyyyMMdd").parse(endDate);
		Calendar todayCal = new GregorianCalendar();
		todayCal.setTime(dToday);

		Date dSaleStrDm = new SimpleDateFormat("yyyyMMdd").parse(startDate);
		Calendar saleStrDmCal = new GregorianCalendar();
		saleStrDmCal.setTime(dSaleStrDm);
		     
		long diffMillis = todayCal.getTimeInMillis() - saleStrDmCal.getTimeInMillis();

		long diff = diffMillis/ (24 * 60 * 60 * 1000);	
		
		return Integer.parseInt(String.valueOf(diff));
	}
	
	public Date addHourToDate(String strDate, int addhour) throws Exception {
		Calendar calendar = new GregorianCalendar();

		int year = Integer.parseInt(strDate.substring(0,4));
		int month = Integer.parseInt(strDate.substring(4,6));
		int day = Integer.parseInt(strDate.substring(6,8));
		int hour = Integer.parseInt(strDate.substring(8,10));
		int minute = Integer.parseInt(strDate.substring(10,12));
		int second = Integer.parseInt(strDate.substring(12,14));				
		
		calendar.set(year, month-1, day, hour + addhour, minute, second);				
		Date date = calendar.getTime();	

		return date;
	}
} // End Of File
