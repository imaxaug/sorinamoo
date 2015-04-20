package kr.co.crewmate.site.model;

import java.util.Date;


/**
 * 클래스명: <code>Cart</code>
 *
 * <pre>
 *  장바구니 정보를 저장하는 모델 클래스
 * </pre>
 *
 * @author 이경연
 * @date 2013. 5. 22.
 */
public class Order extends ToString {
    private String orderNum;
    private String userId;
    private int price;
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}