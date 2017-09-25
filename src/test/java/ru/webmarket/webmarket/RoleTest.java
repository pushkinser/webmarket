package ru.webmarket.webmarket;

import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.webmarket.configuration.Persistence;
import ru.webmarket.entity.Role;
import ru.webmarket.repository.RoleRepository;

public class RoleTest {

    private static RoleRepository roleRepository;

    @BeforeClass
    public static void setup (){
        BasicConfigurator.configure();
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Persistence.class);
        roleRepository = ctx.getBean(RoleRepository.class);
    }

    @Test
    public void shouldGetOrdes () {
        Iterable<Role> allRole = roleRepository.findAll();
        for (Role role: allRole) {
            System.out.println();
        }
        Assert.assertNotNull(allRole);
        Assert.assertTrue(allRole.iterator().hasNext());

    }
}
