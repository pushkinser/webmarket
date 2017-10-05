package ru.webmarket.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.webmarket.AppTest;
import ru.webmarket.entity.dto.ProductDTO;
import ru.webmarket.service.impl.ProductServiceImpl;

import java.util.List;

public class ProductServiceTest extends AppTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void shouldGetAllProduct() {
        List<ProductDTO> productDTOS = productService.getAllProduct();
        for (ProductDTO productDTO: productDTOS) {
            Assert.assertNotNull(productDTO);
        }
    }


}
