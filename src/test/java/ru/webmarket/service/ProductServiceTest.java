package ru.webmarket.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.webmarket.AppTest;
import ru.webmarket.entity.dto.ProductDTO;
import ru.webmarket.service.impl.ProductServiceImpl;

import java.util.List;
import java.util.Random;

public class ProductServiceTest extends AppTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void shouldGetAllProduct() {
        List<ProductDTO> productDTOS = productService.getProducts();
        for (ProductDTO productDTO: productDTOS) {
            Assert.assertNotNull(productDTO);
        }
    }

    final Random random = new Random();

    @Test
    public void shouldAddAndEditAndDeleteProduct() {
        int r =  random.nextInt();
        ProductDTO productDTO = new ProductDTO( r+"", 500.0, "");
        productService.addProduct(productDTO);
        productDTO = productService.findByName(productDTO.getName());
        productDTO.setName("new name");
        productService.editProduct(productDTO);
        Long prodId = productDTO.getId();
        Assert.assertNotNull(productService.getProduct(prodId));
        Assert.assertNotEquals(r, productService.getProduct(prodId).getName());
        productService.deleteProduct(prodId);
        Assert.assertNull(productService.getProduct(prodId));
    }


}
