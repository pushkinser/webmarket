package ru.webmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.webmarket.entity.dto.OrderDTO;
import ru.webmarket.entity.dto.ShoppingCartDTO;
import ru.webmarket.entity.dto.UserDTO;
import ru.webmarket.service.impl.UserServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/{id}")
    public UserDTO getUser(@PathVariable("id") String id) {
        UserDTO userDTO;
        Long longId = Long.parseLong(id, 10);
        userDTO = userService.getUser(longId);
        return userDTO;
    }

    @RequestMapping("/all")
    public List<UserDTO> getUsers() {
        List<UserDTO> userDTOS;
        userDTOS = userService.getAllUsers();

        return userDTOS;
    }

    @RequestMapping(value = "/create/{username}/{name}/{lastname}/{email}/{password}", method = RequestMethod.POST)
    public void addUser(@PathVariable("username") String username,
                        @PathVariable("name") String name,
                        @PathVariable("lastname") String lastname,
                        @PathVariable("email") String email,
                        @PathVariable("password") String password) {
        UserDTO userDTO = new UserDTO(username, name, lastname, email, password);
        userService.addUser(userDTO);
    }

    @RequestMapping(value = "/update/{id}/{username}/{name}/{lastname}/{email}/{password}", method = RequestMethod.POST)
    public void updateUser(@PathVariable("id") String id,
                           @PathVariable("username") String username,
                           @PathVariable("name") String name,
                           @PathVariable("lastname") String lastname,
                           @PathVariable("email") String email,
                           @PathVariable("password") String password) {
        Long longId = Long.parseLong(id, 10);
        UserDTO userDTO = new UserDTO(longId, username, name, lastname, email, password);
        userService.editUser(userDTO);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") String id) {
        Long longId = Long.parseLong(id, 10);
        userService.deleteUser(longId);
    }


//    @RequestMapping(value = "shoppingcart/{id}", method = RequestMethod.GET)
//    public ShoppingCartDTO getUserShoppingCart(@PathVariable("id") String id) {
//        Long longId = Long.parseLong(id, 10);
//        ShoppingCartDTO shoppingCartDTO = userService.getShoppingCart(longId);
//
//        return shoppingCartDTO;
//    }
//
//    @RequestMapping(value = "orders/{id}", method = RequestMethod.GET)
//    public List<OrderDTO> gerUserOrders(@PathVariable("id") String id) {
//        Long longId = Long.parseLong(id, 10);
//        List<OrderDTO> orderDTOS = userService.getOrders(longId);
//
//        return orderDTOS;
//    }
}
