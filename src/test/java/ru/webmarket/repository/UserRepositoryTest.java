package ru.webmarket.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.webmarket.AppTest;
import ru.webmarket.model.entity.Order;
import ru.webmarket.model.entity.ShoppingCart;
import ru.webmarket.model.entity.User;

import java.util.Collections;

public class UserRepositoryTest extends AppTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Test
    public void shouldGetAllUser() {
        Assert.assertNotNull(userRepository.findAll());
    }

    @Test
    public void shouldSaveNewUserWithRole() {

        User user = new User();
        user.setUserName("lol");
        user.setRoles(Collections.singletonList(roleRepository.findByName("CUSTOMER")));
        Assert.assertNotNull(userRepository.save(user).getRoles());

    }

//    @Test
//    public void shouldSaveNewUserWithRoleAndOrder() {
//
//        User user = new User();
//        user.setUserName("lol123");
//
//        Order order = new Order();
//        order.setUser(user);
//
//        user.setOrders(Collections.singletonList(order));
//        user.setRoles(Collections.singletonList(roleRepository.findByName("CUSTOMER")));
//        Assert.assertNotNull(userRepository.save(user).getRoles());
//
//    }

//    @Test
//    public void shouldSaveNewUserWithRoleAndOrderAndShoppingCart() {
//
//        User user = new User();
//        user.setUserName("username");
//
//        Order order = new Order();
//        order.setUser(user);
//
//        ShoppingCart shoppingCart = new ShoppingCart();
//        shoppingCart.setUser(user);
//        shoppingCart.setOrder(order);
//
////        user.setRoles(Collections.singletonList(roleRepository.findByName("CUSTOMER")));
//
//        Assert.assertNotNull(userRepository.save(user).getRoles());
//
//        shoppingCart = shoppingCartRepository.save(shoppingCart);
//
//        Assert.assertNotNull(shoppingCart);
//
////        user.setShoppingCart(shoppingCart);
////        user.setOrders(Collections.singletonList(order));
//
//
//    }
}