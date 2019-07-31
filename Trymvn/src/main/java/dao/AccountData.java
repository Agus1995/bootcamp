package dao;

import model.Account;
import model.Customer;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AccountData {
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    public AccountData(){
        Configuration config = new Configuration();
        config.configure();

        config.addAnnotatedClass(Account.class);
        config.addAnnotatedClass(Customer.class);
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(serviceRegistry);
    }

    public void addAccount(Account account){
        Session sesn = factory.openSession();
        try {
            Transaction tx = sesn.beginTransaction();
            sesn.save(account);
            sesn.flush();
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Account> listAccount(Customer customer){
        Session sesn = factory.openSession();
        List<Account> accounts = new ArrayList<Account>();
        try {
            Query query = sesn.createQuery("FROM Account WHERE customer.customer_number = 'CS-390217'");
     //       query.setString("cif", customer.getCustomer_number());
            accounts = query.list();
        }catch (HibernateException he){
            he.printStackTrace();
        }finally {
            sesn.close();
        }
        return accounts;
    }

    public Account getByIdAccount(String accNumb){
        Session sesn = factory.openSession();
        Account account = new Account();
        try {
            Query query = sesn.createQuery("FROM Account WHERE account_number = :acc");
            query.setString("acc",accNumb);
            account = (Account) query.uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return account;
    }

    public List<Account> getByIdCustomer(String cusNumb){
        Session sesn = factory.openSession();
        List<Account> accounts = new ArrayList<Account>();
        try {
            Query query = sesn.createQuery("FROM Account WHERE customer_number = :cus");
            query.setString("cus",cusNumb);
            accounts = query.list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return accounts;
    }

    public Account getByAccCss(String cusNumb, String accNumb){
        Session sesn = factory.openSession();
        Account account = new Account();
        try {
            Query query = sesn.createQuery("FROM Account WHERE account_number = :acc AND customer_number = :cus");
            query.setString("acc", accNumb);
            query.setString("cus", cusNumb);
            account = (Account) query.uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return account;
    }

    public void deleteAccount(String accNumb, String cssNumb){

        Session sesn = factory.openSession();
        sesn.beginTransaction();
        Query query = sesn.createQuery("DELETE FROM Account where account_number = :acc AND customer_number = :css");
        query.setParameter("acc", accNumb);
        query.setParameter("css", cssNumb);
        query.executeUpdate();
        sesn.getTransaction().commit();
    }

    public void topUp(String accNumb, double nominal){
        Session sesn = factory.openSession();
        Transaction tx = null;
        try {
            tx = sesn.beginTransaction();
            Account account = (Account)sesn.get(Account.class, accNumb);
            account.setBalance(nominal);
            sesn.update(account);
            tx.commit();
        }catch (HibernateException he){
            if(tx!=null) tx.rollback();
            he.printStackTrace();
        }finally {
            sesn.close();
        }
    }
}
