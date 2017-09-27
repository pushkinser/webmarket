package ru.webmarket.service;

import ru.webmarket.entity.Role;
import ru.webmarket.entity.User;
import ru.webmarket.entity.dto.RoleDTO;
import ru.webmarket.entity.dto.UserDTO;

import java.util.List;

public interface RoleService {

    void addRole(RoleDTO roleDTO);

    RoleDTO getRole(Long id);

    void editRole(RoleDTO role);

    void deleteRole(Long id);

    List<RoleDTO> getAllRoles();

    List<UserDTO> getAllUsers(RoleDTO roleDTO);

    RoleDTO findByName(String name);


}