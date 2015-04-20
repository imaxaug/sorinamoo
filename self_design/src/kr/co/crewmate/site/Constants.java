package kr.co.crewmate.site;

import java.util.HashSet;
import java.util.Set;

import kr.co.crewmate.site.config.Config;

/**
 * 클래스명: <code>Constants</code>
 *
 * <pre>
 *  설명을 기입하세요
 * </pre>
 *
 * @author 이경연
 * @date 2012. 6. 28.
 *
 */
public class Constants {

	/**
	 * 검색어 : 시스템점검, 시스템작업, 시스템 점검, 시스템 작업
	 * 찾기 쉬우라고...
	 */
    public static final boolean SYSTEM_JOB = false;

    /**
     * 에러메시지키
     */
    public final static String ERROR_MESSAGE = "errorMessages";

    /**
     * 와스 문자셋
     */
    public final static String WAS_CHARSET = "UTF-8";

    /**
     * URL_SEPERATOR
     */
    public final static String URL_SEPERATOR = "/";

    /**
     * 주문세션아이디
     */
    public final static String ORDER_SESSION_ID = "ORDER_SESSION_ID";

    /**
     * 주문번호 세션아이디
     * (은련카드 사용시)
     */
    public final static String ORDER_NUM_SESSION_ID = "ORDER_NUM_SESSION_ID";

    /**
     * 비회원인증세션키
     */
    public final static String NON_USER_JSESSIONID = "NON_USER_JSESSIONID";

    /**
     * LG 상점정의프로세스타입
     */
    public final static String LG_CUSTOM_PROCESSTYPE = "TWOTR";

    /**
     * LG 상점정의 스킨
     */
    public final static String LG_CUSTOM_SKIN = "red";

    /**
     * LG 결제창 버젼정보
     */
    public final static String LGD_WINDOW_VER = "2.5";

    /**
     * 주문완료세션아이디
     */
    public final static String ORDER_COMPLETE_NUM = "ORDER_COMPLETE_NUM";

    /**
     * 비회원비밀번호
     */
    public final static String NON_USER_PSWD = "NON_USER_PSWD";

    /**
     * 즉시사용적립금
     */
    public final static String DIRECT_SAVED_ID = "100004";

    public final static String LOCALE_SESSION_KEY = "localeKey";
    public final static String LOCALE_SESSION_STORE_KEY = "store_locale";

    public final static boolean IS_CN_DEV = false;

    /*
     * [상점 결제결과처리(DB) 페이지]
     *
     * 1) 위변조 방지를 위한 hashdata값 검증은 반드시 적용하셔야 합니다.
     *
     */
    public final static String LGD_RESPCODE    = "LGD_RESPCODE"    ; // 응답코드: 0000(성공) 그외 실패
    public final static String LGD_RESPMSG     = "LGD_RESPMSG"     ; // 응답메세지
    public final static String LGD_MID         = "LGD_MID"         ; // 상점아이디
    public final static String LGD_OID         = "LGD_OID"         ; // 주문번호
    public final static String LGD_AMOUNT      = "LGD_AMOUNT"      ; // 거래금액
    public final static String LGD_TID         = "LGD_TID"         ; // LG텔레콤이 부여한 거래번호
    public final static String LGD_PAYTYPE     = "LGD_PAYTYPE"     ; // 결제수단코드
    public final static String LGD_PAYDATE     = "LGD_PAYDATE"     ; // 거래일시(승인일시/이체일시)
    public final static String LGD_HASHDATA    = "LGD_HASHDATA"    ; // 해쉬값
    public final static String LGD_FINANCECODE = "LGD_FINANCECODE" ; // 결제기관코드(은행코드)
    public final static String LGD_FINANCENAME = "LGD_FINANCENAME" ; // 결제기관이름(은행이름)
    public final static String LGD_TIMESTAMP   = "LGD_TIMESTAMP"   ; // 타임스탬프

    /*
     * 구매정보
     */
    public final static String LGD_BUYER         = "LGD_BUYER"         ; // 구매자
    public final static String LGD_PRODUCTINFO   = "LGD_PRODUCTINFO"   ; // 상품명
    public final static String LGD_BUYERID       = "LGD_BUYERID"       ; // 구매자 ID
    public final static String LGD_BUYERADDRESS  = "LGD_BUYERADDRESS"  ; // 구매자 주소
    public final static String LGD_BUYERPHONE    = "LGD_BUYERPHONE"    ; // 구매자 전화번호
    public final static String LGD_BUYEREMAIL    = "LGD_BUYEREMAIL"    ; // 구매자 이메일
    public final static String LGD_BUYERSSN      = "LGD_BUYERSSN"      ; // 구매자 주민번호
    public final static String LGD_PRODUCTCODE   = "LGD_PRODUCTCODE"   ; // 상품코드
    public final static String LGD_RECEIVER      = "LGD_RECEIVER"      ; // 수취인
    public final static String LGD_RECEIVERPHONE = "LGD_RECEIVERPHONE" ; // 수취인 전화번호
    public final static String LGD_DELIVERYINFO  = "LGD_DELIVERYINFO"  ; // 배송지

    /**
     * 구매 제한금액
     */
    public final static Integer F_BUY_LIMIT_AMT = 3000;
    public final static Integer S_BUY_LIMIT_AMT = 400;

    public final static String CARD_CHINA_NAME = "중국은련";
    public final static String CARD_CHINA = "3C";

    public final static String CARD_TENPAY_NAME = "텐페이";
    public final static String CARD_TENPAY = "3T";

    public final static String EXIT_YONGDO = "0024";

    public final static String SSG_CARD_NUM = "SSG_CARD_NUM";
    public final static String SSG_CARD_PWD = "SSG_CARD_PWD";

    public final static String SSG_GIFT_CARD_NUM = "SSG_GIFT_CARD_NUM";
    public final static String SSG_GIFT_CARD_PIN = "SSG_GIFT_CARD_PIN";

    // 중국콜센터 파워ID
    public static final String POWER_ID_CHN = "901";

    /**
     * PayBridge 통합결제 구분값 (pg_id)
     */
	public final static String PAYBRIDGE_ALIPAY = "CNA";		// Alipay인
	public final static String PAYBRIDGE_TENPAY = "CNT";		// Tenpay인
	public final static String PAYBRIDGE_UNIONPAY = "CNU";		// UnionPay인

	/**
	 * PayBridge 인터페이스 타입
	 */
	public final static String PAYBRIDGE_INTERFACE_PC_WEB = "PW";
	public final static String PAYBRIDGE_INTERFACE_PC_MESSANGER = "PM";
	public final static String PAYBRIDGE_INTERFACE_MOBILE_WEB = "MW";
	public final static String PAYBRIDGE_INTERFACE_MOBILE_APP = "MA";
	public final static String PAYBRIDGE_INTERFACE_MOBILE_MESSANGER = "MM";

    /**
     * 브랜드샵 사용 여부
     */
    public static final boolean BRAND_SHOP_USE_YN = Config.getBrandShopUseYn();
    /**
     * 브랜드샵 아이디 - 맥
     */
    public static final String BRAND_ID_MAC = "0502";
    public static final String BRAND_ID_DIOR = "0010";

}
