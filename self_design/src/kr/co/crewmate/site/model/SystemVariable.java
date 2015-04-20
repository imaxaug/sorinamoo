package kr.co.crewmate.site.model;

import java.util.Date;

/**
 * 
 * 클래스명: <code>SystemVariable</code>
 *
 * <pre>
 *  할렐루야
 * </pre>
 *
 * @author 이경연
 * @date 2013. 6. 30.
 *
 */
@SuppressWarnings("serial")
public class SystemVariable extends ToString {
    
    private String varKey;
    
    private boolean cnrBatchYn;
    
    private String cardChrgDscntCont ;  //카드사 청구 할인
    private String cardChrgDscntContCn ;//카드사 청구 할인(중국어)

    private String updateColume;        // update 칼럼
    private String updateValue;         // update 칼럼 값
    
    private String popRcmndWord;        //검색어
    private String lastModAdminId;      //최종수정자
    private Date lastModDtm;            //최종수정일
    
    private String upBuyTermMm;
    private String gradeKeepTermMm;
    
    public String getVarKey() {
        return varKey;
    }
    public void setVarKey(String varKey) {
        this.varKey = varKey;
    }
    public boolean isCnrBatchYn() {
        return cnrBatchYn;
    }
    public void setCnrBatchYn(boolean cnrBatchYn) {
        this.cnrBatchYn = cnrBatchYn;
    }
    public String getCardChrgDscntCont() {
        return cardChrgDscntCont;
    }
    public void setCardChrgDscntCont(String cardChrgDscntCont) {
        this.cardChrgDscntCont = cardChrgDscntCont;
    }
    public String getCardChrgDscntContCn() {
        return cardChrgDscntContCn;
    }
    public void setCardChrgDscntContCn(String cardChrgDscntContCn) {
        this.cardChrgDscntContCn = cardChrgDscntContCn;
    }
    public String getUpdateColume() {
        return updateColume;
    }
    public void setUpdateColume(String updateColume) {
        this.updateColume = updateColume;
    }
    public String getUpdateValue() {
        return updateValue;
    }
    public void setUpdateValue(String updateValue) {
        this.updateValue = updateValue;
    }
    public String getPopRcmndWord() {
        return popRcmndWord;
    }
    public void setPopRcmndWord(String popRcmndWord) {
        this.popRcmndWord = popRcmndWord;
    }
    public String getLastModAdminId() {
        return lastModAdminId;
    }
    public void setLastModAdminId(String lastModAdminId) {
        this.lastModAdminId = lastModAdminId;
    }
    public Date getLastModDtm() {
        return lastModDtm;
    }
    public void setLastModDtm(Date lastModDtm) {
        this.lastModDtm = lastModDtm;
    }
    public String getUpBuyTermMm() {
        return upBuyTermMm;
    }
    public void setUpBuyTermMm(String upBuyTermMm) {
        this.upBuyTermMm = upBuyTermMm;
    }
    public String getGradeKeepTermMm() {
        return gradeKeepTermMm;
    }
    public void setGradeKeepTermMm(String gradeKeepTermMm) {
        this.gradeKeepTermMm = gradeKeepTermMm;
    }
    

}
