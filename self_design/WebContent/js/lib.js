/*!
 * jQuery UI Touch Punch 0.2.3
 *
 * Copyright 2011–2014, Dave Furfero
 * Dual licensed under the MIT or GPL Version 2 licenses.
 *
 * Depends:
 *  jquery.ui.widget.js
 *  jquery.ui.mouse.js
 */
//!function(a){function f(a,b){if(!(a.originalEvent.touches.length>1)){a.preventDefault();var c=a.originalEvent.changedTouches[0],d=document.createEvent("MouseEvents");d.initMouseEvent(b,!0,!0,window,1,c.screenX,c.screenY,c.clientX,c.clientY,!1,!1,!1,!1,0,null),a.target.dispatchEvent(d)}}if(a.support.touch="ontouchend"in document,a.support.touch){var e,b=a.ui.mouse.prototype,c=b._mouseInit,d=b._mouseDestroy;b._touchStart=function(a){var b=this;!e&&b._mouseCapture(a.originalEvent.changedTouches[0])&&(e=!0,b._touchMoved=!1,f(a,"mouseover"),f(a,"mousemove"),f(a,"mousedown"))},b._touchMove=function(a){e&&(this._touchMoved=!0,f(a,"mousemove"))},b._touchEnd=function(a){e&&(f(a,"mouseup"),f(a,"mouseout"),this._touchMoved||f(a,"click"),e=!1)},b._mouseInit=function(){var b=this;b.element.bind({touchstart:a.proxy(b,"_touchStart"),touchmove:a.proxy(b,"_touchMove"),touchend:a.proxy(b,"_touchEnd")}),c.call(b)},b._mouseDestroy=function(){var b=this;b.element.unbind({touchstart:a.proxy(b,"_touchStart"),touchmove:a.proxy(b,"_touchMove"),touchend:a.proxy(b,"_touchEnd")}),d.call(b)}}}(jQuery);


$(document).ready(function () {
    var menu = new Menu();
    menu.init($('#menu'));
});

var matchPassword = function(articleId, query, wrongPw) {
    $.get('/confirm_articlePassWord', {
        articleId: articleId,
        query: query,
        password: $('#articlePassword').val()
    }, function (data) {
        if (!data.result) {
            wrongPw.show();
        } else {
            window.location = '/customer/qna/' + articleId + query;
        }
    })
}

var imageFileTypeChecker = function(obj, next) {
    var fileType = ['jpg', 'jpeg', 'gif', 'png']
    var filename = obj.val().split('.');

    if (fileType.indexOf(filename[filename.length-1]) == -1) {
        alert ('첨부할수 없는 파일 형식입니다.\n첨부가능 파일 :\njpg, gif, png');
        return;
    } else {
        next();
    }
}

var fileTypeChecker = function(obj) {
    var fileType = ['jpg', 'jpeg', 'gif', 'png', 'ai', 'eps', 'pdf', 'psd', 'doc', 'ppt', 'hwp', 'xlsx']
    var filename = obj.val().split('.');

    if (fileType.indexOf(filename[filename.length-1]) == -1) {
        alert ('첨부할수 없는 파일 형식입니다.\n첨부가능 파일 :\njpg, gif, png, ai, eps, pdf, psd, doc, ppt, hwp, xlsx');
        obj.val('');
    }
}

var Menu = function () {
    this.init = function (container) {
        if (!container) return;

        container = $(container);
        var list1 = container.find('> ul > li');
        var currentList = container.find('> ul > li.selected');

        container.find('.menuList').hide();
        currentList.find('.menuList').show();

        container.find('> ul').mouseleave(function () {
            currentList.find('.menuList').show();
        });

        list1.mouseenter(function () {
            list1.find('.menuList').hide();
            $(this).addClass('over');
            $(this).find('.menuList').show();
        }).mouseleave(function () {
            $(this).removeClass('over');
            list1.find('.menuList').hide();
        });
    }
};

var FaqList = function () {
    this.init = function (container) {
        if (!container) return;
        this.container = $(container);

        this.container.find('.answer').hide();
        this.container.find('.question').css('cursor', 'pointer').click(function () {
            if ($(this).parent().hasClass('opened')) {
                $(this).parent().removeClass('opened');
                $(this).parent().find('.answer').hide();
            } else {
                $(this).parent().addClass('opened');
                $(this).parent().find('.answer').show();
            }
        });
    }
};

var Layer = function () {
    this.init = function (container, button) {
        container.find('.close').click(function () {
            container.hide();
        });

        button.click(function () {
            container.show();
            return false;
        });
    }
};

var TabMenu = function () {
    this.init = function (container) {
        if (!container) return;

        container = $(container);
        var tabs = container.find('.tabs li');
        var containers = container.find('.tabContainer');
        var currentTab = container.find('.tabs li.on');

        containers.hide();

        for (var i = 0; i < tabs.length; i++) {
            tabs[i].content = containers[i];
        }

        tabs.css('cursor', 'pointer').click(function () {
            tabs.removeClass('on');
            containers.hide();
            $(this).addClass('on');
            $(this.content).show();
        });

        currentTab.click();
    }
};

var TabMenu2 = function () {
    this.init = function (headings, containers) {
        if (!headings || !containers) return;

        headings = $(headings);
        containers = $(containers);
        var currentTab = headings.parent().find('.on');

        containers.hide();

        for (var i = 0; i < headings.length; i++) {
            headings[i].content = containers[i];
        }

        headings.css('cursor', 'pointer').click(function () {
            currentTab.removeClass('on');
            containers.hide();
            currentTab = $(this);
            $(this).addClass('on');
            $(this.content).show();
        });

        currentTab.click();
    }
};

var TabMenu3 = function () {
    this.init = function (container) {
        if (!container) return;

        container = $(container);
        var tabs = container.find('.tabs th a');
        var containers = container.find('th');
        var currentTab = container.find('a.current');

        containers.hide();

        for (var i = 0; i < tabs.length; i++) {
            tabs[i].content = containers[i];
        }

        tabs.css('cursor', 'pointer').click(function () {
            tabs.removeClass('current');
            $(this).addClass('current');
        });

        currentTab.click();
    }
};

var WebPageControl = function () {
    this.init = function (container) {
        var self = this;
        container = $(container);
        var inputBox = container.find('input[type=text]');
        var ul = container.find('ul');
        var btnAdd = $('#permit_btn_add');

        btnAdd.click(function () {
            if (inputBox.val() != '') {
                var li = '<li>' + inputBox.val() +
                    '<button type="button" class="h25 white btn delete">' +
                    '삭제' +
                    '<span class="bg">' +
                    '<span class="left"></span><span class="right"></span>' +
                    '</span>' +
                    '</button>' +
                    '<input type="hidden" name="permit_portpolio_list" value="' + inputBox.val() + '"/></li>';
                ul.append(li);
                self.addDeleteEvent(ul.find('button'));
            } else {
                alert('주소를 입력해 주세요.');
            }
        });
        this.addDeleteEvent(ul.find('button'));
    };
    this.addDeleteEvent = function (button) {
        button.click(function () {
            $(this).parent().remove();
        });
    }
};

function InputTextOff(container) {
    if (!container) container = $('body');

    var textInputs = container.find('.textOff');
    for (var i = 0; i < textInputs.length; i++) {
        $(textInputs[i]).attr('defaultValue', $(textInputs[i]).val());
    }

    textInputs.focusin(function () {
        if ($(this).val() == $(this).attr('defaultValue') || $(this).val() == '') {
            $(this).removeClass('textOff');
            $(this).val('');
            $(this).attr('placeholder', '');
        }
    }).focusout(function () {
            if ($(this).val() == $(this).attr('defaultValue') || $(this).val() == '') {
                $(this).addClass('textOff');
                $(this).val($(this).attr('defaultValue'));
                $(this).attr('placeholder', $(this).attr('data-defaultStr'));
            }
        });
}

var ImageScroll = function () {
	var self = this;

	this.init = function (container) {
		this.$container = $(container);
		this.$target = this.$container.find('ul');
		this.$prevBtn = this.$container.find('.prev');
		this.$nextBtn = this.$container.find('.next');
		this.$pager = this.$container.find('.dots');
		this.animTiming = 5000;
		this.interval = setInterval(function(){self.next();},this.animTiming);
		this.count = 0;
		this.start = false;

        // 페이지 버튼 생성
		for(var i=0; i <= self.maxCount(); i++){
			this.$pager.append($('<button type="text" pageNum="' + i + '" class="page"></button>'));
		}
		this.$pager.find('button').eq(0).addClass('on');

        // 페이지 버튼 클릭 메소드
		this.$pager.find('.page').click(function() {
			var containerWidth = self.$container.width();
			var $pages = self.$target.find('> *');
			var startPoint = parseInt($($pages[self.currentIndex]).css('left'), 10) - (self.currentIndex * containerWidth);

			for (var i =0; i < $pages.length; i++) {
				$($pages[i]).css({left: startPoint + (i * containerWidth)}).show();
			}

			var from = self.currentIndex;
			var to = $(this).index();
			var dir = from - to < 0 ? '-=' : '+=';
			var left = Math.abs(from - to) * containerWidth;

			self.$target.animate({
				left: dir + left
			}, 500, function() {
				self.currentIndex = to;
				self.refreshPage();
				self.refreshPager();
			});
		});

        // 컨트롤 버튼 클릭 메소드
		this.$prevBtn.click(function () {
			self.prev();
		});
		this.$nextBtn.click(function () {
			self.next();
		});

        // 컨트롤 버튼 클릭 메소드
		var $pages = this.$target.find('> *');
		this.currentIndex = 0;
		this.$target.css({
			width: $pages.length *  this.$container.width(),
			left: 0
		});

		this.refreshPage();

		this.$container
			.mouseenter(function() {
				clearInterval(self.interval);
			})
			.mouseleave(function() {
				self.interval = setInterval(function(){self.next();},self.animTiming);
			});
	};

	this.maxCount = function() {
		return this.$target.find('li').length - 1;
	};

	this.prev = function() {
		if (this.start) return;
		this.start = true;

		var containerWidth = this.$container.width();
		this.$target.animate({left: "+=" + containerWidth}, 500, function() {
			self.start = false;
			self.currentIndex = self.getPrevIndex();
			self.refreshPage();
			self.refreshPager();
		});
	};

	this.next = function() {
		if (this.start) return;
		this.start = true;

		var containerWidth = this.$container.width();
		this.$target.animate({left: "-=" + containerWidth}, 500, function() {
			self.start = false;
			self.currentIndex = self.getNextIndex();
			self.refreshPage();
			self.refreshPager();
		});
	};

	this.refreshPage = function() {
		var containerWidth = this.$container.width();
		var $pages = this.$target.find('> *');

		var targetLeft = parseInt(this.$target.css('left'), 10);

		$($pages[this.currentIndex]).css({left: targetLeft * -1}).show();
		$($pages[this.getPrevIndex()]).css({left: (targetLeft * -1) - containerWidth}).show();
		$($pages[this.getNextIndex()]).css({left: (targetLeft * -1) + containerWidth}).show();

		for (var i = 0; i < $pages.length; i++) {
			if ($pages[this.currentIndex] == $pages[i] ||
				$pages[this.getPrevIndex()] == $pages[i] ||
				$pages[this.getNextIndex()] == $pages[i])
					continue;

			$($pages[i]).hide();
		}
	};

	this.getPrevIndex = function() {
		var $pages = this.$target.find('> *');
		if (this.currentIndex == 0) {
			return $pages.length - 1;
		}
		return this.currentIndex - 1;
	};

	this.getNextIndex = function() {
		var $pages = this.$target.find('> *');
		if (this.currentIndex == $pages.length - 1) {
			return 0;
		}
		return this.currentIndex + 1;
	};

	this.refreshPager = function() {
		this.$pager.find('.page.on').removeClass('on');
		$(this.$pager.find('.page')[this.currentIndex]).addClass('on');
	};
}

function menuFolding($container) {
    $container.find('div.title').click(function () {
        var parent = $(this).parent();
        if (parent.hasClass('open')) {
            parent.removeClass('open');
        } else {
//            $container.find('> li.open').removeClass('open');
            parent.toggleClass('open');
        }
    });

    $container.find('.current').parents('.depth1').addClass('open');
}

function qsToObject(qs) {
    var o = {};
    qs.replace(
        new RegExp("([^?=&]+)(=([^&]*))?", "g"),
        function ($0, $1, $2, $3) {
            o[$1] = $3;
        }
    );
    return o;
}

var alignImage = function (image, width, height) {
    var originalWidth = image.width();
    var originalHeight = image.height();

    if (originalWidth > originalHeight) {
        image.css({ height: height, minWidth: width });
        image.css({ marginLeft: -(( image.width() - width ) / 2) });
    } else if (originalWidth == originalHeight) {
        image.css({ width: width, height: height });
    } else if (originalWidth < originalHeight) {
        image.css({ width: width, minHeight: height });
        image.css({ marginTop: -(( image.height() - height ) / 2) });
    }

    image.show();
}

var commaNum = function (num) {
    var len, spot, str;

    num = num + "";
    spot = num.length % 3;
    len = num.length;
    str = num.substring(0, spot);

    while (spot < len) {
        if (str != "") str += ",";
        str += num.substring(spot, spot + 3);
        spot += 3;
    }
    return str;
}

function setPrice(data) {
    var wrapper = $('div#info');
    var price = wrapper.find('span[data-name="price"]')
        , total = wrapper.find('span#totalPrice')
        , point = wrapper.find('span#point')
        , quantity = wrapper.find('input#quantity');

    if (data[0].nodeName == 'SELECT') {
        $('#product_price_id').val(data.find(':selected').attr('data-id'));
        var newPrice = data.find(':selected').attr('data-price');
        price.text(commaNum(newPrice));
        total.text(commaNum(parseInt(newPrice.replace(/,/g, '')) * quantity.val()));
    } else if (data[0].nodeName == 'INPUT') {
        var newCount = data.val();
        total.text(commaNum(parseInt(price.text().replace(/,/g, '')) * newCount));
        point.text(commaNum(point.attr('data-value') * newCount));
    }
}

function setSize(obj) {
    var data = obj.attr('data-match');
    var target = $('td#sizes');

    target.find('select').hide();
    target.find('select[data-match="' + data + '"]').show();

    setPrice(target.find('select[data-match="' + data + '"]'));
}

function floor(num, ja) {
	ja = Math.pow(10, ja)
	return Math.floor(num * ja) / ja;
}
