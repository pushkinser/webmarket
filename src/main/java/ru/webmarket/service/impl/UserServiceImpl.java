package ru.webmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webmarket.entity.User;
import ru.webmarket.entity.converter.UserConverter;
import ru.webmarket.entity.dto.OrderDTO;
import ru.webmarket.entity.dto.RoleDTO;
import ru.webmarket.entity.dto.ShoppingCartDTO;
import ru.webmarket.entity.dto.UserDTO;
import ru.webmarket.repository.UserRepository;
import ru.webmarket.service.UserService;

import java.util.ArrayList;
import java.util.List;

 /*
* TODO: Чтобы удалить пользователя, необходимо полностью удалить из базы все упоминания этого пользователя?
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void addUser(UserDTO userDTO) {
        User user = UserConverter.dtoToEntity(userDTO);
        if (user != null) userRepository.save(user);

    }

    @Override
    public UserDTO getUser(Long id) {
        User user = userRepository.findOne(id);
        if (user == null) return null;
        return UserConverter.entityToDto(user);
    }

    @Override
    public void editUser(UserDTO userDTO) {
        User user = UserConverter.dtoToEntity(userDTO);
        user = userRepository.findById(user.getId());
        if (user != null) {
            user.setName(userDTO.getName());
            user.setLastName(userDTO.getLastName());
            user.setEmail(userDTO.getEmail());
        }
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id);
        if (user != null) userRepository.delete(id);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOS = new ArrayList<>();
        userDTOS = UserConverter.entityToDto(userRepository.findAll());
        if (userDTOS.isEmpty()) return null;
        return userDTOS;
    }

    @Override
    public UserDTO findByUserName(String username) {
        User user = userRepository.findByUserName(username);
        if (user == null) return null;
        return UserConverter.entityToDto(user);
    }

    @Override
    public UserDTO findByEmail(String email) {
        User user = userRepository.findByUserName(email);
        if (user == null) return null;
        return UserConverter.entityToDto(user);
    }

    @Override
    public ShoppingCartDTO getShoppingCart(Long id) {
        UserDTO userDTO = UserConverter.entityToDto(userRepository.findById(id));
        if (userDTO == null) return null;
        return userDTO.getShoppingCart();
    }

    @Override
    public List<RoleDTO> getRoles(Long id) {
        UserDTO userDTO = UserConverter.entityToDto(userRepository.findById(id));
        if (userDTO == null) return null;
        return userDTO.getRoles();
    }

    @Override
    public List<OrderDTO> getOrders(Long id) {
        UserDTO userDTO = UserConverter.entityToDto(userRepository.findById(id));
        if (userDTO == null) return null;
        return userDTO.getOrders();
    }


}
