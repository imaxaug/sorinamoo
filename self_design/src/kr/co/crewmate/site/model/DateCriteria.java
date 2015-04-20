package kr.co.crewmate.site.model;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

/**
 * 
 * 클래스명: <code>DateCriteria</code>
 *
 * <pre>
 *  오늘/일주일/한달 버튼을 위한 날짜 셋
 * </pre>
 *
 * @author 이경연
 * @date 2012. 5. 18.
 *
 */
@SuppressWarnings("serial")
public class DateCriteria extends ToString {
    
    /**
     * 오늘
     */
    private Date today;
    
    /**
     * 15일전(15일)
     */
    private Date weekX2;

    /**
     * 지난달
     */
    private Date month;
    
    /**
     * 지난주
     */
    private Date week;
    
    /**
     * 2달전(60일)
     */
    private Date monthX2;
    
    
    /**
     * 3달전(90일)
     */
    private Date monthX3;
    
    /**
     * 반년전(180일)
     */
    private Date monthX6;
    

    /**
     * 1년전(1년)
     */
    private Date monthX12;
    
    
    public DateCriteria() {
        this.today = new Date();
        this.week = DateUtils.addWeeks(today, -1);
        this.weekX2 = DateUtils.addDays(today, -15);
        this.month = DateUtils.addMonths(today, -1);
        this.monthX2 = DateUtils.addMonths(today, -2);
        this.monthX3 = DateUtils.addMonths(today, -3);
        this.monthX6 = DateUtils.addMonths(today, -6);
        this.monthX12 = DateUtils.addMonths(today, -12);
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Date getWeek() {
        return week;
    }

    public void setWeek(Date week) {
        this.week = week;
    }
    
    
    public Date getMonthX2() {
        return monthX2;
    }

    public void setMonthX2(Date monthX2) {
        this.monthX2 = monthX2;
    }

    public Date getMonthX3() {
        return monthX3;
    }

    public void setMonthX3(Date monthX3) {
        this.monthX3 = monthX3;
    }

    public Date getMonthX6() {
        return monthX6;
    }

    public void setMonthX6(Date monthX6) {
        this.monthX6 = monthX6;
    }

    public Date getMonthX12() {
        return monthX12;
    }

    public void setMonthX12(Date monthX12) {
        this.monthX12 = monthX12;
    }
    
    public Date getWeekX2() {
        return weekX2;
    }

    public void setWeekX2(Date weekX2) {
        this.weekX2 = weekX2;
    }
}
