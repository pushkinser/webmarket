package ru.webmarket.repository;

import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.webmarket.AppTest;
import ru.webmarket.configuration.Persistence;
import ru.webmarket.entity.ShoppingCart;
import ru.webmarket.repository.ShoppingCartRepository;

public class ShoppingCartRepositoryTest extends AppTest {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Test
    public void shouldGetOrdes () {
        Assert.assertNotNull(shoppingCartRepository.findAll());
    }
}
