define('pages/ShoppingCart', ['jquery', 'datatables', 'bootstrap', 'require-css!bootstrap-css', 'domReady!'], function ($) {

    function ShoppingCart(options) {
        this.productsTableElementId = 'info';
        $.extend(this, options);
    }


    ShoppingCart.prototype.draw = function () {
        $('#' + this.productsTableElementId).DataTable({
            'ajax': {'url': '/api/bag/'+25, 'dataSrc': ''},
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
                        return '<a href="/product/' + data.order.orderItems.productDTO.id + '/">' + data.order.orderItems.productDTO.name + '</a>';
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
                    'data': 'order.orderItems.count'
                }
            ],
            "deferRender": true
        });
    };

    ShoppingCart.prototype._onImageCellCreated = function (td, cellData) {
        if (cellData && cellData.order.orderItems.productDTO.id) {
            try {
                $.get('/images/product/' + cellData.id + '.jpg').then(
                    function () {
                        $(td).html('<img src="/images/product/' + cellData.id + '.jpg" class="img-circle" alt="image" width="100px" height="100px" >');
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
        var num = cellData.order.orderItems.productDTO.price;
        var p = num.toFixed(2).split(".");
        var res =  p[0].split("").reverse().reduce(function(acc, num, i, orig) {
            return  num=="-" ? acc : num + (i && !(i % 3) ? " " : "") + acc;
        }, "") + "," + p[1] + '&#8381 ';
        $(td).html(res);
    };

    return ShoppingCart;
});