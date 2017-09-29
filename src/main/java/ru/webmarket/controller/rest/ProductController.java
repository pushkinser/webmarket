package ru.webmarket.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.webmarket.entity.Category;
import ru.webmarket.entity.Product;
import ru.webmarket.entity.dto.CategoryDTO;
import ru.webmarket.entity.dto.ProductDTO;
import ru.webmarket.repository.CategoryRepository;
import ru.webmarket.service.impl.CategoryServiceImpl;
import ru.webmarket.service.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @RequestMapping("/get")
    public ProductDTO getProduct(Long id) {

        return productService.getProduct(id);
    }

    @RequestMapping("/get/all")
    public List<ProductDTO> getAllProduct() {
        return productService.getAllProduct();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addProduct(ProductDTO productDTO) {

        productService.addProduct(productDTO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateProduct(ProductDTO productDTO) {

        productService.editProduct(productDTO);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteProduct(Long id) {
        productService.deleteProduct(id);
    }


}
