<%@page contentType="text/plain" pageEncoding="UTF-8"%><%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@
taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@
taglib uri="http://www.ssgdfs.com/taglib/ui" prefix="ui" %><%@
taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" 
%><<<mstart>>>
${naverTotal.orderTotalAmt}|${naverTotal.orderTotalCount}|${naverTotal.billDate}
<<<mend>>>
<<<pstart>>><c:forEach items="${navers}" var="naver" varStatus="status">
${naver.prdtCode}|${naver.orderTotalCount}|${naver.orderTotalAmt}</c:forEach>
<<<pend>>>
