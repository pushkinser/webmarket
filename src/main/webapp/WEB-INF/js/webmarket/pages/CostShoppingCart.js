define('pages/CostShoppingCart',
    ['jquery', 'bootstrap', 'jgrowl', 'require-css!datatables-css', 'require-css!tables-css','require-css!bootstrap-css', 'require-css!jgrowl-css', 'require-css!growl-css',  'domReady!'],
    function () {

        function CostShoppingCart(options) {
            this.shoppingCartCostElementId = 'shoppingCartCost';
            $.extend(this, options);
        }


        CostShoppingCart.prototype.draw = function () {
            $.ajax({
                url: rootUrl + '/api/shoppingcart/total/',
                type: 'GET',
                success: function (data) {
                    $('#' + this.shoppingCartCostElementId).html('<div style= "text-align: center;">'+this._costConvertRuble(data)+'</div>');
                }.bind(this)
            });
        };

        CostShoppingCart.prototype._costConvertRuble = function (data) {
            var p = data.toFixed(2).split(".");
            return p[0].split("").reverse().reduce(function (acc, num, i) {
               return num === "-" ? acc : num + (i && !(i % 3) ? " " : "") + acc;
           }, "") + "," + p[1] + '&#8381 ';
        };



        return CostShoppingCart;
    });