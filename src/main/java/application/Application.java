package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.HibernateSessionFactory;
import model.UserModel;

public class Application
{

    private static SessionFactory sessionFactory;

    public static void main(String[] args)
    {
        sessionFactory = HibernateSessionFactory.getSession();

        UserModel model = new UserModel();

        model.setUserName("awydin");
        model.setPassword("123456");
        model.setCreatedDate(new Date());

        saveUser(model);
        
        List<UserModel> userList = getUserList();
        if(!userList.isEmpty())
        {
            for (UserModel user : userList)
            {
                System.out.println(user.getUserName());
            }
        }
    }

    private static void saveUser(UserModel model)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(model);
        tx.commit();

    }

    private static List<UserModel> getUserList()
    {
        Session session = sessionFactory.openSession();
        
        List<UserModel> userList = new ArrayList<>();
        
        userList =  session.createQuery("from UserModel", UserModel.class).list();
        
        return  userList;
        
    }
}
