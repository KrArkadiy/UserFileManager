package ru.krylosov.arkadiy.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.krylosov.arkadiy.model.Event;
import ru.krylosov.arkadiy.model.File;
import ru.krylosov.arkadiy.model.User;

public class HibernateSessionFactory {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Event.class);
                configuration.addAnnotatedClass(File.class);
                configuration.addAnnotatedClass(User.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception exc) {
                System.out.println("Error occurred " + exc.getMessage());
            }
        }
        return sessionFactory;
    }
}
