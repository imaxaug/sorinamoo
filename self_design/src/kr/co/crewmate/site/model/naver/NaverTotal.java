package kr.co.crewmate.site.model.naver;

import kr.co.crewmate.site.model.ToString;

public class NaverTotal extends ToString {
    
    private String prdtCode;
    
    private int orderTotalAmt;
    
    private int orderTotalCount;
    
    private String billDate;

    public int getOrderTotalAmt() {
        return orderTotalAmt;
    }

    public void setOrderTotalAmt(int orderTotalAmt) {
        this.orderTotalAmt = orderTotalAmt;
    }

    public int getOrderTotalCount() {
        return orderTotalCount;
    }

    public void setOrderTotalCount(int orderTotalCount) {
        this.orderTotalCount = orderTotalCount;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getPrdtCode() {
        return prdtCode;
    }

    public void setPrdtCode(String prdtCode) {
        this.prdtCode = prdtCode;
    }
}
