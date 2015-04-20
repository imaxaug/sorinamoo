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
<script type="text/javascript" src="/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="/js/lib.js"></script>
<script type="text/javascript" src="/js/validation.js"></script>
<script type="text/javascript" src="/script/shop.js"></script>
<script type="text/javascript" src="/script/common.js"></script>
<script type="text/javascript">
jQuery(function() {
	var isValidEmail = false;
	var isValidPwd = false;
	var isPwdOk = false;

	$("#email").focusin(function() {
		isValidEmail = false;
	});

    $("#email").focusout(function() {
    	isValidEmail = validateEmail($(this));
    });

    $("#password").focusin(function() {
        isValidPwd = false;
    });

    $("#password").focusout(function() {
        isValidPwd = validatePassword($(this));
    });

    $("#rePassword").focusout(function() {
        if ($("#password").val() != $(this).val()) {
            $(this).next().text("비밀번호가 맞지 않습니다.").css("color", "#fe5156");
        } else {
            isPwdOk = true;
        }
    });

    $("#rePassword").focusin(function() {
        isPwdOk = false;
    });

    $("#btnJoin").click(function() {
        if(!isValidEmail) {
        	$("#email").focus();
        	return false;
        }

        if (isEmpty($("#password").val())) {
            alert("비밀번호를 입력하세요.");
            $("#password").focus();
            return false;
        } else if (!isPwdOk) {
            alert("비밀번호가 맞지 않습니다.");
            $("#password").focus();
            return false;
        }

        if (!$("#agreedService").prop("checked")) {
            Alert("이용약관에 동의하셔야 합니다.");
            return false;
        }

        if (!$("#agreedPrivacy").prop("checked")) {
            Alert("개인정보 보호 약관에 동의하셔야 합니다.");
            return false;
        }

        var hpNum = "";
        hpNum = $("#mobile01").val() + $("#mobile02").val() + $("#mobile03").val();
        $("#hpNum").val(hpNum);

        var birthDate = "";
        birthDate = $("#birthYear").val() + $("#birthMonth").val() + $("#birthDay").val();
        $("#birthDate").val(birthDate);

        $("form#joinForm").ajaxSubmit({
            url:  "/shop/subscribe"
            , dataType: "json"
            , success: function(data) {
                if (data.save) {
                    document.location.replace("/shop/joinFinish");
                } else {
                    Alert(data.errorMessages[0].value);
                }
            }
            , error: function(xhr, status, error) {
                Alert("<ui:message key='error.common.system'/>");
            }
        });
    });
});

function validateEmail(obj) {
	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	var isValid = true;

    if(obj.val() == '') {
    	isValid = false;
        $("#emailTxt").text("이메일을 반드시 입력해야 합니다.").css("color", "#fe5156");
    }

    if(exptext.test(obj.val()) == false) {
    	isValid = false;
        $("#emailTxt").text("이 메일형식이 올바르지 않습니다.").css("color", "#fe5156");
    }

    if(isValid) {
    	$("#emailTxt").text();
    }

    return isValid;
}
</script>
</head>
<body class="locale-ko " data-locale="ko" data-_locale="_ko">
<div class="mp-alert"></div>
<div id="marketpress">
    <%@include file="header.jsp"%>
</div>

<div id="body">

		<form name="joinForm" id="joinForm" action="/shop/subscribe" method="post">
		<input type="hidden" name="hpNum" id="hpNum"/>
		<input type="hidden" name="birthDate" id="birthDate"/>

        <div>

                이메일주소 <input type="text" name="email" id="email"/>
            <span id="emailTxt"></span>
            <br/>
                비밀번호 <input type="password" name="password" id="password" style="ime-mode: disabled;" />
            <span></span>
            <br/>
                비밀번호 확인<input type="password" name="rePassword" id="rePassword" style="ime-mode: disabled;" />
            <span></span>
            <br/>
                닉네임 <input type="text" name="nickName" id="nickName"/>
            <span></span>
            <br/>

            <div class="mobile">
                휴대전화
                <input type="text" class="typeText" name="mobile" id="mobile01" maxlength="3" value=""/>
                <span>-</span>
                <input type="text" class="typeText" name="mobile" id="mobile02" maxlength="4" onKeyDown="javascript:onlyNum();"/>
                <span>-</span>
                <input type="text" class="typeText" name="mobile" id="mobile03" maxlength="4" onKeyDown="javascript:onlyNum();"/>
            </div>
            <div class="birthday">
                    생년월일
                <input type="text" name="birthYear" id="birthYear" maxlength="4" onKeyDown="javascript:onlyNum();"/>
                <span>년</span>
                <input type="text" name="birthMonth" id="birthMonth" maxlength="2" onKeyDown="javascript:onlyNum();"/>
                <span>월</span>
                <input type="text" name="birthDay" id="birthDay" maxlength="2" onKeyDown="javascript:onlyNum();"/>
                <span>일</span>
            </div>

            <br/>
            <br/>
            <br/>

            <div class="agreements">
                <table>
                    <colgroup>
                        <col style="width: 190px"/>
                        <col style="width: auto"/>
                    </colgroup>
                    <tr>
                        <td>
                            <input type="checkbox" name="agreedEmail" id="agreedEmail"/>
                            <label for="agreedEmail">이메일을 수신합니다.</label>
                        </td>
                        <td>
                            <input type="checkbox" name="agreedSms" id="agreedSms"/>
                            <label for="agreedSms"> SMS를 수신합니다.</label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="checkbox" name="agreedService" id="agreedService"/>
                            <label for="agreedService">이용약관에 동의합니다 [<a href="/rules/service" target="_blank">내용보기</a>]</label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="checkbox" name="agreedPrivacy" id="agreedPrivacy"/>
                            <label for="agreedPrivacy">개인정보 취급방침에 동의합니다 [<a href="/rules/privacy" target="_blank">내용보기</a>]</label>
                        </td>
                    </tr>
                </table>
            </div>

            <br/>
            <br/>
            <br/>
            <button type="button" id="btnJoin">확인</button>

        </div>
		</form>

        <p id="failMsg"></p>

	</div>
</body>
</html>