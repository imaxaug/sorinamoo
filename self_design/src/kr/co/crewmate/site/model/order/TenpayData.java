package kr.co.crewmate.site.model.order;

import kr.co.crewmate.site.model.ToString;

import org.json.simple.JSONObject;

/**
 * 
 * 클래스명: <code>LGUPlus</code>
 * 
 * <pre>
 *  LG U+ 연동 결제시 결제 관련 데이터를 저장하는 모델 클래스
 * </pre>
 * 
 * @author lionjk
 * @date 2013. 6. 17.
 * 
 */
public class TenpayData extends ToString {
	
	// api이름 (결제요청:pay, 결과통보:notify, 결과검증:verify, 환불요청:refund, 정산정보조회:reconcile, 환율조회:rate)
	private String apiName;
	// 상점ID
	private String merchantId;
	// 결제 요청PG (ALIPAY:CNA, TENPAY:CNT)
	private String pgId;
	// 인터페이스 타입
	private String interfaceType;
	// 주문번호
	private String orderNum;
	// 환불요청번호
	private String refundId;
	// 환불요청 일련번호
	private int refundSeq;
	// 고객 이름(여권상 영문명)
	private String customerName;
	// 대표 상품 코드
	private String itemCode;
	// 대표 상품 이름
	private String itemTitle;
	// 결제 요청 통화
	private String payCurrency;
	// 결제 요청 금액
	private String payAmount;
	// 환불 요청 금액
	private String refundAmount;
	// 결제 요청 일자
	private String reqDate;
	
	// 통보유형 (결제결과통보:PRNO, PG사통보:PGNO, 상점확인요청:MREQ)
	private String notifyType;
	// 통보 시간
	private String notifyTime;
	// 결제 상태
	private String payStatus;
	// PG 부여 고유번호
	private String pgTradeId;
	// PB 부여 고유번호
	private String pbTradeId;
	// 해쉬값
	private String hashValue;
	
	// 요청구분 (지불결제:P, 환불결제:R)
	private String reqType;
	// 요청ID (지불결제:order_id, 환불결제:refund_id
	private String reqId;
	// 정산 시간
	private String settleTime;
	// 정산 통화
	private String settleCurrency;
	// 정산 금액
	private String settleAmount;
	
	// 결제요청 응답 코드 (정상:PA00)
	private String resCode;
	// 응답메세지 (결제요청 URL)
	private String resMsg;
	// 응답 시간 (형식:20140411140956)
	private String resTime;
	
	// 응답 데이터
	private JSONObject resJson;
	private String resJsonStr;
	
	private String rgstDtm;
	
	private String lastModDtm;
	
	private int tenpaySeq;

	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getPgId() {
		return pgId;
	}
	public void setPgId(String pgId) {
		this.pgId = pgId;
	}
	public String getInterfaceType() {
		return interfaceType;
	}
	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public String getPayCurrency() {
		return payCurrency;
	}
	public void setPayCurrency(String payCurrency) {
		this.payCurrency = payCurrency;
	}
	public String getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}
	public String getReqDate() {
		return reqDate;
	}
	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}
	public String getNotifyType() {
		return notifyType;
	}
	public void setNotifyType(String notifyType) {
		this.notifyType = notifyType;
	}
	public String getNotifyTime() {
		return notifyTime;
	}
	public void setNotifyTime(String notifyTime) {
		this.notifyTime = notifyTime;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public String getPgTradeId() {
		return pgTradeId;
	}
	public void setPgTradeId(String pgTradeId) {
		this.pgTradeId = pgTradeId;
	}
	public String getPbTradeId() {
		return pbTradeId;
	}
	public void setPbTradeId(String pbTradeId) {
		this.pbTradeId = pbTradeId;
	}
	public String getHashValue() {
		return hashValue;
	}
	public void setHashValue(String hashValue) {
		this.hashValue = hashValue;
	}
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	public String getResTime() {
		return resTime;
	}
	public void setResTime(String resTime) {
		this.resTime = resTime;
	}
	public int getTenpaySeq() {
		return tenpaySeq;
	}
	public void setTenpaySeq(int tenpaySeq) {
		this.tenpaySeq = tenpaySeq;
	}
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public String getSettleTime() {
		return settleTime;
	}
	public void setSettleTime(String settleTime) {
		this.settleTime = settleTime;
	}
	public String getSettleCurrency() {
		return settleCurrency;
	}
	public void setSettleCurrency(String settleCurrency) {
		this.settleCurrency = settleCurrency;
	}
	public String getSettleAmount() {
		return settleAmount;
	}
	public void setSettleAmount(String settleAmount) {
		this.settleAmount = settleAmount;
	}
	public String getRefundId() {
		return refundId;
	}
	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public JSONObject getResJson() {
		return resJson;
	}
	public void setResJson(JSONObject resJson) {
		this.resJson = resJson;
	}
	public String getResJsonStr() {
		return resJsonStr;
	}
	public void setResJsonStr(String resJsonStr) {
		this.resJsonStr = resJsonStr;
	}
	public String getRgstDtm() {
		return rgstDtm;
	}
	public void setRgstDtm(String rgstDtm) {
		this.rgstDtm = rgstDtm;
	}
	public String getLastModDtm() {
		return lastModDtm;
	}
	public void setLastModDtm(String lastModDtm) {
		this.lastModDtm = lastModDtm;
	}
	public int getRefundSeq() {
		return refundSeq;
	}
	public void setRefundSeq(int refundSeq) {
		this.refundSeq = refundSeq;
	}
	public String getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}


}
