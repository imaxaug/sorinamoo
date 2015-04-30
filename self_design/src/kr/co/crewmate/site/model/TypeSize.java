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
    private String productId;
    private String fileType;
    private String size;
    private int locTop;
    private int locLeft;
    private int locWidth;
    private int locHeight;
    private String sizeName;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
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
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
}