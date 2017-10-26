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
import java.util.Random;


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

    final Random random = new Random();

    @Test
    public void shouldAddAndEditUserAndDelete() {
        int r =  random.nextInt();
        UserDTO userDTO = new UserDTO("username"+r, "name", "lastname", "@", "pas");
        userService.addUser(userDTO);
        userDTO.setName("new name");
        userService.editUser(userDTO);
        Long userId = userService.findByUserName(userDTO.getUserName()).getId();
        Assert.assertNotNull(userService.getUser(userId));
        Assert.assertNotEquals("username"+r, userService.getUser(userId).getName());
        userService.deleteUser(userId);
        Assert.assertNull(userService.getUser(userId));
    }

    @Test
    public void shouldAddUserWithRole() {
        int r =  random.nextInt();
        UserDTO userDTO = new UserDTO("username"+r, "name", "lastname", "@", "pas");

        userService.addUser(userDTO);
        Long userId = userService.findByUserName(userDTO.getUserName()).getId();

        UserDTO userDTO1 = userService.getUser(userId);

        Assert.assertNotNull(userDTO1);
        Assert.assertNotNull(userDTO1.getRoles());
    }

}
