package kr.co.crewmate.site.model.common;

import kr.co.crewmate.site.model.ToString;


/**
 * 
 * 클래스명: <code>Differ</code>
 *
 * <pre>
 *  비교클래스(두모델의 비교분을 저장한다)
 *  WORK WORK_HISTORY 의 부모클래스 
 *  
 * </pre>
 *
 * @author 이경연
 * @date 2012. 5. 21.
 *
 */
@SuppressWarnings("serial")
public class Differ extends ToString {
    
    /**
     * 필드물리적이름
     */
    private String field;
    
    /**
     * 필드논리적이름
     */
    private String fieldName;
    
    /**
     * 구 필드값
     */
    private String oldFieldValue;
    
    /**
     * 신 필드값
     */
    private String newFieldValue;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getOldFieldValue() {
        return oldFieldValue;
    }

    public void setOldFieldValue(String oldFieldValue) {
        this.oldFieldValue = oldFieldValue;
    }

    public String getNewFieldValue() {
        return newFieldValue;
    }

    public void setNewFieldValue(String newFieldValue) {
        this.newFieldValue = newFieldValue;
    }
}
