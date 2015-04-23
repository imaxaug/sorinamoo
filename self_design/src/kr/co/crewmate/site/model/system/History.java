package kr.co.crewmate.site.model.system;

import kr.co.crewmate.site.model.ToString;

public class History extends ToString{

    private String oldFieldValue;
    private String newFieldValue;
    private String fieldName;
    private String adminId;
    private String adminName;
    private String rgstDtm;
    
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
    public String getFieldName() {
        return fieldName;
    }
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    public String getAdminId() {
        return adminId;
    }
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    public String getAdminName() {
        return adminName;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public String getRgstDtm() {
        return rgstDtm;
    }
    public void setRgstDtm(String rgstDtm) {
        this.rgstDtm = rgstDtm;
    }
    
}
