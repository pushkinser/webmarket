package ru.webmarket.repository;

import org.junit.Assert;
import org.junit.Test;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import ru.webmarket.AppTest;
import ru.webmarket.model.entity.Order;
import ru.webmarket.model.entity.ShoppingCart;

public class ShoppingCartTest extends AppTest{

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldGetAllShoppingCart() {
        Assert.assertNotNull(shoppingCartRepository.findAll());
    }

//    @Test
//    public void shouldSaveShoppingCartWithEmptyOrder() {
//        ShoppingCart shoppingCart = new ShoppingCart();
//
//        Order order = new Order();
//        order.setUser(userRepository.findOne(119L));
//
//        shoppingCart.setOrder(order);
//
//        ShoppingCart newShoppingCart = shoppingCartRepository.save(shoppingCart);
//        Assert.assertNotNull(newShoppingCart);
//        Assert.assertNotNull(newShoppingCart.getOrder());
//        Assert.assertNotNull(newShoppingCart.getOrder().getUser());
//
//    }

    @Test
    public void emptyTemplateMethod() {

    }
}