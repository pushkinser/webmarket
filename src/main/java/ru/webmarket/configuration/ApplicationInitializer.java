package ru.webmarket.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
        // Создание корневого контекста Spring
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(Application.class);

        // Листенер для управления жизненным циклом корневого контекста Spring
        container.addListener(new ContextLoaderListener(rootContext));

        // Создание контекста Spring для сервлета-диспетчера Spring MVC
         AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
         dispatcherContext.register(Application.class);

        // Регистрация сервлета-диспетчера Spring MVC
        ServletRegistration.Dynamic dispatcher =
                container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
         dispatcher.setLoadOnStartup(1);
         dispatcher.addMapping("/");

        // Установка параметров контейнера
        container.setInitParameter("defaultHtmlEscape", "true");

        //  Определение log4j
        org.apache.log4j.BasicConfigurator.configure();
//


        // Регистрация других сервлетов и фильтров
//        FilterRegistration charEncodingFilterReg =
//                container.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
//        charEncodingFilterReg.setInitParameter("encoding", "UTF-8");
//        charEncodingFilterReg.setInitParameter("forceEncoding", "true");
//        charEncodingFilterReg.addMappingForUrlPatterns(null, false, "/*");
    }
}
