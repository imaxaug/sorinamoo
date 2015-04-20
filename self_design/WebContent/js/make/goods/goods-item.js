function styleOption() {
	return _.clone({
		position: 'absolute',
		top: '0px',
		left: '0px',
		width: '100px',
		height: '100px',
//		border: '1px solid #999999',
		boxShadow: 'none',
//		selectedBorder: '1px solid #dddddd',
		selectedBoxShadow: '0px 0px 2px #999999',
		backgroundColor: 'transparent',
		zIndex: 2,
		opacity: 1,
		rotate: 0
	});
}

function checkOverflowAllItem() {
	if ($('.goods-item.warning').length > 0) return true;

	var $items = $('.goods-item');
	for (var i = 0; i < $items.length; i++) {
		if (checkOverflow($items.eq(i), true))
			return true;
	}

	return false;
}

function checkOverflow($item, noMessage) {
	if (!$item.parent().length) return;
	var rect = $item[0].getBoundingClientRect();
	var parentRect = $item.parents('.goods-page')[0].getBoundingClientRect();

	if (parentRect.top > rect.top ||
		parentRect.left > rect.left ||
		parentRect.right < rect.right ||
		parentRect.bottom < rect.bottom)
	{
		if (!$item.is('.warning'))
			$item.addClass('warning');

		if (!noMessage) showAlert('인쇄 영역을 넘어갔습니다.');
		return true;
	}
	$item.removeClass('warning');
	return false;
}


$.widget("goods.item", {

	options: {
		type: 'base',
		editable: false,
//		selected: false,

		beforeSelect: null,
		change: null,
		eventCanceled: false
	},

	_create: function() {
		this.element[this.options.type + 'Item'](this.options);
	},

	option: function() {
		if (arguments.length == 1) {
			return this.element[this.options.type + 'Item']('option', arguments[0]);
		}
		return this.element[this.options.type + 'Item']('option', arguments[0], arguments[1]);
	},

	info: function() {
		return this.element[this.options.type + 'Item']('info');
	},

	remove: function() {
		return this.element[this.options.type + 'Item']('remove');
	},

	toggleResizable: function() {
		return this.element[this.options.type + 'Item']('toggleResizable');
	},

	refreshMaxWidth: function() {
		return this.element[this.options.type + 'Item']('refreshMaxWidth');
	}

});

$.widget("goods.msItem", {
	options: {
		isCreated: false,
		type: 'ms',
		style: {
			position: 'absolute',
			top: '0px',
			left: '0px',
			width: '100px',
			height: '100px',
//			backgroundColor: 'yellow',
			zIndex: 2
		},
		itemInfos: [],
		eventCanceled: false,

		change: null
	},

	_getCreateOptions: function() {
		return {
			draggableOption: {
//				grid: [20, 20],
//				containment: 'parent',
				start: $.proxy(function(event, ui) {
					this._trigger('dragstart', event, ui);
				}, this),
				drag: $.proxy(function(event, ui) {
					this._trigger('drag', event, ui);
					this.element.find('.goods-item').each(function() {
						checkOverflow($(this));
					});
				}, this),
				stop: $.proxy(function(event, ui) {
					this.option('style', ui.position);
					this._trigger('change');
				}, this)
			}
		}
	},

	_create: function() {
		this.element.addClass('goods-item');

		this.element.draggable(this.option('draggableOption'));

		this._refresh();
	},

	_refresh: function() {
		this.element
			.addClass(this.option('type'))
			.css(this.option('style'));

		this.element.find('.goods-item').remove();
		_.each(this.option('itemInfos'), this._addItemWithInfo, this);

		if (this.options.isCreated && !this.options.eventCanceled) {
			this._trigger('change');
		}
		this.options.eventCanceled = false;
	},

	_setOption: function(key, value) {
		if (key == 'style') {
			value = _.extend(this.option('style'), value);
			this.element.css(value);

			// for +=1, -=1
			this.options.style.top = this.element.css('top');
			this.options.style.left = this.element.css('left');

			this.element.find('.goods-item').each(function() {
				checkOverflow($(this));
			});
		}
		this._super(key, value);
	},

	info: function() {
		return {
			style: _.clone(this.option('style')),
			type: _.clone(this.option('type')),
			itemInfos: _.clone(this.option('itemInfos'))
		};
	},

	_resetItemInfos: function($items) {
		var $items = $items || this.element.find('.goods-item');
		var infos = [];
		$items.each(function() {
			infos.push($(this).item('info'));
		});
		this.option('itemInfos', infos);
		this.option('style', this.element.position());
		this.option('style', {
			width: this.element.outerWidth(),
			height: this.element.outerHeight()
		});

		// TODO 의존성 낮추기
		setTimeout(function() {
			$('.goods-rotate-handler').hide();
		}, 100);
	},

	_addItemWithInfo: function(info) {
		this._registerEvent(
			$('<div></div>')
				.item(info).appendTo(this.element)
		);
	},

	addItem: function($item) {
		this._originalPosition();
		this.element.append($item);
		this._registerEvent($item);
		this._resetRect();
		this._resetItemInfos();
	},

	addItems: function($items) {
		this.element.append($items);
		this._registerEvent($items);
		this._resetRect();
		this._resetItemInfos($items);
	},

	_resetRect: function() {
		var $items = this.element.find('.goods-item');
		this._resetPosition($items);
		this._resetSize($items);
	},

	_originalPosition: function($items) {
		var $items = $items || this.element.find('.goods-item');
		var parentPosition = this.element.position();
		$items.each(function() {
			$(this).item('option', {
				style: {
					top: '+=' + parseInt(parentPosition.top, 10),
					left:'+=' + parseInt(parentPosition.left, 10)
				},
				eventCanceled: true
			});
		});

		this.option('style', {
			top: 0, left: 0
		});
	},

	_resetPosition: function($items) {
		var $items = $items || this.element.find('.goods-item');
		this._originalPosition($items);

		var position = { top: 50000, left: 50000 };
		for (var i = 0; i < $items.length; i++) {
			var currentPosition = $items.eq(i).position();
			position.top = Math.min(position.top, currentPosition.top);
			position.left = Math.min(position.left, currentPosition.left);
		}
		this.option('style', position);
		$items.each(function() {
			$(this).item('option', {
				style: {
					top: '-=' + parseInt(position.top, 10),
					left:'-=' + parseInt(position.left, 10)
				},
				eventCanceled: true
			});
		});
	},

	_resetSize: function($items) {
		var $items = $items || this.element.find('.goods-item');
		var size = { width: 0, height: 0 };
		for (var i = 0; i < $items.length; i++) {
			var $item = $items.eq(i);
			var currentSize = {
				width: $item.position().left + $item.outerWidth(),
				height: $item.position().top + $item.outerHeight()
			};
			size.width = Math.max(size.width, currentSize.width);
			size.height = Math.max(size.height, currentSize.height);
		}
		this.option('style', size);
	},

	deselectAllItems: function() {
		var $items = this.element.find('.goods-item');
		this._originalPosition($items);

		this.element.parent()
			.append($items).end()
			.remove();

		this._trigger('change');
		return $items;
	},

	remove: function() {
		this._trigger('change');
		this.element.remove();
	},

	_registerEvent: function($items) {
		_.each($items, function(element) {
			$(element).item('option', {
				editable: true,
				draggableDisable: true,
				change: $.proxy(function() {
					this._resetSize();
					this._resetItemInfos();
					this._trigger('change');
				}, this),
				eventCanceled: true
			})
		}, this);
	}

});

$.widget("goods.baseItem", {
	options: {
		isCreated: false,
		type: 'base',
		style: styleOption(),
		editable: false,
		draggableDisable: false,
		selected: false,
		eventCanceled: false,
		maxWidth: null,

		beforeSelect: null,
		select: null,
		change: null,
		dragstart: null,
		drag: null,
		load: null
	},

	_getCreateOptions: function() {
		return {
			draggableOption: {
//				grid: [20, 20],
//				containment: 'parent',
				scroll: false,
				cancel: '.drag-cancel',
				start: $.proxy(function(event, ui) {
					this._trigger('dragstart', event, ui);
				}, this),
				drag: $.proxy(function(event, ui) {
					this._trigger('drag', event, ui);
					checkOverflow(this.element);
				}, this),
				stop: $.proxy(function(event, ui) {
					checkOverflow(this.element);
					var $parent = this.element.parent();
//					var position = {
//						top: Math.min(ui.position.top, $parent.height() - $(event.target).height()),
//						left: Math.min(ui.position.left, $parent.width() - $(event.target).width())
//					};
					var position = {
						top: ui.position.top,
						left: ui.position.left
					};
					this.option('style', position);
				}, this)
			},
			resizableOption: {
//				grid: [10, 10],
				aspectRatio: true,
//				containment: 'parent',
				handles: "se",
				start: $.proxy(function(event, ui) {
					this.element.data('rotate', this.element.css('rotate')).transition(
						{rotate: parseFloat(this.element.css('rotate')) > 180 ? 360 : 0}
						,$.proxy(function() {
							this.element.rotate('show');
						},this)
					);
				}, this),
				resize: $.proxy(function(event, ui) {
					checkOverflow(this.element);
				}, this),
				stop: $.proxy(function(event, ui) {
					if (this.option('maxWidth') && this.option('maxWidth') == ui.size.width &&
						parseInt(this.element.css('width')) >= parseInt(this.option('maxWidth'))) {
						showAlert('현재 이미지로 인쇄 가능한 최대 크기입니다.');
					}
					var $parent = this.element.parent();
//					var size = {
//						width: Math.min(ui.size.width, $parent.width() - ui.position.left),
//						height: Math.min(ui.size.height, $parent.height() - ui.position.top)
//					};
					var size = {
						width: this.element.width(),
						height: this.element.height()
					};
					this.element.css({rotate: this.element.data('rotate')});
					this.option('style', size);
				}, this)
			},
			rotateOption: {
				rotate: $.proxy(function() {
					this.option('style', { rotate: this.element.css('rotate') });
				}, this)
			}
		};
	},

	info: function() {
		return {
			style: _.clone(this.option('style')),
			type: _.clone(this.option('type')),
			selected: _.clone(this.option('selected'))
		};
	},

	_create: function() {
		this.element.addClass('goods-item');
		this.element
			.append('<div class="selected-border"></div>')
			.append('<div class="warning-icon"></div>')
			.append($('<div class="resizeHandler drag-cancel"></div>'));
		this.element.rotate(this.option('rotateOption'));

		this._on(this.element, {
			mousedown: '_selected'
		});

        this.element.bind('contextmenu', function(e) {
            e.preventDefault()
            $('.mp-context-menu').css({"top": (e.pageY-100) + "px", "left": e.pageX + "px"}).show();
        });

		this._refresh();
		this.options.isCreated = true;
	},

	_refresh: function() {
		this.element
			.addClass(this.option('type'))
			.css(this.option('style'));

		// for +=1, -=1
		this.options.style.top = this.element.css('top');
		this.options.style.left = this.element.css('left');

		if (this.element.attr('data-editable') && this.options.editable === 'destroy') {
			this.element
				.draggable('destroy')
				.resizable('destroy');
			this.element.attr('data-editable', '');
		} else if (this.options.editable === true) {
			var resizableOption = this.option('resizableOption');
			if (this.option('maxWidth')) {
				resizableOption.maxWidth = this.option('maxWidth');
			}
			this.element
				.resizable(resizableOption);

			this.element
				.draggable(this.option('draggableOption'));

			this.element.draggable('option', {
				disabled: this.option('draggableDisable'),
				opacity: this.option('style').opacity
			});

			this.element.attr('data-editable', true);
		}

		if (this.option('selected')) {
			this.element.addClass('selected');
//			this.element.css({ border: this.option('style').selectedBorder });
//			this.element.css({ boxShadow: this.option('style').selectedBoxShadow });
			this.element.rotate('show');
		} else {
			this.element.removeClass('selected');
//			this.element.css({ border: this.option('style').border });
//			this.element.css({ boxShadow: this.option('style').boxShadow });
			this.element.rotate('hide');
		}

		if (this.options.isCreated && !this.options.eventCanceled) {
			this._trigger('change');
		}
		this.options.eventCanceled = false;
	},

	_selected: function(e) {
		e.preventDefault();
		if (!this.option('editable') || this.options.selected) return;

		this._trigger('beforeSelect');
		this.option({
			selected: true,
			eventCanceled: true
		});
		this._trigger('select');
    },

	remove: function() {
		this._trigger('change');
		this.element.rotate('hide');
		this.element.remove();
	},

	_setOptions: function() {
		this._superApply(arguments);
		this._refresh();
	},

	_setOption: function(key, value) {
		if (key == 'style') {
			value = _.extend(this.option('style'), value);
			if (this.options.isCreated) checkOverflow(this.element);
		}
		this._super(key, value);
	}
});

$.widget("goods.rectItem", $.goods.baseItem, {

	options: {
		type: 'rect',
		style: _.extend(styleOption(), {
			backgroundColor: '#ccc'
		})
	}

});

$.widget("goods.imageItem", $.goods.baseItem, {

	options: {
		type: 'image',
		style: _.extend(styleOption(),  {
			width: '160px',
			height: 'auto',
//			border: '1px solid transparent',
			backgroundColor: 'transparent'
		}),
		src: ''
	},

	_create: function() {
		if (this.option('style').height !== 'auto') {
			this.element
				.css(this.option('style'))
				.append(
					$('<img>').css({
						width: '100%',
						height: '100%'
					})
				);
		} else {
			this.element.append(
				$('<img>').css({
					width: '100%'
				})
			);
		}

		this._super();
	},

	_refresh: function() {
		this._super();

		this.element.find('img')
			.attr('src', this.option('src'))
			.load($.proxy(this._imageLoad, this));
	},

	info: function() {
		return {
			style: _.clone(this.option('style')),
			type: _.clone(this.option('type')),
			selected: _.clone(this.option('selected')),
			src: _.clone(this.option('src'))
		};
	},

	_imageLoad: function(e) {
		if (this.option('style').height !== 'auto') return;

		var $img = $(e.target);
		var imgHeight = $img.height();
		this.options.style.height = imgHeight;
		this.element.css({height: imgHeight});
		$img.css({ height: '100%' });
	}

});


$.widget("goods.designItem", $.goods.baseItem, {

	options: {
		type: 'design',
		style: _.extend(styleOption(),  {
			width: '100px',
			height: 'auto',
//			border: '1px solid transparent',
			backgroundColor: 'transparent'
		}),
		src: '',
		id: '',
		price: 0,
		price_en: 0,
		price_ko: 0,
		fileType: '',
		text: '',
		font: '',
		color: '',
		mine: false,
		resizable: true,
		originalWidth: 0
	},

	_create: function() {
		if (this.option('style').height !== 'auto') {
			if (this.option('maxWidth')) {
				this.options.style.maxWidth = this.option('maxWidth');
				this.options.style.maxHeight = (parseInt(this.option('maxWidth')) / parseInt(this.options.style.width)) * parseInt(this.options.style.height);
				if (!this.option('resizable')) {
					this.options.style.width = this.option('maxWidth');
					this.options.style.height = this.options.style.maxHeight;
				}
			}
			this.element
				.css(this.option('style'))
				.append(
					$('<img>').css({
						width: '100%',
						height: '100%'
					})
				);
		} else {
			if (this.option('maxWidth')) {
				var style = this.option('style');
				this.options.style.maxWidth = this.option('maxWidth');
				if (this.option('maxWidth') < 100) {
					this.options.style.width = this.option('maxWidth');
				}
			}
			this.element.append(
				$('<img>').css({
					width: '100%'
				})
			);
		}

		this._super();

		this.element.css({visibility: 'hidden'});

		this.element.attr('data-resizable', this.option('resizable'));
		if (!this.option('resizable')) this.refreshMaxWidth();

		this.options.isCreated = false;
	},

	_refresh: function() {
		this._super();

		this.element
			.attr('data-file-type', this.option('fileType'))
			.attr('data-mine', this.option('mine'))
			.find('img')
			.load($.proxy(this._imageLoad, this))
			.attr('src', this.option('src').replace('.png', '_thumbnail.png'))
			.attr('data-id', this.option('id'));

	},

	info: function() {
		return {
			style: _.clone(this.option('style')),
			type: _.clone(this.option('type')),
			selected: _.clone(this.option('selected')),
			src: _.clone(this.option('src')),
			id: _.clone(this.option('id')),
			fileType: _.clone(this.option('fileType')),
			price: _.clone(this.option('price')),
			price_en: _.clone(this.option('price_en')),
			price_ko: _.clone(this.option('price_ko')),
			maxWidth: _.clone(this.option('maxWidth')),
			text: _.clone(this.option('text')),
			font: _.clone(this.option('font')),
			color: _.clone(this.option('color')),
			mine: _.clone(this.option('mine')),
			resizable: _.clone(this.option('resizable')),
			originalWidth: _.clone(this.option('originalWidth'))
		};
	},

	_imageLoad: function(e) {
		if (this.option('style').height !== 'auto') {
			this.element.css({visibility: 'inherit'});
			checkOverflow(this.element);
			return;
		}

		var parentWidth = this.element.parent().width() - 20;
		var parentHeight = this.element.parent().height() - 20;
		var $img = $(e.target);
		if ($img.width() < parentWidth && $img.height() < parentHeight) {
			this.element.css({visibility: 'inherit'});
		}

		setTimeout(_.bind(function() {
			var imgHeight = $img.height();
			this.options.style.height = imgHeight;
			this.element.css({height: imgHeight});

			if (this.option('maxWidth')) {
				var maxHeight = (parseFloat(this.option('maxWidth')) / parseFloat(this.options.style.width)) * parseFloat(imgHeight);
				this.options.style.maxHeight = maxHeight;
				this.element.css({maxHeight: maxHeight});
			}

			$img.css({ height: '100%' });

			//for ie 8
			parentWidth = this.element.parent().width() - 20;
			parentHeight = this.element.parent().height() - 20;
			if ($img.width() > parentWidth) {
				this.options.style.width = parentWidth;
				this.options.style.height = $img.height() * (parentWidth / $img.width());
				this.element.css({
					width: this.options.style.width,
					height: this.options.style.height
				});
			} else if ($img.height() > parentHeight) {
				this.options.style.width = $img.width() * (parentHeight / $img.height());
				this.options.style.height = parentHeight;
				this.element.css({
					width: this.options.style.width,
					height: this.options.style.height
				});
			}

			this.element.css({visibility: 'inherit'});

			checkOverflow(this.element);

			if (!this.options.isCreated) {
				goods.history.undo();
				this._trigger('change');
			}
			this.options.isCreated = true;
		}, this), 300);
	},

	toggleResizable: function() {
		this.option('resizable', !this.option('resizable'));
		if (!this.option('resizable')) {
			this.option({
				style: {
					width: this.options.style.maxWidth,
					height: this.options.style.maxHeight
				}
			});
			this.element.attr('data-resizable', false);
		} else {
			this.element.attr('data-resizable', true);
		}
	},

	refreshMaxWidth: function() {
		if (!this.option('maxWidth')) return;

		this.options.style.maxWidth = this.option('maxWidth');
		this.options.style.maxHeight = (parseFloat(this.option('maxWidth')) / parseFloat(this.options.style.width)) * parseFloat(this.options.style.height);

		if (this.option('resizable')) {
			if (parseFloat(this.options.style.width) > parseFloat(this.options.style.maxWidth)) {
				this.options.style.width = this.options.style.maxWidth;
				this.options.style.height = this.options.style.maxHeight;
				this.element.css({
					width: this.options.style.width,
					height: this.options.style.height
				});
			}
			return;
		}

		var r = parseFloat(this.options.style.width) - parseFloat(this.options.style.maxWidth);
		var left = this.options.style.left;
		if (r > 0) { // left++
			left = parseFloat(left) + (r / 2);
		} else if (r < 0) { // left--
			left = parseFloat(left) - (Math.abs(r) / 2);
		}

		this.option({
			style: {
				left: left,
				width: this.options.style.maxWidth,
				height: this.options.style.maxHeight
			}
		});
	}

});


$.widget("goods.rotate", {

	options: {
		c1: 0,
		c2: 0,
		p1: 0,
		p2: 0,
		currentRotate: 0,

		rotate: null
	},

	_create: function() {
		this.element.append($('<div class="rotate drag-cancel"></div>'));

		if ($('.goods-rotate-handler').length) return;
		$('<div class="goods-rotate-handler">').appendTo('body');
	},

	_ready: function() {
		$('.goods-rotate-handler')
			.css(this.element.find('> .rotate').offset())
			.draggable({
				start: $.proxy(this._handlerStart, this),
				drag: $.proxy(this._handlerDrag, this),
				stop: $.proxy(this._handlerStop, this)
			});
	},

	_handlerStart: function() {
		this.option('c1', this.element.offset().left + (this.element.outerWidth() / 2));
		this.option('c2', this.element.offset().top + (this.element.outerHeight() / 2));

		var $rotate = this.element.find('> .rotate');
		this.option('p1', $rotate.offset().left + ($rotate.outerWidth() / 2));
		this.option('p2', $rotate.offset().top + ($rotate.outerHeight() / 2));
	},

	_handlerDrag: function(e) {
		var c1 = this.option('c1');
		var c2 = this.option('c2');

		var p1 = this.option('p1');
		var p2 = this.option('p2');

		var $handler = $(e.target);
		var q1 = $handler.offset().left + ($handler.outerWidth() / 2);
		var q2 = $handler.offset().top + ($handler.outerHeight() / 2);

		var a1 = (p1 - c1);
		var a2 = (p2 - c2);
		var b1 = (q1 - c1);
		var b2 = (q2 - c2);

		var deg = Math.acos(
			(a1 * b1 + a2 * b2) / (Math.sqrt(Math.pow(a1, 2) + Math.pow(a2, 2)) * Math.sqrt(Math.pow(b1, 2) + Math.pow(b2, 2)))
		) * 180 / Math.PI;

		var deg = (this.option('currentRotate') + this._deg(deg, c1, c2, p1, p2, q1, q2)) % 360;
		if (e.shiftKey && deg % 10 > 0) {
			if (deg % 10 <= 5) {
				deg -= deg % 10;
			} else {
				deg += 10 - (deg % 10);
			}
		}
		this.element.css({ rotate: deg });
	},

	_handlerStop: function() {
		this.option('currentRotate', parseFloat(this.element.css('rotate')));
		$('.goods-rotate-handler').css(this.element.find('> .rotate').offset());
		this._trigger('rotate');
	},

	_deg: function(a, c1, c2, p1, p2, q1, q2) {
		var result = a;
		if (0 < ((p2 - c2) / (p1 - c1) * (q1 - p1) + p2 - q2) * (p1 - c1)) return 360 - result;
		return result;
	},

	show: function() {
		this.element.find('> .rotate').show();
		$('.goods-rotate-handler').show();
		this._ready();
	},

	hide: function() {
		this.element.find('> .rotate').hide();
		$('.goods-rotate-handler').hide();
	}

});
