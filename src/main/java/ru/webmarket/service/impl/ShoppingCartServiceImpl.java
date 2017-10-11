package ru.webmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webmarket.entity.converter.OrderItemConverter;
import ru.webmarket.entity.converter.ProductConverter;
import ru.webmarket.entity.converter.ShoppingCartConverter;
import ru.webmarket.entity.dto.OrderItemDTO;
import ru.webmarket.entity.dto.ProductDTO;
import ru.webmarket.entity.dto.ShoppingCartDTO;
import ru.webmarket.repository.*;
import ru.webmarket.service.ShoppingCartService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {


    private final ShoppingCartRepository shoppingCartRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, OrderRepository orderRepository, OrderItemRepository orderItemRepository, ProductRepository productRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void addShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        if (shoppingCartDTO == null) throw new NullPointerException();
        shoppingCartRepository.save(ShoppingCartConverter.dtoToEntity(shoppingCartDTO));
    }

    @Override
    public List<ShoppingCartDTO> getShoppingCarts() {
        return ShoppingCartConverter.entityToDto(shoppingCartRepository.findAll());
    }

    @Override
    public ShoppingCartDTO getShoppingCart(Long id) {
        return ShoppingCartConverter.entityToDto(shoppingCartRepository.findOne(id));
    }

    @Override
    public ShoppingCartDTO getShoppingCartByUserId(Long id) {
        return ShoppingCartConverter.entityToDto(shoppingCartRepository.findByUser_Id(id));
    }

    @Override
    public void editShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        if (shoppingCartDTO == null) throw new NullPointerException();
        if (shoppingCartRepository.findOne(shoppingCartDTO.getId()) != null)
            shoppingCartRepository.save(ShoppingCartConverter.dtoToEntity(shoppingCartDTO));
    }

    // Можно сделать через editShoppingCart
    @Override
    public void addProduct(ShoppingCartDTO shoppingCartDTO, ProductDTO productDTO) {
        shoppingCartDTO.getOrder().addOrderItemDTO(new OrderItemDTO(productDTO));
        editShoppingCart(shoppingCartDTO);
//        OrderDTO orderDTO = OrderConverter.entityToDto(orderRepository.getOne(shoppingCartDTO.getOrder().getId()));
//        orderDTO.addOrderItemDTO(new OrderItemDTO(productDTO, count));
//        orderRepository.save(OrderConverter.dtoToEntity(orderDTO));
//        TODO: addProduct
    }

    @Override
    public void addProduct(ShoppingCartDTO shoppingCartDTO, Long id) {
        addProduct(shoppingCartDTO, ProductConverter.entityToDto(productRepository.getOne(id)));
    }

    @Override
    public void deleteProduct(ShoppingCartDTO shoppingCartDTO, ProductDTO productDTO) {
        List<OrderItemDTO> orderItemDTOS = shoppingCartDTO.getOrder().getOrderItems();
        for (OrderItemDTO orderItemDTO: orderItemDTOS) {
            if (orderItemDTO.getProduct() == productDTO) orderItemRepository.delete(OrderItemConverter.dtoToEntity(orderItemDTO));
        }
    }

    @Override
    public List<ProductDTO> getProducts(ShoppingCartDTO shoppingCartDTO) {
        List<ProductDTO> productDTOS = new ArrayList<>();

        for (OrderItemDTO orderItemDTO : shoppingCartDTO.getOrder().getOrderItems()) {
            productDTOS.add(orderItemDTO.getProduct());
        }
        return productDTOS;
    }

    @Override
    public Double getTotal(ShoppingCartDTO shoppingCartDTO) {
        Double total = 0.0;

        for (OrderItemDTO orderItemDTO : shoppingCartDTO.getOrder().getOrderItems()) {
            total = total + orderItemDTO.getProduct().getPrice();
        }

        return total;
    }

    @Override
    public int getCountProducts(ShoppingCartDTO shoppingCartDTO) {
        int count = 0;

        for (OrderItemDTO orderItemDTO : shoppingCartDTO.getOrder().getOrderItems()) {
            count = count + orderItemDTO.getCount();
        }
        return count;
    }

    @Override
    public void editProductCount(ShoppingCartDTO shoppingCartDTO, ProductDTO productDTO, int count) {
//    TODO: editProductCount
    }

    @Override
    public void deleteShoppingCart(Long id) {
        if (shoppingCartRepository.findOne(id) == null) throw new NullPointerException();
        shoppingCartRepository.delete(id);
    }

}
