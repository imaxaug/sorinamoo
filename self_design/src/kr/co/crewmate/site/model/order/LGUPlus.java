package kr.co.crewmate.site.model.order;

import kr.co.crewmate.site.model.ToString;

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
public class LGUPlus extends ToString {
    /**
     * <pre>
     * LG데이콤 결제서비스 선택
     * (test:테스트, service:서비스)
     * </pre>
     */
    private String cstPlatform;

    /**
     * 
     */
    private String cstMid;

    /** LG유플러스에서 부여한 상점ID */
    private String lgdMid;

    /** 주문번호 */
    private String lgdOid;

    /** 결제금액 */
    private int lgdAmount;

    /**
     * LG 유플러스에서 부여한 상점키
     */
    private String lgdMertKey;

    /** 구매자명 */
    private String lgdBuyer;

    /** 구매내역 */
    private String lgdProductinfo;

    /**
     * 타임스탬프 거래 위변조를 막기위해 사용 숫자형식으로만 전달해 주세요 예)20090226110637
     */
    private String lgdTimestamp;

    /** 해쉬데이타 */
    private String lgdHashdata;

    /**
     * 구매자아이디 (상품권 결제시 필수)
     */
    private String lgdBuyerid;

    /**
     * 구매자IP (상품권 결제시 필수)
     */
    private String lgdBuyerip;

    /** 구매자주소 */
    private String lgdBuyeraddress;

    /** 구매자휴대폰번호 */
    private String lgdBuyerphone;

    /** 구매자이메일 */
    private String lgdBuyeremail;

    /** 구매자주민번호 */
    private String lgdBuyerssn;

    /**
     * 구매자주민번호 체크여부 (기본값 : N)
     */
    private String lgdCheckssnyn = "N";

    /** 상품코드 */
    private String lgdProductcode;

    /** 수취인 */
    private String lgdReceiver;

    /** 수취인전화번호 */
    private String lgdReceiverphone;

    /** 배송정보 */
    private String lgdDeliveryinfo;

    /**
     * 상점정의초기결제수단 (기본값 : SC0010)
     */
    private String lgdCustomFirstpay = "SC0010";

    /**
     * 상점정의프로세스타입 (기본값 : TWOTR)
     */
    private String lgdCustomProcesstype = "TWOTR";

    /**
     * 상점정의승인가능타임 (기본값 : 10분)
     */
    private String lgdCustomSessiontimeout = "10";

    /**
     * 상점정의결제가능수단 특정결제수단만 보이게 할 경우 사용 예)신용카드,계좌이체만 사용할 경우SC0010-SC0030
     */
    private String lgdCustomUsablepay;

    /** 상점정의스킨 (red, blue, green, cyan, yellow) (기본값 : red) */
    private String lgdCustomSkin = "red";

    /** 상점정의대표자명 */
    private String lgdCustomCeoname;

    /** 상점정의 상점명 */
    private String lgdCustomMertname;

    /** 상점정의 상점전화번호 */
    private String lgdCustomMertphone;

    /** 상점정의 사업자번호 */
    private String lgdCustomBusinessnum;

    /**
     * 상점정의 로고 높이21pix * (폭은 결제창 사이즈에 맞게 정의) ☞ 상점정의 로고 이미지URL을 넘겨주세요
     */
    private String lgdCustomLogo;

    /**
     * 상점정의 신용카드 포인트 사용여부 포인트가맹점이 무조건 포인트를 사용하게 할때 'Y' (기본값 : N)
     */
    private String lgdCustomCardpointuseyn = "N";

    /**
     * 결제금액(amount)중 면세금액 *기본적으로 amount의 1/11을 vat(부가가치세)로 국세청에 신고합니다.
     */
    private String lgdTaxfreeamount;

    /**
     * 상점정의 결제마감시간 형식 : yyyyMMddHHmmss
     */
    private String lgdClosedate;

    /**
     * 에스크로 적용 여부 Y : 에스크로 적용, N : 에스크로 미적용
     */
    private String lgdEscrowUseyn;

    /**
     * 표시할부개월수 구분자는 반드시 ‘:’ 으로 해야함 (기본값 : 0:2:3:4:5:6:7:8:9:10:11:12)
     */
    private String lgdInstallrange;

    /**
     * 특정카드/특정개월무이자 셋팅 카드-개월수 : 개월수, 카드-개월수 형식으로 전달 예) 국민 3,6개월, 삼성 3-6개월 무이자
     * 적용시, 11-3:6,51-3:4:5:6
     */
    private String lgdNointinf;

    /** 사용가능카드사 */
    private String lgdUsablecard;

    /**
     * 현금영수증 사용 여부 Y : 현금영수증 사용함 N : 현금영수증 사용안함 (기본값 : Y)
     */
    private String lgdCashreceiptyn = "Y";

    /** 사용가능 은행(실시간계좌이체) */
    private String lgdUsablebank;

    private String lgdPageUrl;

    private String lgdReturnurl;

    private String lgdNoteurl;

    private String lgdCasnoteurl;

    /** 은련카드 결제결과 데이터 */
    private String lgdRespcode;

    private String lgdRespmsg;

    private String lgdTid;

    private String lgdPaytype;

    private String lgdPaydate;

    private String lgdFinancecode;

    private String lgdFinancename;

    private String lgdEscrowyn;

    private String lgdTransamount;

    private String lgdExchangerate;

    private String lgdCardnum;

    private String lgdCardinstallmonth;

    private String lgdCardnointyn;

    private String lgdFinanceauthnum;

    private String lgdAccountnum;

    private String lgdCastamount;

    private String lgdCascamount;

    private String lgdCasflag;

    private String lgdCasseqno;

    private String lgdOcbsavepoint;

    private String lgdOcbamount;

    private String lgdOcbtotalpoint;

    private String lgdOcbusablepoint;

    private String lgdTelno;

    /** 결제창 호출 문자 인코딩방식 EUC-KR */
    private String lgdEncoding;// 

    /** 결과수신페이지 호출 문자 인코딩방식 EUC-KR */
    private String lgdEncodingNoteurl;

    /** 결과수신페이지 호출 문자 인코딩방식 EUC-KR */
    private String lgdEncodingReturnurl;

    private String adminId;

    private String cstWindowType;
    
    /** 결제창 버젼정보 */
    private String lgdWindowVer;
    /** 결제창 인코딩 */
    private String lgdLanguage;

    public String getCstPlatform() {
        return cstPlatform;
    }

    public void setCstPlatform(String cstPlatform) {
        this.cstPlatform = cstPlatform;
    }

    public String getCstMid() {
        return cstMid;
    }

    public void setCstMid(String cstMid) {
        this.cstMid = cstMid;
    }

    public String getLgdMid() {
        return lgdMid;
    }

    public void setLgdMid(String lgdMid) {
        this.lgdMid = lgdMid;
    }

    public String getLgdOid() {
        return lgdOid;
    }

    public void setLgdOid(String lgdOid) {
        this.lgdOid = lgdOid;
    }

    public int getLgdAmount() {
        return lgdAmount;
    }

    public void setLgdAmount(int lgdAmount) {
        this.lgdAmount = lgdAmount;
    }

    public String getLgdBuyer() {
        return lgdBuyer;
    }

    public void setLgdBuyer(String lgdBuyer) {
        this.lgdBuyer = lgdBuyer;
    }

    public String getLgdProductinfo() {
        return lgdProductinfo;
    }

    public void setLgdProductinfo(String lgdProductinfo) {
        this.lgdProductinfo = lgdProductinfo;
    }

    public String getLgdTimestamp() {
        return lgdTimestamp;
    }

    public void setLgdTimestamp(String lgdTimestamp) {
        this.lgdTimestamp = lgdTimestamp;
    }

    public String getLgdHashdata() {
        return lgdHashdata;
    }

    public void setLgdHashdata(String lgdHashdata) {
        this.lgdHashdata = lgdHashdata;
    }

    public String getLgdBuyerid() {
        return lgdBuyerid;
    }

    public void setLgdBuyerid(String lgdBuyerid) {
        this.lgdBuyerid = lgdBuyerid;
    }

    public String getLgdBuyerip() {
        return lgdBuyerip;
    }

    public void setLgdBuyerip(String lgdBuyerip) {
        this.lgdBuyerip = lgdBuyerip;
    }

    public String getLgdBuyeraddress() {
        return lgdBuyeraddress;
    }

    public void setLgdBuyeraddress(String lgdBuyeraddress) {
        this.lgdBuyeraddress = lgdBuyeraddress;
    }

    public String getLgdBuyerphone() {
        return lgdBuyerphone;
    }

    public void setLgdBuyerphone(String lgdBuyerphone) {
        this.lgdBuyerphone = lgdBuyerphone;
    }

    public String getLgdBuyeremail() {
        return lgdBuyeremail;
    }

    public void setLgdBuyeremail(String lgdBuyeremail) {
        this.lgdBuyeremail = lgdBuyeremail;
    }

    public String getLgdBuyerssn() {
        return lgdBuyerssn;
    }

    public void setLgdBuyerssn(String lgdBuyerssn) {
        this.lgdBuyerssn = lgdBuyerssn;
    }

    public String getLgdCheckssnyn() {
        return lgdCheckssnyn;
    }

    public void setLgdCheckssnyn(String lgdCheckssnyn) {
        this.lgdCheckssnyn = lgdCheckssnyn;
    }

    public String getLgdProductcode() {
        return lgdProductcode;
    }

    public void setLgdProductcode(String lgdProductcode) {
        this.lgdProductcode = lgdProductcode;
    }

    public String getLgdReceiver() {
        return lgdReceiver;
    }

    public void setLgdReceiver(String lgdReceiver) {
        this.lgdReceiver = lgdReceiver;
    }

    public String getLgdReceiverphone() {
        return lgdReceiverphone;
    }

    public void setLgdReceiverphone(String lgdReceiverphone) {
        this.lgdReceiverphone = lgdReceiverphone;
    }

    public String getLgdDeliveryinfo() {
        return lgdDeliveryinfo;
    }

    public void setLgdDeliveryinfo(String lgdDeliveryinfo) {
        this.lgdDeliveryinfo = lgdDeliveryinfo;
    }

    public String getLgdCustomFirstpay() {
        return lgdCustomFirstpay;
    }

    public void setLgdCustomFirstpay(String lgdCustomFirstpay) {
        this.lgdCustomFirstpay = lgdCustomFirstpay;
    }

    public String getLgdCustomProcesstype() {
        return lgdCustomProcesstype;
    }

    public void setLgdCustomProcesstype(String lgdCustomProcesstype) {
        this.lgdCustomProcesstype = lgdCustomProcesstype;
    }

    public String getLgdCustomSessiontimeout() {
        return lgdCustomSessiontimeout;
    }

    public void setLgdCustomSessiontimeout(String lgdCustomSessiontimeout) {
        this.lgdCustomSessiontimeout = lgdCustomSessiontimeout;
    }

    public String getLgdCustomUsablepay() {
        return lgdCustomUsablepay;
    }

    public void setLgdCustomUsablepay(String lgdCustomUsablepay) {
        this.lgdCustomUsablepay = lgdCustomUsablepay;
    }

    public String getLgdCustomSkin() {
        return lgdCustomSkin;
    }

    public void setLgdCustomSkin(String lgdCustomSkin) {
        this.lgdCustomSkin = lgdCustomSkin;
    }

    public String getLgdCustomCeoname() {
        return lgdCustomCeoname;
    }

    public void setLgdCustomCeoname(String lgdCustomCeoname) {
        this.lgdCustomCeoname = lgdCustomCeoname;
    }

    public String getLgdCustomMertname() {
        return lgdCustomMertname;
    }

    public void setLgdCustomMertname(String lgdCustomMertname) {
        this.lgdCustomMertname = lgdCustomMertname;
    }

    public String getLgdCustomMertphone() {
        return lgdCustomMertphone;
    }

    public void setLgdCustomMertphone(String lgdCustomMertphone) {
        this.lgdCustomMertphone = lgdCustomMertphone;
    }

    public String getLgdCustomBusinessnum() {
        return lgdCustomBusinessnum;
    }

    public void setLgdCustomBusinessnum(String lgdCustomBusinessnum) {
        this.lgdCustomBusinessnum = lgdCustomBusinessnum;
    }

    public String getLgdCustomLogo() {
        return lgdCustomLogo;
    }

    public void setLgdCustomLogo(String lgdCustomLogo) {
        this.lgdCustomLogo = lgdCustomLogo;
    }

    public String getLgdCustomCardpointuseyn() {
        return lgdCustomCardpointuseyn;
    }

    public void setLgdCustomCardpointuseyn(String lgdCustomCardpointuseyn) {
        this.lgdCustomCardpointuseyn = lgdCustomCardpointuseyn;
    }

    public String getLgdTaxfreeamount() {
        return lgdTaxfreeamount;
    }

    public void setLgdTaxfreeamount(String lgdTaxfreeamount) {
        this.lgdTaxfreeamount = lgdTaxfreeamount;
    }

    public String getLgdClosedate() {
        return lgdClosedate;
    }

    public void setLgdClosedate(String lgdClosedate) {
        this.lgdClosedate = lgdClosedate;
    }

    public String getLgdEscrowUseyn() {
        return lgdEscrowUseyn;
    }

    public void setLgdEscrowUseyn(String lgdEscrowUseyn) {
        this.lgdEscrowUseyn = lgdEscrowUseyn;
    }

    public String getLgdInstallrange() {
        return lgdInstallrange;
    }

    public void setLgdInstallrange(String lgdInstallrange) {
        this.lgdInstallrange = lgdInstallrange;
    }

    public String getLgdNointinf() {
        return lgdNointinf;
    }

    public void setLgdNointinf(String lgdNointinf) {
        this.lgdNointinf = lgdNointinf;
    }

    public String getLgdUsablecard() {
        return lgdUsablecard;
    }

    public void setLgdUsablecard(String lgdUsablecard) {
        this.lgdUsablecard = lgdUsablecard;
    }

    public String getLgdCashreceiptyn() {
        return lgdCashreceiptyn;
    }

    public void setLgdCashreceiptyn(String lgdCashreceiptyn) {
        this.lgdCashreceiptyn = lgdCashreceiptyn;
    }

    public String getLgdUsablebank() {
        return lgdUsablebank;
    }

    public void setLgdUsablebank(String lgdUsablebank) {
        this.lgdUsablebank = lgdUsablebank;
    }

    public String getLgdMertKey() {
        return lgdMertKey;
    }

    public void setLgdMertKey(String lgdMertKey) {
        this.lgdMertKey = lgdMertKey;
    }

    public String getLgdReturnurl() {
        return lgdReturnurl;
    }

    public void setLgdReturnurl(String lgdReturnurl) {
        this.lgdReturnurl = lgdReturnurl;
    }

    public String getLgdNoteurl() {
        return lgdNoteurl;
    }

    public void setLgdNoteurl(String lgdNoteurl) {
        this.lgdNoteurl = lgdNoteurl;
    }

    public String getLgdCasnoteurl() {
        return lgdCasnoteurl;
    }

    public void setLgdCasnoteurl(String lgdCasnoteurl) {
        this.lgdCasnoteurl = lgdCasnoteurl;
    }

    public String getLgdPageUrl() {
        return lgdPageUrl;
    }

    public void setLgdPageUrl(String lgdPageUrl) {
        this.lgdPageUrl = lgdPageUrl;
    }

    public String getLgdRespcode() {
        return lgdRespcode;
    }

    public void setLgdRespcode(String lgdRespcode) {
        this.lgdRespcode = lgdRespcode;
    }

    public String getLgdRespmsg() {
        return lgdRespmsg;
    }

    public void setLgdRespmsg(String lgdRespmsg) {
        this.lgdRespmsg = lgdRespmsg;
    }

    public String getLgdTid() {
        return lgdTid;
    }

    public void setLgdTid(String lgdTid) {
        this.lgdTid = lgdTid;
    }

    public String getLgdPaytype() {
        return lgdPaytype;
    }

    public void setLgdPaytype(String lgdPaytype) {
        this.lgdPaytype = lgdPaytype;
    }

    public String getLgdPaydate() {
        return lgdPaydate;
    }

    public void setLgdPaydate(String lgdPaydate) {
        this.lgdPaydate = lgdPaydate;
    }

    public String getLgdFinancecode() {
        return lgdFinancecode;
    }

    public void setLgdFinancecode(String lgdFinancecode) {
        this.lgdFinancecode = lgdFinancecode;
    }

    public String getLgdFinancename() {
        return lgdFinancename;
    }

    public void setLgdFinancename(String lgdFinancename) {
        this.lgdFinancename = lgdFinancename;
    }

    public String getLgdEscrowyn() {
        return lgdEscrowyn;
    }

    public void setLgdEscrowyn(String lgdEscrowyn) {
        this.lgdEscrowyn = lgdEscrowyn;
    }

    public String getLgdTransamount() {
        return lgdTransamount;
    }

    public void setLgdTransamount(String lgdTransamount) {
        this.lgdTransamount = lgdTransamount;
    }

    public String getLgdExchangerate() {
        return lgdExchangerate;
    }

    public void setLgdExchangerate(String lgdExchangerate) {
        this.lgdExchangerate = lgdExchangerate;
    }

    public String getLgdCardnum() {
        return lgdCardnum;
    }

    public void setLgdCardnum(String lgdCardnum) {
        this.lgdCardnum = lgdCardnum;
    }

    public String getLgdCardinstallmonth() {
        return lgdCardinstallmonth;
    }

    public void setLgdCardinstallmonth(String lgdCardinstallmonth) {
        this.lgdCardinstallmonth = lgdCardinstallmonth;
    }

    public String getLgdCardnointyn() {
        return lgdCardnointyn;
    }

    public void setLgdCardnointyn(String lgdCardnointyn) {
        this.lgdCardnointyn = lgdCardnointyn;
    }

    public String getLgdFinanceauthnum() {
        return lgdFinanceauthnum;
    }

    public void setLgdFinanceauthnum(String lgdFinanceauthnum) {
        this.lgdFinanceauthnum = lgdFinanceauthnum;
    }

    public String getLgdAccountnum() {
        return lgdAccountnum;
    }

    public void setLgdAccountnum(String lgdAccountnum) {
        this.lgdAccountnum = lgdAccountnum;
    }

    public String getLgdCastamount() {
        return lgdCastamount;
    }

    public void setLgdCastamount(String lgdCastamount) {
        this.lgdCastamount = lgdCastamount;
    }

    public String getLgdCascamount() {
        return lgdCascamount;
    }

    public void setLgdCascamount(String lgdCascamount) {
        this.lgdCascamount = lgdCascamount;
    }

    public String getLgdCasflag() {
        return lgdCasflag;
    }

    public void setLgdCasflag(String lgdCasflag) {
        this.lgdCasflag = lgdCasflag;
    }

    public String getLgdCasseqno() {
        return lgdCasseqno;
    }

    public void setLgdCasseqno(String lgdCasseqno) {
        this.lgdCasseqno = lgdCasseqno;
    }

    public String getLgdOcbsavepoint() {
        return lgdOcbsavepoint;
    }

    public void setLgdOcbsavepoint(String lgdOcbsavepoint) {
        this.lgdOcbsavepoint = lgdOcbsavepoint;
    }

    public String getLgdOcbamount() {
        return lgdOcbamount;
    }

    public void setLgdOcbamount(String lgdOcbamount) {
        this.lgdOcbamount = lgdOcbamount;
    }

    public String getLgdOcbtotalpoint() {
        return lgdOcbtotalpoint;
    }

    public void setLgdOcbtotalpoint(String lgdOcbtotalpoint) {
        this.lgdOcbtotalpoint = lgdOcbtotalpoint;
    }

    public String getLgdOcbusablepoint() {
        return lgdOcbusablepoint;
    }

    public void setLgdOcbusablepoint(String lgdOcbusablepoint) {
        this.lgdOcbusablepoint = lgdOcbusablepoint;
    }

    public String getLgdTelno() {
        return lgdTelno;
    }

    public void setLgdTelno(String lgdTelno) {
        this.lgdTelno = lgdTelno;
    }

    public String getLgdEncoding() {
        return lgdEncoding;
    }

    public void setLgdEncoding(String lgdEncoding) {
        this.lgdEncoding = lgdEncoding;
    }

    public String getLgdEncodingNoteurl() {
        return lgdEncodingNoteurl;
    }

    public void setLgdEncodingNoteurl(String lgdEncodingNoteurl) {
        this.lgdEncodingNoteurl = lgdEncodingNoteurl;
    }
    
    

    public String getLgdWindowVer() {
        return lgdWindowVer;
    }

    public void setLgdWindowVer(String lgdWindowVer) {
        this.lgdWindowVer = lgdWindowVer;
    }

    public String getLgdEncodingReturnurl() {
        return lgdEncodingReturnurl;
    }

    public void setLgdEncodingReturnurl(String lgdEncodingReturnurl) {
        this.lgdEncodingReturnurl = lgdEncodingReturnurl;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getCstWindowType() {
        return cstWindowType;
    }

    public void setCstWindowType(String cstWindowType) {
        this.cstWindowType = cstWindowType;
    }

    public String getLgdLanguage() {
        return lgdLanguage;
    }

    public void setLgdLanguage(String lgdLanguage) {
        this.lgdLanguage = lgdLanguage;
    }
    
    
}
