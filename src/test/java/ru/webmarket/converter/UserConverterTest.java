package ru.webmarket.converter;

import org.junit.Assert;
import org.junit.Test;
import ru.webmarket.entity.User;
import ru.webmarket.entity.converter.UserConverter;
import ru.webmarket.entity.dto.UserDTO;

public class UserConverterTest {


    @Test
    public void shouldConvertEntityToDto() {
        User user = new User("Vasya77", "Vasya","Vasechkin", "@", "123");
        UserDTO userDTO;
        Assert.assertTrue(UserConverter.entityToDto(user).getClass() == UserDTO.class);
        userDTO = UserConverter.entityToDto(user);
        Assert.assertNotNull(userDTO);
        System.out.println(userDTO);
    }

    @Test
    public void shouldConvertDtoToEntity() {
        UserDTO userDTO = new UserDTO("Vasya77", "Vasya","Vasechkin", "@", "123");
        User user;
        Assert.assertTrue(UserConverter.dtoToEntity(userDTO).getClass() == User.class);
        user = UserConverter.dtoToEntity(userDTO);
        Assert.assertNotNull(user);
        System.out.println(user);
    }

}
