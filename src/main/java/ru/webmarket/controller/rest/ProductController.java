package ru.webmarket.controller.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.webmarket.controller.rest.request.ProductBodyJson;
import ru.webmarket.model.dto.ProductDTO;
import ru.webmarket.service.impl.ProductServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductDTO getProduct(@PathVariable("id") Long id) {

        return productService.get(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<ProductDTO> getAllProduct() {

        return productService.getAll();
    }

    @Secured({"ROLE_ADMIN", "ROLE_SELLER"})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Long addProduct(@RequestBody ProductBodyJson a) {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(a.getName());
        productDTO.setPrice(a.getPrice());
        productDTO.setDescription(a.getDescription());

        productDTO = productService.add(productDTO);
//        productService.addProduct(productDTO);
        return productDTO.getId();
    }

//    @RequestMapping(value = "/", method = RequestMethod.PUT)
//    public void updateProduct(ProductDTO productDTO) {
//
//        productService.editProduct(productDTO);
//    }


//    @RequestMapping(value = "/", method = RequestMethod.DELETE)
//    public void deleteProduct(Long id) {
//        productService.deleteProduct(id);
//    }


}