package ru.webmarket.controller.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.webmarket.entity.dto.UserDTO;
import ru.webmarket.security.SecurityUtils;
import ru.webmarket.service.impl.RoleServiceImpl;
import ru.webmarket.service.impl.UserServiceImpl;

@Controller
public class LoginController {

    private final UserServiceImpl userService;


    @Autowired
    public LoginController(UserServiceImpl userService, PasswordEncoder passwordEncoder, RoleServiceImpl roleService) {
        this.userService = userService;
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
    public ModelAndView addUSer(@ModelAttribute("user") UserDTO userDTO) {

        userService.addUser(userDTO);

        return new ModelAndView("redirect:/", SecurityUtils.getAuthInfo());
    }
}
