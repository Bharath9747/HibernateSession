package org.accolite.util;

import org.accolite.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class Utility {
    public static Session getSession() {
        Configuration configuration = new Configuration();

        Properties properties = new Properties();
        properties.put("hibernate.connection.driver.class","com.mysql.cj.jdbc.Driver");
        properties.put("hibernate.connection.url","jdbc:mysql://localhost:3306/Accolite");
        properties.put("hibernate.connection.username","root");
        properties.put("hibernate.connection.password","1234");
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql",true);
        properties.put("hibernate.hbm2ddl.auto","create");
        properties.put("hibernate.allow_update_outside_transaction",true);
        configuration.addAnnotatedClass(Employee.class);
        configuration.setProperties(properties);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory.openSession();
    }
}
