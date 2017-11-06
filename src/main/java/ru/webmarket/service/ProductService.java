package ru.webmarket.service;

import ru.webmarket.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO add (ProductDTO productDTO);

    ProductDTO get (Long id);

    List<ProductDTO> getAll ();

}
