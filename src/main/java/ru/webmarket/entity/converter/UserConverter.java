//package ru.webmarket.entity.converter;
//
//import ru.webmarket.entity.User;
//import ru.webmarket.entity.dto.UserDTO;
//
//import javax.persistence.AttributeConverter;
//import javax.persistence.Converter;
//
//@Converter(autoApply = true)
//public class UserConverter implements AttributeConverter<User, UserDTO> {
//
//
//    @Override
//    public UserDTO convertToDatabaseColumn(User user) {
//
//        if (user == null) {
//            return null;
//        }
//        UserDTO userDTO = new UserDTO(user);
//
//        //userDTO(user);
//
//        return userDTO;
//    }
//
//    @Override
//    public User convertToEntityAttribute(UserDTO userDTO) {
//        return null;
//    }
//}
package ru.webmarket.entity.converter;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import ru.webmarket.entity.Order;
import ru.webmarket.entity.User;
import ru.webmarket.entity.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * TODO : do with @Converter
 *
 */


public class UserConverter {

    public static User dtoToEntity(UserDTO userDTO) {
        if (userDTO == null) return null;
        User user = new User();

        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUserName());
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRoles(RoleConvector.dtoToEntity(userDTO.getRoles()));
        user.setOrdes(OrderConverter.dtoToEntity(userDTO.getOrders()));
        user.setShoppingCart(ShoppingCartConverter.dtoToEntity(userDTO.getShoppingCart()));

        return user;
    }

    public static UserDTO entityToDto(User user) {
        if (user == null) return null;
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUsername());
        userDTO.setName(user.getName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setRoles(RoleConvector.entityToDto(user.getRoles()));
        userDTO.setOrders(OrderConverter.entityToDto(user.getOrdes()));
        userDTO.setShoppingCart(ShoppingCartConverter.entityToDto(user.getShoppingCart()));

        return userDTO;
    }

    public static List<User> dtoToEntity(List<UserDTO> userDTOS) {
        if (userDTOS == null) return null;
        List<User> users = new ArrayList<User>();
        for (UserDTO userDTO : userDTOS) {
            if (userDTO == null) continue;
            users.add(dtoToEntity(userDTO));
        }

        return users;
    }

    public static List<UserDTO> entityToDto(List<User> users) {
        if (users == null) return null;
        List<UserDTO> userDTOS = new ArrayList<UserDTO>();
        for (User user : users) {
            if (user == null) continue;
            userDTOS.add(entityToDto(user));
        }

        return userDTOS;
    }

}
