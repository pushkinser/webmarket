define('pages/ShoppingCart', ['jquery', 'jquery-ui', 'datatables',  'jgrowl', 'require-css!datatables-css', 'require-css!tables-css', 'bootstrap', 'require-css!bootstrap-css', 'require-css!jgrowl-css', 'require-css!growl-css', 'domReady!'], function ($) {

    function ShoppingCart(options) {
        $.extend(this, options);
    }

    var table = $('#' + this.shoppingCartTableElementId).DataTable();

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
                    'render': function () {
                        return 0;
                    },
                    'createdCell': this._priseCellConvertRuble
                },
                {
                    'data': null,
                    'render': function (data) {
                        return '<input id="spinner" type="number" value="'+data.count+'">';
                    },
                    'createdCell': this._productCellCountSpinner
                },
                {
                    'data': null,
                    'searchable': false,
                    'sortable': false,
                    'createdCell': this._productCellDelete.bind(this)
                }
            ],
            "deferRender": true,
            "oLanguage": {
                "sProcessing": "Подождите...",
                "sLengthMenu": "Показать _MENU_ позиций",
                "sZeroRecords": "Записи отсутствуют.",
                "sInfo": "Записи с _START_ до _END_ из _TOTAL_ записей",
                "sInfoEmpty": "Записи с 0 до 0 из 0 записей",
                "sInfoFiltered": "(отфильтровано из _MAX_ записей)",
                "sInfoPostFix": "",
                "sSearch": "Поиск:",
                "sUrl": "",
                "oPaginate": {
                    "sFirst": "Первая",
                    "sPrevious": "Назад",
                    "sNext": "Вперед",
                    "sLast": "Последняя"
                }
            }
        });

        this._productsCellDelete(this.controlElementId);

    };

    ShoppingCart.prototype._productsCellDelete = function (controlElementId) {
        $('#' + controlElementId).html("Очистить корзину <img src='/images/shopping_cart/remove.png' class='img-responsive' width='50px' height='50px'>");
        $('#' + controlElementId).bind("click", function () {
            this._deleteAllProductFromShoppingCart();
        }.bind(this));

    };

    ShoppingCart.prototype._deleteAllProductFromShoppingCart = function () {
        $.ajax({
            url: '/api/shoppingcart/',
            type: 'DELETE',
            contentType: "application/json",
            data: JSON.stringify({'flag': true}),
            success: function () {
                table.clear();
                table.draw();
            }
        }).then(function() {
            $.jGrowl('Корзина очищена', {life:1500, theme: 'success'});
            require(['pages/CostShoppingCart'], function (CostShoppingCart) {
                var navigationMenuCost = new CostShoppingCart();
                navigationMenuCost.draw();
            });
        }, function () {
            $.jGrowl('Не очищена', { life:3000, theme: 'error'});
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

    ShoppingCart.prototype._priseCellConvertRuble = function (td, cellData) {
        var num = cellData.product.price;
        var p = num.toFixed(2).split(".");
        var res = p[0].split("").reverse().reduce(function (acc, num, i, orig) {
            return num == "-" ? acc : num + (i && !(i % 3) ? " " : "") + acc;
        }, "") + "," + p[1] + '&#8381 ';
        $(td).html(res);
    };

    ShoppingCart.prototype._productCellDelete = function (td, cellData) {
        $(td).html("<img src='/images/shopping_cart/remove.png' class='img-responsive' width='50px' height='50px' alt=" + cellData.product.name + "'>");
        $(td).bind("click", function () {
            this._deleteProductFromShoppingCart.apply(this, [cellData, td])
        }.bind(this));

    };

    ShoppingCart.prototype._deleteProductFromShoppingCart = function (cellData, td) {
        $.ajax({
            url: '/api/shoppingcart/',
            type: 'DELETE',
            contentType: "application/json",
            data: JSON.stringify({'id': cellData.id, 'flag': false}),
            success: function () {
                var tr = $(td).parents('tr');
                tr.remove();
                table.draw();
            }
        }).then(function() {
            $.jGrowl(cellData.product.name + ' удален из корзины', {life:1500, theme: 'success'});
            require(['pages/CostShoppingCart'], function (CostShoppingCart) {
                var navigationMenuCost = new CostShoppingCart();
                navigationMenuCost.draw();
            });
        }, function () {
            $.jGrowl(cellData.product.name + ' не удален', { life:3000, theme: 'error'});
        });
    };

    ShoppingCart.prototype._getJson = function (json) {
        return json.order.orderItems;
    };

    ShoppingCart.prototype._productCellCountSpinner = function (td, cellData) {
        var spinnerId = "spinner" + cellData.id;
        $(td).html('<input id=spinnerId  value="'+cellData.count+'" type="number">');
        $(td).bind( function(cellData) {
            var spiner = $('#' + spinnerId).spinner("values", cellData.count);
            spiner.spinner({min : 0})
        });

    };

    return ShoppingCart;
});