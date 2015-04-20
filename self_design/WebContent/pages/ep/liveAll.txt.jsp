<%@page contentType="text/plain" pageEncoding="UTF-8"%><%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@
taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@
taglib uri="http://www.ssgdfs.com/taglib/ui" prefix="ui" %><%@
taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" 
%><c:forEach items="${navers}" var="naver" varStatus="status"><<<begin>>>
<<<mapid>>>${naver.mapid}
<<<pname>>>${naver.pname}
<<<price>>>${naver.price}
<<<pgurl>>>${naver.pgurl}
<<<igurl>>>${naver.igurl}
<<<cate1>>>${naver.cate1}
<<<cate2>>>${naver.cate2}
<<<cate3>>>${naver.cate3}
<<<cate4>>>${naver.cate4}
<<<caid1>>>${naver.caid1}
<<<caid2>>>${naver.caid2}
<<<caid3>>>${naver.caid3}
<<<caid4>>>${naver.caid4}
<<<model>>>${naver.model}
<<<brand>>>${naver.brand}
<<<deliv>>>${naver.deliv}
<<<event>>>${naver.event}
<<<revct>>>${naver.revct}
<<<ftend>>>
</c:forEach>
