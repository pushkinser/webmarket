package ru.webmarket.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.webmarket.entity.dto.ProductDTO;
import ru.webmarket.security.SecurityUtils;
import ru.webmarket.service.impl.ProductServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@Secured({"ROLE_ADMIN", "ROLE_CUSTOMER"})
@Controller
public class ProductViewController {

    @Autowired
    private ProductServiceImpl productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView getItems() {

        return new ModelAndView("products", SecurityUtils.getAuthInfo());
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ModelAndView getItem(@PathVariable("id") long id) {
        return new ModelAndView("product", SecurityUtils.getAuthInfo());
    }
}
