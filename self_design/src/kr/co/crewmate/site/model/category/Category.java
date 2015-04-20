package kr.co.crewmate.site.model.category;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.co.crewmate.site.CodeName;
import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.model.Parameter;
import kr.co.crewmate.site.model.ToString;

/**
 * 클래스명: <code>Category</code>
 *
 * <pre>
 *  잘좀하자
 * </pre>
 *
 * @author 이경훈
 * @date 2013. 4. 16.
 *
 */
public class Category extends ToString implements Parameter {
    
    final String natnCode;
    
    private String ctgrId;
    
    private String koreanItemYn;
    
    /**
     * 부모 카테고리
     */
    private String prntCtgrId;
    
    /**
     * 사용여부
     */
    private boolean useYn;

    /**
     * 코드 값
     */
    private String ctgrValue;
    
    /**
     * 코드 이름
     */
    private String ctgrName;
    
    private String ctgrNameCn;
    
    private String itemCode;
    
    private Date rgstDtm;
    
    private Integer dispOrder;
    
    private String ctgrPathName;
    
    private String cnt;
    
    private String prntCtgrnName;
    
    private String rgstAdminId;
    
    private String lastModAdminId;
    
    private String lastModDtm;
    
    private String rgstStrDtm;
    
    private String categorySelectName;
    
    private String rgstAdminName;
    
    private String lastModAdminName;
    
    private List<Category> subCategory;
    
    private String ctgrNameEn;
       
    /**
     * 브랜드샵 상품 그룹 아이디
     */
    private String prdtGroupId;
    private String brandId;
    
    private String imageUrl;
    
    
    public Category() {
        this.natnCode = Config.getSiteNatnCode();
    }
    
    public String getRgstStrDtm() {
        return rgstStrDtm;
    }

    public void setRgstStrDtm(String rgstStrDtm) {
        this.rgstStrDtm = rgstStrDtm;
    }

    public String getRgstAdminId() {
        return rgstAdminId;
    }

    public void setRgstAdminId(String rgstAdminId) {
        this.rgstAdminId = rgstAdminId;
    }

    public String getLastModAdminId() {
        return lastModAdminId;
    }

    public void setLastModAdminId(String lastModAdminId) {
        this.lastModAdminId = lastModAdminId;
    }

    public String getLastModDtm() {
        return lastModDtm;
    }

    public void setLastModDtm(String lastModDtm) {
        this.lastModDtm = lastModDtm;
    }

    public String getPrntCtgrnName() {
        return prntCtgrnName;
    }

    public void setPrntCtgrnName(String prntCtgrnName) {
        this.prntCtgrnName = prntCtgrnName;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    /**
     * 계층 레벨
     */
    private String lev;
    
    

    public String getLev() {
        return lev;
    }

    public void setLev(String lev) {
        this.lev = lev;
    }

    public String getCtgrId() {
        return ctgrId;
    }

    public void setCtgrId(String ctgrId) {
        this.ctgrId = ctgrId;
    }

    public String getPrntCtgrId() {
        return prntCtgrId;
    }

    public void setPrntCtgrId(String prntCtgrId) {
        this.prntCtgrId = prntCtgrId;
    }

    public boolean getUseYn() {
        return useYn;
    }

    public void setUseYn(boolean useYn) {
        this.useYn = useYn;
    }

    public String getCtgrValue() {
        return ctgrValue;
    }

    public void setCtgrValue(String ctgrValue) {
        this.ctgrValue = ctgrValue;
    }

    public String getCtgrName() {
        return ctgrName;
    }

    public void setCtgrName(String ctgrName) {
        this.ctgrName = ctgrName;
    }

    public Date getRgstDtm() {
        return rgstDtm;
    }

    public void setRgstDtm(Date rgstDtm) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.rgstStrDtm = format.format(rgstDtm);
    }

    @Override
    public String getKey() {
        return this.ctgrId;
    }

    @Override
    public String getValue() {
        if (this.categorySelectName == null) {
            if (CodeName.SITE_NATN_CODE_KR.equals(this.natnCode)) {
                this.categorySelectName = this.ctgrName;
            } else if (CodeName.SITE_NATN_CODE_CN.equals(this.natnCode)) {
                this.categorySelectName = this.ctgrNameCn;
            } else {
                throw new RuntimeException(String.format("존재하지않는 국적코드[%s]", this.natnCode));
            }
        } 
        
        return this.categorySelectName;
    }

    public Integer getDispOrder() {
        return dispOrder;
    }

    public void setDispOrder(Integer dispOrder) {
        this.dispOrder = dispOrder;
    }

    public String getCtgrPathName() {
        return ctgrPathName;
    }

    public void setCtgrPathName(String ctgrPathName) {
        this.ctgrPathName = ctgrPathName;
    }

    public String getCtgrNameCn() {
        return ctgrNameCn;
    }

    public void setCtgrNameCn(String ctgrNameCn) {
        this.ctgrNameCn = ctgrNameCn;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getCategorySelectName() {
        return categorySelectName;
    }

    public void setCategorySelectName(String categorySelectName) {
        this.categorySelectName = categorySelectName;
    }

    public String getNatnCode() {
        return natnCode;
    }

    public String getRgstAdminName() {
        return rgstAdminName;
    }

    public void setRgstAdminName(String rgstAdminName) {
        this.rgstAdminName = rgstAdminName;
    }

    public String getLastModAdminName() {
        return lastModAdminName;
    }

    public void setLastModAdminName(String lastModAdminName) {
        this.lastModAdminName = lastModAdminName;
    }

	public List<Category> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<Category> subCategory) {
		this.subCategory = subCategory;
	}

	public String getPrdtGroupId() {
		return prdtGroupId;
	}

	public void setPrdtGroupId(String prdtGroupId) {
		this.prdtGroupId = prdtGroupId;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

    public String getCtgrNameEn() {
        return ctgrNameEn;
    }

    public void setCtgrNameEn(String ctgrNameEn) {
        this.ctgrNameEn = ctgrNameEn;
    }

	public String getKoreanItemYn() {
		return koreanItemYn;
	}

	public void setKoreanItemYn(String koreanItemYn) {
		this.koreanItemYn = koreanItemYn;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
