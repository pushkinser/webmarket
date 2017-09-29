package ru.webmarket.entity.converter;

import ru.webmarket.entity.Role;
import ru.webmarket.entity.dto.RoleDTO;

import java.util.ArrayList;
import java.util.List;
/*
 */

public class RoleConvector {

    public static Role dtoToEntity(RoleDTO roleDTO) {
        if ( roleDTO == null) return null;
        Role role = new Role();

        role.setId(roleDTO.getId());
        role.setName(roleDTO.getName());

        return role;
    }

    public static RoleDTO entityToDto(Role role) {
        if ( role == null) return null;
        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName());

        return roleDTO;
    }

    public static List<Role> dtoToEntity(List<RoleDTO> roleDTOS) {
        if ( roleDTOS == null) return null;
        List<Role> roles = new ArrayList<>();
        for (RoleDTO roleDTO : roleDTOS) {
            if (roleDTO == null) continue;
            roles.add(dtoToEntity(roleDTO));
        }

        return roles;
    }

    public static List<RoleDTO> entityToDto(List<Role> roles) {
        if ( roles == null) return null;
        List<RoleDTO> roleDTOS = new ArrayList<>();
        for (Role role : roles) {
            if (role == null) continue;
            roleDTOS.add(entityToDto(role));
        }

        return roleDTOS;
    }

}
