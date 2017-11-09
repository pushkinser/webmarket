package ru.webmarket.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.webmarket.security.SecurityUtils;

import javax.servlet.ServletContext;

@Controller
@Secured({"ROLE_ADMIN", "ROLE_CUSTOMER", "ROLE_SELLER"})
public class OrderViewController {

    private final ServletContext rootApplicationContext;

    @Autowired
    public OrderViewController(ServletContext rootApplicationContext) {
        this.rootApplicationContext = rootApplicationContext;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ModelAndView getOrders() {
        ModelAndView model = new ModelAndView("orders", SecurityUtils.getAuthInfo());
        model.addObject("root", rootApplicationContext.getContextPath());
        return model;
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView getOrder() {
        ModelAndView model = new ModelAndView("order", SecurityUtils.getAuthInfo());
        model.addObject("root", rootApplicationContext.getContextPath());
        return model;
    }

}