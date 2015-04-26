package kr.co.crewmate.site.model.common;

import kr.co.crewmate.site.model.PageParam;

/**
 * 
 * 클래스명: <code>PostNumCriteria</code>
 *
 * <pre>
 *  우편번호 검색 및 페이지 처리를 위한 모델 클래스
 * </pre>
 *
 * @author newstar000
 * @date 2011. 12. 12.
 *
 */
public class PostNumCriteria extends PageParam {

    /**
     * 검색여부 (최초 팝업 열었을때 list 보여주지 않기위한 변수)
     */
    private boolean searchYn;
    
    /**
     * <pre>
     * 검색 타입
     * 1: 도로명 + 건물번호
     * 2: 동(읍/면/리)명 + 지번
     * 3: 지번주소
     * 4: 건물명(아파트 명)
     * 5: 사서함 + 사서함번호
     * </pre>
     */
    private String searchType;
    
    /**
     * 기본 검색어
     */
    private String searchText;
    
    /**
     * 건물번호
     */
    private String searchBldg;
    
    private String searchDoro;
    
    private String searchMainNum;
    
    private String searchSubNum;
    
    private String si;
    
    private String gu;
    
    private String areaId;
    
    private String style;
    
    private String paramId;
    
    private String serviceYn;
    
    private String searchDong;
    
    public String getSearchDong() {
        return searchDong;
    }

    public void setSearchDong(String searchDong) {
        this.searchDong = searchDong;
    }

    public String getSearchBldg() {
        return searchBldg;
    }

    public void setSearchBldg(String searchBldg) {
        this.searchBldg = searchBldg;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public boolean isSearchYn() {
        return searchYn;
    }

    public void setSearchYn(boolean searchYn) {
        this.searchYn = searchYn;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchDoro() {
        return searchDoro;
    }

    public void setSearchDoro(String searchDoro) {
        this.searchDoro = searchDoro;
    }

    public String getSearchMainNum() {
        return searchMainNum;
    }

    public void setSearchMainNum(String searchMainNum) {
        this.searchMainNum = searchMainNum;
    }

    public String getSearchSubNum() {
        return searchSubNum;
    }

    public void setSearchSubNum(String searchSubNum) {
        this.searchSubNum = searchSubNum;
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

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getParamId() {
        return paramId;
    }

    public void setParamId(String paramId) {
        this.paramId = paramId;
    }

    public String getServiceYn() {
        return serviceYn;
    }

    public void setServiceYn(String serviceYn) {
        this.serviceYn = serviceYn;
    }
}
