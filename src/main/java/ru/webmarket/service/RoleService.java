package ru.webmarket.service;

import ru.webmarket.model.dto.RoleDTO;

public interface RoleService {

    RoleDTO get (Long id);

    RoleDTO get (String roleName);

}
