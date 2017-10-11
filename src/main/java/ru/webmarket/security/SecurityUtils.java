package ru.webmarket.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import ru.webmarket.entity.User;
import ru.webmarket.entity.converter.UserConverter;
import ru.webmarket.entity.dto.UserDTO;

public class SecurityUtils {
    


    public static UserDTO getCurrentDetails() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof AnonymousAuthenticationToken) return null;

        return UserConverter.entityToDto((User) auth.getPrincipal());
    }

    public static ModelMap getAuthInfo() {
        final ModelMap result = new ModelMap();
        final UserDTO userDTO = getCurrentDetails();

        if (userDTO == null) {
            result.put("isAuthorized", false);
        } else {
            result.put("isAuthorized", true);
            result.put("user", userDTO);
//            result.put("shoppingCart", userDTO.getShoppingCart());
        }
        return result;
    }
}