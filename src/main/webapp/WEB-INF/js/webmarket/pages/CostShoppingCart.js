define('pages/CostShoppingCart',
    ['jquery', 'bootstrap', 'jgrowl', 'require-css!datatables-css', 'require-css!tables-css','require-css!bootstrap-css', 'require-css!jgrowl-css', 'require-css!growl-css',  'domReady!WEB-INF/js/webmarket/pages/CostShoppingCart'],
    function () {

        function CostShoppingCart(options) {
            // this.shoppingCartCostElementId = 'shoppingCartCost';
            $.extend(this, options);
        }


        CostShoppingCart.prototype.draw = function () {
            $.ajax({
                url: '/api/shoppingcart/total/',
                type: 'GET',
                success: function (data) {
                    $('#' + this.shoppingCartCostElementId).html('<div style= "text-align: center;">'+this._costConvertRuble(data)+'</div>');
                }.bind(this)
            });
        };

        CostShoppingCart.prototype._costConvertRuble = function (data) {
            var num = data;
            var p = num.toFixed(2).split(".");
            var res = p[0].split("").reverse().reduce(function (acc, num, i, orig) {
                return num == "-" ? acc : num + (i && !(i % 3) ? " " : "") + acc;
            }, "") + "," + p[1] + '&#8381 ';
           return res;
        };



        return CostShoppingCart;
    });