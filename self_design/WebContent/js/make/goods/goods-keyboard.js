function getInternetExplorerVersion() {
    var rv = -1; // Return value assumes failure.
    if (navigator.appName == 'Microsoft Internet Explorer') {
        var ua = navigator.userAgent;
        var re = new RegExp("MSIE ([0-9]{1,}[\.0-9]{0,})");
        if (re.exec(ua) != null)
            rv = parseFloat(RegExp.$1);
    }
    return rv;
}
var goods = goods || {};
goods.keyboard = {
	eventCancel: function(e) {
		if (e.preventDefault) {
			e.preventDefault();
		} else {
			// internet explorer
			e.returnValue = false;
		}
	},
	_clipboard: [],
	clipboard: function(infos) {
		if (infos === undefined) return this._clipboard.concat();
		this._clipboard = infos.concat();
	},
	ready: function() {
        var ver = getInternetExplorerVersion();
        if (ver > -1 && ver <= 8.0) return;

		KeyboardJS.on('delete, backspace', function(e) {
			if (!$(e.target).is('textarea, input') && $('.mp-editor').length > 0) {
				goods.keyboard.eventCancel(e);
            }
		}, function(e) {
			if ($(e.target).is('textarea, input')) return;
			trash();
		});

		KeyboardJS.on('ctrl+z', function() {
			undo();
		}, null);

		KeyboardJS.on('ctrl+shift+z', function() {
			redo();
		}, null);

		KeyboardJS.on('up', function(e) {
			if ($('.mp-editor-canvas.current .goods-item.selected').length) {
				goods.keyboard.eventCancel(e);
			}
			$('.mp-editor-canvas.current').page('moveSelectedItems', { top: '-=1' });
		}, null);

		KeyboardJS.on('down', function(e) {
			if ($('.mp-editor-canvas.current .goods-item.selected').length) {
				goods.keyboard.eventCancel(e);
			}
			$('.mp-editor-canvas.current').page('moveSelectedItems', { top: '+=1' });
		}, null);

		KeyboardJS.on('left', function(e) {
			if ($('.mp-editor-canvas.current .goods-item.selected').length) {
				goods.keyboard.eventCancel(e);
			}
			$('.mp-editor-canvas.current').page('moveSelectedItems', { left: '-=1' });
		}, null);

		KeyboardJS.on('right', function(e) {
			if ($('.mp-editor-canvas.current .goods-item.selected').length) {
				goods.keyboard.eventCancel(e);
			}
			$('.mp-editor-canvas.current').page('moveSelectedItems', { left: '+=1' });
		}, null);

		KeyboardJS.on('shift+up', function(e) {
			if ($('.mp-editor-canvas.current .goods-item.selected').length) {
				goods.keyboard.eventCancel(e);
			}
			$('.mp-editor-canvas.current').page('moveSelectedItems', { top: '-=10' });
		}, null);

		KeyboardJS.on('shift+down', function(e) {
			if ($('.mp-editor-canvas.current .goods-item.selected').length) {
				goods.keyboard.eventCancel(e);
			}
			$('.mp-editor-canvas.current').page('moveSelectedItems', { top: '+=10' });
		}, null);

		KeyboardJS.on('shift+left', function(e) {
			if ($('.mp-editor-canvas.current .goods-item.selected').length) {
				goods.keyboard.eventCancel(e);
			}
			$('.mp-editor-canvas.current').page('moveSelectedItems', { left: '-=10' });
		}, null);

		KeyboardJS.on('shift+right', function(e) {
			if ($('.mp-editor-canvas.current .goods-item.selected').length) {
				goods.keyboard.eventCancel(e);
			}
			$('.mp-editor-canvas.current').page('moveSelectedItems', { left: '+=10' });
		}, null);

		KeyboardJS.on('ctrl+a', function(e) {
			goods.keyboard.eventCancel(e);
			selectAll();
		}, null);

		KeyboardJS.on('ctrl+c', function(e) {
			var $msItem = $('.goods-item.ms');
			if ($msItem.length) {
				goods.keyboard.clipboard([$msItem.item('info')]);
				return;
			}
			if ($('.goods-item.selected').length) {
				var infos = [];
				$('.goods-item.selected').each(function() {
					infos.push($(this).item('info'));
				});
				goods.keyboard.clipboard(infos);
			}
		}, null);

		KeyboardJS.on('ctrl+v', function(e) {
			var infos = goods.keyboard.clipboard();
			var count = infos[0].type == 'ms' ? infos[0].itemInfos.length : infos.length;
			if (count + $('.mp-editor-canvas.current .goods-item').length > 3) {
				showAlert('한면에 디자인을 3개 이상 추가할 수 없습니다.');
				return;
			}
			_.each(infos, function(item) {
				item.style.top = parseInt(item.style.top, 10) + 15;
				item.style.left = parseInt(item.style.left, 10) + 15;
			});
			$('.mp-editor-canvas.current')
				.page('deselectItems')
				.page('appendItems', infos);

			// TODO 의존성 낮추기
			setTimeout(function() {
				$('.goods-item.selected').rotate('show');
				$('.mp-editor').editor('refreshPrice');
			}, 100);
		}, null);
	}
};
function undo() {
	var history = goods.history.undo();
	if (!history) return;

	if (history.item.type == 'remove-white-color' || history.item.type == 'remove-background') {
		$.post('/mygm/remove_white_undo', {
			prevSrc: history.item.prevSrc
		}, function(data) {
			$('.mp-editor-canvas.current .goods-item img[data-id="' + history.item.id + '"]')
				.attr('src', data.src)
				.data('fuzz', 5);
		});
	} else {
		$('.mp-editor-canvas.current').page('drawItems', history.item);
		$('.mp-editor').editor('refreshPrice');
	}
}
function redo() {
	var history = goods.history.redo();
	if (!history) return;

	if (history.item.type == 'remove-white-color' || history.item.type == 'remove-background') {
		$.post('/mygm/remove_white_undo', {
			prevSrc: history.item.prevSrc
		}, function(data) {
			$('.mp-editor-canvas.current .goods-item img[data-id="' + history.item.id + '"]')
				.attr('src', data.src)
				.data('fuzz', 5);
		});
	} else {
		$('.mp-editor-canvas.current').page('drawItems', history.item);
		$('.mp-editor').editor('refreshPrice');
	}
}
function trash() {
	$('.mp-editor-canvas.current').page('removeItems');
	$('.mp-editor').editor('refreshPrice');
}
function selectAll() {
	$('.mp-editor-canvas.current').page('selectAllItems');
}
