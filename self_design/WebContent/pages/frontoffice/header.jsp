<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="header">
    <div class="section">
        <h1 id="logo"><a href="/">Self Design</a></h1>

        <ul id="headMenu">

            <c:if test="${isLogin}">
            <li><a>전국구님</a></li>
            <li><a href="/mypage/info">마이페이지</a></li>
            <li><a href="/shop/logout">로그아웃</a></li>
            </c:if>

            <c:if test="${not isLogin}">
            <li><a href="/shop/login">로그인</a></li>
            </c:if>

            <li><a href="/make_product?baseProduct=21">상품 만등기</a></li>
            <li><a href="/cart">장바구니</a></li>
            <li><a href="/my_page/order">주문/배송조회</a></li>
            <li class="/designer"><a href="/seller">디자이너 스토어</a></li>
            <li><a href="/customer/faq?type=FA001">고객센터</a></li>
            <li><a href="/customer/notice?type=QA002">단체문의</a></li>
        </ul>

        <ul id="notify">
            <li><a href="/gallery">똑같은 스타일 No! 나만의 티셔츠!</a></li>
        </ul>
    </div>
    <div class="headerBg">
        <div class="top"></div>
        <div class="bottom"></div>
    </div>
</div>