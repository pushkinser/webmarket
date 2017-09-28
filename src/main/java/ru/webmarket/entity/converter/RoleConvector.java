package ru.webmarket.entity.converter;

import ru.webmarket.entity.Role;
import ru.webmarket.entity.dto.RoleDTO;

import java.util.ArrayList;
import java.util.List;
/*
 */

public class RoleConvector {

    public static Role dtoToEntity(RoleDTO roleDTO) {
        Role role = new Role();

        role.setId(roleDTO.getId());
        role.setName(roleDTO.getName());

        return role;
    }

    public static RoleDTO entityToDto(Role role) {
        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName());

        return roleDTO;
    }

    public static List<Role> dtoToEntity(List<RoleDTO> roleDTOS) {
        List<Role> roles = new ArrayList<>();
        for (RoleDTO roleDTO : roleDTOS) {
            roles.add(dtoToEntity(roleDTO));
        }

        return roles;
    }

    public static List<RoleDTO> entityToDto(List<Role> roles) {
        List<RoleDTO> roleDTOS = new ArrayList<>();
        for (Role role : roles) {
            roleDTOS.add(entityToDto(role));
        }

        return roleDTOS;
    }

}
