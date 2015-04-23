package kr.co.crewmate.site.model.system;

import kr.co.crewmate.site.model.ToString;

/**
 * 테이블 정보를 담기 위한 모델 객체
 * @author 남세건
 *
 */
public class Table extends ToString {
    
    private String tableName;
    
    private String koreanName;
    
    private String columnName;
    
    private String dataType;
    
    private String dataLength;
    
    private String nullable;
    
    private String indexOX;
    
    private String pkOX;
    
    private String fkOX;
    
    private String note;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataLength() {
        return dataLength;
    }

    public void setDataLength(String dataLength) {
        this.dataLength = dataLength;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getNullable() {
        return nullable;
    }

    public void setNullable(String nullable) {
        this.nullable = nullable;
    }

    public String getIndexOX() {
        return indexOX;
    }

    public void setIndexOX(String indexOX) {
        this.indexOX = indexOX;
    }

    public String getPkOX() {
        return pkOX;
    }

    public void setPkOX(String pkOX) {
        this.pkOX = pkOX;
    }

    public String getFkOX() {
        return fkOX;
    }

    public void setFkOX(String fkOX) {
        this.fkOX = fkOX;
    }

    public String getKoreanName() {
        return koreanName;
    }

    public void setKoreanName(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
}
