package ru.webmarket.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.webmarket.AppTest;
import ru.webmarket.entity.dto.RoleDTO;
import ru.webmarket.entity.dto.UserDTO;
import ru.webmarket.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;


public class UserServiceTest extends AppTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void shouldGetRoles() {
        List<RoleDTO> roleDTOS = new ArrayList<>();
        List<UserDTO> userDTOS = userService.getAllUsers();
        for (UserDTO userDTO: userDTOS) {
            roleDTOS = userDTO.getRoles();
            Assert.assertNotNull(roleDTOS);
        }

    }
}
