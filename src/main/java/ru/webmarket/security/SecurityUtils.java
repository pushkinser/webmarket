package ru.webmarket.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import ru.webmarket.model.dto.RoleDTO;
import ru.webmarket.model.dto.UserDTO;
import ru.webmarket.model.entity.User;
import ru.webmarket.model.mapper.UserMap;

import java.util.Objects;

public class SecurityUtils {
    


    public static UserDTO getCurrentDetails() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof AnonymousAuthenticationToken) return null;

        return UserMap.toDto((User)auth.getPrincipal());
    }

    public static ModelMap getAuthInfo() {
        final ModelMap result = new ModelMap();
        final UserDTO userDTO = getCurrentDetails();

        if (userDTO == null) {
            result.put("isAuthorized", false);
        } else {
            result.put("isAuthorized", true);
            result.put("user", userDTO);
            for (RoleDTO roleDTO: userDTO.getRoles()) {
//                System.out.println(roleDTO.getName());
//                System.out.println(Objects.equals(roleDTO.getName(), "SELLER"));
                if (Objects.equals(roleDTO.getName(), "SELLER")) result.put("isSeller", true);
            }

        }
        return result;
    }
}
