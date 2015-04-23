package kr.co.crewmate.site.model.common;

import java.math.BigDecimal;
import java.util.Date;

import kr.co.crewmate.site.model.ToString;

/**
 * 클래스명: <code>ExchangeRate</code>
 *
 * <pre>
 *  환율 
 * </pre>
 *
 * @author woo5
 * @date 2013. 7.5
 *
 */
public class ExchangeRateCriteria extends ExchangeRate {
    
    private String rgstStartDtm; 
    
    private String rgstEndDtm;
    
    private String orderBy;
    
    

    public String getRgstStartDtm() {
        return rgstStartDtm;
    }

    public void setRgstStartDtm(String rgstStartDtm) {
        this.rgstStartDtm = rgstStartDtm;
    }

    public String getRgstEndDtm() {
        return rgstEndDtm;
    }

    public void setRgstEndDtm(String rgstEndDtm) {
        this.rgstEndDtm = rgstEndDtm;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

}
