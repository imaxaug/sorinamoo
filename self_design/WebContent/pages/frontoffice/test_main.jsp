<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.ssgdfs.com/taglib/ui" prefix="ui" %>
<%@taglib uri="http://www.ssgdfs.com/taglib/hfn" prefix="hfn"%>
<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<head>
<link href="/css/coupon.css" rel="stylesheet" type="text/css" />
<link href="http://www.bulgaria-web-developers.com/projects/javascript/selectbox/css/jquery.selectbox-0.2.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="/js/jquery/jquery.selectbox-0.2.1.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.form.js"></script>
<script type="text/javascript">
jQuery(function($){
    $('.select_class').selectbox();
    
    $("a.popupSample").click(function() {
        var url = $(this).attr("href");
        openWindow(url, 600, 560, $(this).attr("href")); 
        return false;
    });
    
    $("#testModul").click(function() {
        window.open('/shop/user/ipinAuthentication','ipinWindow', 'width=425, height=550, resizable=0, scrollbars=no, status=0, titlebar=0, toolbar=0, left=435, top=250');
    });
    
    $("body").on("click", "a.testLogin" , function() {
        var nonUserType = $(this).attr("value");
        var isLogin = "${isLogin}";
        alert(isLogin);
        if (isLogin == "true") {
            return true;
        } else {
            if (nonUserType == "myPage" || nonUserType == "order") {
                var url = "/shop/login/loginPopupForm?redirectUrl="+escape($(this).attr("href"))+"&nonUserType="+nonUserType;
                openWindow(url, 500, 700, 'loginPopupForm');
            } else {
                var url = "/shop/login/loginPopupForm?redirectUrl="+escape($(this).attr("href"));
                openWindow(url, 500, 540, 'loginPopupForm'); 
            }
            return false;
        }
    });
    
    $("#btnOffUserBenefit").click(function() {
        var url = "/shop/user/offUserBenefit";
        window.open(url,"offUserBenefit","width=540, height=510");
        return false;
    });
    
    $("#btnOffUserBenefitFor").click(function() {
        var url = "/shop/user/offForeignerUserBenefit";
        window.open(url,"offUserBenefit","width=540, height=570");
        return false;
    });
});

function addProduct(){
	var prdtCode = $("select[name=selectbox]").val();
	var prdtCount = $(".prdtCount").val();
	addCart(prdtCode,prdtCount,'','');
}

function quickProductOrder(){
	var prdtCode = $("select[name=selectbox]").val();
	var prdtCount = $(".prdtCount").val();
	quickOrder(prdtCode, prdtCount, '', '');
}

function goProductDetail(){
	var prdtCode = $("select[name=selectbox]").val();
	var url = "/shop/product/productDetail?prdtCode="+prdtCode;
	location.href = url;
}

function eTicketPop(){
    window.open("/shop/order/eTicketPop?orderNum=2013073000006", "eTicketPop",'width=570,height=360,scrollbars=no,resizable=no');
}

</script>
</head>

<body>
<br/><br/>
<ui:gubunSelect name="ynboolean" key="ynboolean" langCode="CN"></ui:gubunSelect>
<ui:gubunRadio name="ynboolean" key="ynboolean" langCode="KR"></ui:gubunRadio>
<br/><br/>
<ui:gubun key="ynboolean" value="true" langCode="CN"></ui:gubun>
<br/><br/>
<ui:gubun key="ynboolean" value="true"></ui:gubun>
<br/><br/>
<ui:code codeName="01" codeClass="colorCode" langCode="CN" ></ui:code>
<br/><br/>
<ui:code codeName="01" codeClass="colorCode" ></ui:code>
<br/><br/>
<ui:select name="colorCode" key="colorCode"></ui:select>
<br/><br/>
<ui:select name="colorCode" key="colorCode" langCode="CN"></ui:select>
<br/><br/>
<ui:radio name="colorCode" key="colorCode"></ui:radio>
<br/><br/>
<ui:radio name="colorCode" key="colorCode" langCode="CN"></ui:radio>
<br/><br/>
메뉴<br/>
<a href="/shop/login/form">/shop/login/form [로그인]</a><br>
<a href="/shop/loginArea">/shop/loginArea [로그인영역]</a><br>
<a href="/shop/login/logout">/shop/login/logout [로그아웃]</a><br>
<a href="/shop/promotion/eventMain">/shop/promotion/eventMain [이벤트메인]</a><br/>
<a href="/shop/customer/noticeList">/shop/customer/noticeList [공지사항]</a><br/>
<a href="/publish/frontoffice/ia.jsp" target="_blank"><b>IA</b></a><br>
<a href="javascript://" onclick="javascript:goProductDetail();"><b>상품상세</b></a><br/>
<a href="/shop/popupSample" class="popupSample"><b>팝업샘플</b></a><br/>
<a href="javascript://" id="searchPostNum">우편번호 찾기</a><br/>
<a href="/shop/store/sample">매장레이아웃샘플</a><br/>
<a href="/shop/store/main">매장안내 입니다</a>
<br/><br/>
<a href="/shop/user/userChoice">회원가입 폼</a><br/>
<br/><br/>
<a href="javascript://" class="btnLoginPopup">무조건 로그인팝업</a><br/>
<a href="/shop/user/userChoice" class="btnIsLoginPopup">로그인체크후 바닥</a><br/>
<a href="/shop/user/userChoice" class="testLogin">테스트 로그인</a>
<pre>
    class="btnIsLoginPopup"
</pre>
<a href="javascript://" class="btnIsLoginPopup" value="myPage">비회원 mypage 로그인 팝업</a><br/>
<a href="javascript://" class="btnIsLoginPopup" value="order">비회원 order 로그인 팝업</a>

<br/><br/>
<a href="/shop/specialsell/listSpecialSell">/shop/specialsell/listSpecialSell [ 기획전 ] </a><br/>
<br/>
<a href="/shop/template/savedExtinctionTemplate?userId=LIONJK">이경훈_적립금소멸예정           (0007)</a>
<br/>
<pre>
<b>세션키: ${sessionKey}</b>
<b>세션해시키: ${sessionHashKey}</b>
<b>로그인id: ${loginUser.user.userId}</b>
<a href="/shop/order/cart"><b><font color="red">장바구니이동</font></b></a><br/>
<a href="javascript://" onClick="eTicketPop();"><b><font color="red">e Ticket 등록</font></b></a><br/>

<a href="/shop/customer/sample">고객센터 샘플</a><br/>
<a href="#"><img src="${imageServer}/images/shop/brand/temp_brand_event.gif" alt="ETAO" /></a>
<br>
<select id="selectbox" name="selectbox">
<option value="01070112101" >01070112101</option> 
<option value="02840069001" >02840069001</option> 
<option value="00260166201" >00260166201</option> 
<option value="01640006901" >01640006901</option> 
<option value="00100306001" >00100306001</option> 

<option value="외산" >외산</option>
<option value="00480036201" >00480036201</option> 
<option value="02840069001" >02840069001</option>
<option value="00650048601" >00650048601</option>
<option value="02840068901" >02840068901</option>
<option value="02840074401" >02840074401</option>
<option value="02840144401" >02840144401</option>
<option value="00650083401" >00650083401</option>
<option value="00100983501" >00100983501</option>
<option value="00100553701" >00100553701</option>
<option value="00350839001" >00350839001</option>
<option value="00350838801" >00350838801</option>
<option value="00350849601" >00350849601</option>
<option value="00350838701" >00350838701</option>
<option value="00390025201" >00390025201</option>
<option value="00650074001" >00650074001</option>
<option value="00450006301" >00450006301</option>
<option value="02400208701" >02400208701</option>

</select>
<input type="text" class="prdtCount" value="1">
<input type="button" value="장바구니담기" onClick="javascript:addProduct();" />
<br>
<input type="button" value="바로구매" onClick="javascript:quickProductOrder();" />
<br>
</pre>
<br/>
<form id="selectTest" name="hello" action="/shop/main">
<table>
    <tr>
        <td class="select-container">
            <ui:select name="bankCode" key="bankCode" value="${param.bankCode}" clazz="select_class">
                <ui:message key="message.test"/>
            </ui:select>
        </td>
    </tr>
</table>
<br/>
<br/>
<input type="submit"/>
</form>
<br/>
<br/>
<span style="color:red">${param.bankCode}</span>

<ui:select name="bankCode2" key="bankCode" value="06">
    <ui:message key="message.test"/>
</ui:select>
<br /><br />
<ui:reviewPointIcon star="8" />
    &lt;ui:reviewPointIcon star="8" /&gt;  <br />

<ui:smallGradeIcon icon="01" />
    &lt;ui:smallGradeIcon icon="01" /&gt;  <br />
<br /><br />
<ui:largeGradeIcon icon="01" />
    &lt;ui:largeGradeIcon icon="01" /&gt;  <br />
<br /><br />
<pre>
%쿠폰 변경사항안내..
정률을 쓰시던.. 정액을쓰시던.. Y,N 체크는 해주시고
rate,amount 모두 값을 넣어주세요(같은갑을 넣어주셔도 됩니다.)
요청사항~ ㅜㅜ
</pre>
<pre>
    &lt;link href="/css/coupon.css" rel="stylesheet" type="text/css" /&gt;
    &lt;ui:coupon fixRateYn="true" rate="20" amount="20" cpnName="맥도널드 상하이 스파이스 버거 할인쿠폰" cpnImageCode="02" /&gt;
</pre>
<ui:coupon fixRateYn="true" rate="20" amount="20" cpnName="맥도널드 상하이 스파이스 버거 할인쿠폰" cpnImageCode="02" />
<pre>
    &lt;link href="/css/coupon.css" rel="stylesheet" type="text/css" /&gt;
    &lt;ui:coupon fixRateYn="false rate="20"" amount="100.00" cpnName="맥도널드 상하이 스파이스 버거 할인쿠폰" cpnImageCode="03" /&gt;
</pre>
<ui:coupon fixRateYn="false" rate="20" amount="20" cpnName="맥도널드 상하이 스파이스 버거 할인쿠폰" cpnImageCode="03" />

<br /><br />
<a href="#미리보기">미리보기샘플</a> 
<c:if test="${isLogin}">
<pre>
<b>로그인 되어있음</b>
${loginUser}
</pre>
</c:if>

<br/><br/>
<a href="/shop/user/testIpinAuth">인증테스트</a>
<br/><br/>
<a href="javascript://" id="testModul">모듈 테스트</a>
<br/><br/>
<a href="/shop/promotion/benefitEventTest">적립금 증정/관리 테스트</a>
<br/><br/>
<ui:message locale="JP" key="message.delete.fail"></ui:message>
<br/><br/>

<a href="javascript://" id="btnOffUserBenefit">내국인</a>
<a href="javascript://" id="btnOffUserBenefitFor">외국인</a>

</body>
