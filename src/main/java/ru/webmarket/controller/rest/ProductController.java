package ru.webmarket.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.webmarket.controller.rest.request.ProductBodyJson;
import ru.webmarket.entity.dto.ProductDTO;
import ru.webmarket.service.impl.CategoryServiceImpl;
import ru.webmarket.service.impl.ProductServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductDTO getProduct(@PathVariable("id") Long id) {

        return productService.getProduct(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<ProductDTO> getAllProduct() {

        return productService.getProducts();
    }

    @Secured({"ROLE_ADMIN", "ROLE_SELLER"})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Long addProduct(@RequestBody ProductBodyJson a) {

        ProductDTO productDTO = new ProductDTO(a.getName(), a.getPrice(), a.getDescription());
        Long productId = productService.addProductAndGetId(productDTO);
//        productService.addProduct(productDTO);
        return productId;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void updateProduct(ProductDTO productDTO) {

        productService.editProduct(productDTO);
    }


    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteProduct(Long id) {
        productService.deleteProduct(id);
    }


}
