package ru.webmarket.entity.converter;

import ru.webmarket.entity.ShoppingCart;
import ru.webmarket.entity.dto.ShoppingCartDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Сергей
 */
public class ShoppingCartConverter {

    public static ShoppingCartDTO entityToDto(ShoppingCart shoppingCart) {

        ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();

        shoppingCartDTO.setId(shoppingCart.getId());
        shoppingCartDTO.setOrder(OrderConverter.entityToDto(shoppingCart.getOrder()));
        shoppingCartDTO.setUser(UserConverter.entityToDto(shoppingCart.getUser()));

        return shoppingCartDTO;
    }

    public static ShoppingCart dtoToEntity(ShoppingCartDTO shoppingCartDTO) {

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setId(shoppingCartDTO.getId());
        shoppingCart.setOrder(OrderConverter.dtoToEntity(shoppingCartDTO.getOrder()));
        shoppingCart.setUser(UserConverter.dtoToEntity(shoppingCartDTO.getUser()));

        return shoppingCart;
    }

    public static List<ShoppingCartDTO> entityToDto(List<ShoppingCart> shoppingCarts) {
        List<ShoppingCartDTO> shoppingCartDTOS = new ArrayList<>();

        for (ShoppingCart shoppingCart : shoppingCarts) {
            shoppingCartDTOS.add(ShoppingCartConverter.entityToDto(shoppingCart));
        }

        return shoppingCartDTOS;
    }

    public static List<ShoppingCart> dtoToEntity(List<ShoppingCartDTO> shoppingCartDTOS) {
        List<ShoppingCart> shoppingCarts = new ArrayList<>();

        for (ShoppingCartDTO shoppingCartDTO : shoppingCartDTOS) {
            shoppingCarts.add(ShoppingCartConverter.dtoToEntity(shoppingCartDTO));
        }

        return shoppingCarts;
    }
}
