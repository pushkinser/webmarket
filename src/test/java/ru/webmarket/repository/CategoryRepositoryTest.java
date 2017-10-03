package ru.webmarket.repository;

import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.webmarket.configuration.Persistence;
import ru.webmarket.entity.Category;
import ru.webmarket.repository.CategoryRepository;

public class CategoryRepositoryTest {

    private static CategoryRepository categoryRepository;

    @BeforeClass
    public static void setup () {
        BasicConfigurator.configure();
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Persistence.class);
        categoryRepository = ctx.getBean(CategoryRepository.class);
    }

    @Test
    public void shouldGetCategories () {
        Iterable<Category> allCategory = categoryRepository.findAll();
        for (Category category : allCategory) {
            System.out.println(category);
        }
        Assert.assertNotNull(allCategory);
        Assert.assertTrue(allCategory.iterator().hasNext());
    }




}
