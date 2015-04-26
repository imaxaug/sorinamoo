package kr.co.crewmate.site.model;

import java.util.Date;


/**
 * 클래스명: <code>Cart</code>
 *
 * <pre>
 *  장바구니 정보를 저장하는 모델 클래스
 * </pre>
 *
 * @author 이경연
 * @date 2013. 5. 22.
 */
public class CommonCode extends ToString {
    private String codeClassId;
    private String codeClass;
    private String codeKey;
    private String codeValue;
    private String codeOrder;
    private String codeDesc;
    private String codeUseYN;
    private Date createDate;
    private Date lastUpdate;

    public CommonCode(String codeClass) {
    	setCodeClass(codeClass);
    }

    public CommonCode() {

    }

	public String getCodeClass() {
		return codeClass;
	}
	public void setCodeClass(String codeClass) {
		this.codeClass = codeClass;
	}
	public String getCodeKey() {
		return codeKey;
	}
	public void setCodeKey(String codeKey) {
		this.codeKey = codeKey;
	}
	public String getCodeValue() {
		return codeValue;
	}
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
	public String getCodeOrder() {
		return codeOrder;
	}
	public void setCodeOrder(String codeOrder) {
		this.codeOrder = codeOrder;
	}
	public String getCodeDesc() {
		return codeDesc;
	}
	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}
	public String getCodeUseYN() {
		return codeUseYN;
	}
	public void setCodeUseYN(String codeUseYN) {
		this.codeUseYN = codeUseYN;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getCodeClassId() {
		return codeClassId;
	}
	public void setCodeClassId(String codeClassId) {
		this.codeClassId = codeClassId;
	}

}