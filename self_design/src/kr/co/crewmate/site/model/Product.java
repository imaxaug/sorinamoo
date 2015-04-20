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
public class Product extends ToString {
    private String goodsCode;
    private String goodsName;
    private int hitCount;
    private int likeCount;
    private String useYN;
    private String displayYN;
    private Date createDate;
    private Date lastUpdate;
    private String hot;
    private String best;
    private String descTitle;
    private String descCont;
    private String color;
    private String size;
    private String price;
    private String extraPrice;
    private String type;

	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getHitCount() {
		return hitCount;
	}
	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public String getUseYN() {
		return useYN;
	}
	public void setUseYN(String useYN) {
		this.useYN = useYN;
	}
	public String getDisplayYN() {
		return displayYN;
	}
	public void setDisplayYN(String displayYN) {
		this.displayYN = displayYN;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getHot() {
		return hot;
	}
	public void setHot(String hot) {
		this.hot = hot;
	}
	public String getBest() {
		return best;
	}
	public void setBest(String best) {
		this.best = best;
	}
	public String getDescTitle() {
		return descTitle;
	}
	public void setDescTitle(String descTitle) {
		this.descTitle = descTitle;
	}
	public String getDescCont() {
		return descCont;
	}
	public void setDescCont(String descCont) {
		this.descCont = descCont;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getExtraPrice() {
		return extraPrice;
	}
	public void setExtraPrice(String extraPrice) {
		this.extraPrice = extraPrice;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}