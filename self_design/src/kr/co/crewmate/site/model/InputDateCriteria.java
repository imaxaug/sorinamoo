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
 * @author 하정국
 * @date 2012. 5. 23.
 *
 */
@SuppressWarnings("serial")
public class InputDateCriteria extends ToString {
    
    /**
     * 오늘
     */
    private Date today;
    
    /**
     * 한달후
     */
    private Date month;
    
    /**
     * 1주일후
     */
    private Date week;
    
    /**
     * 3달후(90일)
     */
    private Date monthX3;
    
    /**
     * 반년후(180일)
     */
    private Date monthX6;
    
    /**
     * 반년후(360일)
     */
    private Date monthX12;
    
    /**
     * 반년후(730일)
     */
    private Date monthX24;
    
    public InputDateCriteria() {
        this.today = new Date();
        this.week = DateUtils.addWeeks(today, +1);
        this.month = DateUtils.addMonths(today, +1);
        this.monthX3 = DateUtils.addMonths(today, +3);
        this.monthX6 = DateUtils.addMonths(today, +6);
        this.monthX12 = DateUtils.addMonths(today, +12);
        this.monthX24 = DateUtils.addMonths(today, +24);
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

    public Date getMonthX24() {
        return monthX24;
    }

    public void setMonthX24(Date monthX24) {
        this.monthX24 = monthX24;
    }
}
