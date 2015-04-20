/*
 * A7Code MVC
 * */
var A7 = {};
Backbone.ajax = function() {
    A7.Listen.reconnect();
    return Backbone.$.ajax.apply(Backbone.$, arguments);
};
//Model.prototype.toJSON = function(options) {
//	var attrs = _.clone(this.attributes);
//	_.each(attrs);
//	return _.clone(this.attributes);
//}
A7.View;
A7.templates = {};
A7.baseErr = function(err) {
    if (err.status == 401) {
        location.href = '/sign#in';
        return;
    }
    A7.Alert.present(err.responseText);
};
$.fn.outer = function() {
    var el = $(this);
    if( !el[0] ) return "";

    if (el[0].outerHTML) {
        return el[0].outerHTML;
    } else {
        var content = el.wrap('<div>').parent().html();
        el.unwrap();
        return content;
    }
};
(function(old) {
    $.fn.attr = function() {
        if(arguments.length === 0) {
            if(this.length === 0) {
                return null;
            }

            var obj = {};
            $.each(this[0].attributes, function() {
                if(this.specified) {
                    obj[this.name] = this.value;
                }
            });
            return obj;
        }

        return old.apply(this, arguments);
    };
})($.fn.attr);
function t(tagName, text, editable) {
    var split = text.replace(/\s/g, '').split(',');
    var type = split[0];
    var name = split[1];
    var className = name.split('.')[0];
    var value = '{{' + name + '}}';
    var link = editable ? null : split[2];
    var editor = split[2];

	var is_html = false;
	if (tagName == 'html') {
		is_html = true;
		tagName = 'div';
		value = '{' + value + '}';
	}

    var html =
        '<' + tagName + ' class="' + className + '" a7v-attr="' + name + '"'; if (editable) html += ' a7v-editor="' + editor + '" a7v-editable="' + name + '"';
		if (_.contains(['enter', 'fromNow', 'L', 'LL', 'LLL', 'LLLL', 'l', 'll', 'lll', 'llll'], type) && !link) {
			html += ' a7v-value-type="' + type + '"';
		}
		if (type == 'enter' && !link) html += ' a7v-value-type="enter"';
		html += '>';
    if (link)
        if (type == 'img') html +=
            '<a href="' + link + '">';
        else if (_.contains(['enter', 'fromNow', 'L', 'LL', 'LLL', 'LLLL', 'l', 'll', 'lll', 'llll'], type)) html +=
            '<a href="' + link + '" a7v-value=' + name + ' a7v-value-type="' + type + '">';
        else html +=
                '<a href="' + link + '" a7v-value=' + name + '>';
    if (type == 'string') html +=
        value;
    else if (type == 'img') html +=
        '<img src="{' + value + '}" a7v-value="' + name + '">';
    else if (_.contains(['enter', 'fromNow', 'L', 'LL', 'LLL', 'LLLL', 'l', 'll', 'lll', 'llll'], type)) html +=
        '{{#' + type + '}}' + value + '{{/' + type + '}}';
    if (link) html +=
        '</a>';
    html +=
        '</' + tagName + '>';

    return html;
}
A7.wild = function(data) {
    var html = '';
    _.each(data, function(val, key) {
        if (_.isArray(val) || _.isFunction(val) || key == 'id' || key.indexOf('_id') != -1) return;

        var type;
        var lowVal;
        if (_.isString(val)) {
            lowVal = val.toLowerCase();
        }
        if (_.isString(val) && lowVal.indexOf('\n') != -1)
            type = 'enter,';
        else if (_.isString(val) && (lowVal.indexOf('.png') != -1 || lowVal.indexOf('.gif') != -1 || lowVal.indexOf('.jpg') != -1 || val.indexOf('.jpeg') != -1))
            type = 'img,';
        else if (_.isString(val) || _.isNumber(val))
            type = 'string,';
        else if (_.isDate(val))
            type = 'L,';
        else return;

        html += '{{t "' + type + key + '"}}';
    });
    return html;
};
Handlebars.registerHelper('extend', function(text) {
    return new Handlebars.SafeString(text);
});
Handlebars.registerHelper('wild', function() {
    return new Handlebars.SafeString(Handlebars.compile(A7.wild(this))(this));
});
Handlebars.registerHelper('t', function(text) {
    return new Handlebars.SafeString(Handlebars.compile(t('div', text))(this));
});
Handlebars.registerHelper('t-html', function(text) {
	return new Handlebars.SafeString(Handlebars.compile(t('html', text))(this));
});
Handlebars.registerHelper('t-li', function(text) {
    return new Handlebars.SafeString(Handlebars.compile(t('li', text))(this));
});
Handlebars.registerHelper('t-span', function(text) {
    return new Handlebars.SafeString(Handlebars.compile(t('span', text))(this));
});
Handlebars.registerHelper('et', function(text) {
    return new Handlebars.SafeString(Handlebars.compile(t('div', text, true))(this));
});
Handlebars.registerHelper('et-li', function(text) {
    return new Handlebars.SafeString(Handlebars.compile(t('li', text, true))(this));
});
Handlebars.registerHelper('et-span', function(text) {
    return new Handlebars.SafeString(Handlebars.compile(t('span', text, true))(this));
});
Handlebars.registerHelper('enter', function(options) {
    var html = Handlebars.compile(options.fn(this))(this);
    return new Handlebars.SafeString(
        html.replace(/\n/g, "<br>")
    );
});
Handlebars.registerHelper('fromNow', function(options) {
    var html = Handlebars.compile(options.fn(this))(this);
    if (!html) return '';
    return new Handlebars.SafeString(
        moment(html).fromNow()
    );
});
_.each(['L', 'LL', 'LLL', 'LLLL', 'l', 'll', 'lll', 'llll'], function(key) {
    Handlebars.registerHelper(key, function(options) {
        var html = Handlebars.compile(options.fn(this))(this);
        if (!html) return '';
        return new Handlebars.SafeString(
            moment(html).format(key)
        );
    });
});
Handlebars.registerHelper('cp', function(crit, options) {
	var target, key, val, html, operator;
	var err;
	if (crit.indexOf(' == ') != -1)
		operator = ' == ';
	else if (crit.indexOf('==') != -1)
		operator = '==';
	else if (crit.indexOf(' != ') != -1)
		operator = ' != ';
	else if (crit.indexOf('!=') != -1)
		operator = '!=';

	key = crit.split(operator)[0];
	val = crit.split(operator)[1];
	var keys = key.split('.');
	if (keys.length > 1) {
		var target = this;
		_.each(keys, function(key) {
			if (target)
				target = target[key];
			else
				err = true
		});
	} else {
		target = this[key];
	}

	if (err) {
		html = '';
	} else if (_.contains(['==', ' == '], operator)) {
		html = target == val ? Handlebars.compile(options.fn(this))(this) : '';
	} else if (_.contains(['!=', ' != '], operator)) {
		html = target != val ? Handlebars.compile(options.fn(this))(this) : '';
	}

	return new Handlebars.SafeString(html);
});
A7.$t = {
    confirm: '\
		<div class="valign">\
			<div class="confirm">\
				{{#if title}}<div class="title">{{title}}</div>{{/if}}\
				<div class="body">\
					<div class="message">{{message}}</div>\
				</div>\
				<div class="footer">\
					<button type="button" class="cancel">취소</button>\
					<button type="button" class="confirm">확인</button>\
				</div>\
			</div>\
		</div>',
    alert: '\
		<div class="valign">\
			<div class="alert">\
				{{#if title}}<div class="title">{{title}}</h3>{{/if}}\
				<div class="body">\
					<div class="message">{{message}}</div>\
				</div>\
				<div class="footer">\
					<button type="button" class="cancel">확인</button>\
				</div>\
			</div>\
		</div>'
};

A7.render = function(template, data) {
    template = template || '';
    return Handlebars.compile(template.replace(/\t/g, ''))(_.clone(data));
};
A7._model = {};
A7.model = function(name, Model) {
    if (!Model) return A7._model[name];
    A7._model[name] = Model;
    return Model;
};
A7.modelName = function(model) {
    for (var key in A7._model) {
        if (A7._model[key] == model.constructor)
            return key;
    }
};
A7._Model = Backbone.RelationalModel.extend({
    api: function() {
        return '/';
    },

    fetchData: {},

    _options: function(options) {
        if (options.api)
            this.api = options.api;
        if (options.fetchData)
            this.fetchData = options.fetchData;

        this.urlRoot = this.api;
    },

    constructor: function(options) {
        if (!arguments[0] || (!arguments[0].attributes && !arguments[0].options)) {
            this._options({});
            Backbone.RelationalModel.apply(this, arguments);
            return;
        }

        if (arguments[0].options) this._options(arguments[0].options);
        else this._options({});

        if (arguments[0].attributes) {
            Backbone.RelationalModel.apply(this, [arguments[0].attributes, arguments[1]]);
        } else {
            Backbone.RelationalModel.apply(this, [null, arguments[1]]);
        }
    },

    initialize: function() {
    },

    fetch: function(options) {
        options = options || {};
        options.data = _.extend(_.clone(this.fetchData), options.data);
        return Backbone.RelationalModel.prototype.fetch.apply(this, [options]);
    },

	saveChanged: function(next, failNext) {
		A7.Listen.reconnect();
		var toJSON = function(object) {
			if (_.isFunction(object.toJSON)) return object.toJSON();
			return object;
		};
		var allToJSON = function(object) {
			_.each(object, function(val, key) {
				if (_.isDate(val)) return;
				if (_.isObject(val) || _.isArray(val)) {
					object[key] = toJSON(val);
					allToJSON(object[key]);
				}
			});
			return object;
		};
		var data = allToJSON(_.clone(this.changed));
		_.each(data, function(val, key) {
//			if (val !== true && val !== false && _.isEmpty(val)) {
//				this.changed[key] = 'destroy';
//				return;
//			}
			if (_.isArray(val) && !_.isEmpty(val)) {
				if (!val[0].id) return;

				var changed = [];
				var ps = this.previous(key);
				_.each(ps, function(p) {
					var model = _.findWhere(val, { id: p.id });
					if (!model) {
						changed.push({id: p.id, destroy: true});
					}
				});
				_.each(val, function(v) {
					var model = _.findWhere(ps, { id: v.id });
					if (!model) {
						changed.push(v);
					}
				});
				data[key] = changed;
			}
		}, this);

		$.ajax({
			type: "PUT",
			url: this.url(),
			data: data
		})
		.done(next)
		.fail(failNext ? failNext : A7.baseErr);
	},

    savePick: function(keys, next) {
		next = next || function() {};
        var url = _.result(this, 'url');
        var data = _.pick(this.toJSON(), keys);

        $.ajax({
            type: "PUT",
            url: url,
            data: data
        })
        .done(_.bind(function(result) {
            this.set(result);
            if (next) next(result);
        }, this))
        .fail(A7.baseErr);
    }
}, {
    forge: function() {
        if (!arguments[0] || (!arguments[0].attributes && !arguments[0].options)) {
            A7._Model.prototype._options.apply(this, [{}]);
            return Backbone.RelationalModel.findOrCreate.apply(this, arguments)
        }
        if (arguments[0].attributes) {
            var model = Backbone.RelationalModel.findOrCreate.apply(this, [arguments[0].attributes, arguments[1]]);
            if (arguments[0].options) {
                model._options(arguments[0].options);
            }
            return model;
        } else {
            var model = Backbone.RelationalModel.findOrCreate.apply(this, [null, arguments[1]]);
            if (arguments[0].options) {
                model._options(arguments[0].options);
            }
            return model;
        }
    }
});
A7.Model = function(name, props, classProps) {
    return A7.model(name, A7._Model.extend(props, classProps));
};
A7._collection = {};
A7.collection = function(name, Collection) {
    if (!Collection) return A7._collection[name];
    A7._collection[name] = Collection;
    return Collection;
};
A7.collectionName = function(collection) {
    for (var key in A7._collection) {
        if (A7._collection[key] == collection.constructor)
            return key;
    }
};
A7._Collection = Backbone.Collection.extend({
    api: function() {
        return '/';
    },

    fetchData: {},

    _options: function(options) {
        if (options.api)
            this.api = options.api;
        if (options.fetchData)
            this.fetchData = options.fetchData;
        if (options.comparator)
            this.comparator = options.comparator;

        this.url = this.api;
    },

    constructor: function() {
        if (!arguments[0] || (!arguments[0].models && !arguments[0].options)) {
            this._options({});
            Backbone.Collection.apply(this, arguments);
            return;
        }
        if (arguments[0].options) this._options(arguments[0].options);
        else this._options({});

        if (arguments[0].models) {
            Backbone.Collection.apply(this, [arguments[0].models, arguments[1]]);
        } else {
            Backbone.Collection.apply(this, [null, arguments[1]]);
        }
    },

    fetch: function(options) {
        options = options || {};
        options.data = _.extend(_.clone(this.fetchData), options.data);
        return Backbone.Collection.prototype.fetch.apply(this, [options]);
    },

    savePick: function(keys, next) {
        var url = _.result(this, 'url');
        var _data = _.map(this.toJSON(), function(obj) {
            return _.pick(obj, keys);
        });
        var collection = new Backbone.Collection(_data);
        collection.url = url;
        collection.sync('update', collection, {
            success: _.bind(function(result) {
                this.set(result);
                next(result);
            }, this),
            error: A7.baseErr
        });

//        $.ajax({
//            type: "PUT",
//            url: url,
//            data: $.param(data)
//        })
//        .done(_.bind(function(data) {
//            this.set(data);
//            next(data);
//        }, this))
//        .fail(A7.baseErr);
    }

});
A7.Collection = function(name, props, classProps) {
    return A7.collection(name, A7._Collection.extend(props, classProps));
};
A7._view = {};
A7.view = function(name, View) {
    if (!View) return A7._view[name];
    A7._view[name] = View;
    return View;
};
A7.viewName = function(View) {
    for (var key in A7._view) {
        if (A7._view[key] == View || A7._view[key] == View.constructor)
            return key;
    }
};
A7.create = function(constructor, args) {
    function F() {
        return constructor.apply(this, args);
    }
    F.prototype = constructor.prototype;
    return new F();
};
A7.View = Backbone.View.extend({
    _extended: function(View) {
        if (this.name) A7.view(this.name, View);
    },

    _options: function(options) {
        if (options.page)
            this.page = options.page;

        if (options.subviewsModels)
            this.subviewsModels = options.subviewsModels;

//		if (options.defaultAttributes)
//			this.defaultAttributes = options.defaultAttributes;

		if (options.isPresent)
			this.isPresent = options.isPresent;

        if (options.name)
            this.name = options.name;

        if (options.template)
            this.template = options.template;

        this.className = this.className || '';
        this.name = this.name || '';
        if (this.className || this.name)
            this.className = this.className + ' ' + this.name;

        if (options.registerEventsModal)
            this.registerEventsModal = options.registerEventsModal;

        if (options.properties)
            this.properties = options.properties;
    },

//	defaultAttributes: {},

    constructor: function() {
        var options = arguments[0] || {};
        this._options(options);

        Backbone.View.apply(this, arguments);

        this.$el
            .addClass('a7v_')
            .attr('a7v', this.name)
            .attr('a7v-loaded', true)
            .data('a7v', this);

        if (this.model) this.$el.attr('a7v-model', A7.modelName(this.model));
        if (this.collection) this.$el.attr('a7v-collection', A7.collectionName(this.collection));
    },

    properties: function(setter) {
        setter({
        })
    },

    get: function(key) {
        return this._properties[key];
    },

    initialize: function() {
        this.properties(_.bind(function(_properties) {
            this._properties = _properties;
            if (this.model) _.extend(this._properties, this.model.toJSON());
        }, this));

//		if (this.model) this.$el.append(A7.render(this.template, this.model.toJSON()));
//		else this.$el.append(A7.render(this.template, this.defaultAttributes));
        this.$el.append(A7.render(this.template, this._properties));
        this._addA7Views();

        this.ready();
    },

    ready: function() {
    },

    page: null,

    _addA7Views: function() {
        var $a7views = this.$el.find('[a7v]');

        _.each($a7views, function(view) {
            var model, collection, newView, args;
            var $view = $(view);

            var key = $view.attr('a7v-model') || $view.attr('a7v-collection');
            var argsKey = $view.attr('a7v-args');
            var View = A7.view($view.attr('a7v'));
            if (!View) return;
            if ($view.attr('a7v-loaded')) return;

            var page = app.currentPage;
			var parentModel = this.model || this.defaultModel;

            if (argsKey) {
                args = this.get(argsKey) || page.get(argsKey);
                if ($.trim($view.html()).length) {
                    if (View.isItemView) {
                        _.extend(args[0], {
                            template: $view.html()
                        });
                    } else if (View.isItemsView) {
                        _.extend(args[0], {
                            template: '{{extend \'' + $view.html() + '\'}}'
                        });
                    } else {
                        _.extend(args[0], {
                            template: $view.html()
                        });
                    }
                }
                newView = A7.create(View, args);
            } else {
                if (View.isItemView) {
					// TODO toJSON된 상태일때의 문제 this.get(key)
                    if (parentModel) {
//                        model = parentModel.get(key) || this.get(key) || page.get(key);
						model = parentModel.get(key) || page.get(key);
                    } else {
                        model = this.get(key) || page.get(key);
                    }
                    if (!model) return;
                    if ($.trim($view.html()).length) {
                        newView = new View({
                            tagName: $view[0].nodeName.toLowerCase(),
                            attributes: $view.attr(),
                            model: model,
                            template: $view.html()
                        });
                    } else {
                        newView = new View({
                            tagName: $view[0].nodeName.toLowerCase(),
                            attributes: $view.attr(),
                            model: model
                        });
                    }
                } else if (View.isItemsView) {
                    if (parentModel) {
//                        collection = parentModel.get(key) || this.get(key) || page.get(key);
						collection = parentModel.get(key) || page.get(key);
                    } else {
                        collection = this.get(key) || page.get(key);
                    }
					if (!collection) return;
                    if ($.trim($view.html()).length) {
                        newView = new View({
                            tagName: $view[0].nodeName.toLowerCase(),
                            attributes: $view.attr(),
                            collection: collection,
                            template: '{{extend \'' + $view.html() + '\'}}'
                        });
                    } else {
                        newView = new View({
                            tagName: $view[0].nodeName.toLowerCase(),
                            attributes: $view.attr(),
                            collection: collection
                        });
                    }
                } else if (View.isFormView) {
                    if (parentModel) {
//                        collection = parentModel.get(key) || this.get(key) || page.get(key);
						collection = parentModel.get(key) || page.get(key);
                    } else {
                        collection = this.get(key) || page.get(key);
                    }
                    var dModel;
                    var dModelKey = $view.attr('a7v-default-model');
                    if (dModelKey) dModel = this.get(dModelKey) || page.get(dModelKey);

                    newView = new View({
                        tagName: $view[0].nodeName.toLowerCase(),
                        attributes: $view.attr(),
                        collection: collection,
                        defaultModel: dModel
                    });
                } else { //isView
                    var modelOrCollection;
                    if (parentModel) {
//                        modelOrCollection = parentModel.get(key) || this.get(key) || page.get(key);
						modelOrCollection = parentModel.get(key) || page.get(key);
                    } else {
                        modelOrCollection = this.get(key) || page.get(key);
                    }
                    var options = {};
                    if (modelOrCollection) {
                        options = _.has(modelOrCollection, 'models') ?
                        { collection: modelOrCollection } : { model: modelOrCollection };
                    }
                    newView = new View(_.extend({
                        tagName: $view[0].nodeName.toLowerCase(),
                        attributes: $view.attr()
                    }, options));
                }
            }

            newView.$el.addClass($view[0].className);
            $view.after(newView.$el).remove();
        }, this);
    },

    present: function(options, modalClosed) {
        if (_.isFunction(options) && !modalClosed) modalClosed = options;
        this.modalClosed = modalClosed || function() {};
        var $modal = $('<div class="a7v_modal"><div class="valign"></div></div>');
        $modal.find('.valign').append(this.$el);
        $modal.click(_.bind(function(e) {
            if (!$(e.target).is('.a7v_modal, .a7v_modal .valign')) return;
            this.trigger('modalClosed', [false]);
            this.dismiss();
        }, this));
        this.registerEventsModal($modal);
        $modal
            .hide()
            .appendTo('body')
            .fadeIn(150, _.bind(function() {
				this.presented();
			}, this));

    },

	presented: function() {},

    registerEventsModal: function($modal) {
        $modal.find('button.confirm').click(_.bind(function() {
            this.dismiss();
        }, this));
        $modal.find('button.cancel').click(_.bind(function() {
            this.dismiss();
        }, this));
    },

    dismiss: function(options) {
        var $modal = this.$el.parents('.a7v_modal');
        this.modalClosed(options);
        $modal.animate({
            opacity: 0
        }, 150, _.bind(function() {
            this.remove();
            $modal.remove();
        }, this));
    },

    modalClosed: function() {}

}, {
    isView: true
});
A7.FormView = A7.View.extend({
    tagName: 'form',

    _options: function(options) {
        A7.View.prototype._options.apply(this, arguments);
        if (options.events)
            this.events = _.extend(
                _.isFunction(this.events) ? this.events() : this.events,
                _.isFunction(options.events) ? options.events() : options.events
            );

        if (options.removed)
			this.removed = options.removed;

        if (options.added)
            this.added = options.added;

        if (options.saved)
            this.saved = options.saved;

        if (options.closed)
            this.closed = options.closed;

        if (options.defaultModel)
            this.defaultModel = options.defaultModel;

        if (options.append)
            this.append = options.append;
    },

    defaultModel: null,
	changedAttrs: {},

    initialize: function() {
//		if (this.model) {
//			this.$el.append(A7.render(this.template, _.extend(this.model.toJSON())));
//		} else if (this.defaultModel) {
//			this.$el.append(A7.render(this.template, this.defaultModel.toJSON()));
//		} else {
//			this.$el.append(A7.render(this.template, {}));
//		}
        this.properties(_.bind(function(_properties) {
            this._properties = _properties;
            if (this.model) _.extend(this._properties, this.model.toJSON());
        }, this));

//		if (this.model) {
//			this.listenTo(this.model, 'change', this.render);
//		}

        this.$el.append(A7.render(this.template, _.extend(this._properties, !_.isEmpty(this.defaultModel) ? this.defaultModel.toJSON() : {})));

        this.$el.attr('method', 'post');
        this.$el.submit(_.bind(this._submit, this));
        this.$el.on('click', '> [a7v-methods] [a7v-close]', _.bind(this._closed, this));
		this.$el.on('click', '> [a7v-destroy], > [a7v-methods] button[a7v-destroy], > div > [a7v-methods] button[a7v-destroy]', _.bind(this._destroy, this));
        this._addA7Views();
        this.ready();
    },

    ready: function() {},

    saved: function(self, model) {},

    added: function(self, model) {},

	closed: function(self, model) {},

	removed: function(self) {},

	set: function(key, value) {
		var targetModel = this.model || this.defaultModel;
		if (!targetModel) return;

		var attrs = _.isString(key) ? _.object([key], [value]) : key;
//		targetModel.set(_.clone(_.extend(this.changedAttrs, attrs)));

		_.extend(this.changedAttrs, attrs);
	},

    _submit: function(e) {
        e.preventDefault();

        var attrs = this.defaultModel ? this.defaultModel.toJSON() : {};

        _.each(this.$el.find('[name]'), function(control) {
            var $control = $(control);
			if ($control.is("[a7v-ignore]")) return;

            var val = $control.is('[type="checkbox"]') ?
                $control[0].checked : $control.val();
            if ($control.attr('attr-type') == 'integer')
                val = parseInt(val);

            if ($control.attr('name').indexOf('.') != -1) {
                if (!val) return;

                var rel = $control.attr('name').split('.')[0];
                var key = $control.attr('name').split('.')[1];
                if (!attrs[rel]) attrs[rel] = {};
                attrs[rel][key] = val;
            } else {
                attrs[$control.attr('name')] = val;
            }
        }, this);

        var attrs2 = {};
        _.each(this.$el.find('[attr-name]'), function(control) {
            var $control = $(control);
            var key = $control.attr('attr-name');
            if (_.has(attrs2, key)) return;

            attrs2[key] = '';
            var type;
            var format = 'YYYY.MM.DDhhmm';
            _.each(this.$el.find('[attr-name="'+key+'"]'), function(control, i) {
                var $control = $(control);
                if (i == 0) {
                    type = $control.attr('attr-type');
                    format = $control.attr('attr-format') || format;
                }
                attrs2[key] += $(control).val();
            });
            if (type == 'date' && format) {
				attrs2[key] = moment(attrs2[key], format).tz('GMT').format();
			}
        }, this);

        attrs = _.extend(attrs, attrs2);

        if (this.model) {
			this.set(attrs);

			if (!this.model.isValid()) {
                A7.Alert.present(this.model.validationError);
                return;
            }
//			if (!this.$('[required]').val().length) {
//				A7.Alert.present('필수 입력 항목을 입력하지 않으셨습니다.');
//				return;
//			}

			this.model.set(_.clone(this.changedAttrs), { silent: true });
//			this.model.changed = _.clone(this.changedAttrs);

			this.model.saveChanged(_.bind(function(attrs) {
				this.model.set(attrs);
				this.changedAttrs = {};
				this.saved(this, this.model);
			}, this));
//			this.model.save().then(_.bind(function(model) {
//				this.saved(this, model);
//			}, this));
        } else if (this.collection) {
            var Model = this.collection.model;
            var model = Model.forge({
                options: {
                    api: _.result(this.collection, 'api')
                },
                attributes: _.extend(attrs, this.changedAttrs)
            });

			if (!model.isValid()) {
                A7.Alert.present(model.validationError);
                return;
            }
//			if (!this.$('[required]').val().length) {
//				A7.Alert.present('필수 입력 항목을 입력하지 않으셨습니다.');
//				return;
//			}


            model.save(null, {wait: true})
                .then(_.bind(function(data) {
                    this.changedAttrs = {};
                    // backbone-relation의 문제, 새로 만들어진 model의 자식 요소와 관계 설정이 올바르게 되지 않는 버그를 해결
                    _.each(model.getRelations(), function(relation) {
						if (model.get(relation.key))
                        	model.get(relation.key)[A7.modelName(model)] = model;
                    });
                    this.collection.add(model);
                    _.each(this.$el.find('[name]:not([type="hidden"])'), function(control) {
                        var $control = $(control);
                        if ($control.is('[type="checkbox"]')) $control.prop('checked', false);
                        else $control.val('');
                    }, this);
                    this.$el.find('[data_focus]').focus();
                    this.added(this, model);
                }, this));
        }
    },

	_destroy: function() {
		this.removed(this);
	},

    _closed: function(e) {
        this.closed(this);
    }

}, {
    isFormView: true
});
A7.ItemView = A7.View.extend({
    initialize: function() {
        this.properties(_.bind(function(_properties) {
            this._properties = _properties;
            if (this.model) _.extend(this._properties, this.model.toJSON());
        }, this));

        if (this.model) {
            A7.Listen.on({ model: this.model });
            this.listenTo(this.model, 'change', this.render);
            this.listenTo(this.model, 'destroy', this.destroy);
            this.$el.attr('data-id', this.model.get('id'));
//			this.$el.append(A7.render(this.template, this.model.toJSON()));
			this.$el.append(A7.render(this.template, this._properties));
        }
        this.$el.on('click', '> [a7v-destroy], > [a7v-methods] button[a7v-destroy], > div > [a7v-methods] button[a7v-destroy]', _.bind(this._destroy, this));
        this.$el.on('click', '> button[a7v-editable], > [a7v-methods] button[a7v-editable], [a7v-methods] button[a7v-editable]', _.bind(this._modify, this));
        this.$el.on('click', '> [a7v-save], > [a7v-methods] [a7v-save]', _.bind(this._save, this));
        this.$el.on('click',
                '> [a7v-editable]:not(button), ' +
                '> [a7v-attr] [a7v-editable]:not(button), ' +
                '> [a7v-attrs] > [a7v-editable]:not(button), ' +
                '> td [a7v-editable]:not(button), ' +
                '> th [a7v-editable]:not(button)',
            _.bind(this._editable, this));

        this._addA7Views();

        this.ready();
    },

    ready: function() {
    },

    render: function(model) {
		function typeIsDate(type) {
			return _.contains(['fromNow', 'L', 'LL', 'LLL', 'LLLL', 'l', 'll', 'lll', 'llll'], type);
		}
		// ?? TODO 대체 뭘까 changed에 없는 이유 찾아야함.
        _.each(model.toJSON(), _.bind(function(val, key) {
            val = model.get(key);
			if (_.isEmpty(val)) return;
            if (_.isObject(val) && !_.isDate(val)) {
				if (_.has(val, 'api') || _.has(val, 'attributes')) {
					val = val.toJSON();
				}
				var $elements = this.$('.' + key).not(this.$('.a7v_ *')).not('.a7v_');
                _.each($elements, function(el) {
                    var $el = $(el);
                    _.each(val, function(val, subKey) {
                        var $value = $el.find('[a7v-value="' + key + '.' + subKey + '"]').not(this.$('.a7v_ *')).not('.a7v_');
                        if (!$value.length) $value = $el.is('[a7v-attr="' + key + '.' + subKey + '"]') ? $el : {};
                        if (!$value.length) return;

                        if ($value.attr('a7-value-type') && $value.attr('a7v-value-type').toLowerCase() == 'enter')
                            val = val.replace(/\n/g, '<br>');

						if ($value.attr('a7v-value-type') && typeIsDate($value.attr('a7v-value-type'))) {
							if ($value.attr('a7v-value-type') == 'fromNow')
								val = moment(val).fromNow();
							else
								val = moment(val).format($value.attr('a7v-value-type'));
						}

                        if ($value[0].nodeName == 'IMG') $value.attr('src', val);
                        else if ($value.is('input[type="checkbox"]')) $value.prop('checked', val);
                        else if ($value.is('[value]')) $value.val(val);
                        else $value.html(val);
                    }, this);
                }, this);
            } else {
                var $value = this.$('[a7v-value="' + key + '"]').not(this.$('.a7v_ *')).not('.a7v_');
                if (!$value.length) $value = this.$('.' + key).not(this.$('.a7v_ *')).not('.a7v_');
                if (!$value.length) return;

                if ($value.attr('a7v-value-type') && $value.attr('a7v-value-type').toLowerCase() == 'enter')
                    val = val.replace(/\n/g, '<br>');

				if ($value.attr('a7v-value-type') && typeIsDate($value.attr('a7v-value-type'))) {
					if ($value.attr('a7v-value-type') == 'fromNow')
						val = moment(val).fromNow();
					else
						val = moment(val).format($value.attr('a7v-value-type'));
				}

                if ($value[0].nodeName == 'IMG') $value.attr('src', val);
                else if ($value.is('input[type="checkbox"]')) $value.prop('checked', val);
                else if ($value.is('[value]')) $value.val(val);
                else $value.html(val);
            }
        }, this));

        // 임시 TODO 더 좋은 방법 없는지 찾아야함.
        this._addA7Views();

        return this;
    },

    _destroy: function() {
        if (this.model && confirm('정말 삭제하시겠습니까?')) {
			this.model.destroy({ wait: true });
		}
    },

    destroy: function() {
        this.remove();
    },

    _editable: function(e) {
        this._modify(e, true);
    },

    _modify: function(e, editable) {
        var $button = $(e.currentTarget);
        var column = $button.attr('a7v-editable');
        if (!editable && !column) return;

        var editorType = $button.attr('a7v-editor');
        var editor = editorType == 'textarea' ?
            '<textarea class="editor" name="' + column + '">{{'+ column +'}}</textarea>' :
            '<input class="editor" type="text" name="' + column + '" value="{{'+ column +'}}" />' ;

        var ModifyForm = A7.FormView.extend({
            model: this.model,
            className: 'editable ' + column,
            template: '\
				<div a7v-attrs>\
					' + editor + '\
				</div>\
				<div a7v-methods>\
					<button type="submit">수정완료</button>\
					<button type="button" a7v-close>취소</button>\
				</div>\
			',
            events: {
                'click [a7v-methods] button': '_unbindBlur'
//				,
//                'blur [a7v-attrs] .editor': '_blur'
            },
            initialize: function() {
                A7.FormView.prototype.initialize.apply(this);
            },
            closed: _.bind(function(form) {
                form.remove();
                this.$el.attr('data-editable', '');
            }, this),
            saved: _.bind(function(form, data) {
                form.remove();
                this.$el.attr('data-editable', '');
                this.modified(this);
            }, this),
//            _blur: function(e) {
//                this._blurTime = setTimeout(_.bind(function() {
//                    this._submit(e)
//                }, this), 300);
//            },
            _unbindBlur: function() {
                clearTimeout(this._blurTime);
            }
        });

        var modifyForm = new ModifyForm({
            model: this.model
        });

        this.$el.find('> [a7v-editable].' + column + ':not(button), ' +
            '> [a7v-attrs] > [a7v-attr].' + column + ':not(button),' +
            '> [a7v-attr].' + column + ':not(button),' +
            '> td [a7v-editable].' + column + ':not(button),' +
            '> th [a7v-editable].' + column + ':not(button)')
            .after(modifyForm.$el).end()
            .attr('data-editable', 'editable');

        var val = modifyForm.$('.editor').val();
        modifyForm.$('.editor').focus().val('').val(val);
    },

    modified: function(self) {},

    _save: function() {
        this.model.save().then(_.bind(function() {
            this.saved(this, this.model);
        }, this));
    },

    saved: function(self, model) {}

}, {
    isItemView: true
});
A7.ItemsView = A7.View.extend({
    ItemView: A7.ItemView,
    $items: null,
    itemViewOptions: {
    },

    _options: function(options) {
        A7.View.prototype._options.apply(this, arguments);

        if (options.ItemView)
            this.ItemView = options.ItemView;

        if (options.added)
            this.added = options.added;

        if (options.removed)
            this.removed = options.removed;

        if (options.append)
            this.append = options.append;

        if (options.infinity)
            this.infinity = options.infinity;
    },

    offset: 0,

    initialize: function() {
        this.properties(_.bind(function(_properties) {
            this._properties = _properties;
        }, this));

        this.$el.append(A7.render(this.template, this._properties));
        this.$items = this.$el.find(' > [a7v-items-each], > table [a7v-items-each]');
		this.$empty = this.$el.find(' > [a7v-empty]');
        if (this.$items.length)
            if ($.trim(this.$items.html()).length) {
                var $itemViewTemplate = this.$items.find('> *');
                this.itemViewOptions = {
                    tagName: $itemViewTemplate[0].nodeName,
                    template: $.trim($itemViewTemplate.html())
                };
                this.ItemView = A7.view(this.$items.attr('a7v-items-each'));
                $itemViewTemplate.remove();
            } else {
                this.ItemView = A7.view(this.$items.attr('a7v-items-each'));
            }
        else {
            this.$items = $('<div a7v-items-each="' + A7.viewName(this.ItemView) +'"></div>');
            this.$el.prepend(this.$items);
        }

        if (this.infinity) {
            if (_.isFunction(this.infinity.container))
                this.infinity.container = _.bind(this.infinity.container, this)();

            if (this.infinity.toTop) {
                this.infinity.container.css({opacity: 0});
                this.reverse = true;
            }
            this.infinity.container.on('scroll', _.bind(function(e) {
                var isEnd = e.target.scrollHeight - 2 < e.target.scrollTop + e.target.offsetHeight;
                if (this.infinity.toTop) isEnd = e.target.scrollTop == 0;
                if (!isEnd) return;

                if (this.scroll) return;
                this.scroll = true;

                this.$lastItemView = this.infinity.toTop ?
                    this.$items.find('> *:eq(0)') : this.$items.find('> *:last');

                if (this.infinity.toTop) this.transparent = true;
                this.collection.fetch({
                    remove: false,
                    data: {
                        offset: this.offset,
                        limit: this.infinity.length
                    }
                }).then(_.bind(function() {
//                    setTimeout(_.bind(function() {
                        if (this.infinity.toTop) {
                            var offset = this.$lastItemView.offset();
                            this.infinity.container.scrollTop(offset.top - 80);
                            this.$items.find('.transparent').removeClass('transparent');
                            this.transparent = false;
                        }
                        this.scroll = false;
//                    }, this), 500);
                }, this));
            }, this));
        }

        A7.Listen.on({ collection: this.collection });
        this.listenTo(this.collection, "add", this._draw);
        this.listenTo(this.collection, "sync", this._sync);
        this.listenTo(this.collection, "remove", this._remove);
		this.$el.on('keyup', '[a7v-filters] input[type="text"]', _.bind(this._keyupFilter, this));

		// TODO ben이 넣음 여기 넣어도 되나?? marty??..
		this._addA7Views();

        if (!this.collection.length) {
            if (this.infinity && this.infinity.toTop) {
                setTimeout(_.bind(function() {
                    this.infinity.container
                        .scrollTop(this.infinity.container[0].scrollHeight + 500)
                        .animate({opacity: 1}, 150);
                }, this), 500);
            }
            this.ready();
			setTimeout(_.bind(function() {
				this.empty();
			}, this), 1000);
            return;
        }

        this.collection.forEach(function(model) {
            this._draw(model);
        }, this);

        this.ready();
		setTimeout(_.bind(function() {
			this.empty();
		}, this), 1000);

        if (this.infinity && this.infinity.toTop) {
            setTimeout(_.bind(function() {
                this.infinity.container
                    .scrollTop(this.infinity.container[0].scrollHeight + 500)
                    .animate({opacity: 1}, 150);
            }, this), 500);
        }
    },

    ready: function() {
    },

    _draw: function(model) {
        var $existView = this.$el.find('> *[data-id="' + model.get('id') + '"]');
        if ($existView.length) return;

        var index = this.collection.indexOf(model);
        var append = '';
        if (index == 0) append = this.reverse ? 'append' : 'prepend';
        else if (index == this.collection.length - 1) append = this.reverse ? 'prepend' : 'append';
        else append = this.reverse ? 'before' : 'after';

        var itemView = new this.ItemView(_.extend({
            model: model
        }, this.itemViewOptions));

        if (this.transparent) {
            itemView.$el.addClass('transparent');
        }

        if (this.reverse) {
            if (index == 0) {
                this.$items.append(itemView.$el);
                this.infinity.container
                    .scrollTop(this.infinity.container[0].scrollHeight + 500)
            } else this.$items.prepend(itemView.$el);
        } else if ('before' == append) {
            this.$items.find('> *:eq(' + (this.collection.length - index + 1) + ')')[append](itemView.$el)
        } else if ('after' == append) {
            this.$items.find('> *:eq(' + (index-1) + ')')[append](itemView.$el)
        } else {
            this.$items[append](itemView.$el);
        }
        this.offset++;

        this.added(this, model, itemView);
    },

	empty: function() {
		if (this.collection.length == 0) {
			this.$empty.show();
		} else {
			this.$empty.hide();
		}
	},

    _sync: function() {
//		this.$items.empty();
//		this.collection.forEach(function(model) {
//			this._draw(model, 'append');
//		}, this);
//
//		if (!this.addedAddEvent) {
//			this.addedAddEvent = true;
//			this.listenTo(this.collection, "add", this._draw);
//		}
    },

    _remove: function(model, collection, options) {
        this.$el.find('> [a7v-items-each]')
            .find('> [a7v][data-id="' + model.get('id') + '"]').remove();
        this.removed();
    },

    removed: function() {
    },

    added: function(self, model, itemView) {

    },

    _keyupFilter: function(e) {
        // and, or, like, equals;;;
        var $input = $(e.currentTarget);
        if ($.trim($input.val()) != '') {
            var	options = { data: {} };
            var attrs = $input.attr('a7v-search-attrs').replace(/ /g, '').split(',');
            var filters = [];
            _.each(attrs, function(attr) {
                filters.push([attr, "like", "%" + $input.val() + "%"]);
            });
            if (filters.length)
                _.extend(options.data, {
                    filters: JSON.stringify(filters)
                });

            this.collection.fetch(options);
        } else {
            this.collection.fetch();
        }
    }

}, {
    isItemsView: true
});

A7.Page = A7.View.extend({
    baseTemplate: '\
		<!--div class="header" a7v-attrs>\
			<h1 class="title">{{title}}</h1>\
		</div-->\
		<div class="body"></div>\
	',

    _responseData: {},

    _options: function(options) {
        A7.View.prototype._options.apply(this, arguments);

        this.className = this.className + ' page_controller';
        this.responseData = options.res || {};

        if (options.properties)
            this.properties = options.properties;

        if (options.params)
            this.params = options.params;
    },

    constructor: function() {
        if (arguments[0]) this._options(arguments[0]);
        else this._options({});

        Backbone.View.apply(this, arguments);

        this.$el
            .addClass('a7v_')
            .attr('a7v', this.name)
            .data('a7v', this);

        if (this.model) this.$el.attr('a7v-model', A7.modelName(this.model));
        if (this.collection) this.$el.attr('a7v-collection', A7.collectionName(this.collection));
    },

    properties: function() {
        return {};
    },

    _properties: {},

    initialize: function() {
        app.currentPage = this;
        this.beforeReady();
        this.$el.attr('a7v-page', 'page');

        new Promise(_.bind(this.properties, this)).then(_.bind(function(properties) {
            this.$el.append(A7.render(this.baseTemplate, properties));
            this.$header = this.$('> .header');
            this.$title = this.$header.find('h1');
            this.$body = this.$(' > .body');
            this._properties = properties;
            this.load();
        }, this));
    },

    load: function() {
        var headerTemplate = this.loadHeader();
        if (headerTemplate) {
            var $header = $(A7.render(headerTemplate, this._properties));
            this.$header.after($header).remove();
            this.$header = $header;
        }

        var bodyTemplate = this.loadBody();
        if (bodyTemplate) {
            var $body = $(A7.render(bodyTemplate, this._properties));
            this.$body.after($body).remove();
            this.$body = $body;
        }
        this._addA7Views();

        this.ready();
    },

    get: function(key) {
        return this._properties[key];
    },

    beforeReady: function() {

    },

    ready: function() {

    },

    loadHeader: function() {
        return '';
    },

    loadBody: function() {
        return '';
    }

}, {
    isPage: true
});
A7.Confirm = A7.View.extend({
    tatName: 'div',

    className: 'a7v_modal',

    events: {
        'click button.confirm': '_yes',
        'click button.cancel': '_no',
        'click .valign': '_no'
    },

    modalTemplate: function() {
        return A7.$t.confirm;
    },

    present: function(options, modalClosed) {
        if (_.isString(options)) options = { message: options };
        this.modalClosed = modalClosed || function() {};

        $('*:focus').blur();

        this.$el.append(A7.render(this.modalTemplate(), options));
        this.$el
            .hide()
            .appendTo('body')
            .fadeIn(150);
    },

    dismiss: function() {
        this.modalClosed = function() {};
        this.$el.animate({
            opacity: 0
        }, 150, _.bind(function() {
            this.remove();
        }, this));
    },

    _no: function(e) {
        e.preventDefault();
        this.modalClosed(false);
        this.dismiss();
    },

    _yes: function(e) {
        e.preventDefault();
        this.modalClosed(true);
        this.dismiss();
    },

    modalClosed: function() {}
}, {
    present: function(options, modalClosed) {
        var confirm = new this();
        confirm.present(options, modalClosed);
    }

});
A7.Alert = A7.Confirm.extend({
    modalTemplate: function() {
        return A7.$t.alert;
    }
});
A7.Listen = {
    sc: null,
    on: function(listens, next) {
        if (true) return;

        if (!this.sc) this.init();

        var pres = [];
        var presKeys = [];
        var collection;
        _.each(listens, function(val, key) {
            if (_.isArray(val) && val.length == 2) {
                pres.push(val[0][val[1]]());
                listens[key] = val[0];
                presKeys.push(key);
                collection = val[0];
            }
        });

        Promise.all(pres).then(_.bind(function(data) {
            _.each(listens, function(val, key) {
                if (_.has(val, 'models')) {
                    var fetchData = _.clone(val.fetchData);
                    delete fetchData.with_related;
//					delete fetchData.filters;
					delete fetchData.limit;
					delete fetchData.offset;
					delete fetchData.order_by;

                    var url = _.isEmpty(fetchData) ?
                        _.result(val, 'url') : _.result(val, 'url') + '?' + util.objectToQs(val.fetchData);

                    if (!A7.Listen.sc.$events[url]) {
                        A7.Listen.sc.on(url, function(message) {
                            if (message.method == 'create') {
                                if (val.get(message.data.id)) {
                                    val.get(message.data.id).set(message.data);
                                } else {
                                    val.add(message.data);
                                }
                            } else if (message.method == 'update') {
                                val.get(message.data.id).set(message.data);
                            } else if (message.method == 'delete') {
                                val.remove(message.data.id);
                            }
                        });
                    }
                } else if (_.has(val, 'cid')) {
                    if (A7.Listen.sc.$events[_.result(val, 'url')]) return;
                    A7.Listen.sc.on(_.result(val, 'url'), function(message) {
                        if (message.method == 'update') {
                            val.set(message.data);
                        } else if (message.method == 'delete') {
                            val.trigger('destroy');
                        }
                    });
                }
            }, this);
            next(listens);
        }, this));
    },
    off: function(obj) {
        if (true) return;

        if (!this.sc) this.init();

        if (!obj) {
            this.sc.removeAllListeners();
            return;
        }
        var url;
        if (_.has(obj, 'models')) {
            url = _.size(obj.fetchData) ?
                _.result(obj, 'url') + '?' + util.objectToQs(obj.fetchData) : _.result(obj, 'url');
        } else {
            url = _.result(obj, 'url');
        }
        this.sc.removeAllListeners(url);
    },
    reconnect: function(delay) {
        if (true) return;

        if (!this.sc) this.init();
        if (!this.sc.socket.connected) return;
        delay = delay || 1000;

        this.sc.socket.disconnect();
        this.sc.socket.reconnect(delay);
    },
    init: function(url) {
        if (true) return;

        url = url || this.config.url;
        this.sc = io.connect(url);
    },
    config: {
//		url
    }
};

util = {
    qsToObject: function (qs) {
        var o = {};
        qs.replace(
            new RegExp("([^?=&]+)(=([^&]*))?", "g"),
            function ($0, $1, $2, $3) { o[$1] = $3; }
        );
        return o;
    },
    objectToQs: function (o) {
        var str = [];
        for (var k in o)
            str.push(k + "=" + o[k]);
        return str.join("&");
    }
};

A7.fileupload = function($element, next) {
	$element
		.fileupload({
			forceIframeTransport: true,
			url: '/upload',
			dataType: 'text',
			done: _.bind(function(e, response) {
				var data = JSON.parse(response.result);
				next(data);
			}, this)
		})
		.prop('disabled', !$.support.fileInput);
};
