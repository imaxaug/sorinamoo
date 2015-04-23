package kr.co.crewmate.site.model.common;

import kr.co.crewmate.site.model.PageParam;


/**
 * 
 * 클래스명: <code>CodeCriteria</code>
 *
 * <pre>
 *  코드 정보 검색 및 페이지 처리를 위한 모델 클래스
 * </pre>
 *
 * @author newstar000
 * @date 2011. 11. 11.
 *
 */
@SuppressWarnings("serial")
public class CodeCriteria extends PageParam {

    /**
     * 코드 클래스
     */
    private String codeClass;
    
    /**
     * 코드 이름
     */
    private String codeName;
    
    /**
     * 코드 값
     */
    private String codeValue;
    
    /**
     * 중국어 코드값
     */
    private String codeValueCn;
    
    /**
     * 사용여부
     */
    private Boolean codeUseYn;
    
    private String rgstStartDtm;
    
    private String rgstEndDtm;
    
    private String decorator;
    
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

    private String codeSelect;
    
    private String codeClassName;
    
    public String getCodeClass() {
        return codeClass;
    }

    public void setCodeClass(String codeClass) {
        this.codeClass = codeClass;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public Boolean getCodeUseYn() {
        return codeUseYn;
    }

    public void setCodeUseYn(Boolean codeUseYn) {
        this.codeUseYn = codeUseYn;
    }

    public String getCodeSelect() {
        return codeSelect;
    }

    public void setCodeSelect(String codeSelect) {
        this.codeSelect = codeSelect;
    }

    public String getCodeClassName() {
        return codeClassName;
    }

    public void setCodeClassName(String codeClassName) {
        this.codeClassName = codeClassName;
    }

    public String getDecorator() {
        return decorator;
    }

    public void setDecorator(String decorator) {
        this.decorator = decorator;
    }

    public String getCodeValueCn() {
        return codeValueCn;
    }

    public void setCodeValueCn(String codeValueCn) {
        this.codeValueCn = codeValueCn;
    }
}

