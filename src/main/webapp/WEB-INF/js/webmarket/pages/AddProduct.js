define('pages/AddProduct',
    ['jquery', 'bootstrap', 'jgrowl', 'require-css!datatables-css', 'require-css!bootstrap-css', 'require-css!jgrowl-css', 'require-css!growl-css'],
    function () {

        function AddProduct(options) {
            $.extend(this, options);
        }


        AddProduct.prototype.draw = function () {
            var productNameId = 'inputName';
            var productPriceId = 'inputPrice';
            var productDescriptionId = 'inputDescription';
            var productImageLoadId = 'inputImage';
            var buttonAddProductId = 'btnAddProduct';

            this._drawAddProductPage(productNameId, productPriceId, productDescriptionId, productImageLoadId, buttonAddProductId);
        };

        AddProduct.prototype._drawAddProductPage = function (productNameId, productPriceId, productDescriptionId, productImageLoadId, buttonAddProductId) {
            var $formId = $('#' + this.formId);
            $formId.html('<p>' +
                '<div class="form-group">' +
                '<label for="inputProductName">Название продукта</label>' +
                '<input type="text" class="form-control" id="' + productNameId + '" placeholder="Введите название продукта">' +
                '</div>' +
                '<div class="form-group col-md ">' +
                '<label for="inputPrice">Стоимость</label>' +
                '<input type="text" class="form-control" id="' + productPriceId + '" value="0">' +
                '</div>' +
                '<div class="form-group col-md ">' +
                '<label for="inputDescription">Описание</label>' +
                '<input type="text" class="form-control" id="' + productDescriptionId + '" placeholder="Введите описание">' +
                '</div>' +
                '<div class="form-group col-md ">' +
                '<label for="inputImg">Загрузить изображение товара</label>' +
                '<input type="file" id="' + productImageLoadId + '" data-filename-placement="inside" >' +
                '</div>' +
                '<button type="button" id="' + buttonAddProductId + '" class="btn btn-lg btn-primary ">Добавить</button>');

            var priceInputElement = $('#' + productPriceId);

            var priceInput = $(priceInputElement);
            priceInput.bind("blur", function () {
                if (isNaN(parseFloat(priceInput.val()))) {
                    $.jGrowl('Некорректный ввод', {life: 3000, position: 'bottom-right', theme: 'error'});
                    priceInput.val(0);
                    priceInput.change();
                }
            });

            $('#' + buttonAddProductId).bind("click", function () {
                const name = $('#' + productNameId).val();
                const price = priceInput.val();
                const description = $('#' + productDescriptionId).val();

                var data = [name, price, description];

                this._addNewProduct.apply(this, [data]);

            }.bind(this));
        };


        AddProduct.prototype._addNewProduct = function (data) {
            const pName = data[0];
            const pPrice = data[1];
            const pDescription = data[2];

            $.ajax({
                url: '/api/product/',
                type: 'POST',
                contentType: "application/json",
                data: JSON.stringify({'name': pName, 'price': pPrice, 'description': pDescription}),
                success: function () {
                    $.jGrowl(pName + ' добавлен в каталог', {life: 1500, theme: 'success', position: 'bottom-right'});
                    require(['pages/CostShoppingCart'], function (CostShoppingCart) {
                        var navigationMenuCost = new CostShoppingCart();
                        navigationMenuCost.draw();
                    });
                }.bind(this),
                error: function () {
                    $.jGrowl(pName + ' не добавлен :(', {life: 3000, theme: 'error', position: 'bottom-right'});
                }.bind(this)
            });

        };

        return AddProduct;
    });