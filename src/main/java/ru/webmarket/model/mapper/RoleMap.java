package ru.webmarket.model.mapper;

import ru.webmarket.model.dto.RoleDTO;
import ru.webmarket.model.entity.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleMap {

    public static Role toEntity(RoleDTO roleDTO) {
        if (roleDTO == null) return null;
        Role role = new Role();

        role.setId(roleDTO.getId());
        role.setName(roleDTO.getName());

        return role;
    }

    public static RoleDTO toDto(Role role) {
        if (role == null) return null;
        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName());

        return roleDTO;
    }

    public static List<Role> toEntity(List<RoleDTO> roleDTOS) {
        if (roleDTOS == null) return null;
        List<Role> roles = new ArrayList<>();
        for (RoleDTO roleDTO : roleDTOS) {
            if (roleDTO == null) continue;
            roles.add(toEntity(roleDTO));
        }
        return roles;
    }

    public static List<RoleDTO> toDto(List<Role> roles) {
        if (roles == null) return null;
        List<RoleDTO> roleDTOS = new ArrayList<>();
        for (Role role : roles) {
            if (role == null) continue;
            roleDTOS.add(toDto(role));
        }
        return roleDTOS;
    }
}