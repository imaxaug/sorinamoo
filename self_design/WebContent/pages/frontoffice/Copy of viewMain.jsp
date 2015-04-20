<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.ssgdfs.com/taglib/ui" prefix="ui" %>
<%@taglib uri="http://www.ssgdfs.com/taglib/hfn" prefix="hfn"%>
<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>셀프디자인 마켓프레스</title>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE"/>
    <!--
    <link rel="image_src" href="https://www.marketpress.co.kr/img/fb.png" />
     -->
    <link rel="stylesheet" href="/css/all.css"/>
    <script type="text/javascript" src="http://connect.facebook.net/en_US/all.js"></script>
    <script type="text/javascript" src="/js/jquery/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="/js/jquery/jquery-ui-1.9.2.custom.min.js"></script>
    <script type="text/javascript" src="/js/lib.js"></script>
    <script type="text/javascript" src="/js/validation.js"></script>
    <script type="text/javascript" src="http://malsup.github.com/jquery.form.js"></script>
    <script type="text/javascript" src="/js/jquery.iframe-transport.js"></script>
    <script type="text/javascript" src="/js/jquery.fileupload.js"></script>
    <script type="text/javascript" src="/js/jquery.tmpl.min.js"></script>
    <script type="text/javascript" src="/js/jquery.transit.min.js"></script>
    <script type="text/javascript" src="/js/jquery.mousewheel.min.js"></script>
    <script type="text/javascript" src="/js/make/jquery.transit.min.js"></script>
    <script type="text/javascript" src="/js/imagesloaded.pkgd.min.js"></script>
    <script type="text/javascript" src="/js/masonry.pkgd.min.js"></script>
    <script type="text/javascript" src="/js/make/underscore.js"></script>
    <script type="text/javascript" src="/js/make/keyboard.js"></script>
    <script type="text/javascript" src="/js/make/goods/goods-history.js"></script>
    <script type="text/javascript" src="/js/make/goods/goods-item.js"></script>
    <script type="text/javascript" src="/js/make/goods/goods-page.js"></script>
    <script type="text/javascript" src="/js/make/goods/goods-keyboard.js"></script>
    <script type="text/javascript" src="/js/make/make-product.js"></script>

    <script src="/js/a7/promise-3.2.0.js"></script>
    <script src="/js/a7/underscore.js"></script>
    <script src="/js/a7/handlebars-v1.3.0.js"></script>
    <script src="/js/a7/moment-with-langs.min.js"></script>
    <script src="/js/a7/moment-timezone.min.js"></script>
    <script src="/js/a7/backbone.js"></script>
    <script src="/js/a7/backbone-relation.js"></script>
    <script src="/js/a7/a7-backbone.js"></script>
    <script src="/js/infinity.js"></script>




    <script>
        $(function () {
            var commify = function (n) {
                var reg = /(^[+-]?\d+)(\d{3})/;   // 정규식
                n += '';                          // 숫자를 문자열로 변환

                while (reg.test(n))
                    n = n.replace(reg, '$1' + ',' + '$2');

                return n;
            };

            $('span.number').each(function () {
                $(this).text(commify($(this).text()));
            });

        });
    </script>
    <!--[if lte IE 9]>
    <style type="text/css">
        .goods-item > .rotate,
        .goods-rotate-handler {
            display: none !important;
        }
        #photoGallery #list ul li div.infobox {
            background: url('/img/share/whiteB.png');
        }
    </style>
    <![endif]-->
</head>
<body class="locale-ko " data-locale="ko" data-_locale="_ko">
<div class="mp-alert"></div>
<div id="marketpress">
<div id="header">
    <div class="section">
        <h1 id="logo"><a href="/">마켓프레스</a></h1>
        <ul id="headMenu">

            <li><a>전국구님</a></li>
            <li><a href="/logout">로그아웃</a></li>
            <li><a href="/my_page/info">마이페이지</a></li>

            <li class="designer"><a href="/seller">디자이너 스토어</a></li>

            <li><a href="/cart">장바구니</a></li>
            <li><a href="/my_page/order">주문/배송조회</a></li>
            <li><a href="/customer/faq?type=FA001">고객센터</a></li>
            <li><a href="/customer/notice?type=QA002">단체문의</a></li>
        </ul>
        <div id="menu">
            <ul>
                <li class="myPdtMake">
                    <a href="/make_product">내상품만들기</a>

                    <div class="menuList">
                        <div class="cont">
                            <div class="list">
                                <ul>
                                    <li class="big"><a href="/make_product">내상품만들기</a></li>
                                    <li class="big"><a href="/make">전체상품보기</a></li>
                                    <li class="big"><a href="/make/free_design/IT005">무료디자인</a></li>
                                </ul>
                            </div>
                            <div class="list" style="display: none;">
                                <ul>
                                    <li class="big"><a>DIY 상품만들기</a></li>

                                    <li>
                                        <a href="/make_product?base_product=1">Value 반팔 [20수]</a>
                                    </li>

                                    <li>
                                        <a href="/make_product?base_product=4">AAA 반팔 [1301]</a>
                                    </li>

                                    <li>
                                        <a href="/make_product?base_product=7">PK 폴로 반팔 [20수]</a>
                                    </li>

                                    <li>
                                        <a href="/make_product?base_product=3">나그랑 반팔 [20수]</a>
                                    </li>

                                    <li>
                                        <a href="/make_product?base_product=16">AAA 베이스볼</a>
                                    </li>

                                    <li>
                                        <a href="/make_product?base_product=22">Basic 맨투맨 [기모]</a>
                                    </li>

                                    <li>
                                        <a href="/make_product?base_product=23">Basic 후드 [기모]</a>
                                    </li>

                                    <li>
                                        <a href="/make_product?base_product=24">AAA 후드</a>
                                    </li>

                                    <li>
                                        <a href="/make_product?base_product=27">Basic 집업 [기모]</a>
                                    </li>

                                    <li>
                                        <a href="/make_product?base_product=29">AAA 탱크탑</a>
                                    </li>

                                    <li>
                                        <a href="/make_product?base_product=31">Value 아동 반팔 [ 20수]</a>
                                    </li>

                                    <li>
                                        <a href="/make_product?base_product=40">매쉬캡</a>
                                    </li>

                                    <li>
                                        <a href="/make_product?base_product=37">캔버스 토트가방</a>
                                    </li>

                                    <li>
                                        <a href="/make_product?base_product=38">머그컵</a>
                                    </li>

                                </ul>
                            </div>
                            <div class="list" style="display: none;">
                                <ul>
                                    <li class="big"><a>전체카달로그</a></li>

                                    <li><a href="/make/catalog/CAT001">반팔</a></li>

                                    <li><a href="/make/catalog/CAT006">긴팔 / 맨투맨</a></li>

                                    <li><a href="/make/catalog/CAT003">후드 / 집업후드</a></li>

                                    <li><a href="/make/catalog/CAT004">폴로 / PK 티셔츠</a></li>

                                    <li><a href="/make/catalog/CAT005">베이스볼/나그랑</a></li>

                                    <li><a href="/make/catalog/CAT002">남여공용</a></li>

                                    <li><a href="/make/catalog/CAT009">민소매</a></li>

                                    <li><a href="/make/catalog/CAT010">아동/키즈 티셔츠</a></li>

                                    <li><a href="/make/catalog/CAT008">스포츠의류</a></li>

                                    <li><a href="/make/catalog/CAT007">자수 제작 상품 ★</a></li>

                                    <li><a href="/make/catalog/CAT011">머그컵</a></li>

                                    <li><a href="/make/catalog/CAT012">캔버스백</a></li>

                                    <li><a href="/make/catalog/CAT013">모자</a></li>

                                    <li><a href="/make/catalog/CAT014">앞치마</a></li>

                                    <!--<li style="letter-spacing: -1px;"><a href="/catalog/list">맨투맨/후드/집업후드</a></li>-->
                                </ul>
                            </div>
                            <div class="list" style="display: none;">
                                <ul>
                                    <li class="big"><a>무료디자인</a></li>

                                    <li><a href="/make/free_design/IT005">이벤트 / 기념일</a></li>

                                    <li><a href="/make/free_design/IT002">커플/ I ♥ / 가족</a></li>

                                    <li><a href="/make/free_design/IT006">캐릭터</a></li>

                                    <li><a href="/make/free_design/IT007">해골</a></li>

                                    <li><a href="/make/free_design/IT010">패션 / 빈티지</a></li>

                                    <li><a href="/make/free_design/IT013">아트 / 일러스트</a></li>

                                    <li><a href="/make/free_design/IT018">타투 / 트라이벌</a></li>

                                    <li><a href="/make/free_design/IT008">나라 / 장소</a></li>

                                    <li><a href="/make/free_design/IT009">동물 / 식물</a></li>

                                    <li><a href="/make/free_design/IT004">군대 / 종교</a></li>

                                    <li><a href="/make/free_design/IT015">유머 / 패러디 / 시사</a></li>

                                    <li><a href="/make/free_design/IT016">음식</a></li>

                                    <li><a href="/make/free_design/IT017">음악 / 댄스 / 힙합</a></li>

                                    <li><a href="/make/free_design/IT020">앰블럼 / 로고</a></li>

                                    <li><a href="/make/free_design/IT003">게임 / 취미 / 스포츠</a></li>

                                    <li><a href="/make/free_design/IT021">자동차 / 탈것</a></li>

                                    <li><a href="/make/free_design/IT019">한글 디자인 / 캘리그라피</a></li>

                                    <li><a href="/make/free_design/IT001">텍스트 / 슬로건</a></li>

                                    <li><a href="/make/free_design/IT012">리본 / 배너 / 꾸미기</a></li>

                                    <li><a href="/make/free_design/IT011">액자</a></li>

                                    <li><a href="/make/free_design/IT014">말풍선 / 화살표</a></li>

                                    <li><a href="/make/free_design/IT022">패턴 / 무늬 / 문양</a></li>

                                    <li><a href="/make/free_design/IT023">스마일</a></li>

                                </ul>
                            </div>
                        </div>
                        <div class="menuStyle">
                            <div class="arrow"></div>
                        </div>
                    </div>
                </li>
                <li class="artshop" style="display: none;">
                    <a href="/artshop">아트샵</a>

                    <div class="menuList">
                        <div class="cont">
                            <div class="list">
                                <ul class="culture">

                                    <li><a href="/artshop/list?art=ART001">LIMITED</a></li>

                                    <li><a href="/artshop/list?art=ART002">BRAND</a></li>

                                    <li><a href="/artshop/list?art=ART003">ISSUE ♥</a></li>

                                    <li><a href="/artshop/list?art=ART004">SALE</a></li>


                                    <li><a href="/artshop/list?style=ST001">MEN 남자</a></li>

                                    <li><a href="/artshop/list?style=ST002">WOMEN 여자</a></li>

                                    <li><a href="/artshop/list?style=ST003">라이프</a></li>

                                </ul>
                            </div>
                            <div class="list">
                                <ul>
                                    <li class="big"><a href="/make/free_design">디자인카테고리</a></li>

                                    <li><a href="/artshop/list?design=IT005">이벤트 / 기념일</a></li>

                                    <li><a href="/artshop/list?design=IT002">커플/ I ♥ / 가족</a></li>

                                    <li><a href="/artshop/list?design=IT006">캐릭터</a></li>

                                    <li><a href="/artshop/list?design=IT007">해골</a></li>

                                    <li><a href="/artshop/list?design=IT010">패션 / 빈티지</a></li>

                                    <li><a href="/artshop/list?design=IT013">아트 / 일러스트</a></li>

                                    <li><a href="/artshop/list?design=IT018">타투 / 트라이벌</a></li>

                                    <li><a href="/artshop/list?design=IT008">나라 / 장소</a></li>

                                    <li><a href="/artshop/list?design=IT009">동물 / 식물</a></li>

                                    <li><a href="/artshop/list?design=IT004">군대 / 종교</a></li>

                                    <li><a href="/artshop/list?design=IT015">유머 / 패러디 / 시사</a></li>

                                    <li><a href="/artshop/list?design=IT016">음식</a></li>

                                    <li><a href="/artshop/list?design=IT017">음악 / 댄스 / 힙합</a></li>

                                    <li><a href="/artshop/list?design=IT020">앰블럼 / 로고</a></li>

                                    <li><a href="/artshop/list?design=IT003">게임 / 취미 / 스포츠</a></li>

                                    <li><a href="/artshop/list?design=IT021">자동차 / 탈것</a></li>

                                    <li><a href="/artshop/list?design=IT019">한글 디자인 / 캘리그라피</a></li>

                                    <li><a href="/artshop/list?design=IT001">텍스트 / 슬로건</a></li>

                                    <li><a href="/artshop/list?design=IT012">리본 / 배너 / 꾸미기</a></li>

                                    <li><a href="/artshop/list?design=IT011">액자</a></li>

                                    <li><a href="/artshop/list?design=IT014">말풍선 / 화살표</a></li>

                                    <li><a href="/artshop/list?design=IT022">패턴 / 무늬 / 문양</a></li>

                                    <li><a href="/artshop/list?design=IT023">스마일</a></li>

                                </ul>
                            </div>
                        </div>
                        <div class="menuStyle">
                            <div class="arrow"></div>
                        </div>
                    </div>
                </li>
                <li class="photoGallery">
                    <a href="/gallery">포토갤러리</a>

                    <div class="menuList">
                        <div class="cont">
                            <div class="list">
                                <ul class="galleryList">

                                    <li><a href="/gallery?type=GAL006">포토후기</a></li>

                                    <li><a href="/gallery?type=GAL003">공연/행사티셔츠</a></li>

                                    <li><a href="/gallery?type=GAL005">프린팅방식</a></li>

                                </ul>
                            </div>
                        </div>
                        <div class="menuStyle">
                            <div class="arrow"></div>
                        </div>
                    </div>
                </li>
                <li class="theme">
                    <a href="/theme/team">만들기 TIP</a>
                </li>
                <li class="theme" style="display: none;">
                    <a href="/theme/worldcup">월드컵</a>
                </li>
                <li class="cam" style="display: none;">
                    <a href="/theme/campaign">캠페인</a>
                </li>
            </ul>
        </div>
        <ul id="notify">
            <li><a href="/gallery">똑같은 스타일 No! 나만의 티셔츠! 마켓프레스와 함께!</a></li>
        </ul>
    </div>
    <div class="headerBg">
        <div class="top"></div>
        <div class="bottom"></div>
    </div>
</div>
<div id="body">
    <!-- start 페이지 고유 컨텐츠 -->

<div id="cancel-click"></div>
<div id="designWindow">
    <div class="section">
        <!------  Layer ------->
<div id="selectMenuLayer" style="display: none;" class="menuLayer">
    <div class="layerForm" id="selectPdtLayer">
        <div class="tabs">
            <ul class="depth1">
                <li class="tab category"><a href="#" class="mp-category" data-group="" data-code="">전체 카달로그</a>
                    <ul class="depth2 category" data-group-name="전체 카달로그">
                        <li class="mp-category" data-group="" data-code="">전체</li>
                    </ul>
                </li>
                <li class="tab products"><a href="#" class="mp-category" data-group="" data-code="">주제별 카테고리</a>
                    <ul class="depth2 products" data-group-name="주제별 카테고리">
                        <li class="mp-category" data-group="" data-code="">전체</li>
                    </ul>
                </li>
                <!--<li class="tab colors"><a href="#">색상</a>-->
                    <!--<ul class="depth2 colors">-->
                        <!--<li class="color white current"></li>-->
                        <!--<li class="color red"></li>-->
                        <!--<li class="color purple"></li>-->
                        <!--<li class="color cyan"></li>-->
                        <!--<li class="color brown"></li>-->
                        <!--<li class="color yellow"></li>-->
                        <!--<li class="color green"></li>-->
                        <!--<li class="color blue"></li>-->
                        <!--<li class="color green"></li>-->
                    <!--</ul>-->
                <!--</li>-->
                <!--<li class="tab price"><a href="#">가격</a>-->
                    <!--<ul class="depth2 price">-->
                        <!--<li class="current">~ 10,000원</li>-->
                        <!--<li class="current">~ 20,000원</li>-->
                        <!--<li class="current">~ 30,000원</li>-->
                        <!--<li class="current">~ 40,000원</li>-->
                    <!--</ul>-->
                <!--</li>-->
            </ul>
        </div>
        <div id="tab1" class="content">
            <h2 class="mp-category-heading">전체</h2>
            <ul class="pdtList mp-products">
            </ul>
        </div>
        <div id="tab2" class="content" style="display: none;">
            <div class="pdtImage"><img src="../img/make/pdtImage_small.png" alt="상품이미지"/></div>
            <div class="info1">
                <h3 class="pdtName"></h3>
                <div class="description"></div>
            </div>
            <div class="info2">
                <p><strong>사이즈</strong><span class="sizes"></span></p>
                <p><strong>가격</strong><span class="price"></span></p>
            </div>
            <div class="info3">
                <img src="" alt="" class="infoImg" style="display: none;" />
                <!--<table>-->
                    <!--<colgroup>-->
                        <!--<col>-->
                        <!--<col>-->
                        <!--<col>-->
                        <!--<col>-->
                        <!--<col>-->
                    <!--</colgroup>-->
                    <!--<thead>-->
                    <!--<tr>-->
                        <!--<th></th>-->
                        <!--<th>가슴둘레</th>-->
                        <!--<th>소매</th>-->
                        <!--<th>총기장</th>-->
                        <!--<th>팔길이</th>-->
                    <!--</tr>-->
                    <!--</thead>-->
                    <!--<tbody>-->
                    <!--<tr>-->
                        <!--<td>S</td>-->
                        <!--<td>5</td>-->
                        <!--<td>5</td>-->
                        <!--<td>5</td>-->
                        <!--<td>5</td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                        <!--<td>M</td>-->
                        <!--<td>10</td>-->
                        <!--<td>10</td>-->
                        <!--<td>10</td>-->
                        <!--<td>10</td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                        <!--<td>L</td>-->
                        <!--<td>15</td>-->
                        <!--<td>15</td>-->
                        <!--<td>15</td>-->
                        <!--<td>15</td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                        <!--<td>XL</td>-->
                        <!--<td>20</td>-->
                        <!--<td>20</td>-->
                        <!--<td>20</td>-->
                        <!--<td>20</td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                        <!--<td>2XL</td>-->
                        <!--<td>25</td>-->
                        <!--<td>25</td>-->
                        <!--<td>25</td>-->
                        <!--<td>25</td>-->
                    <!--</tr>-->
                    <!--</tbody>-->
                <!--</table>-->
                <div class="colors">
                    <ul class="mp-product-detail-colors">
                        <li class="text">색상</li>
                        <!--<li class="color brown current"></li>-->
                    </ul>
                </div>
                <div class="button">
                    <button type="button" class="h40 grey cancel">뒤로가기
                        <span class="bg"><span class="left"></span><span class="right"></span></span>
                    </button>
                    <button type="button" class="h40 black done">상품만들기
                        <span class="bg"><span class="left"></span><span class="right"></span></span>
                    </button>
                </div>
            </div>
        </div>
        <button type="button" class="close"><img src="../img/make/close.png" alt="닫기"/></button>
    </div>
</div>
<!----  End Layer ----->

<!----  freeDesign Layer ----->
<div id="freeDesignWrapper" style="display: none" class="menuLayer">
    <div class="layerForm" id="freeDesignLayer">
        <div class="tabs">
            <ul class="depth1">
                <li class="tab category">
                    <div class="mp-category-title mp-category" data-group="" data-code="">무료 디자인</div>
                    <ul class="depth2 designCategory mp-categories">
                        <li class="mp-category" data-group="" data-code="">전체</li>
                    </ul>
                </li>
                <li class="tab premiumCategory">
                    <div class="mp-premium-category-title mp-category" data-group="" data-code="">디자이너 스토어</div>
                    <ul class="depth2 designCategory mp-premium-categories">
                        <li class="mp-category" data-group="" data-code="">전체</li>
                        <!--<li class="mp-category" data-group="price" data-code="1000">&#8361;1,000</li>-->
                        <!--<li class="mp-category" data-group="price" data-code="2000">&#8361;2,000</li>-->
                        <!--<li class="mp-category" data-group="price" data-code="3000">&#8361;3,000</li>-->
                    </ul>
                </li>
                <li class="tab sort">
                    <a href="#">등록순</a>
                    <ul class="depth2 sortList">
                        <li class="selected">추천순</li>
                        <li>판매순</li>
                        <li>등록순</li>
                    </ul>
                </li>
                <li class="search">
                    <input type="text" name="inputSearch" id="inputSearch"/>
                    <label for="inputSearch"><button type="button" class="zoomer"><img src="../img/make/zoomer.png" alt="찾기버튼"/></button></label>
                </li>
            </ul>
        </div>
        <!--<div class="tab1 pdtList mp-designs" style="display: none;">-->
            <!--<ul>-->
                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->
                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->
                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->
                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->

                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->
                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->
                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->
                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->

                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->
                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->
                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->
                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->

                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->
                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->
                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->
                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->

                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->
                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->
                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->
                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->

                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->
                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->
                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->
                <!--<li><a href="#"><img src="../img/make/lego.png" alt="상품이미지"/></a></li>-->
            <!--</ul>-->
        <!--</div>-->
        <div class="tab2 pdtList mp-designs-container">
            <div class="designerBox" style="display: none;">
                <div class="designerProfileImage">
                    <img src="../img/make/sampleProfileImage.png" alt="디자이너 프로필"/>
                </div>
                <div class="info1">
                    <h2 class="pdtName">오색찬란한 블라블라</h2>
                    <p class="designer">by <a href="">macaronic</a></p>
                </div>
                <div class="info1">
                    <p class="desc">100% Cotton / Origin : america<br/>제품설명설명텍스트텍스트</p>
                </div>
                <div class="buttons">
                    <button type="button" class="choice">선택</button>
                    <button type="button" class="cancel">취소</button>
                </div>
            </div>
            <h2 class="mp-category-heading">전체</h2>
            <ul class="mp-designs">
            </ul>
        </div>
        <button type="button" class="close"><img src="../img/make/close.png" alt="닫기"/></button>
    </div>
</div>
<!----  End freeDesign Layer ----->

<!----  loadImage Layer ----->
<div id="loadImageWrapper" style="display: none" class="menuLayer">
    <div id="loadImageBox" class="layerForm">
        <div class="tabs">
            <p class="layerName">내 디자인으로 상품만들기</p>
            <div class="tab">등록순</div>
        </div>
        <div class="pdtList content">
            <form action="/make_product/design" method="POST" enctype="multipart/form-data">
                <div class="buttons">
                    <span class="btnLoadImage"><span>이미지 불러오기</span><input type="file" name="filename" id="image-file"></span>
                    <!--<a href="#" class="btnFacebookImage"><span>사진첩</span></a>-->
                    <!--<a href="#" class="btnInstagram"><span>사진첩</span></a>-->
                </div>
                <input type="submit" value="업로드" style="display: none;">
            </form>
            <div class="help">
                <a href="">이미지 준비방법</a><img src="../img/make/blueQuestion.png" alt="도움말"/>
            </div>
            <div class="remove"><span></span></div>
            <div class="mp-designs-container">
                <ul class="mp-designs">
                </ul>
            </div>
        </div>
        <button type="button" class="close"><img src="../img/make/close.png" alt="닫기"/></button>
    </div>
</div>

<div id="designAreaWrap" style="display: none">
    <div id="designArea">
        <button type="button" id="btnMove"><img src="../img/make/move.png" alt="이동"/></button>
        <button type="button" id="btnRotate"><img src="../img/make/rotation.png" alt="회전"/></button>
        <button type="button" id="btnScale"><img src="../img/make/scale.png" alt="회전"/></button>
        <button type="button" id="btnTrash"><img src="../img/make/trash.png" alt="휴지통"/></button>
    </div>
</div>

<div id="imageAlign" style="display: none">
    <div class="position">
        가로 <input type="text" class="typeText" value="22cm"/> X 세로 <input type="text" class="typeText" value="22cm"/>
    </div>
    <div class="imgPosition">
        <span class="pos left selected"><img src="../img/make/frontLeft.png" alt="앞면좌측정렬"/><span class="text">왼쪽</span></span>
        <span class="pos center"><img src="../img/make/frontCenter.png" alt="앞면가운데정렬"/><span class="text">중앙</span></span>
        <span class="pos right"><img src="../img/make/backCenter.png" alt="뒷면가운데정렬"/><span class="text">뒷면</span></span>
    </div>
    <div class="bg">
        <span class="top"></span>
        <span class="bottom"></span>
    </div>
</div>
<!----  End loadImage Layer ----->

<!----  sizeTable Layer ----->
<div id="sizeTable" style="display: none">
    <button type="button" class="close">
        <img src="../img/make/whiteX.png" alt="닫기버튼"/>
    </button>
    <div class="triangle"></div>
    <div class="info1">
        <h3 class="pdtName">AAA 미국 직수입 반팔</h3>
        <p>상품관련 설명 디테일<br/>사용용도에 대한 설명 + 원단에 대한 설명등</p>
    </div>
    <table>
        <colgroup>
            <col style="width: 20%;">
            <col style="width: 20%;">
            <col style="width: 20%;">
            <col style="width: 20%;">
            <col style="width: 20%;">
        </colgroup>
        <thead>
        <tr>
            <th></th>
            <th>가슴둘레</th>
            <th>소매</th>
            <th>총기장</th>
            <th>팔길이</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>S</td>
            <td>5</td>
            <td>5</td>
            <td>5</td>
            <td>5</td>
        </tr>
        <tr>
            <td>M</td>
            <td>10</td>
            <td>10</td>
            <td>10</td>
            <td>10</td>
        </tr>
        <tr>
            <td>L</td>
            <td>15</td>
            <td>15</td>
            <td>15</td>
            <td>15</td>
        </tr>
        <tr>
            <td>XL</td>
            <td>20</td>
            <td>20</td>
            <td>20</td>
            <td>20</td>
        </tr>
        <tr>
            <td>2XL</td>
            <td>25</td>
            <td>25</td>
            <td>25</td>
            <td>25</td>
        </tr>
        </tbody>
    </table>
</div>
<!----  End sizeTable Layer ----->

<!----  addText Layer ----->
<div id="addTextWrapper" style="display: none" class="menuLayer">
    <div class="layerForm" id="addText">
        <button type="button" class="close"><img src="/img/make/close.png" alt="닫기"/></button>
        <div class="title">텍스트 추가하기</div>
        <div class="content">
            <textarea class="textbox mp-text-value"></textarea>
            <div class="mp-text-preview">
                <div class="placeholder">미리 보기</div>
                <img src="" alt=""/>
                <!--<div class="add">텍스트 적용</div>-->
            </div>


            <div class="mp-selected-font">
                <span class="text">색상 선택</span>
                <div class="img">
                    <img src="/img/fonts/ko/Bangul.png" />
                </div>
            </div>
            <div class="mp-font-selector">
                <ul>
                    <!-- ko -->
                    <li data-font-path="ko/Bangul.ttf" class="selected"><img src="/img/fonts/ko/Bangul.png" /></li>
                    <li data-font-path="ko/batang.ttc"><img src="/img/fonts/ko/batang.png" /></li>
                    <li data-font-path="ko/BM-HANNA.ttf"><img src="/img/fonts/ko/BM-HANNA.png" /></li>
                    <li data-font-path="ko/BusanFont_Provisional.ttf"><img src="/img/fonts/ko/BusanFont_Provisional.png" /></li>
                    <li data-font-path="ko/Dare.ttf"><img src="/img/fonts/ko/Dare.png" /></li>
                    <li data-font-path="ko/Eunjin.ttf"><img src="/img/fonts/ko/Eunjin.png" /></li>
                    <li data-font-path="ko/Eunpen.ttf"><img src="/img/fonts/ko/Eunpen.png" /></li>
                    <li data-font-path="ko/EunpenH.ttf"><img src="/img/fonts/ko/EunpenH.png" /></li>
                    <li data-font-path="ko/HamchoB.ttf"><img src="/img/fonts/ko/HamchoB.png" /></li>
                    <li data-font-path="ko/HangulB.ttf"><img src="/img/fonts/ko/HangulB.png" /></li>
                    <li data-font-path="ko/HangulL.ttf"><img src="/img/fonts/ko/HangulL.png" /></li>
                    <li data-font-path="ko/HangulPB.ttf"><img src="/img/fonts/ko/HangulPB.png" /></li>
                    <li data-font-path="ko/HangulTL.ttf"><img src="/img/fonts/ko/HangulTL.png" /></li>
                    <li data-font-path="ko/JejuGothic.ttf"><img src="/img/fonts/ko/JejuGothic.png" /></li>
                    <li data-font-path="ko/JejuHallasan.ttf"><img src="/img/fonts/ko/JejuHallasan.png" /></li>
                    <li data-font-path="ko/JejuMyeongjo.ttf"><img src="/img/fonts/ko/JejuMyeongjo.png" /></li>
                    <li data-font-path="ko/KoreanGS.TTF"><img src="/img/fonts/ko/KoreanGS.png" /></li>
                    <li data-font-path="ko/malgun-gothic-bold.ttf"><img src="/img/fonts/ko/malgun-gothic-bold.png" /></li>
                    <li data-font-path="ko/malgun.ttf"><img src="/img/fonts/ko/malgun.png" /></li>
                    <!--<li data-font-path="ko/mb.ttf"><img src="/img/fonts/ko/mb.png" /></li>-->
                    <!--<li data-font-path="ko/mh.ttf"><img src="/img/fonts/ko/mh.png" /></li>-->
                    <!--<li data-font-path="ko/mj.ttf"><img src="/img/fonts/ko/mj.png" /></li>-->
                    <!--<li data-font-path="ko/mm.ttf"><img src="/img/fonts/ko/mm.png" /></li>-->
                    <li data-font-path="ko/NanumGothicBold.ttf"><img src="/img/fonts/ko/NanumGothicBold.png" /></li>
                    <li data-font-path="ko/NanumPen.ttf"><img src="/img/fonts/ko/NanumPen.png" /></li>
                    <li data-font-path="ko/Oldkorean.ttf"><img src="/img/fonts/ko/Oldkorean.png" /></li>
                    <li data-font-path="ko/REXIR.ttf"><img src="/img/fonts/ko/REXIR.png" /></li>
                    <li data-font-path="ko/SeoulHangangB.ttf"><img src="/img/fonts/ko/SeoulHangangB.png" /></li>
                    <li data-font-path="ko/SeoulNamsanB.ttf"><img src="/img/fonts/ko/SeoulNamsanB.png" /></li>
                    <li data-font-path="ko/SungdongB.ttf"><img src="/img/fonts/ko/SungdongB.png" /></li>
                    <li data-font-path="ko/TreeB.TTF"><img src="/img/fonts/ko/TreeB.png" /></li>
                    <li data-font-path="ko/TreeL.TTF"><img src="/img/fonts/ko/TreeL.png" /></li>

                    <!-- etc -->
                    <li data-font-path="etc/ADDCN__.TTF"><img src="/img/fonts/etc/ADDCN__.png" /></li>
                    <li data-font-path="etc/AIRSTREA.TTF"><img src="/img/fonts/etc/AIRSTREA.png" /></li>
                    <li data-font-path="etc/All Star Resort.ttf"><img src="/img/fonts/etc/All Star Resort.png" /></li>
                    <li data-font-path="etc/Allstar4.ttf"><img src="/img/fonts/etc/Allstar4.png" /></li>
                    <li data-font-path="etc/AmaticSC-Bold.ttf"><img src="/img/fonts/etc/AmaticSC-Bold.png" /></li>
                    <li data-font-path="etc/Arial Black.ttf"><img src="/img/fonts/etc/Arial Black.png" /></li>
                    <li data-font-path="etc/arialbd.ttf"><img src="/img/fonts/etc/arialbd.png" /></li>
                    <li data-font-path="etc/Arista.ttf"><img src="/img/fonts/etc/Arista.png" /></li>
                    <li data-font-path="etc/ARLRDBD.TTF"><img src="/img/fonts/etc/ARLRDBD.png" /></li>
                    <li data-font-path="etc/Bangers.ttf"><img src="/img/fonts/etc/Bangers.png" /></li>
                    <li data-font-path="etc/Birds of Paradise.ttf"><img src="/img/fonts/etc/Birds of Paradise.png" /></li>
                    <li data-font-path="etc/BLKCHCRY.TTF"><img src="/img/fonts/etc/BLKCHCRY.png" /></li>
                    <li data-font-path="etc/BodoniXT.ttf"><img src="/img/fonts/etc/BodoniXT.png" /></li>
                    <li data-font-path="etc/BOMBARD_.ttf"><img src="/img/fonts/etc/BOMBARD_.png" /></li>
                    <li data-font-path="etc/BorisBlackBloxx.ttf"><img src="/img/fonts/etc/BorisBlackBloxx.png" /></li>
                    <li data-font-path="etc/BROAD___.ttf"><img src="/img/fonts/etc/BROAD___.png" /></li>
                    <li data-font-path="etc/CALVINN.TTF"><img src="/img/fonts/etc/CALVINN.png" /></li>
                    <li data-font-path="etc/cc1.TTF"><img src="/img/fonts/etc/cc1.png" /></li>
                    <li data-font-path="etc/CHEESEBU.TTF"><img src="/img/fonts/etc/CHEESEBU.png" /></li>
                    <li data-font-path="etc/CloisterBlack.ttf"><img src="/img/fonts/etc/CloisterBlack.png" /></li>
                    <li data-font-path="etc/collegeb.ttf"><img src="/img/fonts/etc/collegeb.png" /></li>
                    <li data-font-path="etc/Comfortaa-Bold.ttf"><img src="/img/fonts/etc/Comfortaa-Bold.png" /></li>
                    <li data-font-path="etc/coolvetica rg.ttf"><img src="/img/fonts/etc/coolvetica rg.png" /></li>
                    <li data-font-path="etc/CooperBlack.ttf"><img src="/img/fonts/etc/CooperBlack.png" /></li>
                    <li data-font-path="etc/densmore.ttf"><img src="/img/fonts/etc/densmore.png" /></li>
                    <li data-font-path="etc/DIEHLDA_.ttf"><img src="/img/fonts/etc/DIEHLDA_.png" /></li>
                    <li data-font-path="etc/Diploma.ttf"><img src="/img/fonts/etc/Diploma.png" /></li>
                    <li data-font-path="etc/DoubleFeature20.ttf"><img src="/img/fonts/etc/DoubleFeature20.png" /></li>
                    <li data-font-path="etc/Dynalight-Regular.ttf"><img src="/img/fonts/etc/Dynalight-Regular.png" /></li>
                    <li data-font-path="etc/EFON.TTF"><img src="/img/fonts/etc/EFON.png" /></li>
                    <li data-font-path="etc/ENFUTUBK.TTF"><img src="/img/fonts/etc/ENFUTUBK.png" /></li>
                    <li data-font-path="etc/Essays1743.ttf"><img src="/img/fonts/etc/Essays1743.png" /></li>
                    <li data-font-path="etc/FZXKFW.TTF"><img src="/img/fonts/etc/FZXKFW.png" /></li>
                    <li data-font-path="etc/Gabrielle.ttf"><img src="/img/fonts/etc/Gabrielle.png" /></li>
                    <li data-font-path="etc/gunplay rg.ttf"><img src="/img/fonts/etc/gunplay rg.png" /></li>
                    <li data-font-path="etc/handsean.ttf"><img src="/img/fonts/etc/handsean.png" /></li>
                    <li data-font-path="etc/impact.ttf"><img src="/img/fonts/etc/impact.png" /></li>
                    <li data-font-path="etc/IMPOS50.ttf"><img src="/img/fonts/etc/IMPOS50.png" /></li>
                    <li data-font-path="etc/Impregnable.ttf"><img src="/img/fonts/etc/Impregnable.png" /></li>
                    <li data-font-path="etc/Infinite.ttf"><img src="/img/fonts/etc/Infinite.png" /></li>
                    <li data-font-path="etc/JennaSue.ttf"><img src="/img/fonts/etc/JennaSue.png" /></li>
                    <li data-font-path="etc/Jersey M54.ttf"><img src="/img/fonts/etc/Jersey M54.png" /></li>
                    <li data-font-path="etc/Karate.ttf"><img src="/img/fonts/etc/Karate.png" /></li>
                    <li data-font-path="etc/KGIAndLoveAndYou.ttf"><img src="/img/fonts/etc/KGIAndLoveAndYou.png" /></li>
                    <li data-font-path="etc/KOMTIT__.ttf"><img src="/img/fonts/etc/KOMTIT__.png" /></li>
                    <li data-font-path="etc/KoolBean.ttf"><img src="/img/fonts/etc/KoolBean.png" /></li>
                    <li data-font-path="etc/LOKICOLA.TTF"><img src="/img/fonts/etc/LOKICOLA.png" /></li>
                    <li data-font-path="etc/MFDings.ttf"><img src="/img/fonts/etc/MFDings.png" /></li>
                    <li data-font-path="etc/NBA Bulls.ttf"><img src="/img/fonts/etc/NBA Bulls.png" /></li>
                    <li data-font-path="etc/New Athletic M54.ttf"><img src="/img/fonts/etc/New Athletic M54.png" /></li>
                    <li data-font-path="etc/OldLondon.ttf"><img src="/img/fonts/etc/OldLondon.png" /></li>
                    <li data-font-path="etc/Pacifico.ttf"><img src="/img/fonts/etc/Pacifico.png" /></li>
                    <li data-font-path="etc/Pop Warner.ttf"><img src="/img/fonts/etc/Pop Warner.png" /></li>
                    <li data-font-path="etc/PORNSA__.TTF"><img src="/img/fonts/etc/PORNSA__.png" /></li>
                    <li data-font-path="etc/SFCollegiate.ttf"><img src="/img/fonts/etc/SFCollegiate.png" /></li>
                    <li data-font-path="etc/STENCIL.TTF"><img src="/img/fonts/etc/STENCIL.png" /></li>
                    <li data-font-path="etc/Street-Bold.ttf"><img src="/img/fonts/etc/Street-Bold.png" /></li>
                    <li data-font-path="etc/terminator real nfi.ttf"><img src="/img/fonts/etc/terminator real nfi.png" /></li>
                    <li data-font-path="etc/Tondu_Beta.ttf"><img src="/img/fonts/etc/Tondu_Beta.png" /></li>
                    <li data-font-path="etc/Ultra.ttf"><img src="/img/fonts/etc/Ultra.png" /></li>
                    <li data-font-path="etc/Wanted M54.ttf"><img src="/img/fonts/etc/Wanted M54.png" /></li>
                    <li data-font-path="etc/WildRide.ttf"><img src="/img/fonts/etc/WildRide.png" /></li>

                </ul>
                <img src="/img/make/close.png" class="selector-close" alt="닫기">
            </div>

            <div class="align mp-text-align">
                <span class="text">텍스트 정렬방식</span>
                <span class="icon" data-align="right"><img src="../img/make/rightAlign.png" alt="오른쪽정렬"/></span>
                <span class="icon selected" data-align="center"><img src="../img/make/centerAlign.png" alt="가운데정렬"/></span>
                <span class="icon" data-align="left"><img src="../img/make/leftAlign.png" alt="왼쪽정렬"/></span>
            </div>
            <div class="colors">
                <span class="text">색상 선택</span>
                <!--<span class="selectColor">인디언핑크</span>-->
                <ul class="colors mp-text-colors">
                    <li class="color current" style="background-color: #000000" data-color-code="000000"><span></span></li>
                    <li class="color" style="background-color: #ffffff" data-color-code="ffffff"><span></span></li>
                    <li class="color" style="background-color: #f3ff00" data-color-code="f3ff00"><span></span></li>
                    <li class="color" style="background-color: #ffc000" data-color-code="ffc000"><span></span></li>
                    <li class="color" style="background-color: #66e301" data-color-code="66e301"><span></span></li>
                    <li class="color" style="background-color: #ff60b6" data-color-code="ff60b6"><span></span></li>
                    <li class="color" style="background-color: #3eaeff" data-color-code="3eaeff"><span></span></li>
                    <li class="color" style="background-color: #fe7b00" data-color-code="fe7b00"><span></span></li>
                    <li class="color" style="background-color: #d83200" data-color-code="d83200"><span></span></li>
                    <li class="color" style="background-color: #006400" data-color-code="006400"><span></span></li>
                    <li class="color" style="background-color: #3736ad" data-color-code="3736ad"><span></span></li>
                    <li class="color" style="background-color: #7a22a2" data-color-code="7a22a2"><span></span></li>
                    <li class="color" style="background-color: #ff90cc" data-color-code="ff90cc"><span></span></li>
                    <li class="color" style="background-color: #160a61" data-color-code="160a61"><span></span></li>
                    <li class="color" style="background-color: #6e2b05" data-color-code="6e2b05"><span></span></li>
                    <li class="color" style="background-color: #daa520" data-color-code="daa520"><span></span></li>
                    <li class="color" style="background-color: #c0c0c0" data-color-code="c0c0c0"><span></span></li>
                </ul>
            </div>
            <div class="button">
                <button type="button" class="h40 black add">
                    <strong class="value">텍스트 넣기</strong>
                    <span class="bg"><span class="left"></span><span class="right"></span></span>
                </button>
            </div>
        </div>
    </div>
</div>
<!----  End addText Layer ----->

<div id="cartLayerWrapper" style="display: none">
   <div class="layerForm" id="cartLayer" style="display: block">
      <div class="tableWrapper table1">
         <table id="productList" class="">
            <colgroup>
               <col/>
               <col style="width: 100px;"/>
               <col style="width: 120px;"/>
               <col style="width: 120px;"/>
               <col style="width: 120px;"/>
               <col style="width: 80px;"/>
            </colgroup>
            <thead>
            <tr>
               <th>상품명</th>
               <th>사이즈</th>
               <th>수량</th>
               <th>상품금액</th>
               <th>합계</th>
               <th>삭제</th>
            </tr>
            </thead>
            <tbody>
            <tr>
               <td class="pdtName">
                  <div class="pdtNameWrap">
                     <div class="pic">
                        <a href="#"><img src="" alt="앞면 이미지"/></a>
                     </div>
                     <div class="pic">
                        <a href="#"><img src="" alt="뒷면 이미지"/></a>
                     </div>
                     <div class="txt">
                        <div class="category"><a href="">AAA 미국 직수입 반팔</a></div>
                        <div class="title"><a href="">오색찬란 블라블라</a></div>
                     </div>
                  </div>
               </td>
               <td class="size"><span class="num">S</span></td>
               <td class="count">
                  <input type="text" class="spinner quantity" name="quantity">
                  <button type="button" class="h25 white btnModify">
                     변경
                     <span class="bg"><span class="left"></span><span class="right"></span></span>
                  </button>
               </td>
               <td class="price">
                  <!--<div class="pdtCost"><span class="num">1000</span>원</div>-->
                  <div><span class="num">1000</span>원</div>
                  <!--<div class="percent"><span class="num">[8%]</span></div>-->
                  <!--<div class="lastPrice">-->
                  <!--<span class="num">12,000</span>원-->
                  <!--<a href="#"><img src="../img/share/icon_question.gif" alt="?"/></a>-->
                  <!--</div>-->
               </td>
               <td class="total"><span class="num">2000</span>원</td>
               <td class="delete">
                  <button type="button"><img src="../img/btn/btn_delete.gif" class="btnDel" alt="X"/></button>
               </td>
            </tr>
            </tbody>
         </table>
      </div>


      <button type="button" class="close"><img src="../img/make/close.png" alt="닫기"/></button>
   </div>
</div>
<!----  End freeDesign Layer ----->

        <ul class="sideMenu">
            <li class="menu selectPdt"><a href="#selectMenuLayer">상품 선택</a></li>
            <li class="menu freeDesign"><a href="#freeDesignWrapper">디자인</a></li>
            <li class="menu loadImage"><a href="#loadImageWrapper">업로드</a></li>
            <li class="menu addText"><a href="#addTextWrapper">텍스트</a></li>
        </ul>


        <div id="mp-login-user" data-is-admin="false" style="display: none;"></div>

        <div id="pdtFaces" class="mp-editor-faces"></div>

        <div id="product" class="mp-editor">
            <div class="mp-editor-image">
                <img src="" class="mp-editor-image-background"/>
            </div>

            <div class="mp-side">
                <div class="header">
                    <h3 class="productName">
                        <span class="mp-editor-name"></span>
                        <span><a href="#"><img src="/img/make/info.png" alt="정보보기" class="mp-editor-info-btn"/></a></span>
                    </h3>
                </div>
                <div class="body">
                    <div id="options">
                        <span class="name">색상 - <span class="mp-color-name"></span></span>
                        <ul class="colors mp-editor-colors">
                        </ul>
                        <div class="option">
                            <span class="name">사이즈 <a href="#" class="size-info"><img src="../img/make/question.png" alt="도움말"/></a></span>
                            <select name="sizes" id="sizes" class="mp-editor-sizes">
                                <!--<option value="none">사이즈 선택</option>-->
                                <!--<option value="x_small">x_small</option>-->
                                <!--<option value="small">small</option>-->
                            </select>
                            <img src="" class="size-info-img" style="display: none;" alt=""/>
                        </div>
                        <div class="option">
                            <span class="name">수량</span>
                            <input type="text" class="quantity mp-editor-quantity spinner" name="quantity" id="quantity" value="0"/>
                        </div>
                    </div>
                </div>
                <div class="order">
                    <div class="name">가격</div>
                    <div class="price">
                        <!--<div class="v-align">-->
                        <div class="mp-editor-price middle" data-price="0">
                            <!--기본 6000원<br>앞면 7000원<br>뒷면 6000원<br>-->
                            <!--<strong>-->
                            <!--합계 17000원-->
                            <!--</strong>-->
                        </div>
                        <!--</div>-->
                    </div>
                    <button type="button" class="h50 black addCart">
                        <span class="text">장바구니 담기</span>
                        <span class="bg"><span class="left"></span><span class="right"></span></span>
                    </button>
                    <button type="button" class="h50 white cart">주문하기
                        <span class="bg"><span class="left"></span><span class="right"></span></span>
                    </button>
                    <div class="go-detail">
                        실측 사이즈 및 상세 정보 보기
                    </div>
                </div>
            </div>
        </div>

        <div class="mp-editor-tools">

            <div class="tool goods-no-blur" data-tool="remove-background" title="흰색 배경 지우기">
                <img class="goods-no-blur" src="/img/icons/glyphicons_317_tree_deciduous.png" alt="흰색 배경 지우기" title="흰색 배경 지우기"/>
            </div>
            <div class="tool goods-no-blur" data-tool="remove-white-color" title="흰색 모두 지우기">
                <img class="goods-no-blur" src="/img/icons/glyphicons_138_picture.png" alt="흰색 모두 지우기" title="흰색 모두 지우기"/>
            </div>
            <div class="tool goods-no-blur" data-tool="align-center" title="가로 중앙 정렬">
                <img class="goods-no-blur" src="/img/icons/align_center.png" alt="가로 중앙 정렬" title="가로 중앙 정렬"/>
            </div>
            <div class="tool goods-no-blur" data-tool="valign-middle" title="세로 중앙 정렬">
                <img class="goods-no-blur" src="/img/icons/valign_middle.png" alt="세로 중앙 정렬" title="세로 중앙 정렬"/>
            </div>
            <div class="tool goods-no-blur" data-tool="undo" title="undo">
                <img class="goods-no-blur" src="/img/icons/glyphicons_435_undo.png" alt="undo" title="undo"/>
            </div>
            <div class="tool goods-no-blur" data-tool="redo" title="redo">
                <img class="goods-no-blur" src="/img/icons/glyphicons_434_redo.png" alt="redo" title="redo"/>
            </div>
            <div class="tool goods-no-blur" data-tool="trash" title="지우기">
                <img class="goods-no-blur" src="/img/icons/glyphicons_trash.png" alt="지우기" title="지우기"/>
            </div>
            <div class="tool goods-no-blur" data-tool="select-all" title="전체선택">
                <img class="goods-no-blur" src="/img/icons/glyphicons_152_check.png" alt="전체선택" title="전체선택"/>
            </div>
        </div>

        <div class="mp-cart">
            <div class="icon">
                <img src="/img/icons/glyphicons_202_shopping_cart@2x.png" alt="장바구니" title="장바구니"/>
                <div class="count">5</div>
            </div>
            <div class="body">
                <div class="products-controller v-align">
                    <div class="products middle"></div>
                </div>
            </div>
        </div>

        <div class="share">
            <div class="social">
                <a href="#"><img src="/img/share/marketPress_facebook.png" alt="페이스북"/></a>
                <a href="#"><img src="/img/share/marketPress_twitter.png" alt="트위터"/></a>
                <a href="#"><img src="/img/share/marketPress_pinterest.png" alt="핀터레스트"/></a>
                <a href="#"><img src="/img/share/marketPress_mail.png" alt="메일"/></a>
                <a href="#"><img src="/img/share/marketPress_social_plus.png"/></a>
            <span class="count">
               123
            </span>
            </div>
            <div class="buttons">
                <button type="button" class="favoPdt">관심상품</button>
                <button type="button" class="guidePrint">인쇄방식<img src="/img/make/white_question.png" alt="도움말"/>
                </button>
                <button type="button" class="saleRate">단체 할인율</button>
            </div>
        </div>
    </div>
    <div class="whiteBar"></div>
    <div class="browser">
        Delete or Backspace 지우기<br>
        오른쪽 마우스 클릭&nbsp;&nbsp;앞으로/뒤로 보내기<br>
        <span class="more">단축키 더보기...<br></span>
        <div class="more">
            방향키 이동&nbsp;&nbsp;Shift+방향키 크게 이동<br />
            Ctrl+c 복사&nbsp;&nbsp;Ctrl+v 붙여넣기 <br/>
            Ctrl+z 실행취소&nbsp;&nbsp;Ctrl+Shift+z 재실행&nbsp;&nbsp;Ctrl+a 전체선택
        </div>
        <br>

            상품 만들기 툴은
            <a class="chrome" href="https://www.google.co.kr/chrome" target="_blank">
                <i>Ch</i><i>ro</i><i>m</i><i>e</i>
            </a>,
            <a class="safari" href="http://support.apple.com/kb/dl1531" target="_blank">Safari</a>,
            <a class="ie" href="http://windows.microsoft.com/ko-kr/internet-explorer/ie-10-worldwide-languages" target="_blank">IE10</a>
            최적화 되어 있으며<br>
            <i>Window</i>와
            <i>Mac</i> 에서 모두 결제 가능합니다.

    </div>
</div>

<div id="detail">
    <div class="section">
    <div class="size-info">
        <h3 class="productName">상세 정보</h3>
        <!--<h3 class="productName">특양면 맨투맨</h3>-->
        <div class="description" style="padding: 0 0 15px; width: 400px;">
            100% 국내제작상품. 100% 면. <br>기본스타일의 양면원단 크루넥 맨투맨입니다. <br>두툼한 원단과 늘어나지 않는 시보리밴드로 착용감이 좋은 단체티셔츠 상품입니다.<br>
        </div>
        <div class="size-table" style="position: relative; left: -14px;">
            <img src="https://www.marketpress.co.kr/up/base_product/21/CM_Size.jpg" alt=""/>
        </div>
    </div>

    <!--<h4 class="subtitle">디테일 및 상품후기</h4>-->
    <div class="gallery">
        <h4 class="subtitle">이 제품으로 다른 분들은 이렇게 만드셨어요!</h4>
        <div id="slider">
            <ul id="pdtImages">

                <li class="slide" style="background-image: url(https://www.marketpress.co.kr/up/gallery/4cea8e71c23c7546fae1ee04bdce6951_thumbnail.JPG);">
                    <!--<div class="imageWrapper" >-->
                        <!--<img src="https://www.marketpress.co.kr/up/gallery/4cea8e71c23c7546fae1ee04bdce6951_thumbnail.JPG" alt="상품이미지"/>-->
                    <!--</div>-->
                </li>

                <li class="slide" style="background-image: url(https://www.marketpress.co.kr/up/comment/7b0553749ba158feb1d41e89fe1bea55_thumbnail.jpg);">
                    <!--<div class="imageWrapper" >-->
                        <!--<img src="https://www.marketpress.co.kr/up/comment/7b0553749ba158feb1d41e89fe1bea55_thumbnail.jpg" alt="상품이미지"/>-->
                    <!--</div>-->
                </li>

                <li class="slide" style="background-image: url(https://www.marketpress.co.kr/up/comment/6534271e3ebad56ea7826d8300c20771_thumbnail.jpg);">
                    <!--<div class="imageWrapper" >-->
                        <!--<img src="https://www.marketpress.co.kr/up/comment/6534271e3ebad56ea7826d8300c20771_thumbnail.jpg" alt="상품이미지"/>-->
                    <!--</div>-->
                </li>

                <li class="slide" style="background-image: url(https://www.marketpress.co.kr/up/comment/c528e90e9c6de16676d0ad86881e9c60_thumbnail.jpg);">
                    <!--<div class="imageWrapper" >-->
                        <!--<img src="https://www.marketpress.co.kr/up/comment/c528e90e9c6de16676d0ad86881e9c60_thumbnail.jpg" alt="상품이미지"/>-->
                    <!--</div>-->
                </li>

                <li class="slide" style="background-image: url(https://www.marketpress.co.kr/up/comment/822046e39176331e72f02c98e5c31513_thumbnail.jpg);">
                    <!--<div class="imageWrapper" >-->
                        <!--<img src="https://www.marketpress.co.kr/up/comment/822046e39176331e72f02c98e5c31513_thumbnail.jpg" alt="상품이미지"/>-->
                    <!--</div>-->
                </li>

                <li class="slide" style="background-image: url(https://www.marketpress.co.kr/up/comment/3e9bfa700aeb83680902e1d5877d6f9a_thumbnail.jpg);">
                    <!--<div class="imageWrapper" >-->
                        <!--<img src="https://www.marketpress.co.kr/up/comment/3e9bfa700aeb83680902e1d5877d6f9a_thumbnail.jpg" alt="상품이미지"/>-->
                    <!--</div>-->
                </li>

                <li class="slide" style="background-image: url(https://www.marketpress.co.kr/up/gallery/c661a4104b7d1dab17d1ea3dfe3b4b2e_thumbnail.jpg);">
                    <!--<div class="imageWrapper" >-->
                        <!--<img src="https://www.marketpress.co.kr/up/gallery/c661a4104b7d1dab17d1ea3dfe3b4b2e_thumbnail.jpg" alt="상품이미지"/>-->
                    <!--</div>-->
                </li>

            </ul>
            <div class="controls">
                <button type="button" class="left" currentIndex="0" maxIndex="7"><img src="../img/make/arrowLeft.png" alt="왼쪽으로 슬라이드"/></button>
                <button type="button" class="right" currentIndex="0" maxIndex="7"><img src="../img/make/arrowRight.png" alt="오른쪽으로 슬라이드"/></button>
            </div>
        </div>

    </div>
    <!--<h4 class="subtitle">구매후기</h4>-->
    <div id="comments">
        <h4 class="subtitle">고객 후기</h4>
        <ul class="read comments">

<li class="img commentItem" data-id="1950">

    <div class="infos">
        <div class="designer">ZihotheZaho</div>
        <div class="date">2015-04-09</div>
        <div class="grade w82 grade5"></div>
    </div>
    <div class="review">
        <div class="userImg"><img src="../img/make/profileImage.png" alt=""/></div>
        <div class="body">

            <div class="photo"><img src="https://www.marketpress.co.kr/up/comment/b4f0e7ac5cb36f73bdbd8dec64954f2d_thumbnail.jpg" /></div>


            <div class="comment">
                <div class="valign">
                    프린트너무 잘해주셨어요!!!
<br>너무 맘에들어요 잘입을께요
                </div>
            </div>

        </div>
    </div>
</li>

<li class="img commentItem" data-id="1947">

    <div class="infos">
        <div class="designer">DIME</div>
        <div class="date">2015-04-08</div>
        <div class="grade w82 grade5"></div>
    </div>
    <div class="review">
        <div class="userImg"><img src="../img/make/profileImage.png" alt=""/></div>
        <div class="body">

            <div class="photo"><img src="https://www.marketpress.co.kr/up/comment/6843cad789cedc6c0385ab5505be51af_thumbnail.jpg" /></div>


            <div class="comment">
                <div class="valign">
                    오늘 제품 받았습니다!
<br>너무 맘에 드네요 ^^
<br>마켓프레스 초창기부터 애용자였는데, 프린팅방식 바뀐이후로 300프로 만족하고 있습니다! 최고입니다!
<br>
<br>제 레이블 MD상품제작에 지대한 도움이 되고 있습니다!
<br>감사합니다!
                </div>
            </div>

        </div>
    </div>
</li>


<li class="text commentItem" data-id="1946">
    <div class="infos">
        <div class="designer">DYNSTdesign</div>
        <div class="date">2015-04-07</div>
        <div class="grade w82 grade5"></div>
    </div>
    <div class="review">
        <div class="userImg"><img src="../img/make/profileImage.png" alt=""/></div>
        <div class="body">


            <div class="comment">
                <div class="valign">
                    선물드린건데 아주 만족입니다!
                </div>
            </div>

        </div>
    </div>
</li>

<li class="img commentItem" data-id="1940">

    <div class="infos">
        <div class="designer">다리</div>
        <div class="date">2015-04-01</div>
        <div class="grade w82 grade5"></div>
    </div>
    <div class="review">
        <div class="userImg"><img src="../img/make/profileImage.png" alt=""/></div>
        <div class="body">

            <div class="photo"><img src="https://www.marketpress.co.kr/up/comment/2c8e9da956809210312e239a146f6829_thumbnail.jpg" /></div>


            <div class="comment">
                <div class="valign">
                    굿입니다
                </div>
            </div>

        </div>
    </div>
</li>


<li class="text commentItem" data-id="1935">
    <div class="infos">
        <div class="designer">woowarm</div>
        <div class="date">2015-03-30</div>
        <div class="grade w82 grade5"></div>
    </div>
    <div class="review">
        <div class="userImg"><img src="../img/make/profileImage.png" alt=""/></div>
        <div class="body">


            <div class="comment">
                <div class="valign">
                    다 전체적으로 너무 이쁘고 잘 만들어져 왔네요
                </div>
            </div>

        </div>
    </div>
</li>


<li class="text commentItem" data-id="1933">
    <div class="infos">
        <div class="designer">jinachoi</div>
        <div class="date">2015-03-27</div>
        <div class="grade w82 grade5"></div>
    </div>
    <div class="review">
        <div class="userImg"><img src="../img/make/profileImage.png" alt=""/></div>
        <div class="body">


            <div class="comment">
                <div class="valign">
                    일러스트 파일로 해야 했는데 급하게 하다보니 ㅠㅠ 살짝 깨진감이 있지만 다들 너무 좋아하네요 감사합니다 ㅜㅜ퀄리티 대박이예용!!! 짱짱!!
                </div>
            </div>

        </div>
    </div>
</li>

<li class="img commentItem" data-id="1931">

    <div class="infos">
        <div class="designer">쿠로대원</div>
        <div class="date">2015-03-26</div>
        <div class="grade w82 grade5"></div>
    </div>
    <div class="review">
        <div class="userImg"><img src="../img/make/profileImage.png" alt=""/></div>
        <div class="body">

            <div class="photo"><img src="https://www.marketpress.co.kr/up/comment/592dc7fdaae07344eb4c6489687cf883_thumbnail.jpg" /></div>


            <div class="comment">
                <div class="valign">
                    긴팔 티셔츠의 핏과 프린팅 모두 대만족 합니다^^
                </div>
            </div>

        </div>
    </div>
</li>

<li class="img commentItem" data-id="1930">

    <div class="infos">
        <div class="designer">슈나이더리</div>
        <div class="date">2015-03-25</div>
        <div class="grade w82 grade5"></div>
    </div>
    <div class="review">
        <div class="userImg"><img src="../img/make/profileImage.png" alt=""/></div>
        <div class="body">

            <div class="photo"><img src="https://www.marketpress.co.kr/up/comment/e56cc8c539e43f53e3ef378b54c420ff_thumbnail.jpg" /></div>


            <div class="comment">
                <div class="valign">
                    깔끔하게 잘 나왔네요~
<br>딸내미가 좋아서 미쳐 날뜁니다.
                </div>
            </div>

        </div>
    </div>
</li>

<li class="img commentItem" data-id="1929">

    <div class="infos">
        <div class="designer">겜티</div>
        <div class="date">2015-03-25</div>
        <div class="grade w82 grade0"></div>
    </div>
    <div class="review">
        <div class="userImg"><img src="../img/make/profileImage.png" alt=""/></div>
        <div class="body">

            <div class="photo"><img src="https://www.marketpress.co.kr/up/comment/5e95cec1e5d17bcd81d257a2cb8784c0_thumbnail.jpg" /></div>


            <div class="comment">
                <div class="valign">
                    저번에 너무 만족스럽게 나와서 다른디자인으로 또 주문했는데 이번엔 로고가 예시 이미지에 비해 너무 작게 나왔네요ㅠㅠ 너무 아래쪽으로 프린트되기도 했구요ㅠㅠ
                </div>
            </div>

        </div>
    </div>
</li>

<li class="img commentItem" data-id="1928">

    <div class="infos">
        <div class="designer">beyond</div>
        <div class="date">2015-03-24</div>
        <div class="grade w82 grade5"></div>
    </div>
    <div class="review">
        <div class="userImg"><img src="../img/make/profileImage.png" alt=""/></div>
        <div class="body">

            <div class="photo"><img src="https://www.marketpress.co.kr/up/comment/1b34411f00ca156cb0ce1f1fd10e21e2_thumbnail.jpg" /></div>


            <div class="comment">
                <div class="valign">
                    옷 자체의 품질도 생각보다 좋고 무엇보다 프린트 품질이 아주 좋아요. 제작에서 배송까지 3일밖에 안걸렸네요. 아주 만족스럽습니다. 샘플 진행이었고 이젠 희망자 받아서 여러벌 더 주문하려구요^^
                </div>
            </div>

        </div>
    </div>
</li>

<li class="img commentItem" data-id="1927">

    <div class="infos">
        <div class="designer">청춘한복아랑</div>
        <div class="date">2015-03-24</div>
        <div class="grade w82 grade5"></div>
    </div>
    <div class="review">
        <div class="userImg"><img src="../img/make/profileImage.png" alt=""/></div>
        <div class="body">

            <div class="photo"><img src="https://www.marketpress.co.kr/up/comment/de35fc17049c7aaa0bb8bd9f7c4c962f_thumbnail.jpg" /></div>


            <div class="comment">
                <div class="valign">
                     완전 맘에들어요!!! 반팔티도 맞추려고욥!!! #청춘한복 #아랑
                </div>
            </div>

        </div>
    </div>
</li>


<li class="text commentItem" data-id="1926">
    <div class="infos">
        <div class="designer">yijunhee</div>
        <div class="date">2015-03-24</div>
        <div class="grade w82 grade5"></div>
    </div>
    <div class="review">
        <div class="userImg"><img src="../img/make/profileImage.png" alt=""/></div>
        <div class="body">


            <div class="comment">
                <div class="valign">
                    구매 완료가 늦었네요 ㅋㅋ
<br>머그컵 예쁘게 잘 나오네요
<br>색깔 진하게 많이 들어가는 부분은
<br>약간 흰색이 섞이는듯
                </div>
            </div>

        </div>
    </div>
</li>

<li class="img commentItem" data-id="1925">

    <div class="infos">
        <div class="designer">홍투맨</div>
        <div class="date">2015-03-22</div>
        <div class="grade w82 grade4"></div>
    </div>
    <div class="review">
        <div class="userImg"><img src="../img/make/profileImage.png" alt=""/></div>
        <div class="body">

            <div class="photo"><img src="https://www.marketpress.co.kr/up/comment/205b36e68131cfae1ae73efd96f88b13_thumbnail.png" /></div>


            <div class="comment">
                <div class="valign">
                    생각보다 선명하게 프린팅이 나오진 않았지만
<br>맨투맨도 짱짱하고 괜찮네요.
<br>앞으로 자주 이용하게 될꺼같네요.
                </div>
            </div>

        </div>
    </div>
</li>

<li class="img commentItem" data-id="1924">

    <div class="infos">
        <div class="designer">아레카야자</div>
        <div class="date">2015-03-22</div>
        <div class="grade w82 grade5"></div>
    </div>
    <div class="review">
        <div class="userImg"><img src="../img/make/profileImage.png" alt=""/></div>
        <div class="body">

            <div class="photo"><img src="https://www.marketpress.co.kr/up/comment/9029730132a1b8285ddaf27b3387358a_thumbnail.jpg" /></div>


            <div class="comment">
                <div class="valign">
                    원하는대로 잘 나왔습니다. 친구들과 티셔츠를 잘 입어서 좋았습니다.
                </div>
            </div>

        </div>
    </div>
</li>


<li class="text commentItem" data-id="1922">
    <div class="infos">
        <div class="designer">ineeee</div>
        <div class="date">2015-03-21</div>
        <div class="grade w82 grade0"></div>
    </div>
    <div class="review">
        <div class="userImg"><img src="../img/make/profileImage.png" alt=""/></div>
        <div class="body">


            <div class="comment">
                <div class="valign">
                    처음엔 디자인이 잘못 나오더니
<br>인쇄 깔끔하게 신경써 달라니까
<br>다 번져서 나옴
<br>처음부터 번져서 만들어 졌음 이해를 하는데
<br>예전에 만들었던 컵은 인쇄 안번지고 깨끗이 잘 나왔었는데 이번 컵은 색상도 고르지 못하고..
                </div>
            </div>

        </div>
    </div>
</li>


<li class="text commentItem" data-id="1921">
    <div class="infos">
        <div class="designer">슈나이더리</div>
        <div class="date">2015-03-20</div>
        <div class="grade w82 grade5"></div>
    </div>
    <div class="review">
        <div class="userImg"><img src="../img/make/profileImage.png" alt=""/></div>
        <div class="body">


            <div class="comment">
                <div class="valign">
                     애기 옷과 제가 입을 옷들..
<br>역시, 말끔히 잘 나왔네요.
<br>애용은 계속됩니다, 쭉~
                </div>
            </div>

        </div>
    </div>
</li>

<li class="img commentItem" data-id="1920">

    <div class="infos">
        <div class="designer">우진댄서</div>
        <div class="date">2015-03-20</div>
        <div class="grade w82 grade5"></div>
    </div>
    <div class="review">
        <div class="userImg"><img src="../img/make/profileImage.png" alt=""/></div>
        <div class="body">

            <div class="photo"><img src="https://www.marketpress.co.kr/up/comment/a3094f92beacd24433102c0809d8acab_thumbnail.jpg" /></div>


            <div class="comment">
                <div class="valign">
                    굿~
                </div>
            </div>

        </div>
    </div>
</li>

<li class="img commentItem" data-id="1919">

    <div class="infos">
        <div class="designer">쿠로대원</div>
        <div class="date">2015-03-19</div>
        <div class="grade w82 grade5"></div>
    </div>
    <div class="review">
        <div class="userImg"><img src="../img/make/profileImage.png" alt=""/></div>
        <div class="body">

            <div class="photo"><img src="https://www.marketpress.co.kr/up/comment/2b397eba9b4ab319434465e2923ba629_thumbnail.jpg" /></div>


            <div class="comment">
                <div class="valign">
                     언제나 멋진 프린팅 감사합니다^^
                </div>
            </div>

        </div>
    </div>
</li>

<li class="img commentItem" data-id="1917">

    <div class="infos">
        <div class="designer">yijunhee</div>
        <div class="date">2015-03-19</div>
        <div class="grade w82 grade4"></div>
    </div>
    <div class="review">
        <div class="userImg"><img src="../img/make/profileImage.png" alt=""/></div>
        <div class="body">

            <div class="photo"><img src="https://www.marketpress.co.kr/up/comment/701f9fb4b82a05a773606235358cbdf5_thumbnail.jpg" /></div>


            <div class="comment">
                <div class="valign">
                    일반적인 출력보다 적색이 많이 어둡게 나오네요
<br>다음부턴 조심해야겠어요
<br>제품 품질은 만족합니다~
                </div>
            </div>

        </div>
    </div>
</li>


<li class="text commentItem" data-id="1916">
    <div class="infos">
        <div class="designer">애니웨어</div>
        <div class="date">2015-03-17</div>
        <div class="grade w82 grade5"></div>
    </div>
    <div class="review">
        <div class="userImg"><img src="../img/make/profileImage.png" alt=""/></div>
        <div class="body">


            <div class="comment">
                <div class="valign">
                     굿 ㅎ
                </div>
            </div>

        </div>
    </div>
</li>


        </ul>
    </div>
    <div class="more">
        <button type="button">
            <span class="text">
                더보기 (<span class="currentCount">20</span>/<span class="totalCount">516</span>)
            </span>
            <span class="loading">
                불러오는 중...
            </span>
        </button>
    </div>
    <div id="guides">
        <a href="/guides/order" target="_blank" class="guide delivery">주문/배송안내</a>
        <a href="/guides/kind" target="_blank" class="guide print">인쇄방식</a>
        <a href="/guides/print" target="_blank" class="guide dry">세탁방식</a>
        <a href="/guides/change" target="_blank" class="guide change">교환/반품/환불안내</a>
        <a href="/guides/quality" target="_blank" class="guide quality">품질보증 및 청약철회기준</a>
    </div>
</div>

<script>
    var $comments;
    function layout() {
        setTimeout(function() {
            if ($comments.data('masonry')) {
            } else {
                $comments.masonry({
                    columnWidth: 11,
                    itemSelector: '.commentItem'
                });
            }
            setTimeout(function() {
                $comments.animate({
                    opacity: 1
                }, 500);
            }, 500);
        }, 500);
    }

    $(function () {
        $('.controls button.left').click(function() {
            var $images = $('#slider .slide');
            var $currentImage = $('#slider .slide.show');
            var $nextImage;
            $nextImage = $currentImage.prev();
            if ($nextImage.length == 0)
                $nextImage = $('#slider .slide:last');
            $nextImage.addClass('show');
            $currentImage.removeClass('show');
        });
        $('.controls button.right').click(function() {
            var $images = $('#slider .slide');
            var $currentImage = $('#slider .slide.show');
            var $nextImage;
            if ($currentImage.length == 0) {
                $nextImage = $('#slider .slide:last');
            } else {
                $nextImage = $currentImage.next();
                if ($nextImage.length == 0)
                    $nextImage = $('#slider .slide:first');
            }
            $nextImage.addClass('show');
            $currentImage.removeClass('show');
        }).click();

        $comments = $('#comments .comments');
        $comments.css({opacity: 0});
        imagesLoaded($comments, function() {
            layout();
        });
//        setTimeout(function() {
//            layout();
//        }, 1500);

        // ajax 페이징
        $('.more button').on('click', function (e) {
            e.preventDefault();
            var $self = $(this);
            var currentCount = parseInt($self.find('.currentCount').text());
            var totalCount = parseInt($self.find('.totalCount').text());

            if (currentCount >= totalCount) return;

            $self.addClass('loading');

            $.get('/make/get_comments', {
                offset: currentCount,
                base_product: $(this).attr('data-id')
            }, function (data) {
                if (data.result == false) {
                    alert(data.message);
                    return;
                }
                var items = $('<ul></ul>').html(data).find('li').css({opacity: 0}).get();
                if ($comments.find('li').length > 60) {
                    $comments.html('');
                    $comments.masonry();
                }
                $comments.append(items);
                imagesLoaded($comments, function() {
                    $comments.masonry('appended', items);
                    $self.removeClass('loading');
                });
//                setTimeout(function() {
//                    $comments.masonry('appended', items);
//                    $self.removeClass('loading');
//                }, 1000);
                $self.parent().find('.current').removeClass('current');
                $self.addClass('current');
                $self.find('.currentCount').text(currentCount + items.length);
            });
        });
    })
</script>
</div>

<div style="display: none;">
    <div id="mp-login-user-id">29563</div>
</div>

<script id="tFace" type="text/x-jquery-tmpl">
<div class="face"
    data-file-type="${file_type}"
    data-type="${type}"
    data-sort="${sort}">
    <div class="img" title="${name_ko}"><img src="${filepath}" alt="${name_ko}" title="${name_ko}" /></div>
    <!-- span class="name">${name_ko}</span -->
</div>
</script>

<script id="tProduct" type="text/x-jquery-tmpl">
<div class="product" data-id="${productId}" data-basket-id="${id}">
    <div class="img"><a href="/make_product?product=${productId}"><img src="${filepath}" /></a></div>
    <div class="name">${name_ko}</div>
    <div class="info">
        <span class="size">${size}</span> |
        <span class="quantity">${quantity}</span>개
    </div>
    <div class="options">
        <div class="edit-quantity">
            <input type="text" class="quantity" name="quantity" value="${quantity}">
            <button type="button" data-basket-id="${id}">
            수량 변경
            </button>
        </div>
    </div>
    <div class="remove"><img src="/img/icons/glyphicons_197_remove.png" title="삭제" /></div>
    <div class="option"><img src="/img/icons/glyphicons_136_cogwheel.png" title="편집" /></div>
</div>
</script>

<div class="mp-context-menu">
    <ul>
        <li class="forward">맨 앞으로 보내기</li>
        <li class="backward">맨 뒤로 보내기</li>
        <li class="delete">삭제 Delete</li>
        <li class="copy">복사 Ctrl+C</li>
    </ul>
</div>
</div>
<!-- end #body -->
<div id="footer">
    <div id="footerList">
        <div class="section">
            <div class="footListSection">
                <div class="title">About us</div>
                <ul>
                    <li><a href="http://www.marketpress.co/" target="_blank">회사소개</a></li>
                    <li><a href="/introduce">마켓프레스 소개</a></li>
                    <li><a href="/guides/alliance">제휴 및 제안</a></li>
                    <li class="btnSns">
                        <a href="https://www.facebook.com/marketpress" target="_blank"><img src="/img/btn/btn_facebook.png" alt="facebook"/></a>
                        <a href="https://twitter.com/marketpress" target="_blank"><img src="/img/btn/btn_twitter.png"alt="twitter"/></a>
                        <a href="http://www.marple.co.kr/" target="_blank"><img src="/img/btn/btn_blog.png" alt="blog"/></a>
                    </li>
                    <li><a href="/rules/service">이용약관</a></li>
                    <li><a href="/rules/privacy">개인정보 취급방침</a></li>
                </ul>
            </div>
            <div class="footListSection">
                <div class="title">도움센터</div>
                <ul>
                    <li><a href="/customer/qna?type=QA001">고객센터 게시판</a></gli>
                    <li><a href="/customer/qna?type=QA002">단체시안/견적</a></li>
                    <li class="tel">문의전화 1566-9437</li>
                    <li>fax 02-6499-3629</li>
                    <li class="helpEmail"><a href="mailto:help@marketpress.co.kr">help@marketpress.co.kr</a></li>
                    <li>카카오톡:marketpress</li>
                    <li><a href="/customer/faq">FAQ</a></li>
                </ul>
            </div>
            <div class="footListSection">
                <div class="title">오프라인 매장</div>
                <ul class="offlineShop">
                    <li>
                        <span class="shop">홍대 와우산점</span>
                        서울 마포구 서교동 363-1<br/>
                        <!--OPEN : 1PM - 9PM<br/>-->
                        070-4095-5090 [1pm-9pm]
                    </li>
                    <li>
                        <span class="shop">이태원점</span>
                        서울 용산구 이태원동 57-29<br/>
                        <!--OPEN : 12PM - 8PM<br/>-->
                        070-4641-1801 [12pm-8pm]
                    </li>
                </ul>
            </div>
            <div class="footListSection">
                <div class="title">상품 및 샘플안내</div>
                <ul>
                    <li><a href="/make">상품 카달로그</a></li>
                    <li><a href="/make">내상품 만들기</a></li>
                    <li><a href="/gallery?type=GAL006">제작후기</a></li>
                    <li><a href="/guides/kind">인쇄 종류 안내</a></li>
                    <li><a href="/guides/price">프린팅 서비스 가격</a></li>
                </ul>
            </div>
            <div class="footListSection designSell">
                <div class="title">디자이너 스토어</div>
                <ul>
                    <li><a href="/seller">디자이너 스토어</a></li>

                    <li><a href="/seller/image_guide">이미지 작업방법</a></li>

                    <!--<li><a href="#">인쇄서비스</a></li>-->
                    <li><a href="http://www.webhard.co.kr" target="_blank"><span class="head">웹하드</span></a></li>
                    <li>ID:marketpress</li>
                    <li>pw:marple</li>
                </ul>
            </div>
        </div>
    </div>
    <!-- end .footer_list -->
    <div id="footerInfo">
        <div class="section">
            <div class="footerInfo1">
                <span class="footLogo">(주)마켓프레스</span>
                <address>서울 구로구 디지털로 30길 28 마리오타워 605호</address>
                <span class="tel">고객센터 : 1566-9437 (평일 AM 10:00~PM 7:00 / 토,일요일 공휴일 휴무)</span>
                관리자:<a href="mailto:help@marketpress.co.kr">help@marketpress.co.kr</a>
            </div>
            <div class="footer_info2">
                대표이사:박혜윤 | 사업자등록번호:105-88-13322 | 통신판매업:서울구로제0211호
                CopyrightMarketPRESS.co.kr All rights reserved.
            </div>
            <img class="inicis"
                 src='https://image.inicis.com/mkt/certmark/inipay/inipay_43x43_gray.png'
                 border="0"
                 alt="클릭하시면 이니시스 결제시스템의 유효성을 확인하실 수 있습니다."
                 style="cursor:hand"
                 Onclick=javascript:window.open("https://mark.inicis.com/mark/popup_v1.php?no=50241&st=1392602453","mark","scrollbars=no,resizable=no,width=565,height=683");>
        </div>
    </div>
</div>
<!-- end #footer -->
</div>
</body>
</html>