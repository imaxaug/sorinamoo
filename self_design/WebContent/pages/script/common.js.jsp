<%@page contentType="application/javascript" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.ssgdfs.com/taglib/ui" prefix="ui" %>
<%@taglib uri="http://www.ssgdfs.com/taglib/hfn" prefix="hfn"%>
<ui:decorator name="none"/>

 (function(w,d,n,s,e,o) {
  w[n]=w[n]||function(){(w[n].q=w[n].q||[]).push(arguments)};
  e=d.createElement(s);e.async=1;e.charset='utf-8';e.src='//static.recopick.com/dist/production.min.js';
  o=d.getElementsByTagName(s)[0];o.parentNode.insertBefore(e,o);
})(window, document, 'recoPick', 'script');
recoPick('site', '${onlyServerHost}');
checkVisitRecoPick();
jQuery(function($) {
    //$('input.inputNumberText').numeric();
    
    $('input.upper').keyup(function() {
        $(this).css("ime-mode", "disabled");
        $(this).val($(this).val().toUpperCase());
    });
    
   
    
});

function checkVisitRecoPick(){
	if(document.URL.match('_CAD')!=null){
		recoPick('page', 'visit');
	}
	
}
	
function inputNumberTextKeyDown(){
    var event = window.event;
    
    if (event.keyCode != 13) {
        if (event.keyCode != 8) {
            if ((event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 || event.keyCode <= 105)) {
            }else{
                event.returnValue = false;
            }
        }
    }
}

function emailValidation(obj) {
    var pattern0 = /[ㄱ-힣\`\~\!\@\#\$\%\^\&\*\(\)\=\+\\\|\;\'\'\:\"\"\,\/\<\>\?]/g;
    var pattern1 = /[ㄱ-힣\@]/g;
    var pattern2 = /\./g;
    var pattern3 = /\.{2,}/g;
    var pattern4 = /\.$/;
    var email = obj.val().split("@");

    if(pattern1.test(email[0])) {
        alert("<ui:message key='validate.invalid.email' locale='${localeKey}'/>");
        return false;
    }

    if(pattern1.test(email[1])
        || !pattern2.test(email[1])
        || pattern3.test(email[1])
        || pattern4.test(email[1])){
        alert("<ui:message key='validate.invalid.email' locale='${localeKey}'/>");
        return false;
    }
    
    return true;
}

function isEmpty(value) {
    return (value == null || value == undefined || value == "");
}

function openWindow(url, width, height, target) {
    if (isEmpty(target)) {
        target = '_BLANK';
    }
    
    window.open(url, target, 'width=' + width + ',height=' + height + ',scrollbars=yes');    
}

function openWindowNoScroll(url, width, height, target) {
    if (isEmpty(target)) {
        target = '_BLANK';
    }
    
    window.open(url, target, 'width=' + width + ',height=' + height + ',scrollbars=no');    
}
<%-- 
/**
 * 상품 판매가와 할인율을 넣으면 얼마가 할인되는지를 리턴한다.
 * @param sellPriced
 * @param dscntRate
 * @returns {Number}
 */
--%>
function discountPrice(sellPrice, dscntRate){
    
    var rate = parseFloat(dscntRate);
    var discountRate = (rate * 100.0) / 100.0;
    var minusPrice = Number((sellPrice * (discountRate / 100)));
    minusPrice = cutoff(minusPrice);
    
    return minusPrice;
}

function cutoff(minusPrice){
    // return parseInt(Math.round((parseFloat(minusPrice) / 1.0))) * 1;
    return parseInt(Math.round((parseFloat(minusPrice) / 100.0))) * 100;
}

function expectSavePoint(sellPrice, dscntRate){
    
    var savePoint = (sellPrice * dscntRate) / 1000.0;
    savePoint = Math.floor(parseFloat(savePoint)) * 10;
    return parseInt(savePoint);
}


<%-- 
/**
 * 상품 판매가와 할인가를 넣으면 할인율을 리턴한다.
 * @param sellPrice
 * @param dscntSellPrice
 * @returns {Number}
 */
--%>
function discountRate(sellPrice, dscntSellPrice){

    var newDiscountRate = ((parseInt(sellPrice) - parseInt(dscntSellPrice)) / (parseInt(sellPrice) * 1.0)) * 100.0;
    newDiscountRate = Math.round(parseInt(newDiscountRate));
    
    return newDiscountRate;
}

<%-- 
/**
 * 소수점 처리 추가
 * @param val
 * @returns {String}
 */
--%>
function price_format(val){
    val = $.trim(val+"");
    if(val == ''){ return val; }
    if(isNaN(val)){ return val; }
	
	var tempArr;
	var temp = "";
	if( val.indexOf(".") ){
		tempArr = val.split(".");
		val = tempArr[0];
		temp = tempArr[1];
	}

    var rv = "", idx = 0;
    for (var i = val.length-1 ; i >= 0 ; i--){
        rv = ((idx != 0 && idx%3 == 0) ? val.substring(i, i+1) + "," : val.substring(i, i+1)) + rv;
        idx++;
    }

	if( ! isEmpty(temp) ){
		rv = rv+"."+temp;
	}
	
    return rv;
}

function onlyNum() {
    if(((event.keyCode < 48) || (event.keyCode > 57))
            && event.keyCode != 8 && event.keyCode != 9
            && ((event.keyCode < 96) || (event.keyCode > 105))
            && event.keyCode != 46 && event.keyCode != 13
            && event.keyCode != 37 && event.keyCode != 39
            && event.keyCode != 35 && event.keyCode != 36){
        event.returnValue = false;
    }
}

function onlyNumForKeyup(obj) {
    var isValid = false;
    var pattern = /\D/g;
    var cut = obj.val().substr(0, obj.val().length - 1);
    
    if (pattern.test(obj.val())) {
        isValid = false;
        Alert("숫자만 사용할 수 있습니다.");
        obj.val(cut);
    } else {
        isValid = true;
    }
    
    return isValid;
}

<%--
/**
 * 날짜 포멧을 맞춘다
 * @param str '20120109'
 * @return '2012-01-09'
 **/
--%>
function dataFormat(str){
    if(str.length == 8){
        str = str.substr(0,4) + "-" + str.substr(4,2) + "-" + str.substr(6,2);
    }

    return str;
}

function validateResno(obj) {
    return onlyNumForKeyup(obj);
}

function validatePassword(obj) {
    var isValid = false;

    if (isEmpty(obj.val()) && (obj.val().length < 8)) {
        isValid = false;
        obj.next().text(" <ui:message key='error.regex.password' locale='${localeKey}'/>").css("color", "#fe5156");
    } else if (obj.val().length >= 8) {
        var pattern1 = /\s/g;
        var pattern2 = /\D/g;
        var cut = obj.val().substr(0, obj.val().length - 1);
        
        if (pattern1.test(obj.val())){
            isValid = false;
            Alert(" <ui:message key='error.space.input' locale='${localeKey}'/>");
            obj.val(cut);
        }
        
        if (pattern2.test(obj.val())){
            isValid = true;
            obj.next().text(" <ui:message key='message.user.password.ok' locale='${localeKey}'/>").css("color", "#00bff3");
            
            var alpNum = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"];
            
            for (var i = 0; i < alpNum.length; i++) {
                var pattern3 = new RegExp(alpNum[i] + "{4,}", "g");
                if (pattern3.test(obj.val())){
                    isValid = false;
                    obj.next().text(" <ui:message key='error.same.four.password' locale='${localeKey}'/>").css("color", "#fe5156");
                    break;
                }
            }
        } else {
            isValid = false;
            obj.next().text(" <ui:message key='error.regex.password' locale='${localeKey}'/>").css("color", "#fe5156");
        }
    } else {
        isValid = false;
    }
    
    return isValid;
}

function validateName(obj) {
    var isValid = true;
    var pattern = /[^ㄱ-힣]/g;
    
    if (!isEmpty(obj.val()) && pattern.test(obj.val())){
        obj.next().text("한글만 입력가능합니다.").css("color", "#fe5156");
        isValid = false;
    } else {
        obj.next().text("");
    }
    
    return isValid;
}

function validateNumPassword(obj) {
    var isValid = false;
    
    if (!isEmpty(obj.val()) && (obj.val().length < 4)) {
        isValid = false;
        obj.next().text("4자리 숫자").css("color", "gray");
    } else if (obj.val().length == 4) {
        var num = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"];
        var pattern = /\D/g;
        
        if (pattern.test(obj.val())) {
            isValid = false;
            obj.next().text("숫자만 사용할 수 있습니다.").css("color", "#fe5156");
        } else {
            isValid = true;
            obj.next().text("사용가능.").css("color", "#00bff3");
        }
        
        for (var i = 0; i < num.length; i++) {
            var pattern3 = new RegExp(num[i] + "{4,}", "g");
            if (pattern3.test(obj.val())){
                isValid = false;
                obj.next().text("같은 숫자를 네번 사용할 수 없습니다.").css("color", "#fe5156");
                break;
            }
        }
    }
    
    return isValid;
}

function imageError(obj) {
    obj.src = "${uploadServer}<ui:variable key="no.image"/>";
}

function Alert(message) {
    alert(message);
}

function Confirm(message) {
    return confirm(message);
}

function brandImageError(obj) {
    obj.src = "${uploadServer}<ui:variable key="no.brandImage"/>";
}
/**
 * 달러 -> 원화 리턴
 * javaScript:dalToWon(달러, 환율);
 */
function dalToWon(dal, dalRate){
    var rate = parseFloat(dalRate);
    rate = (rate * 100.0) / 100.0;
    var saveWon = parseInt(dal * rate)
    return saveWon;
}

/**
 * 원화 -> 달러 리턴
 * javaScript:wonToDal(원화, 환율);
 */
function wonToDal(strWon, strRate){
    var saveDal = parseFloat(strWon/ strRate);
    saveDal = Math.round(saveDal * 100)/100;
    return saveDal;
}

/**
 * 원화 -> 달러 리턴
 * javaScript:wonToDal(원화, 환율);
 */
function wonToDal(strWon, strRate){
    var saveDal = parseFloat(strWon/ strRate);
    saveDal = Math.round(saveDal * 100)/100;
    return saveDal;
}

/**
 * 위안 -> 달러 리턴 
 * javaScript:cnyToDal(위안, 중국환율);
 */
function cnyToDal(cny, cnyRate){
    var dal = parseFloat(cny/ cnyRate);
    dal = Math.round(dal * 100)/100;
    return dal;
}

/*****
* 영문과 숫자만 입력
* onkeydown="javaScript:validateNonKr();"
******/
function validateNonKr() {
	
	if(event.keyCode == 9 || event.keyCode == 13 || event.keyCode == 35 || event.keyCode == 36 || event.keyCode == 37 || event.keyCode == 39 || event.keyCode == 116 || event.keyCode == 8 || event.keyCode == 16 || (65 <= event.keyCode && event.keyCode <= 90) || (event.keyCode >= 96 && event.keyCode <= 105) || (!event.shiftKey && (47 < event.keyCode && event.keyCode < 58))){
	}else{
		if(event.preventDefault){
			//익스플로러 11 
            event.preventDefault();
        } else {
        	//그외 익스플로러
            event.returnValue = false; 
        }
	}
}

/*****
* 영문만 입력
* onkeydown="javaScript:validateOnlyEn();"
******/
function validateOnlyEn() {
	
	if(event.keyCode == 9 || event.keyCode == 13 || event.keyCode == 35 || event.keyCode == 36 || event.keyCode == 37 || event.keyCode == 39 || event.keyCode == 116 || event.keyCode == 8 || event.keyCode == 16 || (65 <= event.keyCode && event.keyCode <= 90) ){
	
	}else{
		if(event.preventDefault){
			//익스플로러 11
            event.preventDefault();
        } else {
        	//그외 익스플로러
            event.returnValue = false;
        }
	} 
}

/********************
* 숫자와  ","   입력***********************
* onkeydown="javaScript:validateNumber();"*
******************************************/
function validateNumber() {
    if(event.keyCode == 8 || 35 <= event.keyCode && event.keyCode <= 40 || event.keyCode == 46 || event.keyCode == 188 || (48 <= event.keyCode && event.keyCode <= 57) || (96 <= event.keyCode && event.keyCode <= 105) || (!event.shiftKey && (47 < event.keyCode && event.keyCode < 58))){
    }else{
        if(event.preventDefault){
			//익스플로러 11
            event.preventDefault();
        } else {
        	//그외 익스플로러
            event.returnValue = false;
        }
    }
}

/*****
* 영문과 숫자 골뱅이@ 쩜. 만입력
* onkeydown="javaScript:validateNonKrForEmail();"
******/
function validateNonKrForEmail() {
	if(event.keyCode == 13 || event.keyCode == 35 || event.keyCode == 36 || event.keyCode == 37 || event.keyCode == 39 || event.keyCode == 50 || event.keyCode == 110 || event.keyCode == 116 || event.keyCode == 190 || event.keyCode == 8 || event.keyCode == 16 || (65 <= event.keyCode && event.keyCode <= 90) || (event.keyCode >= 96 && event.keyCode <= 105) || (!event.shiftKey && (47 < event.keyCode && event.keyCode < 58) || (event.shiftKey && event.keyCode === 189) || event.keyCode == 189)){
	}else{
		event.returnValue = false;
	}
}

/*****
* 11.1@222.333.444
* @ 로 split한후 111 에 영문과숫자 - _ 를 제외한 특수문자를 체크한다.
* @ 로 split한후 도메인에 영문과 숫자 - _ 를 제외한 특수문제를 체크하고  222.333 형태인지 체크한다.
******/
function validateEmail(temp) {
    var tempArray = temp.split("@",2);
    var flag = true;
	    if(tempArray[0] == null || (/[^\w\.-]/g).test(tempArray[0]) || tempArray[1] == null || (/[^\w\.-]/g).test(tempArray[1]) || !(/[^\s\.]\.[^\s\.]/g).test(tempArray[1])){
	    	flag = false;
	    }
	    return flag;
}
 
<%--
/**
 * 같은 행끼리 로우스팬 주기
 * @param tableId ex) $("#tableId")
 * @param colIdx  rowspan을 주기위한 index 
 * 사용법	
 	$(window).load(function () {
        fnSetRowspan($("#couponTable"), 0);
        fnSetRowspan($("#couponTable"), 1);
    });
 **/
--%>     
function fnSetRowspan(tableId, colIdx) {
	tableId.each(function(){
		var that;
		$('tr', this).each(function(row) {
			$('td:eq('+colIdx+')', this).each(function(col) {
				if ($(this).html() == $(that).html()) {
				    rowspan = $(that).prop("rowSpan");
					if (rowspan == undefined) {
						$(that).prop("rowSpan",1);
						rowspan = $(that).prop("rowSpan");
					}
					rowspan = Number(rowspan)+1;
					$(that).prop("rowSpan",rowspan); // do your action for the colspan cell here
					$(this).hide(); // .remove(); // do your action for the old cell here
				} else {
					that = this;
				}
				that = (that == null) ? this : that; // set the that if not already set
			});
		});
	});
}

