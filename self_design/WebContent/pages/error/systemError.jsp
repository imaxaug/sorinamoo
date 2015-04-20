<%@page contentType="text/html;charset=utf-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="copyright" content="2013 SHINSEGAE DUTY FREE" />
<title>서비스에 불편을 드려 죄송합니다.</title>
<link href="/css/error.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <!--
    <h2><font color="red">${exception.message}</font></h2>
    <table class="table">
        <c:forEach items="${exception.stackTrace}" var="trace" varStatus="status">
        <tr>
            <td style="padding-left:${status.count * 5}px">${trace}</td>
        </tr>
        </c:forEach>
    </table> -->
    <div class="error-box">
        <div class="error">
            <%--
            <p><img src="${imageServer}/images/shop/error/error_01.gif" alt="서비스 이용에 불편을 드려 죄송합니다." /></p>
             --%>
            <p class="txt">서비스 이용에 불편을 드려 죄송합니다.</p>

            <p class="txt">방문하시려는 페이지에 예기치 않은 오류가 발생하여 정상적으로 접속이 되지 않습니다. 서비스 이용에 불편을 드려 대단히 죄송합니다.
                            동일한 오류가 반복될 경우 [고객센터]로 문의해주시면 빠른 시간내에 조치하겠습니다. 감사합니다.
            </p>

            <p>
                <a href="javascript:history.back();">이전 화면 돌아가기</a>
            </p>
        </div>
        <%--
        <p class="btn">
            <img src="${imageServer}/images/shop/error/btn_customer.gif" alt="신세계인터넷면세점 고객센터 1577-0161" />
            <a href="${serverHostForSSL}/shop/customer/inquiries"><img src="${imageServer}/images/shop/error/btn_customer02.gif" alt="신세계인터넷면세점 고객센터 1:1 문의하기" /></a>
        </p>
        --%>
    </div>
</body>
</html>
