package kr.co.crewmate.site.model.product;

import java.util.List;

import kr.co.crewmate.site.model.PageParam;
import kr.co.crewmate.site.model.Product;

/**
 *
 * 클래스명: <code>UserCriteria</code>
 *
 * <pre>
 *  회원 리스트를 검색 및 페이지 처리를 위한 모델 클래스
 * </pre>
 *
 * @author 남세건
 * @date 2013.5.24
 *
 */
public class ProductCriteria extends Product {

    private String baseProduct;
	private String topic;

	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getBaseProduct() {
		return baseProduct;
	}

	public void setBaseProduct(String baseProduct) {
		this.baseProduct = baseProduct;
	}

}
