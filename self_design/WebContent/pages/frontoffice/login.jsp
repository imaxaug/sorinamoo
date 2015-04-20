<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<script type="text/javascript">
jQuery(function() {
    $("#login-id").focus();
    $("#login-id").addClass("id-pw-on");

//     $('#login-id').focusout(function() {
//         $(this).val($(this).val().toUpperCase());
//     });

    var errorMessages = "${errorMessages[0].value}";
    if (errorMessages != "") {
        //Alert(errorMessages);
        $("#failMsg").text(errorMessages);
        $("#login-id").focus();
    }

    $("form#loginForm").submit(function() {
        $("form#loginForm input.inputBox").each(function(){
            $(this).val($.trim($(this).val()));
        });
    });

    $(".inputBox").focusin(function() {
        $(".inputBox").removeClass("id-pw-on");
        $(this).addClass("id-pw-on");
    });

    $(".joinUser").click(function() {
        var localYn = $(this).attr("value");
        var pageNatn = $(this).attr("class").split(" ")[0];
        opener.location.href = "${serverHost}/shop/user/userAuthentication?localYn="+localYn+"&pageNatn="+pageNatn;
        window.close();
    });

    $("#btnSinsegaeJoin").click(function() {
        Alert("서비스 준비 중입니다.");
        return false;
    });
});
</script>
</head>
<body class="locale-ko " data-locale="ko" data-_locale="_ko">
<div class="mp-alert"></div>
<div id="marketpress">
    <%@include file="header.jsp"%>
</div>

<div id="body">

${isLogin}

		<form name="loginForm" id="loginForm" action="/shop/process" method="post">
			<input type="hidden" name="redirectUrl" value="${userLoginForm.redirectUrl}" />
			<input type="hidden" name="nonUserType" value="${userLoginForm.nonUserType}">

			<input type="text" id="login-id" name="userId" class="inputBox" value="${userLoginForm.userId}" />
			<input type="password" id="login-password" name="password" class="inputBox" />
			<input type="checkbox" id="login-id-save" name="saveId" ${userLoginForm.saveId ? 'checked="checked"' : ""} />
			<label for="login-id-save">아이디저장</label>
			<input type="image" src="" alt="로그인" />
		</form>

        <p id="failMsg"></p>

        <a href="/shop/join">회원가입</a>

	</div>
</body>
</html>