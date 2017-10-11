package ru.webmarket.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.webmarket.entity.dto.OrderDTO;
import ru.webmarket.entity.dto.RoleDTO;
import ru.webmarket.entity.dto.ShoppingCartDTO;
import ru.webmarket.entity.dto.UserDTO;

import java.util.List;

public interface UserService {

    void addUser(UserDTO userDTO);

    UserDTO getUser(Long id);

    void editUser(UserDTO userDTO);

    void deleteUser(Long id);

    List<UserDTO> getAllUsers();

    UserDTO findByUserName(String username);

    UserDTO findByEmail(String email);

    List<RoleDTO> getRoles (Long id);

    List<OrderDTO> getOrders (Long id);


}
