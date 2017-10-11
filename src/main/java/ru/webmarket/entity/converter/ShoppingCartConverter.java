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
        if (shoppingCart == null) return null;

        ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();

        shoppingCartDTO.setId(shoppingCart.getId());
        shoppingCartDTO.setOrder(OrderConverter.entityToDto(shoppingCart.getOrder()));
        shoppingCartDTO.setUserId(shoppingCart.getUser().getId());

        return shoppingCartDTO;
    }

    public static ShoppingCart dtoToEntity(ShoppingCartDTO shoppingCartDTO) {
        if (shoppingCartDTO == null) return null;
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setId(shoppingCartDTO.getId());
        shoppingCart.setOrder(OrderConverter.dtoToEntity(shoppingCartDTO.getOrder()));

        return shoppingCart;
    }

    public static List<ShoppingCartDTO> entityToDto(List<ShoppingCart> shoppingCarts) {
        if (shoppingCarts == null) return null;
        List<ShoppingCartDTO> shoppingCartDTOS = new ArrayList<>();
        for (ShoppingCart shoppingCart : shoppingCarts) {
            if (shoppingCart == null) continue;
            shoppingCartDTOS.add(ShoppingCartConverter.entityToDto(shoppingCart));
        }

        return shoppingCartDTOS;
    }

    public static List<ShoppingCart> dtoToEntity(List<ShoppingCartDTO> shoppingCartDTOS) {
        if (shoppingCartDTOS == null) return null;
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        for (ShoppingCartDTO shoppingCartDTO : shoppingCartDTOS) {
            if (shoppingCartDTO == null) continue;
            shoppingCarts.add(ShoppingCartConverter.dtoToEntity(shoppingCartDTO));
        }

        return shoppingCarts;
    }
}
