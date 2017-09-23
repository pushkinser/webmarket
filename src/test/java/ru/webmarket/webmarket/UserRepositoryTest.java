package ru.webmarket.webmarket;

import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.webmarket.configuration.Persistence;
import ru.webmarket.entity.User;
import ru.webmarket.repository.UserRepository;



public class UserRepositoryTest {
    private static User defaultUser;

    private static UserRepository userRepository;

    @BeforeClass
    public static void setup() {
        BasicConfigurator.configure();
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Persistence.class);
        userRepository = ctx.getBean(UserRepository.class);
        defaultUser = new User();
        defaultUser.setUserName("NewUser!");
        defaultUser.setEmail("@");
        defaultUser.setPassword("123");
        userRepository.saveAndFlush(defaultUser);
    }

    @Test
    public void shouldAbleCreateUser() {
        User testUser = userRepository.findById(defaultUser.getId());
        Assert.assertNotNull(defaultUser);
        userRepository.delete(defaultUser);
    }


}
