define('pages/AddProduct',
    ['jquery', 'bootstrap', 'jgrowl', 'require-css!datatables-css', 'require-css!bootstrap-css', 'require-css!jgrowl-css', 'require-css!growl-css'],
    function () {

        function AddProduct(options) {
            $.extend(this, options);
        }


        AddProduct.prototype.draw = function () {
            var $formId = $('#' + this.formId);
            $formId.html('<p>' +
                '<div class="form-group">' +
                ' <label for="inputProductName">Название продукта*</label>' +
                ' <input type="text" class="form-control" id="inputProductName" placeholder="Введите название продукта">' +
                ' </div>' +
                '<div class="form-group col-md ">' +
                ' <label for="inputPrice">Стоимость*</label>' +
                ' <input type="text" class="form-control" id="inputProductPrise" placeholder="Введите стоимость">' +
                ' </div>' +
                '<div class="form-group col-md ">' +
                ' <label for="inputPrice">Описание</label>' +
                ' <input type="text" class="form-control" id="inputProductPrise" placeholder="Введите описание">' +
                ' </div>'+
                '<div class="form-group col-md ">' +
                '<label for="inputPrice">Загрузить изображение товара</label>'+
                '<input type="file" data-filename-placement="inside">'+
                ' </div>'+
                '<button type="button" class="btn btn-lg btn-primary ">Добавить</button>');
        };


        return AddProduct;
    });