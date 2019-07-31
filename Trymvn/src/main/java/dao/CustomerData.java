package dao;

import model.Customer;
import org.hibernate.*;
import org.hibernate.Query;
import org.hibernate.query.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CustomerData {

    private static SessionFactory factory;
    private static Session session;
    private static ServiceRegistry serviceRegistry;

    public CustomerData(){
        Configuration config = new Configuration();
        config.configure();

        config.addAnnotatedClass(Customer.class);
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(serviceRegistry);
    }

    public List<Customer> listCustomer(){
        Session sesn = factory.openSession();
        List<Customer> customers = new ArrayList<Customer>();

        try {
            Query query = sesn.createQuery("from Customer");
            customers = query.list();
        }catch (HibernateException he){
            he.printStackTrace();
        }finally {
            sesn.close();
        }
        return customers;
    }

    public Customer getByIdCustomer(String CssNumb){
        Session sesn = factory.openSession();

        Customer customer = new Customer();
        try {
            Query query = sesn.createQuery("FROM Customer WHERE customer_number = :acc");
            query.setString("acc",CssNumb);
            customer = (Customer) query.uniqueResult();
        } catch (ObjectNotFoundException e){
            e.printStackTrace();
        } catch (HibernateException e){
            e.printStackTrace();
        } catch (EntityNotFoundException e){
            e.fillInStackTrace();
        } finally {
            sesn.close();
        }
        return customer;
    }

    public void addCustomer(Customer customer){
        Session sesn = factory.openSession();
        try {
            Transaction tx = sesn.beginTransaction();
            sesn.save(customer);
            sesn.flush();
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
