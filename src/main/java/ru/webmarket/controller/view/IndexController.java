package ru.webmarket.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.webmarket.model.dto.UserDTO;
import ru.webmarket.model.entity.User;
import ru.webmarket.model.mapper.UserMap;
import ru.webmarket.security.SecurityUtils;
import ru.webmarket.security.UserDetailsManager;

import javax.servlet.ServletContext;
import java.security.Principal;

@Controller
public class IndexController {

    private final UserDetailsManager userDetailsManager;

    private final ServletContext rootApplicationContext;

    @Autowired
    public IndexController(UserDetailsManager userDetailsManager, ServletContext rootApplicationContext) {
        this.userDetailsManager = userDetailsManager;
        this.rootApplicationContext = rootApplicationContext;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN", "ROLE_CUSTOMER", "ROLE_SELLER"})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("products", SecurityUtils.getAuthInfo());
        modelAndView.addObject("root", rootApplicationContext.getContextPath());
        return modelAndView;
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accessDenied(Principal user) {
        ModelAndView model = new ModelAndView("403");

        if (user != null) {
            model.addObject("username", user.getName());

            UserDetails userDetails = userDetailsManager.loadUserByUsername(user.getName());
            UserDTO userDTO = UserMap.toDto((User) userDetails);
            model.addObject("roles", userDTO.getRoles());
        }
        return model;
    }
}
