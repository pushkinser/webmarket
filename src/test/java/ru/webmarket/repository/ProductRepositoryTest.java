package ru.webmarket.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.webmarket.AppTest;

public class ProductRepositoryTest extends AppTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void shouldGetAllProducts () {
        Assert.assertNotNull(productRepository.findAll());
    }

    @Test
    public void shouldSomeThing () {

    }

}
