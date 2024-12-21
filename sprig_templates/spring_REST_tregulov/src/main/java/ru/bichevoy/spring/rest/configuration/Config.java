package ru.bichevoy.spring.rest.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "ru.bichevoy.spring.rest")
@EnableWebMvc
@EnableTransactionManagement
public class Config {

    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("org.postgresql.Driver");
            dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/ChatDB?useSSL=false");
            dataSource.setUser("postgres");
            dataSource.setPassword("password");
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("ru.bichevoy.spring.rest");

        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        jpaProperties.setProperty("hibernate.show_sql", "true");

        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return transactionManager;
    }
}
