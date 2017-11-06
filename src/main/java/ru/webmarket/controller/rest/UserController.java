package ru.webmarket.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.webmarket.model.dto.UserDTO;
import ru.webmarket.service.impl.UserServiceImpl;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDTO getUser(@PathVariable("id") Long id) {

        return userService.get(id);
    }
}
