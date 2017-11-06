package ru.webmarket.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.webmarket.AppTest;
import ru.webmarket.model.entity.User;
import ru.webmarket.model.mapper.UserMap;
import ru.webmarket.repository.UserRepository;

public class MapperTest extends AppTest {

    private UserMap userMap;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserMap() {
        User user = userRepository.findOne(1L);
        System.out.println(userMap.toDto(user));
    }

}
