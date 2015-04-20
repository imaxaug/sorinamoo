<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.ssgdfs.com/taglib/ui" prefix="ui" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="copyright" content="2013 SHINSEGAE DUTY FREE" />
<title>신세계인터넷면세점</title>
<link rel="shortcut icon" TYPE="image/x-ico" href="${imageServer}/images/favicon.ico" /> 
<link href="/css/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.alphanumeric.pack.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.mousewheel.js"></script>
<script type="text/javascript" src="/js/jquery/mwheelIntent.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.jscrollpane.min.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.rotate.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.jqzoom-core.js"></script>
<script type="text/javascript" src="/js/jquery/common.js"></script>
<script type="text/javascript" src="/script/common.js"></script>
<script type="text/javascript" src="/script/shop.js"></script>
<script type="text/javascript">
jQuery(function($){
    <%-- 상단 gnb 닫기 --%>
    $(".main-top-banner span").click(function(){
        $(this).parent().hide();
    });
    $.ajax({
        type: "get"
        , url : "/shop/getMainPopUp"
        , dataType:"json"
        , success: function(data) {
            for (var i = 0; i < data.list.length; i++) {
                var sizeY = data.list[i].sizeY +35;
                var sizeX = data.list[i].sizeX +5;
                window.open(
                      '/shop/PopupMain?popupSeq='+data.list[i].popupSeq
                    , data.list[i].popupSeq
                    , 'width='+sizeX+', height='+sizeY+', top='+data.list[i].lctnX+', left='+data.list[i].lctnY+',scrollbars=no,resizable=no'
                );
            }
        }
    });
    
    storeReady = function(){
        alert("준비중입니다.");
        return;
    };
    
    
});

</script>

<decorator:head/>
</head>
<body style="background: url(${imageServer}/images/shop/common/bg_body.jpg) repeat-x center bottom;">
<c:import url="/shop/common/mainTop"/>
<div id="wrapper">
    <div id="wrap">
        <c:import url="/shop/common/mainGnb"/>
        <div id="body">
            <decorator:body/>
        </div><!-- end body -->        
        <c:import url="/shop/common/quickbar"/>
        <c:import url="/shop/common/footer"/>
        <c:import url="/shop/common/leftbar"/>
    </div><!-- end wrap -->
    <p class="go-top"><a href="#head"><img src="${imageServer}/images/shop/common/top.png" alt="top" /></a></p>
</div><!-- end wrapper -->
<div class="layer-detail" id="previewProduct"></div>


</body>
</html>
