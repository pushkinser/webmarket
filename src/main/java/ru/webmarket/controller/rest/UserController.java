package ru.webmarket.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.webmarket.entity.dto.OrderDTO;
import ru.webmarket.entity.dto.ShoppingCartDTO;
import ru.webmarket.entity.dto.UserDTO;
import ru.webmarket.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

/*
* TODO: addUser и updateUser должны возвращать UserDTO
 */

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/get")
    public UserDTO getUser(Long id) {

        return userService.getUser(id);
    }

    @RequestMapping("/get/all")
    public List<UserDTO> getUsers() {

        return userService.getAllUsers();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUser(UserDTO userDTO) {

        userService.addUser(userDTO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateUser(UserDTO userDTO) {

        userService.editUser(userDTO);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteUser(Long id) {

        userService.deleteUser(id);
    }

}
