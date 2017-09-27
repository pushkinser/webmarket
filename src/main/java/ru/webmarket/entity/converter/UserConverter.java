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
        User user = new User();

        user.setId(userDTO.getId());
        user.setUserName(userDTO.getUserName());
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        //user.setRoles(userDTO.getRoles());
        //user.setOrdes(userDTO.getOrders());
        //user.setShoppingCart(userDTO.getShoppingCart());

        return user;
    }

    public static UserDTO entityToDto (User user) {

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUserName());
        userDTO.setName(user.getName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        //userDTO.setRoles(user.getRoles());
        //userDTO.setOrders(user.getOrdes());
        //.setShoppingCart(user.getShoppingCart());

        return userDTO;
    }

    public static List<User> dtoToEntity (List<UserDTO> userDTOS) {
        List<User> users = new ArrayList<User>();
        for (UserDTO userDTO: userDTOS) {
            users.add(dtoToEntity(userDTO));
        }

        return users;
    }

    public static List<UserDTO> entityToDto (List<User> users) {
        List<UserDTO> userDTOS = new ArrayList<UserDTO>();
        for (User user: users) {
            userDTOS.add(entityToDto(user));
        }

        return userDTOS;
    }

}