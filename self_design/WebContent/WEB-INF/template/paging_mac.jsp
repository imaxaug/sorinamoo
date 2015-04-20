<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:if test="${pageInfo.totalPage > 0}">
   	<c:if test="${pageInfo.currentPage > 1}">
    	<a href="${pageInfo.url}${pageInfo.separator}${pageInfo.pageParam}=${pageInfo.currentPage-1}${pageInfo.paramString}" class="prevbtn"><img src="${imageServer}/images/shop/brandShop/mac/btn_prevpage.gif" alt="이전" /></a>
   	</c:if>
   	<c:if test="${pageInfo.currentPage <= 1}">
    	<a href="#none" class="prevbtn"><img src="${imageServer}/images/shop/brandShop/mac/btn_prevpage.gif" alt="이전" /></a>
   	</c:if>
    <c:if test="${!empty pageInfo.pages}">
    </c:if>
    <c:forEach items="${pageInfo.pages}" var="page" varStatus="status">
        <c:if test="${pageInfo.currentPage != page}">
            <a href="${pageInfo.url}${pageInfo.separator}${pageInfo.pageParam}=${page}${pageInfo.paramString}">${page}</a>
        </c:if>
        <c:if test="${pageInfo.currentPage == page}">
            <a href="javascript://" class="on">${page}</a>
        </c:if>
    </c:forEach>
    <c:if test="${!empty pageInfo.pages}">
    </c:if>
    <c:if test="${pageInfo.currentPage >= pageInfo.totalPage}">
        <a href="#none" class="nextbtn"><img src="${imageServer}/images/shop/brandShop/mac/btn_nextpage.gif" alt="다음" /></a>
    </c:if>
    <c:if test="${pageInfo.currentPage < pageInfo.totalPage}">
        <a href="${pageInfo.url}${pageInfo.separator}${pageInfo.pageParam}=${pageInfo.currentPage+1}${pageInfo.paramString}" class="nextbtn"><img src="${imageServer}/images/shop/brandShop/mac/btn_nextpage.gif" alt="다음" /></a>
    </c:if>
</c:if>
