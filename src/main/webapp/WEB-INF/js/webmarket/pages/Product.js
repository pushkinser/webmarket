define('pages/Product', ['jquery', 'bootstrap', 'require-css!bootstrap-css', 'domReady!'], function ($) {

    function Product() {
    }

    Product.prototype.draw = function () {
        var str = document.location.href;
        var regexp = 'product/';
        var indexId = str.indexOf(regexp);
        var id = str.slice(indexId + regexp.length);
        var url = rootUrl + "/api/product/" + id;
        var productImageElementId = 'productImageId';
        var descriptionId = 'descriptionId';
        var shoppingCartIconId = 'shoppingcartId';
        $.ajax({
            type: 'get',
            url: url,
            dataType: 'json',
            success: function (data) {
                this._drawProductPage(productImageElementId, descriptionId, shoppingCartIconId, data);
            }.bind(this)
        });
    };

    Product.prototype._drawProductPage = function (productImageElementId, descriptionId, shoppingCartIconId, data) {
        $('#info').html('<p>'
            + '<div class="row">'
            + '<div class="col-md-6">'
            + '<div id="' + productImageElementId + '"></div>'
            + '</div>'
            + '<div class="col-md-6">'
            + '<h1>' + data.name + '</h1>'
            + '<p>'
            + '<h1>' + this._convertRuble(data.price) + '</h1>'
            + '<div id = "' + shoppingCartIconId + '"></div>'
            // + "<img src='/images/shopping_cart/add.png' class='img-responsive' alt=data.name>"
            + '<p>'
            + '<p>'
            + '<p>'
            + '<div id="' + descriptionId + '"></div>'
            + '</div>');
        this._drawTitle(data);
        this._drawProductImage(productImageElementId, data);
        this._drawDescription(descriptionId, data);
        this._addProductCell(shoppingCartIconId, data);
    };

    Product.prototype._drawProductImage = function (productImageElementId, data) {
        if (data && data.id) {
            try {
                $.get(rootUrl + '/images/product/' + data.id + '.jpg').then(
                    function () {
                        $('#' + productImageElementId).html('<img src="' + rootUrl + '/images/product/' + data.id + '.jpg" class="img-thumbnail" alt="' + data.name + '">');
                    },
                    function () {
                        $('#' + productImageElementId).html('<img src="' + rootUrl + '/images/product/pain.png" class="img-thumbnail" alt="Изображение товара отсутствует">');
                    }
                );
            } catch (err) {
            }
        }
    };

    Product.prototype._addProductCell = function (shoppingCartIconId, data) {
        var iconId = 'iconId';
        $('#' + shoppingCartIconId).html("<img src='" + rootUrl + "/images/shopping_cart/add.png' id = " + iconId + " class='img-responsive' width='50px' height='50px' >");
        $('#' + iconId).bind("click", function () {
            this._addProductInShoppingCart.apply(this, [data, 1])
        }.bind(this));
    };

    Product.prototype._addProductInShoppingCart = function (data, count) {
        $.ajax({
            url: rootUrl + '/api/shoppingcart/',
            type: 'PUT',
            contentType: "application/json",
            data: JSON.stringify({'id': data.id, 'count': count}),
            success: function () {
                $.jGrowl(data.name + ' добавлен в корзину!', {life: 1500, theme: 'success', position: 'bottom-right'});
                require(['pages/CostShoppingCart'], function (CostShoppingCart) {
                    var navigationMenuCost = new CostShoppingCart();
                    navigationMenuCost.draw();
                });
            }.bind(this),
            error: function () {
                $.jGrowl(data.name + ' не добавлен :(', {life: 3000, theme: 'error', position: 'bottom-right'});
            }.bind(this)
        });

    };

    Product.prototype._drawTitle = function (data) {
        $('#title').append(data.name);
    };

    Product.prototype._convertRuble = function (num) {
        var p = num.toFixed(2).split(".");
        return p[0].split("").reverse().reduce(function (acc, num, i, orig) {
            return num === "-" ? acc : num + (i && !(i % 3) ? " " : "") + acc;
        }, "") + "," + p[1] + '&#8381';
    };

    Product.prototype._drawDescription = function (descriptionId, data) {
        if (data && data.description) $('#' + descriptionId).html(data.description)
        else $('#' + descriptionId).html('');
    };


    return Product;
});