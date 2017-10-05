package ru.webmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webmarket.entity.Role;
import ru.webmarket.entity.User;
import ru.webmarket.entity.converter.RoleConverter;
import ru.webmarket.entity.converter.UserConverter;
import ru.webmarket.entity.dto.OrderDTO;
import ru.webmarket.entity.dto.RoleDTO;
import ru.webmarket.entity.dto.ShoppingCartDTO;
import ru.webmarket.entity.dto.UserDTO;
import ru.webmarket.repository.RoleRepository;
import ru.webmarket.repository.UserRepository;
import ru.webmarket.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

 /*
 *
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public void addUser(UserDTO userDTO) {
        if (userDTO == null) throw new NullPointerException();
        User user = UserConverter.dtoToEntity(userDTO);

        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findByName("CUSTOMER"));
        user.setRoles(roles);
        userRepository.save(user);

    }

    @Override
    public UserDTO getUser(Long id) {
        return UserConverter.entityToDto(userRepository.findOne(id));
    }

    @Override
    public void editUser(UserDTO userDTO) {
        if (userDTO == null) throw new NullPointerException();
        if (userRepository.findById(userDTO.getId()) != null) userRepository.save(UserConverter.dtoToEntity(userDTO));
    }

    @Override
    public void deleteUser(Long id) {
        if (userRepository.findById(id) == null) throw new NullPointerException();
        userRepository.delete(id);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        if (userRepository.findAll() == null) return null;
        return userRepository.findAll().stream()
                .map(UserConverter::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String username) {
        return UserConverter.entityToDto(userRepository.findByUserName(username));
    }

    @Override
    public UserDTO findByEmail(String email) {
        return UserConverter.entityToDto(userRepository.findByEmail(email));
    }

    @Override
    public ShoppingCartDTO getShoppingCart(Long id) {
        return UserConverter.entityToDto(userRepository.findById(id)).getShoppingCart();
    }

    @Override
    public List<RoleDTO> getRoles(Long id) {
        if (userRepository.findById(id) == null) return null;
        return userRepository.findById(id).getRoles().stream()
                .map(RoleConverter::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrders(Long id) {
        if (userRepository.findById(id) == null) return null;
        return UserConverter.entityToDto(userRepository.findById(id)).getOrders();
    }
}
