package kr.co.crewmate.site.model;

import java.util.Date;


/**
 * 클래스명: <code>Product</code>
 *
 * <pre>
 *  상품 정보를 저장하는 모델 클래스
 * </pre>
 *
 * @author 이경연
 * @date 2013. 5. 22.
 */
public class Design extends ToString {
    private String design_id;
    private String design_name;
    private String file_path;
    private String price;
    private String premium_yn;
    private String desc;
    private String seller_id;
	public String getDesign_id() {
		return design_id;
	}
	public void setDesign_id(String design_id) {
		this.design_id = design_id;
	}
	public String getDesign_name() {
		return design_name;
	}
	public void setDesign_name(String design_name) {
		this.design_name = design_name;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPremium_yn() {
		return premium_yn;
	}
	public void setPremium_yn(String premium_yn) {
		this.premium_yn = premium_yn;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}


}