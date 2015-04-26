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
 * @author 이경연
 * @date 2013. 6. 6.
 *
 */
public class ExchangeRate extends ToString {
    
    private String exchangeRateDate;
    
    private BigDecimal dal;
    
    private BigDecimal yen;
    
    private BigDecimal yuan;
    
    private BigDecimal yen100Won ;   //100엔당 원화 
    private BigDecimal yuanWon  ;     //1위안당 원화 
    
    private Date rgstDtm;
    
    private String adminId;

    private int rowNum ; 
    
    
    public BigDecimal getYen100Won() {
        return yen100Won;
    }

    public void setYen100Won(BigDecimal yen100Won) {
        this.yen100Won = yen100Won;
    }

    public BigDecimal getYuanWon() {
        return yuanWon;
    }

    public void setYuanWon(BigDecimal yuanWon) {
        this.yuanWon = yuanWon;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public String getExchangeRateDate() {
        return exchangeRateDate;
    }

    public void setExchangeRateDate(String exchangeRateDate) {
        this.exchangeRateDate = exchangeRateDate;
    }

    public BigDecimal getDal() {
        return dal;
    }

    public void setDal(BigDecimal dal) {
        this.dal = dal;
    }

    public BigDecimal getYen() {
        return yen;
    }

    public void setYen(BigDecimal yen) {
        this.yen = yen;
    }

    public BigDecimal getYuan() {
        return yuan;
    }

    public void setYuan(BigDecimal yuan) {
        this.yuan = yuan;
    }

    public Date getRgstDtm() {
        return rgstDtm;
    }

    public void setRgstDtm(Date rgstDtm) {
        this.rgstDtm = rgstDtm;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

}
