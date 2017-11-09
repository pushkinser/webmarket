package ru.webmarket.model.mapper;

import ru.webmarket.model.dto.ShoppingCartDTO;
import ru.webmarket.model.entity.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartMap {

    public static ShoppingCartDTO toDto(ShoppingCart shoppingCart) {
        if (shoppingCart == null) return null;

        ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();

        shoppingCartDTO.setId(shoppingCart.getId());
        shoppingCartDTO.setOrder(OrderMap.toDto(shoppingCart.getOrder()));
        shoppingCartDTO.setUser(UserMap.toDto(shoppingCart.getUser()));

        return shoppingCartDTO;
    }

    public static ShoppingCart toEntity(ShoppingCartDTO shoppingCartDTO) {
        if (shoppingCartDTO == null) return null;
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setId(shoppingCartDTO.getId());
        shoppingCart.setOrder(OrderMap.toEntity(shoppingCartDTO.getOrder()));
        shoppingCart.setUser(UserMap.toEntity(shoppingCartDTO.getUser()));

        return shoppingCart;
    }

    public static List<ShoppingCartDTO> toDto(List<ShoppingCart> shoppingCarts) {
        if (shoppingCarts == null) return null;
        List<ShoppingCartDTO> shoppingCartDTOS = new ArrayList<>();
        for (ShoppingCart shoppingCart : shoppingCarts) {
            if (shoppingCart == null) continue;
            shoppingCartDTOS.add(toDto(shoppingCart));
        }

        return shoppingCartDTOS;
    }

    public static List<ShoppingCart> toEntity(List<ShoppingCartDTO> shoppingCartDTOS) {
        if (shoppingCartDTOS == null) return null;
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        for (ShoppingCartDTO shoppingCartDTO : shoppingCartDTOS) {
            if (shoppingCartDTO == null) continue;
            shoppingCarts.add(toEntity(shoppingCartDTO));
        }

        return shoppingCarts;
    }
}
