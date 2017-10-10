package ru.webmarket.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.webmarket.entity.User;
import ru.webmarket.entity.converter.UserConverter;
import ru.webmarket.entity.dto.UserDTO;
import ru.webmarket.security.SecurityUtils;
import ru.webmarket.security.UserDetailsManager;
import ru.webmarket.service.impl.UserServiceImpl;

import java.security.Principal;

@Controller
public class IndexController {

    @Autowired
    private UserDetailsManager userDetailsManager;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN", "ROLE_CUSTOMER"})
    public ModelAndView index() {
        final ModelAndView model = new ModelAndView("products", SecurityUtils.getAuthInfo());

        return model;
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accessDenied(Principal user) {
        ModelAndView model = new ModelAndView("403");

        if (user != null) {
            model.addObject("username", user.getName());

            UserDetails userDetails = userDetailsManager.loadUserByUsername(user.getName());
            UserDTO userDTO = UserConverter.entityToDto((User) userDetails);
           model.addObject("roles", userDTO.getRoles());
        }
        return model;
    }
}
