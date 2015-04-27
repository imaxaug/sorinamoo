package kr.co.crewmate.site.model;

import java.util.Date;
import java.util.List;


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
public class TypeSize extends ToString {
    private String productType;
    private String productSize;
    private int locTop;
    private int locLeft;
    private int locWidth;
    private int locHeight;
    private String productId;
    private String sizeName;

	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public int getLocTop() {
		return locTop;
	}
	public void setLocTop(int locTop) {
		this.locTop = locTop;
	}
	public int getLocLeft() {
		return locLeft;
	}
	public void setLocLeft(int locLeft) {
		this.locLeft = locLeft;
	}
	public int getLocWidth() {
		return locWidth;
	}
	public void setLocWidth(int locWidth) {
		this.locWidth = locWidth;
	}
	public int getLocHeight() {
		return locHeight;
	}
	public void setLocHeight(int locHeight) {
		this.locHeight = locHeight;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

}