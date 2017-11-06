package ru.webmarket.model.mapper;


import ru.webmarket.model.dto.UserDTO;
import ru.webmarket.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserMap {

    public static User toEntity(UserDTO userDTO) {
        if (userDTO == null) return null;
        User user = new User();

        user.setId(userDTO.getId());
        user.setUserName(userDTO.getUserName());
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRoles(RoleMap.toEntity(userDTO.getRoles()));

        return user;
    }

    public static UserDTO toDto(User user) {
        if (user == null) return null;
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUsername());
        userDTO.setName(user.getName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setRoles(RoleMap.toDto(user.getRoles()));

        return userDTO;
    }

    public static List<User> toEntity(List<UserDTO> userDTOS) {
        if (userDTOS == null) return null;
        List<User> users = new ArrayList<>();
        for (UserDTO userDTO : userDTOS) {
            if (userDTO == null) continue;
            users.add(toEntity(userDTO));
        }

        return users;
    }

    public static List<UserDTO> toDto(List<User> users) {
        if (users == null) return null;
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users) {
            if (user == null) continue;
            userDTOS.add(toDto(user));
        }

        return userDTOS;
    }

//    private ModelMapper modelMapper;
//
//    public UserDTO toDto (User user) {
////        modelMapper = new ModelMapper();
//        modelMapper.skip()
////        modelMapper.addMappings(mapper -> mapper.skip(Destination::set));
//        return new ModelMapper().map(user, UserDTO.class);
//    }
//
//
////    public UserMap() {
////
////        modelMapper = new ModelMapper();
////
////        modelMapper.addMappings(new PropertyMap<UserDTO, User>() {
////            @Override
////            protected void configure() {
////                map().setId(source.getId());
////                map.
////            }
////        });
////
////    }
//
////    public UserDTO toDto(User user) {
////        UserDTO userDTO = modelMapper.createTypeMap(User.class, UserDTO.class);
////        return userDTO;
////    }

}