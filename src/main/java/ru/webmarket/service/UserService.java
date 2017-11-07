package ru.webmarket.service;

import ru.webmarket.model.dto.RoleDTO;
import ru.webmarket.model.dto.UserDTO;
import ru.webmarket.model.entity.User;

import java.util.List;

public interface UserService {

    UserDTO register (UserDTO userDTO);

    UserDTO get (Long id);

    UserDTO get (String userName);

    List<RoleDTO> getRoles (UserDTO userDTO);

}
