package hibernatesample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


import java.util.List;



public class HibernateSample
{
    static  SessionFactory factory;

     @BeforeClass
     public static void setup()
     {
         StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
         factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
     }

     @Test
     @Ignore
     public void saveMessage()
     {
         Message message = new Message("hibernate 5 is greate");

         try (Session session = factory.openSession())
         {
             Transaction tx = session.beginTransaction();
             session.persist(message);
             tx.commit();
         }
     }

     @Test

     public void readMessage()
     {
         try (Session session = factory.openSession())
         {
             List<Message> list = session.createQuery("from Message", Message.class).list();

             for (Message m : list)
             {
                 System.out.println(m.toString());
             }
         }
     }
 }
