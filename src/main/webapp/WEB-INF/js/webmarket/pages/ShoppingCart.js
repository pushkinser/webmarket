define('pages/ShoppingCart', ['jquery', 'datatables', 'require-css!datatables-css', 'require-css!tables-css', 'bootstrap', 'require-css!bootstrap-css', 'domReady!'], function ($) {

    function ShoppingCart(options) {
        $.extend(this, options);
    }

    ShoppingCart.prototype.draw = function () {
        $('#' + this.shoppingCartTableElementId).DataTable({
            'ajax': {'url': '/api/shoppingcart/', 'dataSrc': this._getJson},
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
                        return '<a href="/product/' + data.product.id + '/">' + data.product.name + '</a>';
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
                },
                {
                    'data': null,
                    'searchable': false,
                    'sortable': false,
                    'createdCell': this._a.bind(this)
                }
            ],
            "deferRender": true,
            "oLanguage": {
                "sProcessing":   "Подождите...",
                "sLengthMenu":   "Показать _MENU_ позиций",
                "sZeroRecords":  "Записи отсутствуют.",
                "sInfo":         "Записи с _START_ до _END_ из _TOTAL_ записей",
                "sInfoEmpty":    "Записи с 0 до 0 из 0 записей",
                "sInfoFiltered": "(отфильтровано из _MAX_ записей)",
                "sInfoPostFix":  "",
                "sSearch":       "Поиск:",
                "sUrl":          "",
                "oPaginate": {
                    "sFirst": "Первая",
                    "sPrevious": "Назад",
                    "sNext": "Вперед",
                    "sLast": "Последняя"
                }
            }
        });
    };

    ShoppingCart.prototype._onImageCellCreated = function (td, cellData) {
        if (cellData && cellData.product.id) {
            try {
                $.get('/images/product/' + cellData.product.id + '.jpg').then(
                    function () {
                        $(td).html('<img src="/images/product/' + cellData.product.id + '.jpg" class="img-circle" alt="image" width="100px" height="100px" >');
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

    ShoppingCart.prototype._a = function (td, cellData) {
        $(td).html("<img src='/images/shopping_cart/remove.png' class='img-responsive' width=\"50px\" height=\"50px\" alt=" + cellData.product.name + "'>");
        $(td).bind("click", function () { this._deleteProductFromShoppingCart.apply(this, [cellData.id])}.bind(this));
    };

    ShoppingCart.prototype._deleteProductFromShoppingCart = function (id) {
        $.ajax({
            url: '/api/shoppingcart/',
            type: 'DELETE',
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify({'id': id}),
            success: function() {  }
        });

    };

    ShoppingCart.prototype._getJson  = function (json) {
        return json.order.orderItems;
    };

    return ShoppingCart;
});