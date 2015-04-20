<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.ssgdfs.com/taglib/ui" prefix="ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="copyright" content="2013 SHINSEGAE DUTY FREE" />
<title>SHINSEGAE</title>
</head>
<body style="margin:0; padding:0; font-family:'돋움','Dotum',sans-serif;">
<div style="width: 700px; overflow: hidden;  padding: 0; margin: 0; font-family:'돋움','Dotum',sans-serif;">
    <table cellspacing="0" cellpadding="0" border="0" style="padding: 0; margin: 0; width: 700px; background:#fff;">
        <tbody>
            <tr>
                <td><img src="http://image.ssgdfs.com/images/shop/mail/head_confirm.gif" width="700" height="80" alt="sinsegae duty free 신세계인터넷면세점 회원가입 인증메일입니다." style="border: 0; padding: 0;  vertical-align: top;" /></td>
            </tr>
            <tr>
                <td>
                    <table cellspacing="0" cellpadding="0" border="0" style="width: 598px; margin: 0 auto;">
                        <tr>
                            <td>
                                <div style="margin: 0 auto; height: 356px; width: 598px; background: url(http://image.ssgdfs.com/images/shop/mail/title_confirm02.gif) no-repeat 0 0;">
                                    <p style="padding: 0; margin: 0; font-size: 11px; visibility: hidden;">
                                        신세계인터넷면세점 인증메일
                                    </p>
                                </div>
                            </td>
                        </tr>
                    </table>                    
                </td>
            </tr>
            <tr>
                <td style="font-szie: 12px;">
                    <p style="padding: 21px 0 10px 50px; margin: 0; height: 24px;">
                        <img src="http://image.ssgdfs.com/images/shop/mail/confirm02_txt.gif" width="172" height="16" alt="아래 코드를 입력하세요."/>
                    </p>
                    <table cellspacing="0" cellpadding="0" border="0" style="width: 598px; margin: 0 auto 66px auto; border-top: 2px solid #555; font-size: 12px;">
                        <tbody>
                            <tr>
                                <th style="padding: 0 0 0 18px; width: 120px; background: #f8f8f8; font-size: 12px; height: 30px; font-weight: normal; text-align: left; border-right: 1px solid #d4d4d4;  border-bottom: 1px solid #d4d4d4;">인증코드</th>
                                <td style="padding: 0 0 0 18px;  font-size: 12px; height: 30px; width: 478px;  border-bottom: 1px solid #d4d4d4;">${authCode}</td>
                            </tr>
                        </tbody>
                    </table>
                </td>
            </tr>
            <tr>
                <td>
                    <p style="padding: 10px 0 10px 0; margin: 0; font-size: 12px; color: #666; text-align: center; border-top: 1px solid #f5f5f5; border-bottom: 1px solid #f5f5f5;">
                        본 메일은 발신전용으로 회신되지 않습니다. 궁금하신 사항은 <a href="http://www.ssgdfs.com/" style="font-weight: bold; color: #666;">[여기]</a>를 클릭하여 문의해 주시기 바랍니다.<br />
                        You have questions Please contact us by clicking here.
                    </p>    
                </td>
            </tr>
            <tr>
                <td>
                    <div style="padding: 0; margin: 0 0 19px; position: relative; width: 700px;  height: 125px; height: 124px; overflow: hidden; background: url(http://image.ssgdfs.com/images/shop/mail/bg_foot.gif) no-repeat 0 0;" >
                        <div style="padding:0; margin:0; width:700px; height:125px; background:url(http://image.ssgdfs.com/images/shop/mail/foot_logo.gif) no-repeat 40px 51px;">
	                        <p style="padding: 22px 0 0 161px; margin: 0;"><img src="http://image.ssgdfs.com/images/shop/mail/address.gif" width="265" height="12" alt="부산광역시 해운대구 해운대 해변로 296 (중동) ㈜신세계면세점" style="border: 0; vertical-align: top;" /></p>
	                        <p style="padding: 4px 0 0 161px; margin: 0;"><img src="http://image.ssgdfs.com/images/shop/mail/crop_info01.gif" width="502" height="26" alt="대표이사 : 성영목     사업자등록번호 : 617-85-40132     법인등록번호 : 110111-0003999 통신판매업신고번호 : 2012-부산해운-0491     개인정보관리책임자 : 이규원     이메일 : cs_dfs@chosunhotel.co.kr" style="border: 0; vertical-align: top;" /></p>
	                        <p style="padding: 4px 0 0 161px; margin: 0;"><img src="http://image.ssgdfs.com/images/shop/mail/crop_info02.gif" width="209" height="10" alt="대표번호 : 1577-0161     팩스 : 051-749-1266 " style="border: 0; vertical-align: top;" /></p>
	                        <p style="padding: 9px 0 0 161px; margin: 0;"><img src="http://image.ssgdfs.com/images/shop/mail/copy_right.gif" width="362" height="9" alt="COPYRIGHT@2013 BY SHINSEGAE DUTY FREE. ALL RIGHT RESERVED." style="border: 0; vertical-align: top; "/></p>
                       </div>
                    </div>
                </td>
            </tr>
        </tbody>
    </table>
</div><!-- end mail temp -->
</body>
</html>