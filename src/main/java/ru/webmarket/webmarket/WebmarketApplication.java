package ru.webmarket.webmarket;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.webmarket.configuration.Persistence;
import ru.webmarket.entity.User;
import ru.webmarket.repository.UserRepository;


public class WebmarketApplication {
	public static void main(String[] args) {
        BasicConfigurator.configure();
        try {
            ApplicationContext ctx = new AnnotationConfigApplicationContext(Persistence.class);
            UserRepository bean = ctx.getBean(UserRepository.class);
            User user = bean.findById(4L);
            System.out.println(user);
        } catch (Exception e) {

        }
	}

}