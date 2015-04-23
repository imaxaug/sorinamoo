package kr.co.crewmate.site.model.system;

import kr.co.crewmate.site.model.PageParam;

public class HistoryCriteria extends PageParam{

    /**
     * 변경 구분코드
     * C =  변경
     */
    private String chngGbnCode;
    
    /**
     * 변경 구분코드
     * C =  변경
     */
    private String workGbn;
    
    /**
     * 할인인련번호
     */
    private Integer dscntSeq;
    
    /**
     * 상품코드
     */
    private String prdtCode;
    
    /**
     * 주문번호
     */
    private String orderNum;
    
    /**
     * 회원아이디
     */
    private String userId;
    
    /**
     * 회원등급아이디
     */
    private String userGradeId;
    
    /**
     * 사은품 일련번호
     */
    private String freeGiftId;
    
    private String powerId;

    
    public String getFreeGiftId() {
        return freeGiftId;
    }

    public void setFreeGiftId(String freeGiftId) {
        this.freeGiftId = freeGiftId;
    }

    public String getChngGbnCode() {
        return chngGbnCode;
    }

    public void setChngGbnCode(String chngGbnCode) {
        this.chngGbnCode = chngGbnCode;
    }

    public String getPrdtCode() {
        return prdtCode;
    }

    public void setPrdtCode(String prdtCode) {
        this.prdtCode = prdtCode;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserGradeId() {
        return userGradeId;
    }

    public void setUserGradeId(String userGradeId) {
        this.userGradeId = userGradeId;
    }

    public Integer getDscntSeq() {
        return dscntSeq;
    }

    public void setDscntSeq(Integer dscntSeq) {
        this.dscntSeq = dscntSeq;
    }

    public String getWorkGbn() {
        return workGbn;
    }

    public void setWorkGbn(String workGbn) {
        this.workGbn = workGbn;
    }

	public String getPowerId() {
		return powerId;
	}

	public void setPowerId(String powerId) {
		this.powerId = powerId;
	}
  
    
}
