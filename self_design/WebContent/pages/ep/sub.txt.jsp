<%@page contentType="text/plain" pageEncoding="UTF-8"%><%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@
taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@
taglib uri="http://www.ssgdfs.com/taglib/ui" prefix="ui" %><%@
taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" 
%><c:forEach items="${navers}" var="naver" varStatus="status"><<<begin>>>
<<<mapid>>>${naver.mapid}
<<<class>>>${naver.clazz}
<<<utime>>><fmt:formatDate value="${naver.utime}" pattern="yyyy-MM-dd HH:mm:ss"/>
<<<ftend>>>
</c:forEach>
