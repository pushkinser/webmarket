define('pages/ShoppingCart', ['jquery', 'datatables', 'require-css!datatables-css', 'require-css!tables-css', 'bootstrap', 'require-css!bootstrap-css', 'domReady!'], function ($) {

    function ShoppingCart(options) {
        $.extend(this, options);
    }

    ShoppingCart.prototype.draw = function () {
        $('#' + this.shoppingCartTableElementId).DataTable({
            'ajax': {'url': '/api/shoppingcart/', 'dataSrc': this._a},
            'columns': [
                {
                    'data': null,
                    'searchable': false,
                    'sortable': false,
                    'render': function () {
                        return '<img src="/images/product/loader.gif" class="img-circle" alt="Изображение товара отсутствует" width="100px" height="100px" >';
                    },
                    'createdCell': this._onImageCellCreated
                },
                {
                    'data': null,
                    'render': function (data) {
                        return '<a href="/product/' + data.productId + '/">' + data.product.name + '</a>';
                    }
                },
                {
                    'data': null,
                    'render': function() {
                        return 0;
                    },
                    'createdCell': this._priseCellConvertRuble
                },
                {
                    'data': 'count'
                }
            ],
            "deferRender": true
        });
    };

    ShoppingCart.prototype._onImageCellCreated = function (td, cellData) {
        if (cellData && cellData.productId) {
            try {
                $.get('/images/product/' + cellData.productId + '.jpg').then(
                    function () {
                        $(td).html('<img src="/images/product/' + cellData.productId + '.jpg" class="img-circle" alt="image" width="100px" height="100px" >');
                    },
                    function () {
                        $(td).html('<img src="/images/product/pain.png" class="img-circle" alt="Изображение товара отсутствует" width="100px" height="100px" >');
                    }
                );
            } catch (err) {
            }
        }
    };

    ShoppingCart.prototype._priseCellConvertRuble  = function (td, cellData) {
        var num = cellData.product.price;
        var p = num.toFixed(2).split(".");
        var res =  p[0].split("").reverse().reduce(function(acc, num, i, orig) {
            return  num=="-" ? acc : num + (i && !(i % 3) ? " " : "") + acc;
        }, "") + "," + p[1] + '&#8381 ';
        $(td).html(res);
    };

    ShoppingCart.prototype._a  = function (json) {
        return json.order.orderItems;
    };

    return ShoppingCart;
});