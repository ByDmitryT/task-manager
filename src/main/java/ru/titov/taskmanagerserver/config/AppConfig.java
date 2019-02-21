package ru.titov.taskmanagerserver.config;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("ru.titov.taskmanagerserver")
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@EnableJpaRepositories("ru.titov.taskmanagerserver.api.repository")
@EnableWebMvc
public class AppConfig {

    @Autowired
    private org.springframework.core.env.Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws ClassNotFoundException {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("ru.titov.taskmanagerserver.entity");
        final JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }

    private Properties additionalProperties() {
        final Properties properties = new Properties();
        properties.setProperty(Environment.HBM2DDL_AUTO, env.getProperty("datasource.hbm2ddlauto"));
        properties.setProperty(Environment.DIALECT, env.getProperty("datasource.dialect"));
        properties.setProperty(Environment.SHOW_SQL, env.getProperty("datasource.showSql"));
        return properties;
    }

    @Bean
    public DataSource dataSource() throws ClassNotFoundException {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        final String driverClassName = env.getProperty("datasource.driverClassName");
        if (driverClassName == null) throw new ClassNotFoundException();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(env.getProperty("datasource.url"));
        dataSource.setUsername(env.getProperty("datasource.login"));
        dataSource.setPassword(env.getProperty("datasource.password"));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

}
