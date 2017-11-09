package ru.webmarket.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.webmarket.security.SecurityUtils;

import javax.servlet.ServletContext;

@Secured({"ROLE_ADMIN", "ROLE_CUSTOMER", "ROLE_SELLER"})
@Controller
public class ProductViewController {

    private final ServletContext rootApplicationContext;

    @Autowired
    public ProductViewController(ServletContext rootApplicationContext) {
        this.rootApplicationContext = rootApplicationContext;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView getItems() {
        ModelAndView model = new ModelAndView("products", SecurityUtils.getAuthInfo());
        model.addObject("root", rootApplicationContext.getContextPath());
        return model;
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ModelAndView getItem(@PathVariable("id") long id) {
        ModelAndView model = new ModelAndView("product", SecurityUtils.getAuthInfo());
        model.addObject("root", rootApplicationContext.getContextPath());
        return model;
    }

}