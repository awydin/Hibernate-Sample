package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactory
{
    
    private static SessionFactory session = null;
    private static HibernateSessionFactory hsf = null;

    public static SessionFactory getSession()
    {
        if (hsf == null)
        {
            hsf = new HibernateSessionFactory();
        }
        return session;
    }

    private HibernateSessionFactory()
    {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        session = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
    }
    
    
}
