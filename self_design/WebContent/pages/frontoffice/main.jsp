<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.util.Enumeration" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.ssgdfs.com/taglib/ui" prefix="ui" %>
<%@taglib uri="http://www.ssgdfs.com/taglib/hfn" prefix="hfn"%>
<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>---------------------------</title>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=EDGE"/>
<link rel="stylesheet" href="/css/all.css"/>
<script type="text/javascript" src="/js/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/lib.js"></script>
<script type="text/javascript" src="/js/validation.js"></script>
<script type="text/javascript" src="/script/shop.js"></script>
<script type="text/javascript" src="/script/common.js"></script>
<script>

</script>
</head>
<body class="locale-ko " data-locale="ko" data-_locale="_ko">
<div class="mp-alert"></div>
<div id="marketpress">
    <%@include file="header.jsp"%>
</div>

<div id="body">

${isLogin}
<br/>
<br/>

<%
    String ls_name = "";
    String ls_value = "";

    Enumeration enum_app = session.getAttributeNames();
    int i = 0;

    while(enum_app.hasMoreElements()) {
        i++;
        ls_name = enum_app.nextElement().toString();
        ls_value = session.getAttribute(ls_name).toString();
        out.println("<br/>얻어온 세션 이름 [ " + i +" ] : " + ls_name + "<br/>");
        out.println("<br/>얻어온 세션 값 [ " + i +" ] : " + ls_value + "<hr/>");
}
%>

</div>
</body>
</html>