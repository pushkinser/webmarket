define('pages/ShoppingCart', ['jquery', 'bootstrap', 'require-css!bootstrap-css', 'domReady!'], function ($) {

    function ShoppingCart(options) {
        this.productsTableElementId = 'info';
        $.extend(this, options);
    }


    ShoppingCart.prototype.draw = function () {

    };

    ShoppingCart.prototype._onImageCellCreated = function (td, cellData) {
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

    return ShoppingCart;
});