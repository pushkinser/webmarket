define('pages/Orders', ['jquery', 'jquery-ui', 'datatables', 'jgrowl', 'require-css!datatables-css', 'require-css!tables-css', 'bootstrap', 'require-css!bootstrap-css', 'require-css!jgrowl-css', 'require-css!growl-css', 'domReady!'],
    function ($) {

        function Orders(options) {
            $.extend(this, options);
        }

        Orders.prototype.draw = function () {

            $.ajax({
                url: '/api/order/get',
                type: 'GET',
                success: function (data) {

                    if (data.length == 0) $('#' + this.ordersControlId).append('<h4> У вас нет заказов.</h4>');

                    var elementId;
                    for (var i = 0; i < data.length; i++) {
                        elementId = data[i].id;
                        $('#' + this.ordersControlId).append('<div class="order' + elementId + '"> '+
                            '<h4>Заказ №'+ elementId + '</h4>' +
                            '<table id="table'+elementId+'" cellspacing="0" width="100%">' +
                            '<thead>' +
                            '<tr>' +
                            '<th></th>' +
                            '<th></th>' +
                            '<th></th>' +
                            '</tr>' +
                            '</thead>' +
                            '</table>' +
                            '</div><p>');
                    }
                    var orderClassName;
                    var orderTableId;
                    var postfix;
                    for (var i = 0; i < data.length; i++) {
                        postfix = data[i].id;
                        orderClassName = 'div.order' + postfix;
                        orderTableId = '#table'+postfix;

                        $('#' + this.ordersControlId).children(orderClassName).children(orderTableId).DataTable({
                            'data' : data[i].orderItem,
                            'columns': [
                                {
                                    'data': null,
                                    'render': function (data) {
                                        return '<a href="/product/' + data.product.id + '/">' + data.product.name + '</a>';
                                    }
                                },
                                {
                                    'data' : 'count'
                                },
                                {
                                    'data': null,
                                    'render': function () {
                                        return 0;
                                    },
                                    'createdCell': this._priseCellConvertRuble,
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



                        $('#' + this.ordersControlId).children(orderClassName)
                            .append('<div style= "text-align:right;"> ' +
                                '<h4> Стоимость заказа: '+ this._costConvertRuble(data[i].prise) +'</h4><p>'+
                            '<h4> Адрес: '+data[i].address + '</h4></div>');
                    }


                }.bind(this)
            });

        };

        Orders.prototype._priseCellConvertRuble = function (td, cellData) {
            var num = cellData.product.price*cellData.count;
            var p = num.toFixed(2).split(".");
            var res = p[0].split("").reverse().reduce(function (acc, num, i) {
                return num === "-" ? acc : num + (i && !(i % 3) ? " " : "") + acc;
            }, "") + "," + p[1] + '&#8381 ';
            $(td).html(res);
        };

        Orders.prototype._costConvertRuble = function (data) {
            var num = data;
            var p = num.toFixed(2).split(".");
            var res = p[0].split("").reverse().reduce(function (acc, num, i, orig) {
                return num == "-" ? acc : num + (i && !(i % 3) ? " " : "") + acc;
            }, "") + "," + p[1] + '&#8381 ';
            return res;
        };

        return Orders;
    });

