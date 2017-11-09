package ru.webmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.webmarket.model.dto.RoleDTO;
import ru.webmarket.model.dto.UserDTO;
import ru.webmarket.model.mapper.UserMap;
import ru.webmarket.repository.UserRepository;
import ru.webmarket.service.UserService;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final ShoppingCartServiceImpl shoppingCartService;

    private final RoleServiceImpl roleService;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleServiceImpl roleService, ShoppingCartServiceImpl shoppingCartService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.shoppingCartService = shoppingCartService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Возвращает сохраненного нового User с ролью CUSTOMER и с пустой корзиной.
     */
    @Override
    public UserDTO register(UserDTO userDTO) {
        if (userDTO == null) return null;

        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userDTO.setRoles(Collections.singletonList(roleService.get("CUSTOMER")));
        userDTO = UserMap.toDto(userRepository.save(UserMap.toEntity(userDTO)));

        shoppingCartService.addByUser(userDTO);

        return userDTO;
    }

    /**
     * Возвращает пользователя по идентификатору.
     */
    @Override
    public UserDTO get(Long userId) {
        return UserMap.toDto(userRepository.findOne(userId));
    }

    /**
     * Возвращает пользовтеля по логину.
     */
    @Override
    public UserDTO get(String userName) {
        return UserMap.toDto(userRepository.findByUserName(userName));
    }

    /**
     * Возвращает список ролей у пользователя.
     */
    @Override
    public List<RoleDTO> getRoles(UserDTO userDTO) {
        return userDTO.getRoles();
    }
}
