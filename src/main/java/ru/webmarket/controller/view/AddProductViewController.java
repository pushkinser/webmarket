package ru.webmarket.controller.view;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.webmarket.security.SecurityUtils;

@Secured({"ROLE_ADMIN", "ROLE_SELLER"})
@Controller
public class AddProductViewController {

    @RequestMapping(value = "/addproduct", method = RequestMethod.GET)
    public ModelAndView getFormForAddProduct() {
        return new ModelAndView("addproduct", SecurityUtils.getAuthInfo());
    }


}
