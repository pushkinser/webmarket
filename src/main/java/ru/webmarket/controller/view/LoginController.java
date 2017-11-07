package ru.webmarket.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.webmarket.model.dto.UserDTO;
import ru.webmarket.security.SecurityUtils;
import ru.webmarket.service.impl.RoleServiceImpl;
import ru.webmarket.service.impl.UserServiceImpl;
import ru.webmarket.validator.UserValidator;

import java.util.List;

@Controller
public class LoginController {

    private final UserServiceImpl userService;

    private final UserValidator userValidator;

    @Autowired
    public LoginController(UserServiceImpl userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
        ModelAndView model = new ModelAndView("login");

        if (error != null) {
            model.addObject("error", "Неверное имя пользователя или пароль");

            return model;
        }

        model.addAllObjects(SecurityUtils.getAuthInfo());

        return model;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView("register");

        userValidator.validate(userDTO, bindingResult);

        if (bindingResult.hasErrors()) {

            List<FieldError> errors = bindingResult.getFieldErrors();

            for (FieldError error : errors ) {
                System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
                modelAndView.addObject("error", error.getDefaultMessage());
            }

            return modelAndView;
        }

        userService.register(userDTO);

        return new ModelAndView("redirect:/", SecurityUtils.getAuthInfo());
    }
}
