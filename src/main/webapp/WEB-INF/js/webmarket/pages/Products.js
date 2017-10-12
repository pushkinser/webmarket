// TODO: comments & jsdoc
// TODO: strict
// TODO: find out why jquery functions aren't recognized properly by Idea when imported by requirejs
// TODO: remove inlined styles
// TODO: find out how to handle sourcemaps properly

define('pages/Products', ['jquery', 'datatables', 'require-css!datatables-css', 'require-css!tables-css', 'bootstrap', 'require-css!bootstrap-css', 'domReady!'], function ($) {

    function Products(options) {
        this.productsTableElementId = 'info';
        $.extend(this, options);
    }

    Products.prototype.draw = function () {
        $('#' + this.productsTableElementId).DataTable({
            'ajax': {'url': '/api/product/', 'dataSrc': ''},
            'columns': [
                {
                    'data': null,
                    'searchable': false,
                    'sortable': false,
                    'render': function () {
                        return '<img src="/images/product/loader.gif" class="img-circle" alt="Изображение товара отсутствует" width="100px" height="100px" >';
                    },
                    'createdCell': this._onImageCellCreated
                    //    TODO: переделать c cell на render
                },
                {
                    'data': null,
                    'render': function (data) {
                        return '<a href="/product/' + data.id + '/">' + data.name + '</a>';
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
                        return "<img src='/images/shopping_cart/add.png' class='img-responsive' alt=data.name onclick='productsPage.addProductInShoppingCart(" + data.id + ")'>";
                    },
                    'searchable': false,
                    'sortable': false
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

    Products.prototype._onImageCellCreated = function (td, cellData) {
        if (cellData && cellData.id) {
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

    Products.addProductInShoppingCart = function (id) {
        // $.ajax({
        //     type: 'PUT',
        //     data: id,
        //     // success: function() { ... },
        //     // error: function(){ ... },
        //     url: '/api/shoppingcat/',
        //     cache:false
        // });
        console.log('Добавляем ');
    };

    Products.prototype._priseCellConvertRuble = function (td, cellData) {
        var num = cellData.price;
        var p = num.toFixed(2).split(".");
        var res = p[0].split("").reverse().reduce(function (acc, num, i, orig) {
            return num == "-" ? acc : num + (i && !(i % 3) ? " " : "") + acc;
        }, "") + "," + p[1] + '&#8381 ';
        $(td).html(res);
    };

    return Products;
});