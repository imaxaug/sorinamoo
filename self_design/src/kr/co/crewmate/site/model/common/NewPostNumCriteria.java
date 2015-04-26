package kr.co.crewmate.site.model.common;

import kr.co.crewmate.site.model.PageParam;

public class NewPostNumCriteria extends PageParam {
    
    private boolean firstSearch = true;
    
    private String type;

    private String si;
    
    private String gu;
    
    private String doroName;
    
    private String bldgMainNum;
    
    private boolean valueOk;
    
    private String searchValue;
    
    private String dong;
    
    private String bldgName;
    
    
    private String startMainNum;
    
    private String startSubNum;
    
    
    private String lawDongName;
    
    private String landMainNum;
    
    private String landSubNum;
    
    
    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public boolean isValueOk() {
        return valueOk;
    }

    public void setValueOk(boolean valueOk) {
        this.valueOk = valueOk;
    }

    public boolean isFirstSearch() {
        return firstSearch;
    }

    public void setFirstSearch(boolean firstSearch) {
        this.firstSearch = firstSearch;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public String getStartMainNum() {
        return startMainNum;
    }

    public void setStartMainNum(String startMainNum) {
        this.startMainNum = startMainNum;
    }

    public String getStartSubNum() {
        return startSubNum;
    }

    public void setStartSubNum(String startSubNum) {
        this.startSubNum = startSubNum;
    }

    public String getBldgName() {
        return bldgName;
    }

    public void setBldgName(String bldgName) {
        this.bldgName = bldgName;
    }

    public String getLawDongName() {
        return lawDongName;
    }

    public void setLawDongName(String lawDongName) {
        this.lawDongName = lawDongName;
    }

    public String getLandMainNum() {
        return landMainNum;
    }

    public void setLandMainNum(String landMainNum) {
        this.landMainNum = landMainNum;
    }

    public String getLandSubNum() {
        return landSubNum;
    }

    public void setLandSubNum(String landSubNum) {
        this.landSubNum = landSubNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSi() {
        return si;
    }

    public void setSi(String si) {
        this.si = si;
    }

    public String getGu() {
        return gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }

    public String getDoroName() {
        return doroName;
    }

    public void setDoroName(String doroName) {
        this.doroName = doroName;
    }

    public String getBldgMainNum() {
        return bldgMainNum;
    }

    public void setBldgMainNum(String bldgMainNum) {
        this.bldgMainNum = bldgMainNum;
    }
    
}
