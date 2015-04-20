<%@page contentType="application/javascript" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.ssgdfs.com/taglib/ui" prefix="ui" %>
<%@taglib uri="http://www.ssgdfs.com/taglib/hfn" prefix="hfn"%>
<ui:decorator name="none"/>
jQuery(function($) {
    $('input.upper').keyup(function() {
        $(this).css("ime-mode", "disabled");
        $(this).val($(this).val().toUpperCase());
    });
    
    $("#searchPostNum").click(function() {
        var url = "/shop/user/searchPostNumGibun";
        openWindow(url, 500, 640, "searchPostNum");
        return false;
    });
    
    $("body").on("click", ".btnLoginPopup", function() {
        var url = "/shop/login/loginPopupForm?redirectUrl="+escape(location.href);
        openWindow(url, 500, 540, 'loginPopupForm'); 
        return false;
    });
    
    $("body").on("click", ".btnIsLoginPopup", function() {
        var nonUserType = $(this).attr("value");
        if (${isLogin}) {
            return true;
        } else {
            if (nonUserType == "myPage" || nonUserType == "order") {
                var url = "/shop/login/loginPopupForm?redirectUrl="+escape(location.href)+"&nonUserType="+nonUserType;
                openWindow(url, 500, 700, 'loginPopupForm');
            } else {
                var url = "/shop/login/loginPopupForm?redirectUrl="+escape(location.href);
                openWindow(url, 500, 540, 'loginPopupForm'); 
            }
            return false;
        }
    });
    
    
    $("body").on("click",".btnFindIpPwd", function() {
        var url = "/shop/login/findIdPopup"
        openWindow(url, 500, 540, 'loginPopupForm');
        return false;
    });
    
    $("body").on("click" , ".btnBnfEvent" , function() {
        if (${isLogin}) {
            $.ajax({
                url : "/shop/promotion/bnfEvent"
                , type : "POST"
                , data : "bnfPrsntSeq="+$(this).attr("id")
                , dataType : "json"
                , success : function(data) {
                    if (data.success) {
                        Alert("발급 되었습니다.");
                    } else {
                        var errorMessages = data.errorMessages;
                        Alert(errorMessages[0]);
                    }
                }
            });
        } else {
            var url = "/shop/login/loginPopupForm?redirectUrl="+escape(location.href);
            openWindow(url, 490, 480, 'loginPopupForm'); 
            return false;
        }
    });
});

<%-- Twitter --%>
function goTwitter(prdtCode, prdtPath, prdtEngName){
    var url      = "http://twitter.com/share?text=";
    var prdtName = encodeURIComponent("[" + prdtEngName + "]");
    var prdtUrl  = encodeURIComponent(prdtPath + "?prdtCode=" + prdtCode);
    var result = window.open(url + prdtName + " " + prdtUrl , 'twitter', 'width=466, height=356');
    if (result) {
        result.focus();
    }
    
    return false;
}

<%-- facebook --%>
function goFaceBook(name, image){

    var url     = location.href;
    var title   = "[신세계 인터넷 면세점]" + name;
    var summary = "[신세계 인터넷 면세점]";
    var url     = "http://www.facebook.com/sharer.php?s=100&p[url]=" + url + "&p[images][0]=" + image + "&p[title]=" + title + "&p[summary]=" + summary;
    url = url.split("#").join("%23");
    url = encodeURI(url);

    window.open(url);

    return false;
}

<%-- 미투데이 --%>
function shareMe2Day(msg, url, tag, shortType) {
    //단축 URL 사용시. - durl 사용
    if( shortType == "Y"){
        var params = {
                longurl : url,
                type        : "json"
            };
            $.getJSON("http://durl.me/api/Create.do?callback=?", params, function (jsonData){
                url = jsonData['shortUrl'] ;
                
                var href = "http://me2day.net/posts/new?new_post[body]=" + encodeURIComponent("신세계 인터넷 면세점" + msg) + " " + encodeURIComponent(url) + "&new_post[tags]=" + encodeURIComponent(tag);
                var a = window.open(href, "me2Day", "");
                if ( a ) {
                    a.focus();
                } 
            });         
    } else {    
        var href = "http://me2day.net/posts/new?new_post[body]=" + encodeURIComponent("신세계 인터넷 면세점" + msg) + " " + encodeURIComponent(url) + "&new_post[tags]=" + encodeURIComponent(tag);
        var a = window.open(href, "me2Day", "");
        if ( a ) {
            a.focus();
        }
    }
}

/**
 * 장바구니 담기
 * @param : 상품코드
 * @param : 상품수량
 * @param : 옵션내용
 * @param : 카테고리ID
 */
function addCart(prdtCode, prdtCount, optnDesc, ctgrId, detail){
    if(prdtCode == undefined || prdtCode == "") {
        prdtCode = "";
    }
    if(prdtCount == undefined || prdtCount == "") {
        prdtCount = 1;
    }
    if (optnDesc == undefined || optnDesc == "") {
        optnDesc = "";
    }
    if (ctgrId == undefined || ctgrId == '') {
        ctgrId = "";
    }

    var params = "prdtCode=" + prdtCode;
    params += "&optnDesc=" + encodeURI(optnDesc);
    params += "&ctgrId=" + ctgrId;
    params += "&prdtCount=" + prdtCount;
    
    <%-- 상품상세가 아니고, 옵션이 없을때만
    옵션조회해서 
    옵션있을때 미리보기 레이어
    /shop/display/getProductOption
    --%>
    var goStop = true;
    if(isEmpty(detail) && isEmpty(optnDesc)){
        $.ajax({
        type:'get',
        url:'/shop/display/getProductOption?prdtCode='+prdtCode,
        dataType:'json',
        async:false,
        success:function(data){
            if(!isEmpty(data.prdtOption)){
                var topi;
                if($(window).scrollTop() < 170){
                    topi = ($(window).scrollTop() + ($(window).height() / 2) - (625/2) + 170);
                }else{
                    topi = ($(window).scrollTop() + ($(window).height() / 2) - (625/2));
                }
                var leftpoi = ($(window).width() / 2) - (818/2);
                $("div.layer-detail").css({"position": "absolute", "z-index" : "100", "top": topi , "left" : leftpoi });
                
                var params = "prdtCode="+ prdtCode;
                $(".layer-detail").show();
                $.ajax({
                    type: "GET"
                    ,url: "/shop/product/productPreview"
                    ,data: params
                    ,dataType: "html"
                    ,async : false
                    ,success: function(html) {
                        $("div#previewProduct").css({"position": "absolute" , "top": topi , "left" : leftpoi });
                        
                        $("div#previewProduct").html("");
                        $("div#previewProduct").html(html);
                        
                        $(".color-size").selectbox();
                        
                        $('.layer-detail .jqzoom').jqzoom({
                            zoomType: 'reverse',
                            lens:true,
                            xOffset:40,
                            yOffset:0,
                            preloadImages: false,
                            alwaysOn:false 
                        });
                        
                        // 줌 패드 영역 롤링
                        $(".preview-product .pattern-list .view-con span").click(function(){
                            btn = $(this).attr("class");
                            targetList = $("div.pattern-wrap ul");
                            targetLen = $("div.pattern-wrap ul li").width();
                            listView(btn , targetList , targetLen , "h");
                            targetList.width(targetLen* $("div.pattern-wrap ul li").size());
                        });
                        /*** 롤링 공통 ***/
                        var flag = true;
                        listView = function(btn, tagetList, targetlen , type){
                            if(flag){
                                flag = false;
                                poi = tagetList.position();
                                poiX = poi.left;
                                poiY = poi.top;
                                size = (tagetList.find("li").size()-5)*targetLen;
                                
                                if(btn == "prev"){
                                    if(type == "h"){
                                        if(poiX <= size*-1) {
                                            targetList.stop();
                                        }else {
                                            targetList.stop().animate({"left" : poiX -targetLen} , 500);
                                        }
                                    }else if(type == "v"){
                                        if(poiY <= size*-1) {
                                            targetList.stop();
                                        }else {
                                            targetList.stop().animate({"top" : poiY -targetLen} , 500);
                                        }
                                    }
                                }else if(btn == "next"){
                                    if(type == "h"){
                                        if(poiX == 0) {
                                            targetList.stop();
                                        }else {
                                            targetList.stop().animate({"left" : poiX +targetLen} , 500);
                                        }
                                    }else if(type == "v")  {
                                        if(poiY == 0) {
                                            targetList.stop();
                                        }else {
                                            targetList.stop().animate({"top" : poiY +targetLen} , 500);
                                        }
                                    }
                                }
                                setTimeout(function(){flag = true;}, 500);
                            }
                        }
                    }
                });<%--end ajax --%>
                goStop = false;
            }
        }
    });
    };
    if(!goStop){
        return false;
    }
    
    $.ajax({
        type: "post"
        ,url: "/shop/order/addCart"
        ,data: params
        ,dataType: "json"
        ,success: function(data) {
		        if (data.success) {
			        var iprdtCode=data.info.prdtCode;
			        var icount = data.info.prdtCount;
			        var ibuyDal = data.info.buyPriceDal;
			        var ictgrId = data.info.ctgrId;
			        var ictgrId1 = "";
			        if(ictgrId!=null  && ictgrId.length>=4){ictgrId1   = ictgrId.substring(0,4);}
					var ictgrId2 = "";
					if(ictgrId!=null  && ictgrId.length>=6){ictgrId2   = ictgrId.substring(0,6);}
					recoPick("page", "basket", {id:iprdtCode, count:icount, total_sales:ibuyDal, c1:ictgrId1, c2:ictgrId2, c3:ictgrId});
		        	if( Confirm("<ui:message key='confirm.addCart.message'/>") ){
		        		location.href = "/shop/order/cart";
		        	}
		        	 
		        } else {
		            var errorMessages = data.errorMessages;
		            Alert(errorMessages);
		        }
            }
            , error: function(xhr, status, error) {
                Alert("<ui:message key='error.common.system'/>");
            }
	});
}
/**
 * 위시리스트 담기-단건
 * @param : 상품코드
 */
function addWishProduct(prdtCode){
    
    if(!${isLogin}){
        var url = "/shop/login/loginPopupForm?redirectUrl="+escape(location.href);
        openWindow(url, 500, 540, 'loginPopupForm'); 
        return false;
    }

    $.ajax({
        type: "POST"
        ,url: "/shop/product/addWish"
        ,data: "prdtCode="+prdtCode
        ,dataType: "json"
        ,success: function(data) {
                if (data.save) {
                    if( Confirm("<ui:message key='confirm.addWishProduct.message'/>")){
                        location.href = "/shop/mypage/wish/listWish";   
                    }
                } else {
                    var errorMessages = data.errorMessages;
                    Alert(errorMessages);
                }
            }
            , error: function(xhr, status, error) {
                Alert("<ui:message key='error.common.system'/>");
            }
    });
}

/**
 * 위시리스트 담기-다건
 * @param : 상품코드
 */
function addWishProducts(prdtCodes){
    $.ajax({
        type: "POST"
        ,url: "/shop/product/addWishList"
        ,data: "prdtCodes="+prdtCodes
        ,dataType: "json"
        ,success: function(data) {
                if (data.save) {
                    if( Confirm("<ui:message key='confirm.addWishProduct.message'/>")){
                        location.href = "/shop/mypage/wish/listWish";   
                    }
                } else {
                    var errorMessages = data.errorMessages;
                    Alert(errorMessages);
                }
            }
            , error: function(xhr, status, error) {
                Alert("<ui:message key='error.common.system'/>");
            }
    });
}

/**
 * 위시리스트 삭제-단건
 * @param : 상품코드
 */
function delWishProduct(prdtCode){
    $.ajax({
        type: "POST"
        ,url: "/shop/product/deleteWishByPrdtCode"
        ,data: "prdtCode="+prdtCode
        ,dataType: "json"
        ,success: function(data) {
                if (data.del) {
                     Confirm("<ui:message key='confirm.delWishProduct.message'/>")
                } else {
                    var errorMessages = data.errorMessages;
                    Alert(errorMessages);
                }
            }
            , error: function(xhr, status, error) {
                Alert("<ui:message key='error.common.system'/>");
            }
    });
}

/**
 * 이미지 업로드
 * @param : 아이디
 */
function openImageUpload(paramId) {
    var url = "/admin/uploadImageForm";
    if (paramId == undefined || paramId == "") {
    } else {
        url += "?paramId=" + paramId;
    } 

    openWindow(url, 500, 250, 'imageUpload'); 
    return false;
}

/**
 * 바로구매
 * @param : 상품코드
 * @param : 상품수량
 * @param : 옵션내용
 * @param : 카테고리ID
 */
function quickOrder(prdtCode, prdtCount, optnDesc, ctgrId, detail){
	
    if(prdtCode == undefined || prdtCode == "") {
        prdtCode = "";
    }
    if(prdtCount == undefined || prdtCount == "") {
        prdtCount = 1;
    }
    if (optnDesc == undefined || optnDesc == "") {
        optnDesc = "";
    }
    if (ctgrId == undefined || ctgrId == '') {
        ctgrId = "";
    }

    var params = "prdtCode=" + prdtCode;
    params += "&optnDesc=" + encodeURI(optnDesc);
    params += "&ctgrId=" + ctgrId;
    params += "&prdtCount=" + prdtCount;
    
    <%-- 상품상세가 아니고, 옵션이 없을때만
    옵션조회해서 
    옵션있을때 미리보기 레이어
    /shop/display/getProductOption
    --%>
    var goStop = true;
    if(isEmpty(detail) && isEmpty(optnDesc)){
        $.ajax({
        type:'get',
        url:'/shop/display/getProductOption?prdtCode='+prdtCode,
        dataType:'json',
        async:false,
        success:function(data){
            if(!isEmpty(data.prdtOption)){
                var topi;
                if($(window).scrollTop() < 170){
                    topi = ($(window).scrollTop() + ($(window).height() / 2) - (625/2) + 170);
                }else{
                    topi = ($(window).scrollTop() + ($(window).height() / 2) - (625/2));
                }
                var leftpoi = ($(window).width() / 2) - (818/2);
                $("div.layer-detail").css({"position": "absolute", "z-index" : "100", "top": topi , "left" : leftpoi });
                
                var params = "prdtCode="+ prdtCode;
                $(".layer-detail").show();
                $.ajax({
                    type: "GET"
                    ,url: "/shop/product/productPreview"
                    ,data: params
                    ,dataType: "html"
                    ,async : false
                    ,success: function(html) {
                        $("div#previewProduct").css({"position": "absolute" , "top": topi , "left" : leftpoi });
                        
                        $("div#previewProduct").html("");
                        $("div#previewProduct").html(html);
                        
                        $(".color-size").selectbox();
                        
                        $('.layer-detail .jqzoom').jqzoom({
                            zoomType: 'reverse',
                            lens:true,
                            xOffset:40,
                            yOffset:0,
                            preloadImages: false,
                            alwaysOn:false 
                        });
                        
                        // 줌 패드 영역 롤링
                        $(".preview-product .pattern-list .view-con span").click(function(){
                            btn = $(this).attr("class");
                            targetList = $("div.pattern-wrap ul");
                            targetLen = $("div.pattern-wrap ul li").width();
                            listView(btn , targetList , targetLen , "h");
                            targetList.width(targetLen* $("div.pattern-wrap ul li").size());
                        });
                        /*** 롤링 공통 ***/
                        var flag = true;
                        listView = function(btn, tagetList, targetlen , type){
                            if(flag){
                                flag = false;
                                poi = tagetList.position();
                                poiX = poi.left;
                                poiY = poi.top;
                                size = (tagetList.find("li").size()-5)*targetLen;
                                
                                if(btn == "prev"){
                                    if(type == "h"){
                                        if(poiX <= size*-1) {
                                            targetList.stop();
                                        }else {
                                            targetList.stop().animate({"left" : poiX -targetLen} , 500);
                                        }
                                    }else if(type == "v"){
                                        if(poiY <= size*-1) {
                                            targetList.stop();
                                        }else {
                                            targetList.stop().animate({"top" : poiY -targetLen} , 500);
                                        }
                                    }
                                }else if(btn == "next"){
                                    if(type == "h"){
                                        if(poiX == 0) {
                                            targetList.stop();
                                        }else {
                                            targetList.stop().animate({"left" : poiX +targetLen} , 500);
                                        }
                                    }else if(type == "v")  {
                                        if(poiY == 0) {
                                            targetList.stop();
                                        }else {
                                            targetList.stop().animate({"top" : poiY +targetLen} , 500);
                                        }
                                    }
                                }
                                setTimeout(function(){flag = true;}, 500);
                            }
                        }
                    }
                });<%--end ajax --%>
                goStop = false;
            }
        }
    });
    };
    if(!goStop){
        return false;
    }
    
    $.ajax({
        type: "post"
        ,url: "/shop/order/quickOrder"
        ,data: params
        ,dataType: "json"
        ,success: function(data) {
		        if (data.success) {
		            if (${isLogin}) {
			            location.href = "${serverHostForSSL}/shop/order/orderSheet";
			        } else {
			            var url = "/shop/login/loginPopupForm?redirectUrl="+escape(location.href)+"&nonUserType=order";
                        openWindow(url, 500, 700, 'loginPopupForm');
                        return;
			        }
		        } else {
		            var errorMessages = data.errorMessages;
		            Alert(errorMessages);
		        }
            }
            , error: function(xhr, status, error) {
                Alert("<ui:message key='error.common.system'/>");
            }
	});
}


function isPopupOpen(){
    var win = window.open("${serverHostForSSL}", "_blank","width=0,height=0 status=yes, scrollbars=no,resizable=no, menubar=no");
    
    if (win == null || typeof(win) == "undefined" || (win == null && win.outerWidth == 0) || (win != null && win.outerHeight == 0) || win.test == "undefined") 
    {
        //alert("팝업 차단 기능이 설정되어있습니다\n\n차단 기능을 해제(팝업허용) 한 후 다시 이용해 주십시오.\n\n만약 팝업 차단 기능을 해제하지 않으면\n정상적인 주문이 이루어지지 않습니다.");
        Alert("<ui:message key='check.open.popup'/>"); 
        if(win){
            win.close();
        }
        return false;
        
    }else if (win){
        if (win.innerWidth === 0){
            //alert("팝업 차단 기능이 설정되어있습니다\n\n차단 기능을 해제(팝업허용) 한 후 다시 이용해 주십시오.\n\n만약 팝업 차단 기능을 해제하지 않으면\n정상적인 주문이 이루어지지 않습니다.");
            Alert("<ui:message key='check.open.popup'/>"); 
            return false;
        }
    }else{
        return false;
    }
    
    if(win){    // 팝업창이 떠있다면 close();
        win.close();
    }
    return true;
}


function isPopupOpenXpay()
{
    var xpayUrl = "<ui:variable key='lg.server' />";
    var cstPlatform = "<ui:variable key='lg.cstPlatform.china' />";
    var serverPort = "<ui:variable key='lg.serverPort' />";
    var lgServer = xpayUrl;
    
    if( cstPlatform == "test" ){
        lgServer = lgServer + ":" + serverPort;
    }

    var win = window.open(lgServer, "_blank","width=0,height=0 status=yes, scrollbars=no,resizable=no, menubar=no");
    
    if (win == null || typeof(win) == "undefined" || (win == null && win.outerWidth == 0) || (win != null && win.outerHeight == 0) || win.test == "undefined") 
    {
        //alert("팝업 차단 기능이 설정되어있습니다\n\n차단 기능을 해제(팝업허용) 한 후 다시 이용해 주십시오.\n\n만약 팝업 차단 기능을 해제하지 않으면\n정상적인 주문이 이루어지지 않습니다.");
        Alert("<ui:message key='check.open.popup'/>"); 
        if(win){
            win.close();
        }
        return false;
        
    }else if (win){
        if (win.innerWidth === 0){
            //alert("팝업 차단 기능이 설정되어있습니다\n\n차단 기능을 해제(팝업허용) 한 후 다시 이용해 주십시오.\n\n만약 팝업 차단 기능을 해제하지 않으면\n정상적인 주문이 이루어지지 않습니다.");
            Alert("<ui:message key='check.open.popup'/>");
            return false;
        }
    }else{
        return false;
    }
    
    if(win){    // 팝업창이 떠있다면 close();
        win.close();
    }
    return true;
    
}