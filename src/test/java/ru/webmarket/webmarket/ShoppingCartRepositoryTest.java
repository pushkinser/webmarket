package ru.webmarket.webmarket;

import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.webmarket.configuration.Persistence;
import ru.webmarket.entity.ShoppingCart;
import ru.webmarket.repository.ShoppingCartRepository;

public class ShoppingCartRepositoryTest {

    private static ShoppingCartRepository shoppingCartRepository;

    @BeforeClass
    public static void setup (){
        BasicConfigurator.configure();
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Persistence.class);
        shoppingCartRepository = ctx.getBean(ShoppingCartRepository.class);
    }

    @Test
    public void shouldGetOrdes () {
        Iterable<ShoppingCart> allShoppingcart = shoppingCartRepository.findAll();
        for (ShoppingCart shoppingCart: allShoppingcart) {
            System.out.println();
        }
        Assert.assertNotNull(allShoppingcart);
        Assert.assertTrue(allShoppingcart.iterator().hasNext());

    }
}
