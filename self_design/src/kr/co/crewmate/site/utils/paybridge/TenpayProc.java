package kr.co.crewmate.site.utils.paybridge;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import kr.co.crewmate.site.Constants;
import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.exceptions.PaymentException;
//import kr.co.crewmate.site.model.order.OrderParam;
import kr.co.crewmate.site.model.order.TenpayData;
import kr.co.crewmate.site.utils.Utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Service;

/**
 * 텐페이 견제 연동 클라이언튼
 * @author NOP_DEV
 *
 */
@Service
public class TenpayProc {
	
	// 통합 Gateway Host Name을 설정합니다.
    private static final String gateway_host1 = "gwk.tianmibao.com";
    private static final String gateway_host2 = "gwk1.tianmibao.com";
    private static final String gateway_host3 = "gwk2.tianmibao.com";
	
	// PayBridge 통화 (미국달러:USD, 중국인민폐:CNY, 홍콩달러:HKD, 원화:KRW)
	private final static String PAYBRIDGE_CURRENCY = "USD";
	
	// 문자열 인코딩 값을 설정합니다.
	private static final String char_set = "utf-8";
	
	/**
	 * 결제 요청
	 * @param pg_id
	 * @param interfaceType
	 * @param orderInfo
	 * @param remoteIp
	 * @return
	 */
//	public static TenpayData makePayReq(String pg_id, String interfaceType, OrderParam orderInfo, String remoteIp){
//		MakeHash makeHash = new MakeHash(); //해쉬 기능 클래스 
//		JSONObject jsonRequest = new JSONObject(); //Json 기능 클래스
//
//		if(StringUtils.isEmpty(interfaceType))
//			interfaceType = Constants.PAYBRIDGE_INTERFACE_PC_WEB;
//    	
//		String order_id = orderInfo.getOrderNum();
//    	String item_code = (orderInfo.getPrdtCode()!=null && orderInfo.getPrdtCode().size()>0)?orderInfo.getPrdtCode().get(0):""; // 상품코드(주문세션ID)
//    	String item_title = orderInfo.getPrdtName(); //영문 상품명
//    	String pay_amount = "";	// 결제 금액
//    	if("test".equals(Config.getString("tenpay.platform")))
//    		pay_amount = "0.01"; 
//    	else
//    		pay_amount = orderInfo.getOrderAmtDal().toString();
//    	
//    	String pay_currency = PAYBRIDGE_CURRENCY; // 결제 통화 (계약시에 신청한 통화로 변경하실 경우에는 통보하여 주십시오.)
//    	String customer_name = orderInfo.getBuyerNameEng(); // 영문 고객 이름(여권기준)
//    	
//    	
//    	// 주요 파라미터에 대한 위변조를 확인할 수 있도록 해쉬처리합니다. (순서를 변경하시면 안됩니다)
//    	String hashValueStr = Config.getString("tenpay.mertId")
//				+ pg_id
//				+ interfaceType
//				+ order_id
//				+ item_code
//				+ pay_amount
//				+ pay_currency
//				+ Config.getString("tenpay.hashKey");		
//		String hash_value = makeHash.sha(hashValueStr, char_set);	
//
//		// Json 객체에 파라미터를 담습니다.
//		jsonRequest.put("api_name", "pay");
//		jsonRequest.put("merchant_id", Config.getString("tenpay.mertId"));
//		jsonRequest.put("pg_id", pg_id);
//		jsonRequest.put("interface_type", interfaceType);
//		jsonRequest.put("order_id", order_id);
//		jsonRequest.put("customer_name", customer_name);
//		jsonRequest.put("item_code", item_code);
//		jsonRequest.put("item_title", item_title);
//		jsonRequest.put("pay_currency", pay_currency);
//		jsonRequest.put("pay_amount", pay_amount);
//		jsonRequest.put("hash_value", hash_value);
//		jsonRequest.put("etc", remoteIp);
//
//		return getJSONObjectResponse(jsonRequest);
//	}
	
	/**
	 * 환불 요청
	 * @param pg_id
	 * @param order_id
	 * @param cnclAcptSeq
	 * @param refundAmt
	 * @return
	 */
	public static TenpayData makeRefundRequest(String pg_id, String order_id, int cnclAcptSeq, String refundAmt){
		MakeHash makeHash = new MakeHash(); //해쉬 기능 클래스 
		JSONObject jsonRequest = new JSONObject(); //Json 기능 클래스
		DateUtil dateUtil = new DateUtil();
		
		// 요청 파라미터 정보를 설정합니다.
    	String refund_id = "CNCL"+order_id+"_"+cnclAcptSeq; //환불 결제 ID
    	String refund_req_time = dateUtil.getNowFullTime("yyyyMMddHHmmssSSS"); //환불 요청 시간
    	String refund_amount = ""; //환불 요청 금액, 통화는 상점 정보로 설정
    	if("test".equals(Config.getString("tenpay.platform")))
    		refund_amount = "0.01"; 
    	else
    		refund_amount = refundAmt;

    	String fee_deduct_yn = "N"; //PG 수수료 차감 여부, 차감하는 경우 "Y", 차감하지 않는 경우 "N"
    	String refund_reason = "CR"; //환불 요청 사유, 고객 단순요청은 "CR", 품절(또는 판매중지)은 "SO", 반품(불량/교환/상품불일치)은 "RT", 구매가능시간 초과는 "TO", 그외는 "ET"
    	
    	// 주요 파라미터에 대한 위변조를 확인할 수 있도록 해쉬처리합니다. (순서를 변경하시면 안됩니다)
    	String hashValueStr = Config.getString("tenpay.mertId")
				+ pg_id
				+ refund_id
				+ refund_amount
				+ fee_deduct_yn
				+ refund_reason
				+ order_id
				+ Config.getString("tenpay.hashKey");		
		String hash_value = makeHash.sha(hashValueStr, char_set);	

		// Json 객체에 파라미터를 담습니다.
		jsonRequest.put("api_name", "refund");
		jsonRequest.put("merchant_id", Config.getString("tenpay.mertId"));
		jsonRequest.put("pg_id", pg_id);
		jsonRequest.put("refund_id", refund_id);
		jsonRequest.put("refund_req_time", refund_req_time);
		jsonRequest.put("refund_amount", refund_amount);
		jsonRequest.put("fee_deduct_yn", fee_deduct_yn);
		jsonRequest.put("refund_reason", refund_reason);
		jsonRequest.put("order_id", order_id);
		jsonRequest.put("hash_value", hash_value);
		
		// 게이트웨이로 요청메세지를 전송하고 응답메세지를 반환합니다.
		return getJSONObjectResponse(jsonRequest);
	}	

	/**
	 * 게이트웨이로 요청메세지를 전송하고 응답메세지를 출력
	 * @param enc_data
	 */
	public static TenpayData getJSONObjectResponse(JSONObject jsonRequest){
		setDataRequest(jsonRequest);
		
		// Json 객체를 상점 암호화 키로 AES 암호화합니다.
		AES aes = new AES(); //암복호화 기능 클래스
		String enc_data = aes.getSecure("ENCODE", jsonRequest.toJSONString(), Config.getString("tenpay.encKey"));

		TenpayData tenpay = null;
		
		HttpClient httpclient = null;
		JSONObject jsonResponse = null;
		try {
			// HTTP 연결을 시도하고 응답메세지를 얻습니다.
			HttpResponse response = makeHttpClient(httpclient, enc_data, null);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				entity = new BufferedHttpEntity(entity);
				
				// 응답메세지를 JSON 객체로 파싱합니다.
				jsonResponse = (JSONObject)JSONValue.parse(EntityUtils.toString(entity));
				
				if(jsonResponse != null){
					tenpay = new TenpayData();

					tenpay.setApiName((String) jsonRequest.get("api_name")+" response");
					tenpay.setMerchantId((String) jsonRequest.get("merchant_id"));
					tenpay.setPgId((String) jsonRequest.get("pg_id"));
					tenpay.setInterfaceType((String) jsonRequest.get("interface_type"));
					tenpay.setOrderNum((String) jsonRequest.get("order_id"));
					tenpay.setNotifyType((String) jsonResponse.get("notify_type"));
					tenpay.setNotifyTime((String) jsonResponse.get("notify_time"));
					tenpay.setCustomerName((String) jsonResponse.get("customer_name"));
					tenpay.setItemCode((String) jsonResponse.get("item_code"));
					tenpay.setItemTitle((String) jsonResponse.get("item_title"));
					tenpay.setPayCurrency((String) jsonResponse.get("pay_currency"));
					tenpay.setPayStatus((String) jsonResponse.get("pay_status"));
					tenpay.setPgTradeId((String) jsonResponse.get("pg_trade_id"));
					tenpay.setPbTradeId((String) jsonResponse.get("pb_trade_id"));
					tenpay.setHashValue((String) jsonResponse.get("hash_value"));

					if(jsonResponse.containsValue("pay_amount")){
						Double payAmt = (Double) jsonResponse.get("pay_amount");
						if(payAmt!=null)
							tenpay.setPayAmount(String.valueOf(payAmt));
					} else{
						tenpay.setPayAmount("0");
					}

					tenpay.setResCode((String) jsonResponse.get("res_code"));
					tenpay.setResMsg((String) jsonResponse.get("res_msg"));
					tenpay.setResTime((String) jsonResponse.get("res_time"));
					tenpay.setResJson(jsonResponse);
					tenpay.setResJsonStr(jsonResponse.toJSONString());

					try{
						Utils.writeTenpayFileLog(tenpay, "RESPONSE");
//						orderDao.insertTenpayHistory(tenpay);
					}catch(Exception e){e.printStackTrace();}
					
				}
				
				// HTTP 연결을 해제합니다.
				EntityUtils.consume(entity);
			}
		} catch (Throwable e) {
			String apiType = (String) jsonRequest.get("api_type");
			if("pay".equals(apiType))
				throw new PaymentException("결제 요청이 실패하였습니다.[주문번호:" + (String) jsonRequest.get("order_id") + "]");
			else if("refund".equals(apiType))
				throw new PaymentException("결제 취소요청이 실패하였습니다.[주문번호:" + (String) jsonRequest.get("order_id") + "]");
			else
				throw new PaymentException("요청이 실패하였습니다.");
		} finally {	
			if(httpclient!=null)
				httpclient.getConnectionManager().shutdown();
		}
		
		return tenpay;
	}
	

	/**
	 * 대사정보 및 정산정보 요청 샘플
	 */
	public static TenpayData[] makeReconcileRequest(String pg_id, String order_id){
		MakeHash makeHash = new MakeHash(); //해쉬 기능 클래스 
		JSONObject jsonRequest = new JSONObject(); //Json 기능 클래스

		// 요청 파라미터 정보를 설정합니다.
    	String req_type = "ID"; //기간 방식은 "DATE", ID 방식은 "ID"
    	String begin_date = "NnN"; //조회 시작 일자, 결제 요청일 기준, ID 방식일 경우에는 "NnN" 
    	String end_date = "NnN"; //조회 종료 일자, 결제 요청일 기준, ID 방식일 경우에는 "NnN" 
    	
    	// 주요 파라미터에 대한 위변조를 확인할 수 있도록 해쉬처리합니다. (순서를 변경하시면 안됩니다)
    	String hashValueStr = Config.getString("tenpay.mertId")
				+ req_type
				+ begin_date
				+ end_date
				+ order_id
				+ Config.getString("tenpay.hashKey");		
		String hash_value = makeHash.sha(hashValueStr, char_set);
		
		// Json 객체에 파라미터를 담습니다.
		jsonRequest.put("api_name", "reconcile");
		jsonRequest.put("merchant_id", Config.getString("tenpay.mertId"));
		jsonRequest.put("req_type", req_type);
		jsonRequest.put("begin_date", begin_date);
		jsonRequest.put("end_date", end_date);
		jsonRequest.put("order_id", order_id);
		jsonRequest.put("hash_value", hash_value);
		
		// 게이트웨이로 요청메세지를 전송하고 응답메세지를 반환합니다.
		return getJSONArrayResponse(jsonRequest);
	}	

	/**
	 * 게이트웨이로 요청메세지를 전송하고 응답메세지(JSONArray)를 복호화하여 출력
	 * @param enc_data
	 */
	private static TenpayData[] getJSONArrayResponse(JSONObject jsonRequest){
		// Json 객체를 상점 암호화 키로 AES 암호화합니다.
		AES aes = new AES(); //암복호화 기능 클래스
		String enc_data = aes.getSecure("ENCODE", jsonRequest.toJSONString(), Config.getString("tenpay.encKey"));

		TenpayData[] tenpay = null;

		HttpClient httpclient = null;
		JSONObject jsonResponse = null;
		try {
			// HTTP 연결을 시도하고 응답메세지를 얻습니다.
			HttpResponse response = makeHttpClient(httpclient, enc_data, null);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				entity = new BufferedHttpEntity(entity);
				
				// 응답메세지를 JSON 객체로 파싱합니다.
				jsonResponse = (JSONObject)JSONValue.parse(EntityUtils.toString(entity));
				String res_code = (String) jsonResponse.get("res_code");
				if (res_code.indexOf("00") > 0){// 정상처리인 경우, 상점 암호화키로 응답메세지를 복호화합니다.
					JSONArray res_msgs = (JSONArray)JSONValue.parse((String)jsonResponse.get("res_msg"));
					String hash_value = (String) jsonResponse.get("hash_value");
					
					// res_msg에 대한 올바른 해쉬값을 생성합니다.
					MakeHash makeHash = new MakeHash(); //해쉬 기능 클래스 
					String hash_value_standard = makeHash.sha((String)jsonResponse.get("res_msg") + Config.getString("tenpay.hashKey") , char_set);

					// 해쉬값을 검사하여 데이터 위변조를 확인합니다.
					if (hash_value.indexOf(hash_value_standard) < 0){
						return null; // 위변조된 경우로 해당 응답메세지를 폐기합니다. 관리자에게 확인을 요청하여 주십시오.
					}
					
					JSONObject res_msg = null;
					tenpay = new TenpayData[res_msgs.size()];
					int i = 0;
					for (Object obj: res_msgs){
						res_msg = (JSONObject)obj;
						System.out.println("res_msg = " + res_msg.toJSONString());
						
						if(res_msg != null){
							tenpay[i] = new TenpayData();
							
							tenpay[i].setApiName((String) jsonRequest.get("api_name")+" response");
							tenpay[i].setMerchantId((String) res_msg.get("merchant_id"));
							tenpay[i].setPgId((String) res_msg.get("pg_id"));
							tenpay[i].setInterfaceType((String) res_msg.get("interface_type"));
							tenpay[i].setCustomerName((String) res_msg.get("customer_name"));
							tenpay[i].setPayCurrency((String) res_msg.get("pay_currency"));
							tenpay[i].setPayStatus((String) res_msg.get("pay_status"));
							tenpay[i].setPgTradeId((String) res_msg.get("pg_trade_id"));
							tenpay[i].setSettleTime((String) res_msg.get("settle_time"));
							
							String reqType = (String) res_msg.get("req_type");
							tenpay[i].setReqType(reqType);
							tenpay[i].setReqId((String) res_msg.get("req_id"));
							
							if("R".equals(reqType)){
								tenpay[i].setOrderNum((String) res_msg.get("pb_remark"));
								
							}else{
								tenpay[i].setOrderNum((String) res_msg.get("req_id"));
								
							}
							
							if(res_msg.containsValue("pay_amount")){
								Double payAmt = (Double) res_msg.get("pay_amount");
								if(payAmt!=null)
									tenpay[i].setPayAmount(String.valueOf(payAmt));
							} else{
								tenpay[i].setPayAmount("0");
							}
							if(res_msg.containsValue("settle_amount")){
								Double settleAmount = (Double) res_msg.get("settle_amount");
								if(settleAmount!=null)
									tenpay[i].setSettleAmount(String.valueOf(settleAmount));
							} else{
								tenpay[i].setSettleAmount("0");
							}
							
							tenpay[i].setResCode((String) jsonResponse.get("res_code"));
							tenpay[i].setResMsg((String) res_msg.get("res_msg"));
							tenpay[i].setResTime((String) jsonResponse.get("res_time"));

							try{
								Utils.writeTenpayFileLog(tenpay[i], "RESPONSE");
//								orderDao.insertTenpayHistory(tenpay[i]);
								i++;
							}catch(Exception e){
								e.printStackTrace(); 
								continue;
							}
							
						}
					}
				}
				
				// HTTP 연결을 해제합니다.
				EntityUtils.consume(entity);
			}
			
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {	
			if(httpclient!=null)
				httpclient.getConnectionManager().shutdown();
		}	
		return tenpay;
	}

	private static TenpayData setDataRequest(JSONObject jsonRequest){
		TenpayData hist = new TenpayData();

		hist.setApiName((String) jsonRequest.get("api_name"));
		hist.setPgId((String) jsonRequest.get("pg_id"));
		hist.setInterfaceType((String) jsonRequest.get("interface_type"));
		hist.setOrderNum((String) jsonRequest.get("order_id"));
		hist.setItemCode((String) jsonRequest.get("item_code"));
		hist.setItemTitle((String) jsonRequest.get("item_title"));
		hist.setCustomerName((String) jsonRequest.get("customer_name"));
		if("refund".equals(hist.getApiName())){
			hist.setRefundId((String) jsonRequest.get("refund_id"));
			hist.setPayAmount((String) jsonRequest.get("refund_amount"));
		}else
			hist.setPayAmount((String) jsonRequest.get("pay_amount"));
		hist.setPayStatus((String) jsonRequest.get("pay_status"));
		hist.setHashValue((String) jsonRequest.get("hash_value"));
		hist.setResCode((String) jsonRequest.get("res_code"));
		hist.setResMsg((String) jsonRequest.get("res_msg"));

		try{
			Utils.writeTenpayFileLog(hist, "REQUEST");
//			orderDao.insertTenpayHistory(hist);
		}catch(Exception e){e.printStackTrace();}

		return hist;
	}
	
	/**
	 * 결제 결과 검증
	 */
	public TenpayData doVeifyRequest(String pg_id, String order_id){
		MakeHash makeHash = new MakeHash(); //해쉬 기능 클래스 
		JSONObject jsonRequest = new JSONObject(); //Json 기능 클래스
    	
    	// 주요 파라미터에 대한 위변조를 확인할 수 있도록 해쉬처리합니다. (순서를 변경하시면 안됩니다)
    	String hashValueStr = Config.getString("tenpay.mertId")
				+ order_id
				+ Config.getString("tenpay.hashKey");		
		String hash_value = makeHash.sha(hashValueStr, "utf-8");	
		
		// Json 객체에 파라미터를 담습니다.
		jsonRequest.put("api_name", "verify");
		jsonRequest.put("merchant_id", Config.getString("tenpay.mertId"));
		jsonRequest.put("order_id", order_id);
		jsonRequest.put("hash_value", hash_value);
		
		// 게이트웨이로 요청메세지를 전송하고 응답메세지를 반환합니다.
		return getEncJSONObjectResponse(jsonRequest);
	}	
	
	/**
	 * 게이트웨이로 요청메세지를 전송하고 응답메세지(JSONObject)를 복호화하여 출력
	 * @param enc_data
	 */
	private TenpayData getEncJSONObjectResponse(JSONObject jsonRequest){
		// TODO Auto-generated method stub
		// Json 객체를 상점 암호화 키로 AES 암호화합니다.
		AES aes = new AES(); //암복호화 기능 클래스
		String enc_data = aes.getSecure("ENCODE", jsonRequest.toJSONString(), Config.getString("tenpay.encKey"));

		TenpayData tenpay = null;

		HttpClient httpclient = null;
		JSONObject jsonResponse = null;
		try {
			// HTTP 연결을 시도하고 응답메세지를 얻습니다.
			HttpResponse response = makeHttpClient(httpclient, enc_data, null);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				entity = new BufferedHttpEntity(entity);
				
				// 응답메세지를 JSON 객체로 파싱합니다.
				jsonResponse = (JSONObject)JSONValue.parse(EntityUtils.toString(entity));
				String res_code = (String) jsonResponse.get("res_code");
				String res_msg_str = "";
				if (res_code.indexOf("00") > 0){// 정상처리인 경우, 상점 암호화키로 응답메세지를 복호화합니다.
					JSONObject res_msg = (JSONObject)JSONValue.parse(aes.getSecure("DECODE", (String)jsonResponse.get("res_msg"), Config.getString("tenpay.encKey")));
					res_msg_str = res_msg.toJSONString();
					System.out.println("res_msg = " + res_msg.toJSONString());
				}else
					res_msg_str = "";
				
				if(jsonResponse != null){
					tenpay = new TenpayData();

					tenpay.setApiName((String) jsonRequest.get("api_name"));
					tenpay.setOrderNum((String) jsonRequest.get("order_id"));
					tenpay.setHashValue((String) jsonRequest.get("hash_value"));
					tenpay.setResCode((String) jsonResponse.get("res_code"));
					tenpay.setResMsg(res_msg_str);
					tenpay.setResJson(jsonResponse);
					tenpay.setResJsonStr(jsonResponse.toJSONString());
					
					try{
						Utils.writeTenpayFileLog(tenpay, "RESPONSE");
					}catch(Exception e){e.printStackTrace();}
				}

				// HTTP 연결을 해제합니다.
				EntityUtils.consume(entity);
			}
			
		} catch (Throwable e) {
			throw new PaymentException("검증 요청이 실패하였습니다.[주문번호:" + (String) jsonRequest.get("order_id") + "]");
		} finally {	
			if(httpclient!=null)
				httpclient.getConnectionManager().shutdown();
		}	
		return tenpay;
	}

	/**
	 * enc_data 복호화
	 */
	public static TenpayData getJSONObjectDecrypt(String enc_data){
		TenpayData tenpay = null;
		JSONObject res_msg = null;
		
		AES aes = new AES(); //암복호화 기능 클래스
		JSONObject jsonResponse = (JSONObject)JSONValue.parse(aes.getSecure("DECODE", enc_data, Config.getString("tenpay.encKey")));
		
		if(jsonResponse != null){
			tenpay = new TenpayData();
			
			tenpay.setApiName((String) jsonResponse.get("api_name"));
			tenpay.setMerchantId((String) jsonResponse.get("merchant_id"));
			tenpay.setPgId((String) jsonResponse.get("pg_id"));
			tenpay.setInterfaceType((String) jsonResponse.get("interface_type"));
			tenpay.setOrderNum((String) jsonResponse.get("order_id"));
			tenpay.setNotifyType((String) jsonResponse.get("notify_type"));
			tenpay.setNotifyTime((String) jsonResponse.get("notify_time"));
			tenpay.setCustomerName((String) jsonResponse.get("customer_name"));
			tenpay.setItemCode((String) jsonResponse.get("item_code"));
			tenpay.setItemTitle((String) jsonResponse.get("item_title"));
			tenpay.setPayCurrency((String) jsonResponse.get("pay_currency"));
			tenpay.setPayStatus((String) jsonResponse.get("pay_status"));
			tenpay.setPgTradeId((String) jsonResponse.get("pg_trade_id"));
			tenpay.setPbTradeId((String) jsonResponse.get("pb_trade_id"));
			tenpay.setHashValue((String) jsonResponse.get("hash_value"));

			if(jsonResponse.containsValue("pay_amount")){
				Double payAmt = (Double) jsonResponse.get("pay_amount");
				if(payAmt!=null)
					tenpay.setPayAmount(String.valueOf(payAmt));
			} else{
				tenpay.setPayAmount("0");
			}

			tenpay.setResCode((String) jsonResponse.get("res_code"));
			tenpay.setResMsg((String) jsonResponse.get("res_msg"));
			tenpay.setResTime((String) jsonResponse.get("res_time"));

			tenpay.setResJson(jsonResponse);
			tenpay.setResJsonStr(jsonResponse.toJSONString());
			
			try{
				Utils.writeTenpayFileLog(tenpay, "ObjDecrypt");
			}catch(Exception e){e.printStackTrace();}
		}

		return tenpay;
	}

	private static HttpResponse makeHttpClient(HttpClient httpclient, String enc_data, String gatewayHost) throws URISyntaxException, ClientProtocolException, IOException {
		if(gatewayHost == null)
			gatewayHost = gateway_host1;
		
		// 게이트웨이 URL을 생성합니다.
		URIBuilder builder = new URIBuilder();
		builder.setScheme("http").setHost(gatewayHost).setPath("/gateway");
		URI uri = builder.build();	
		HttpPost httpPost = new HttpPost(uri);
		
		// 파라미터를 설정합니다.
		MultipartEntity mEntity = new MultipartEntity( HttpMultipartMode.BROWSER_COMPATIBLE);             
		mEntity.addPart("merchant_id", new StringBody(Config.getString("tenpay.mertId"),"text/plain", Charset.forName( "UTF-8" )));
		mEntity.addPart("enc_data", new StringBody(enc_data,"text/plain", Charset.forName( "UTF-8" )));
		httpPost.setEntity(mEntity);                           
		httpclient = new DefaultHttpClient();
		httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		
		// 요청 정보를 출력합니다.
		String reqURL = httpPost.getURI().toString();
		System.out.println("Paybridge Gateway URL = " + reqURL);
		System.out.println("merchant_id = " + Config.getString("tenpay.mertId"));
		System.out.println("enc_data = " + enc_data);
		
		// HTTP 연결을 시도하고 응답메세지를 얻습니다.
		HttpResponse response = httpclient.execute(httpPost);
		
		if(response.getEntity()==null){
			if(gateway_host1.equals(gatewayHost))
				makeHttpClient(httpclient, enc_data, gateway_host2);
			else if(gateway_host2.equals(gatewayHost))
				makeHttpClient(httpclient, enc_data, gateway_host3);
			else 
				return response;
		}
		
		return response;
	}
}
