package ru.webmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.webmarket.entity.dto.UserDTO;
import ru.webmarket.service.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

//    @RequestMapping(value = "/{id}")
//    public UserDTO user() {
//        UserDTO userDTO = new UserDTO();
//        userDTO = userService.getUser(1L);
//        return new ModelAndView.((View) userDTO);
//    }


//    @RequestMapping(value = "/profile", method = RequestMethod.GET)
//    public ModelAndView profile() {
//        return new ModelAndView("profile", SecurityUtils.getAuthInfo());
//    }


//    @RequestMapping("/")
//    public Iterable<UserDTO> getUsers() {
//        return userService.getAllUsers();
//    }


//    @RequestMapping("/{id}")
//    public UserDTO getUsers(@PathVariable("id") String id) {
//        UserDTO userDTO;
//        Long longId = Long.parseLong(id, 10);
//        userDTO = userService.getUser(longId);
//        return userDTO.toString();
//    }


    @RequestMapping("/{id}")
    public String getUser(@PathVariable("id") String id) {
        UserDTO userDTO;
        Long longId = Long.parseLong(id, 10);
        userDTO = userService.getUser(longId);
        return userDTO.toString();
    }

    @RequestMapping("/all")
    public String getUsers () {
        List<UserDTO> userDTOS;
        userDTOS = userService.getAllUsers();

        return  userDTOS.toString();
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
        UserDTO userDTO = new UserDTO();
        Long longId = Long.parseLong(id, 10);
        userService.deleteUser(longId);
    }
}
