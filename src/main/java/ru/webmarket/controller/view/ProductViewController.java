package ru.webmarket.controller.view;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.webmarket.security.SecurityUtils;

@Secured({"ROLE_ADMIN", "ROLE_CUSTOMER", "ROLE_SELLER"})
@Controller
public class ProductViewController {

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView getItems() {
        return new ModelAndView("products", SecurityUtils.getAuthInfo());
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ModelAndView getItem(@PathVariable("id") long id) {
        return new ModelAndView("product", SecurityUtils.getAuthInfo());
    }

}
