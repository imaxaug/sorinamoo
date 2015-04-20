<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:if test="${pageHolder.getTotalPages() > 0}">
	<c:set var="firstPage" value="1" />
	<c:set var="lastPage" value="${pageHolder.getTotalPages()}" />
	<c:set var="currentPage" value="${pageHolder.currentPage}" />
	<c:set var="prevPage" value="${pageHolder.currentPage}" />
	<c:set var="nextPage" value="${pageHolder.currentPage}" />
	
	<c:if test="${pageHolder.currentPage - 1 > 0}">
		<c:set var="prevPage" value="${pageHolder.currentPage-1}" />
	</c:if>

	<c:if test="${pageHolder.currentPage + 1 <= lastPage}">
		<c:set var="nextPage" value="${pageHolder.currentPage+1}" />
	</c:if>
	
	<c:choose>		
		<c:when test="${pageInfo.url eq '/shop/store/listStoreBrand'}">
			<a href=#" onclick="javascript:getStoreBrandList('','${criteria.ctgrName}','${firstPage}')" class="btn"><img src="${imageServer}/images/shop/store/contents/common/paging_first.gif" width="25" height="25" alt="처음" /></a>
			<a href=#" onclick="javascript:getStoreBrandList('','${criteria.ctgrName}','${prevPage}')" class="btn"><img src="${imageServer}/images/shop/store/contents/common/paging_prev.gif" width="25" height="25" alt="이전" /></a>
			
		    <c:forEach items="${pageInfo.pages}" var="page" varStatus="status">
		        <c:if test="${pageInfo.currentPage != page}">
		            <a href=#" onclick="javascript:getStoreBrandList('','${criteria.ctgrName}','${page}')">${page}</a>
		        </c:if>
		        <c:if test="${pageInfo.currentPage == page}">
		        	<a href=#" onclick="javascript:getStoreBrandList('','${criteria.ctgrName}','${currentPage}')" style="border:0px"><strong>${currentPage}</strong></a>
		        </c:if>
		    </c:forEach>

			<a href=#" onclick="javascript:getStoreBrandList('','${criteria.ctgrName}','${nextPage}')" class="btn"><img src="${imageServer}/images/shop/store/contents/common/paging_next.gif" width="25" height="25" alt="다음" /></a>
			<a href=#" onclick="javascript:getStoreBrandList('','${criteria.ctgrName}','${lastPage}')" class="btn"><img src="${imageServer}/images/shop/store/contents/common/paging_last.gif" width="25" height="25" alt="마지막" /></a>		
		</c:when>
		<c:otherwise>
			<a href="${pageInfo.url}${pageInfo.separator}${pageInfo.pageParam}=${firstPage}${pageInfo.paramString}" class="btn"><img src="${imageServer}/images/shop/store/contents/common/paging_first.gif" width="25" height="25" alt="처음" /></a>
			<a href="${pageInfo.url}${pageInfo.separator}${pageInfo.pageParam}=${prevPage}${pageInfo.paramString}" class="btn"><img src="${imageServer}/images/shop/store/contents/common/paging_prev.gif" width="25" height="25" alt="이전" /></a>
			
		    <c:forEach items="${pageInfo.pages}" var="page" varStatus="status">
		        <c:if test="${pageInfo.currentPage != page}">
		            <a href="${pageInfo.url}${pageInfo.separator}${pageInfo.pageParam}=${page}${pageInfo.paramString}&hash=pageHash">${page}</a>
		        </c:if>
		        <c:if test="${pageInfo.currentPage == page}">
		            <a href="${pageInfo.url}${pageInfo.separator}${pageInfo.pageParam}=${currentPage}${pageInfo.paramString}" style="border:0px"><strong>${currentPage}</strong></a>
		        </c:if>
		    </c:forEach>
			
			<a href="${pageInfo.url}${pageInfo.separator}${pageInfo.pageParam}=${nextPage}${pageInfo.paramString}" class="btn"><img src="${imageServer}/images/shop/store/contents/common/paging_next.gif" width="25" height="25" alt="다음" /></a>
			<a href="${pageInfo.url}${pageInfo.separator}${pageInfo.pageParam}=${lastPage}${pageInfo.paramString}" class="btn"><img src="${imageServer}/images/shop/store/contents/common/paging_last.gif" width="25" height="25" alt="마지막" /></a>		
		</c:otherwise>
	</c:choose>
</c:if>
								







