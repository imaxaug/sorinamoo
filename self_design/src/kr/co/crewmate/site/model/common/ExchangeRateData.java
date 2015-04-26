package kr.co.crewmate.site.model.common;

import java.math.BigDecimal;

public class ExchangeRateData extends ExchangeRate{

    private String status;
    
    private BigDecimal dal;
    
    private BigDecimal yen;
    
    private BigDecimal yuan;
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
