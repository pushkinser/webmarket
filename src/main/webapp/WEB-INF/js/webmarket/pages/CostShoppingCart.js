define('pages/CostShoppingCart',
    ['jquery', 'bootstrap', 'jgrowl', 'require-css!datatables-css', 'require-css!tables-css','require-css!bootstrap-css', 'require-css!jgrowl-css', 'require-css!growl-css',  'domReady!WEB-INF/js/webmarket/pages/CostShoppingCart'],
    function () {

        function CostShoppingCart(options) {
            this.shoppingCartCostElementId = 'shoppingCartCost';
            $.extend(this, options);
        }


        CostShoppingCart.prototype.draw = function () {
            $.ajax({
                url: '/api/shoppingcart/total/',
                type: 'GET',
                success: function (data) {
                    $('#' + this.shoppingCartCostElementId).html(data);
                    // $(td).bind("click", function () { this._addProductInShoppingCart.apply(this, [cellData, 1])}.bind(this));
                }.bind(this)
            });

            // $(td).html("<img src='/images/shopping_cart/add.png' class='img-responsive' alt=" + cellData.name + " width='50px' height='50px' >");
            // $(td).bind("click", function () { this._addProductInShoppingCart.apply(this, [cellData, 1])}.bind(this));
        };



        return CostShoppingCart;
    });