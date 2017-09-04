package org.hibernate.launch.session;

import org.compsci.entity.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
/**
 * Created by LalinPethiyagoda on 19/09/2015.
 */
public class HibernateTest {

    public static void main(String[] args) {
        UserDetails user = new UserDetails();
        user.setUserId(4);
        user.setUserName("Lalin");
        Session session=null;
        /**
        try {
            Configuration configuration = new Configuration().configure();
            ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
            registry.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = registry.buildServiceRegistry();

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            session =sessionFactory.openSession();

        }catch(HibernateException e){
            e.printStackTrace();
        }
         */
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }
}
