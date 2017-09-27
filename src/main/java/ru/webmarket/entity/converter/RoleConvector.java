package ru.webmarket.entity.converter;

import ru.webmarket.entity.Role;
import ru.webmarket.entity.dto.RoleDTO;
/*
* TODO : Converter for List<RoleDTO> and List<Role>
 */

public class RoleConvector {

    public static Role dtoToEntity(RoleDTO roleDTO) {
        Role role = new Role();

        role.setId(roleDTO.getId());
        role.setName(roleDTO.getName());
        role.setUsers(UserConverter.dtoToEntity(roleDTO.getUsers()));

        return role;
    }

    public static RoleDTO entityToDto(Role role) {
        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName());
        roleDTO.setUsers(UserConverter.entityToDto(role.getUsers()));

        return roleDTO;
    }

}
