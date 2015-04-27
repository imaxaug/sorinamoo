<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.util.Enumeration" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.ssgdfs.com/taglib/ui" prefix="ui" %>
<%@taglib uri="http://www.ssgdfs.com/taglib/hfn" prefix="hfn"%>
<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>---------------------------</title>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE"/>
    <link rel="image_src" href="https://www.marketpress.co.kr/img/fb.png" />
    <link rel="stylesheet" href="/css/all.css"/>

    <script type="text/javascript" src="/js/jquery/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="/js/jquery/jquery-ui-1.9.2.custom.min.js"></script>
    <script type="text/javascript" src="/js/jquery/jquery.iframe-transport.js"></script>
    <script type="text/javascript" src="/js/jquery/jquery.fileupload.js"></script>
    <script type="text/javascript" src="/js/jquery/jquery-tmpl/jquery.tmpl.js"></script>

    <script type="text/javascript" src="/js/jquery/jquery.transit.min.js"></script>
    <script type="text/javascript" src="/js/jquery/jquery.mousewheel.min.js"></script>
    <script type="text/javascript" src="/js/lib.js"></script>
    <script type="text/javascript" src="/js/validation.js"></script>
    <script type="text/javascript" src="/js/jquery/jquery.form.js"></script>

    <script type="text/javascript" src="/js/pkgd/imagesloaded.pkgd.min.js"></script>
    <script type="text/javascript" src="/js/pkgd/masonry.pkgd.min.js"></script>

    <script type="text/javascript" src="/js/make/jquery.transit.min.js"></script>
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
    <script src="/js/infinity/infinity.js"></script>

    <script type="text/javascript" src="/script/shop.js"></script>
    <script type="text/javascript" src="/script/common.js"></script>

    <script>
    var islogin = '${isLogin}';
    //alert(islogin);

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

            <c:if test="${isLogin}">
            <li><a>전국구님</a></li>
            <li><a href="/mypage/info">마이페이지</a></li>
            <li><a href="/shop/logout">로그아웃</a></li>
            </c:if>

            <c:if test="${not isLogin}">
            <li><a href="/shop/login">로그인</a></li>
            </c:if>

            <li><a href="/make_product?base_product=21">상품 만등기</a></li>
            <li><a href="/cart">장바구니</a></li>
            <li><a href="/my_page/order">주문/배송조회</a></li>
            <li class="/designer"><a href="/seller">디자이너 스토어</a></li>
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
<%-- 전체상품 --%>
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

        <div class="tab2 pdtList mp-designs-container">
            <!-- <div class="designerBox" style="display: none;">
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
            </div> -->
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
                    <span class="btnLoadImage">
	                    <span>이미지 불러오기</span>
	                    <input type="file" name="filename" id="image-file">
                    </span>
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
                  <div><span class="num">1000</span>원</div>
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
            <%-- 시작 --%>
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
                        <div class="mp-editor-price middle" data-price="0">
                        </div>
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
        <div class="description" style="padding: 0 0 15px; width: 400px;">
            ${product.description}
        </div>
        <div class="size-table" style="position: relative; left: -14px;">
            <img src="${product.sizeFilePath}" alt=""/>
        </div>
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
    })
</script>
</div>

<div style="display: none;">
    <div id="mp-login-user-id">${loginUser.user.aliasId}</div>
</div>

<%-- jsp EL 과 jquery.tmpl ${} 혼용에 대하여 (http://windowx.tistory.com/515)
JSP 의 EL 을 사용하면 보통 '${}' keyword를 이용하여 context value를 레퍼런스 할 수 있다.
최근에 jQuery tmpl을 자주 사용하는데 같은 키워드 ${} 를 이용하게 되어서 문제가 되었습니다.
jQuery tmpl를 {{html }}으로 수정하면 해결할 수 있으나, 근본적인 해결책은 <%@ page isELIgnored="true" %>를 해주어야 한다.
--%>
<script id="tFace" type="text/x-jquery-tmpl">
<div class="face"
    data-file-type="{{html file_type}}"
    data-type="{{html type}}"
    data-sort="{{html sort}}">
    <div class="img" title="{{html name_ko}}"><img src="{{html filepath}}" alt="{{html name_ko}}" title="{{html name_ko}}" /></div>
    <!-- span class="name">${name_ko}</span -->
</div>
</script>

<script id="tProduct" type="text/x-jquery-tmpl">
<div class="product" data-id="${productId}" data-basket-id="${id}">
    <div class="img"><a href="/make_product?product={{html productId}}"><img src="{{html filepath}}" /></a></div>
    <div class="name">{{html name_ko}}</div>
    <div class="info">
        <span class="size">{{html size}}</span> |
        <span class="quantity">{{html quantity}}</span>개
    </div>
    <div class="options">
        <div class="edit-quantity">
            <input type="text" class="quantity" name="quantity" value="${quantity}">
            <button type="button" data-basket-id="{{html id}}">
            수량 변경
            </button>
        </div>
    </div>
    <div class="remove"><img src="/img/icons/glyphicons_197_remove.png" title="삭제" /></div>
    <div class="option"><img src="/img/icons/glyphicons_136_cogwheel.png" title="편집" /></div>
</div>
</script>

<%--
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
--%>

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
------------- footer -------------
</div>
<!-- end #footer -->
</div>
</body>
</html>