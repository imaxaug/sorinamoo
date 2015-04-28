package kr.co.crewmate.site.model;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
public class Product extends ToString {
    private String productId;
    private String productName;
    private int hitCount;
    private int likeCount;
    private String useYN;
    private String displayYN;
    private Date createDate;
    private Date lastUpdate;
    private String hot;
    private String best;
    private String descTitle;
    private String description;
    private String color;
    private String size;
    private String price;
    private String extraPrice;
    private String type;
    private String filePath;
    private String catalog;
    private String category;
    private String sizeFilePath;
    private String sizeFileName;
    private List<Canvas> canvas;
    private LinkedHashMap<String, List<Product>> colorAry;
    private LinkedHashMap<String, List<TypeSize>> typeAry;
    private List<CommonCode> oriSizes;
    private List<Product> sizes;
    private List<Product> files;
    private List<Product> prices;

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
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<Canvas> getCanvas() {
		return canvas;
	}
	public void setCanvas(List<Canvas> canvas) {
		this.canvas = canvas;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSizeFilePath() {
		return sizeFilePath;
	}
	public void setSizeFilePath(String sizeFilePath) {
		this.sizeFilePath = sizeFilePath;
	}
	public String getSizeFileName() {
		return sizeFileName;
	}
	public void setSizeFileName(String sizeFileName) {
		this.sizeFileName = sizeFileName;
	}
	public HashMap<String, List<TypeSize>> getTypeAry() {
		return typeAry;
	}
	public void setTypeAry(LinkedHashMap<String, List<TypeSize>> typeAry) {
		this.typeAry = typeAry;
	}
	public List<Product> getSizes() {
		return sizes;
	}
	public void setSizes(List<Product> sizes) {
		this.sizes = sizes;
	}
	public List<CommonCode> getOriSizes() {
		return oriSizes;
	}
	public void setOriSizes(List<CommonCode> oriSizes) {
		this.oriSizes = oriSizes;
	}
	public List<Product> getFiles() {
		return files;
	}
	public void setFiles(List<Product> files) {
		this.files = files;
	}
	public List<Product> getPrices() {
		return prices;
	}
	public void setPrices(List<Product> prices) {
		this.prices = prices;
	}
	public HashMap<String, List<Product>> getColorAry() {
		return colorAry;
	}
	public void setColorAry(LinkedHashMap<String, List<Product>> colorAry) {
		this.colorAry = colorAry;
	}

}