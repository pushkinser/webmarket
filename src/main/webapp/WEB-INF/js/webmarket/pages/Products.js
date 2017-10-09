define('pages/Products', ['jquery', 'datatables', 'require-css!datatables-css', 'bootstrap', 'require-css!bootstrap-css', 'domReady!'], function ($) {

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
                        return '<img src="/images/product/default_item.jpg" class="img-circle" alt="Изображение товара отсутствует" width="100px" height="100px" >';
                    },
                    'createdCell': function (td, cellData) {
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
                            } catch (err){}
                        }
                    }
                },
                {
                    'data': null,
                    'render': function (data) {
                        return '<a href="/product/' + data.id + '/">' + data.name + '</a>';
                    }
                },
                {'data': 'price'},
                {
                    'defaultContent': "<img src='/images/shopping_cart/add.png' class='img-responsive' alt=data.name>",
                    'searchable': false,
                    'sortable': false
                }
            ],
            "deferRender": true
        });
    };

    return Products;
});