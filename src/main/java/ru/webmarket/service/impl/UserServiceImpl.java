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
        userRepository.save(user);

    }

    @Override
    public UserDTO getUser(Long id) {
        return UserConverter.entityToDto(userRepository.findOne(id));
    }

    @Override
    public void editUser(UserDTO userDTO) {

        User user = UserConverter.dtoToEntity(userDTO);
        user = userRepository.findById(user.getId());

        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());

    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return UserConverter.entityToDto(userRepository.findAll());
    }

    @Override
    public UserDTO findByUserName(String username) {
        return UserConverter.entityToDto(userRepository.findByUserName(username));
    }

    @Override
    public UserDTO findByEmail(String email) {
        return UserConverter.entityToDto(userRepository.findByUserName(email));
    }

    @Override
    public ShoppingCartDTO getShoppingCart(Long id) {

        return UserConverter.entityToDto(userRepository.findById(id)).getShoppingCart();
    }

    @Override
    public List<RoleDTO> getRoles(Long id) {

        return UserConverter.entityToDto(userRepository.findById(id)).getRoles();
    }

    @Override
    public List<OrderDTO> getOrders(Long id) {

        return UserConverter.entityToDto(userRepository.findById(id)).getOrders();
    }


}
