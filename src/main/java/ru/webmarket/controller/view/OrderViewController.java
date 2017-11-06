package ru.webmarket.controller.view;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.webmarket.security.SecurityUtils;

@Controller
@Secured({"ROLE_ADMIN", "ROLE_CUSTOMER", "ROLE_SELLER"})
public class OrderViewController {

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ModelAndView getOrders() {
        return new ModelAndView("orders", SecurityUtils.getAuthInfo());
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView getOrder() {
        return new ModelAndView("order", SecurityUtils.getAuthInfo());
    }

}