define('pages/Order', ['jquery', 'jquery-ui', 'datatables', 'jgrowl', 'require-css!datatables-css', 'require-css!tables-css', 'bootstrap', 'require-css!bootstrap-css', 'require-css!jgrowl-css', 'require-css!growl-css', 'domReady!'],
    function () {

        function Order(options) {
            $.extend(this, options);
        }

        Order.prototype.draw = function () {
            $('#' + this.orderTableElementId).DataTable({
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
                        'data': 'count',
                        'searchable': false,
                        'sortable': false
                    }
                ],
                "searching": false,
                "paging": false,
                "info": false,
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

            this._orderDrawControl(this.orderControlId);
        };

        Order.prototype._orderDrawControl = function (controlElementId) {
            var controlId = $('#' + controlElementId);

            $.ajax({
                url: '/api/shoppingcart/total/',
                type: 'GET',
                async: false,
                success: function (data) {
                    controlId.append('<div style= "text-align:right;  "><h1>'+"Стоимость заказа "+this._costConvertRuble(data)+'</h1></div>');
                }.bind(this)
            });


            controlId.append('<label for="addressId">Введите адрес доставки:</label>' +
                '<input type="address" class="form-control" id="addressId"  placeholder="Адрес">'+
                '<button type="button" class="btn btn-primary">Закаказть</button>');

            controlId.children('button').bind("click", function () {
                $.jGrowl('yep ' + controlId.children('input').val(), {life: 3000, theme: 'success', position: 'bottom-right'});

                $.ajax({
                    url: '/api/order/complete',
                    type: 'POST',
                    contentType: "application/json",
                    data: JSON.stringify({'address': controlId.children('input').val()}),
                    success: function () {

                        $tableId = $('#info');
                        $tableId.DataTable().clear();
                        $tableId.DataTable().draw();

                        require(['pages/CostShoppingCart'], function (CostShoppingCart) {
                            var navigationMenuCost = new CostShoppingCart();
                            navigationMenuCost.draw();
                        });

                        $.jGrowl('yep  ' +  controlId.children('input').val(), {
                            life: 600,
                            position: 'bottom-right',
                            theme: 'success'
                        });

                        $(window).attr('location','/');
                    }
                });

            }.bind(this));

            // $controlId.children('btn').bind("click", function () {
            //     this._();
            // }.bind(this));
            // $controlId.append(" Оформить заказ <a href='/order'><img src='/images/shopping_cart/stores.png' class='img-responsive' width='50px' height='50px'></a>");
        };


        Order.prototype._costConvertRuble = function (data) {
            var num = data;
            var p = num.toFixed(2).split(".");
            var res = p[0].split("").reverse().reduce(function (acc, num, i, orig) {
                return num == "-" ? acc : num + (i && !(i % 3) ? " " : "") + acc;
            }, "") + "," + p[1] + '&#8381 ';
            return res;
        };


        Order.prototype._onImageCellCreated = function (td, cellData) {
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

        Order.prototype._priseCellConvertRuble = function (td, cellData) {
            var num = cellData.product.price;
            var p = num.toFixed(2).split(".");
            var res = p[0].split("").reverse().reduce(function (acc, num, i) {
                return num === "-" ? acc : num + (i && !(i % 3) ? " " : "") + acc;
            }, "") + "," + p[1] + '&#8381 ';
            $(td).html(res);
        };

        Order.prototype._getJson = function (json) {
            return json;
        };

        return Order;
    });
