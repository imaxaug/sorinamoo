$.widget( "goods.page", {
	options: {
		className: 'goods-page',
		position : "absolute",
		top: 0,
		left: 0,
		width: 0,
		height: 0
		// callbacks
		,
		change: null
//            random: null
	},

	_getCreateOptions: function() {
		return {
			itemOptions: {
				editable: true,
				change: $.proxy(this._onItemChange, this),
				beforeSelect: $.proxy(this._itemBeforeSelect, this),
				select: $.proxy(this._itemSelect, this),
				draggableDisable: false,
				eventCanceled: false
			}
		}
	},

	_closer: function() {
	},

	_create: function() {
		this._closer();

		this.element
			.addClass(this.options.className);

		this._on($(document), {
			mousedown: '_click'
		});

		this._refresh();
	},

	_refresh: function() {
		this.element.css({
			position: this.options.position,
			top: this.options.top,
			left: this.options.left,
			width: this.options.width,
			height: this.options.height,
			boxShadow: this.options.boxShadow,
			background: this.options.background
		});
	},

	_setOptions: function() {
		this._superApply( arguments );

		this._refresh();
	},

	_setOption: function( key, value ) {
		this._super( key, value );
	},

	_onItemChange: function() {
		this._trigger('change', {}, {
			infos: this.infos()
		});
	},

	infos: function() {
		var infos = [];
		this.element.find('> .goods-item').each(function() {
			infos.push($(this).item('info'));
		});
		return infos;
	},

	_click: function(e) {
		if ($(e.target).hasClass('ms')) {
			this.deselectItems();
			return;
		}
		if ($(e.target).is('.goods-rotate-handler') || $(e.target).is('.goods-item') || $(e.target).parents('.goods-item').length || $(e.target).is('.goods-no-blur')) return;
		this.deselectItems();
	},

	deselectItems: function() {
		var $msItem = this.element.find('.goods-item.ms');
		var $deselectedItems = $msItem.msItem('deselectAllItems');
		this._registerEvent($deselectedItems);

		this.element.find('> .selected').each(function() {
			$(this).item('option', {
				selected: false,
				eventCanceled: true
			});
		});
        $('.mp-context-menu').hide();
	},

	_itemBeforeSelect: function() {
		if (_.contains(KeyboardJS.activeKeys(), 'shift')) return;
		this.deselectItems();
	},

	_itemSelect: function() {
		var $selectedItems = this.element.find('> .selected');
//		this.frontItem($selectedItems);
		var $msItem = this.element.find('.goods-item.ms');

		if ($msItem.length) {
			$msItem.msItem('addItem', $selectedItems);
//			this.frontItem($msItem);
			this._onItemChange();
			return;
		}

		if ($selectedItems.length != 2) {
			this._onItemChange();
			return;
		}

		var $msItem = this.addItem({ type: 'ms' }, true);
		$msItem.msItem('addItems', $selectedItems);
//		this.frontItem($msItem);
		this._onItemChange();
	},

	// TODO 셀렉트된애가 가장 위로 올라오게 강제한 부분 => 앞뒤 조절하는 툴 개발
	forwardItem: function($selectedItem) {
		this.element.find('.goods-item[data-editable="true"]').each(function() {
            if (this == $selectedItem.get(0)) return;

			if (parseInt($(this).css('zIndex'), 10) >= parseInt($selectedItem.css('zIndex'), 10)) {
				$selectedItem.item('option', { style: { zIndex: parseInt($(this).css('zIndex'), 10) + 1 }, eventCanceled: true });
			}
		});
	},

    backwardItem: function($selectedItem) {
        this.element.find('.goods-item[data-editable="true"]').each(function() {
            if (this == $selectedItem.get(0)) return;

            $(this).item('option', { style: { zIndex: parseInt($(this).css('zIndex'), 10) + 1 }, eventCanceled: true });
            if (parseInt($(this).css('zIndex'), 10) <= parseInt($selectedItem.css('zIndex'), 10)) {
                $selectedItem.item('option', { style: { zIndex: parseInt($(this).css('zIndex'), 10) - 1 }, eventCanceled: true });
            }
        });
    },

	_movedItemPosition: {
		top: 0,
		left: 0
	},

	_registerEvent: function($items) {
		_.each($items, function(element) {
			var options = this.option('itemOptions');
			options.eventCanceled = true;
			$(element).item('option', options);
		}, this);
	},

	addItem: function(info, eventCanceled) {
		var info = _.extend(_.clone(this.option('itemOptions')), (info || {}));

		var $item = $('<div>').item(info);
		$item.appendTo(this.element);

		if (!eventCanceled) {
			this._onItemChange();
//			this.frontItem($item);
		}
		return $item;
	},

	drawItems: function(infos) {
		this.element.find('> *').remove();
		this.appendItems(infos, true);
	},

	appendItems: function(infos, eventCanceled) {
		for (var i = 0; i < infos.length; i++)
			this.addItem(infos[i], true);

		if (!eventCanceled) {
			this._onItemChange();
		}
	},

	removeItems: function() {
		this.element.find('> .selected, .goods-item.ms').item('remove');
		this._onItemChange();
	},

	moveSelectedItems: function(position) {
		var $msItem = this.element.find('.goods-item.ms');
		if ($msItem.length) {
			$msItem.msItem('option', { style: position, eventCanceled: true });
			this._onItemChange();
			return;
		}

		this.element.find(' > .selected').item('option', { style: position, eventCanceled: true });
		this._onItemChange();
	},

	selectAllItems: function() {
		var $items = this.element.find('.goods-item');
		if ($items.length == 1) {
			$items.item('option', { selected: true });
			return;
		}
		var $msItem = this.addItem({ type: 'ms' }, true);
		$items.each(function() {
			$(this).item('option', { selected: true, eventCanceled: true });
		});
		$msItem.msItem('addItems', $items);

		this._onItemChange();
	}
});