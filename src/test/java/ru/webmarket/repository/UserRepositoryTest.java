package ru.webmarket.repository;

import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.webmarket.AppTest;
import ru.webmarket.configuration.Persistence;
import ru.webmarket.entity.User;
import ru.webmarket.repository.UserRepository;


public class UserRepositoryTest extends AppTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldGetUsers() {
        Iterable<User> allUsers = userRepository.findAll();
        for (User user : allUsers) {
            System.out.println(user);
        }
        Assert.assertNotNull(allUsers);
        Assert.assertTrue(allUsers.iterator().hasNext());
    }

    @Test
    public void shouldSaveAndDeleteUser() {
        User user = new User("Vasya77", "Vasya","Vasechkin", "@", "123");
        userRepository.save(user);
        Assert.assertTrue(userRepository.exists(user.getId()));
        User foundUser = userRepository.findById(user.getId());
        Assert.assertNotNull(foundUser);
        Assert.assertEquals(foundUser, user);
        userRepository.delete(user);
    }

    @Test
    public void shouldUpdateUserEmail() {
        User user = new User("Test", "test", "test", "@", "test");
        userRepository.save(user);
        Assert.assertTrue(userRepository.exists(user.getId()));
        User user2 = userRepository.findById(user.getId());
        user.setEmail("@@");
        Assert.assertNotNull(userRepository.findById(user.getId()));
        Assert.assertNotEquals(user.getEmail(),user2.getEmail());
        Assert.assertTrue(user != user2);
        userRepository.delete(user.getId());
    }
}