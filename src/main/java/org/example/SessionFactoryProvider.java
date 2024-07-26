package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {

    private static SessionFactory sessionFactory;

    private SessionFactoryProvider() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.addPackage("org.example");
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Ticket.class);
//                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory();

            } catch (Exception e) {
                System.out.println("The error in the hibernate initialization" + e);
            }
        }
        return sessionFactory;
    }
}
