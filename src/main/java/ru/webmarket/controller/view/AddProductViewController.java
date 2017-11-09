package ru.webmarket.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.webmarket.security.SecurityUtils;

import javax.servlet.ServletContext;

@Secured({"ROLE_ADMIN", "ROLE_SELLER"})
@Controller
public class AddProductViewController {

    private final ServletContext rootApplicationContext;

    @Autowired
    public AddProductViewController(ServletContext rootApplicationContext) {
        this.rootApplicationContext = rootApplicationContext;
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.GET)
    public ModelAndView getFormForAddProduct() {
        ModelAndView model = new ModelAndView("addproduct", SecurityUtils.getAuthInfo());
        model.addObject("root", rootApplicationContext.getContextPath());
        return model;
    }

}