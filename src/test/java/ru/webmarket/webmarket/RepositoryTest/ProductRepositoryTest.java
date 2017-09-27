package ru.webmarket.webmarket.RepositoryTest;

import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.webmarket.configuration.Persistence;
import ru.webmarket.entity.Product;
import ru.webmarket.repository.ProductRepository;

public class ProductRepositoryTest {

    private static ProductRepository productRepository;

    @BeforeClass
    public static void setup() {
        BasicConfigurator.configure();
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Persistence.class);
        productRepository = ctx.getBean(ProductRepository.class);
    }

    @Test
    public void shouldGetProducts() {
        Iterable<Product> allProducts = productRepository.findAll();
        for (Product product: allProducts) {
            System.out.println(product);
            System.out.println(product.getCategories());
        }
        Assert.assertNotNull(allProducts);
        Assert.assertTrue(allProducts.iterator().hasNext());

    }
}

