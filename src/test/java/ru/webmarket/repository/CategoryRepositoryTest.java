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
import ru.webmarket.entity.Category;
import ru.webmarket.repository.CategoryRepository;

public class CategoryRepositoryTest extends AppTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void shouldGetCategories () {
        Iterable<Category> allCategory = categoryRepository.findAll();
        Assert.assertNotNull(allCategory);
    }


}
