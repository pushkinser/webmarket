package ru.webmarket.controller.view;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.webmarket.security.SecurityUtils;

@Secured({"ROLE_ADMIN", "ROLE_CUSTOMER"})
@Controller
public class ShoppingCartViewController {

    @RequestMapping(value = "/bag/{id}", method = RequestMethod.GET)
    public ModelAndView getItems(@PathVariable("id") Long id) {

        return new ModelAndView("shoppingcart", SecurityUtils.getAuthInfo());
    }



}
