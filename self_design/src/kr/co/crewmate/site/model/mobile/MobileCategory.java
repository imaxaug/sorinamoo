package kr.co.crewmate.site.model.mobile;

import java.util.List;

import kr.co.crewmate.site.model.category.Category;

public class MobileCategory {

    /**
     * 카테고리아이디
     */
    private String ctgrId;
    
    /**
     * 카테고리명
     */
    private String ctgrName;
    
    /**
     * 카테고리명[중국]
     */
    private String ctgrNameCn;
    
	/**
     * 하위 카테고리
     */
    private List<Category> depthCategory;
    
    public String getCtgrId() {
        return ctgrId;
    }
    public void setCtgrId(String ctgrId) {
        this.ctgrId = ctgrId;
    }
    public String getCtgrName() {
        return ctgrName;
    }
    public void setCtgrName(String ctgrName) {
        this.ctgrName = ctgrName;
    }
    public String getCtgrNameCn() {
		return ctgrNameCn;
	}
	public void setCtgrNameCn(String ctgrNameCn) {
		this.ctgrNameCn = ctgrNameCn;
	}
	
    public List<Category> getDepthCategory() {
        return depthCategory;
    }
    public void setDepthCategory(List<Category> depthCategory) {
        this.depthCategory = depthCategory;
    }
}
