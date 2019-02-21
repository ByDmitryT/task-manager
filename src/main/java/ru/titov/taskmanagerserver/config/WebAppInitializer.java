package ru.titov.taskmanagerserver.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(@NotNull final ServletContext servletContext) throws ServletException {
        @NotNull final AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(AppConfig.class);
        servletContext.addListener(new ContextLoaderListener(applicationContext));
    }

}
