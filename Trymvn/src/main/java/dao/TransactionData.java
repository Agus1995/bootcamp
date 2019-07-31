package dao;

import model.Customer;
import model.Transaction;
import model.Transactiontype;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;

public class TransactionData {
    private static SessionFactory factory;
    private static Session session;
    private static ServiceRegistry serviceRegistry;

    public TransactionData(){
        Configuration config = new Configuration();
        config.configure();

        config.addAnnotatedClass(Transaction.class);
        config.addAnnotatedClass(Transactiontype.class);
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(serviceRegistry);
    }

    public void addTransaction(Transaction transaction){
        Session sesn = factory.openSession();
        try {
            org.hibernate.Transaction tx = sesn.beginTransaction();
            sesn.save(transaction);
            sesn.flush();
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public List<Transaction> transactionList(String accNumb){
        Session sesn = factory.openSession();
        List<Transaction> transactions = new ArrayList<Transaction>();
        try {
            Query query = sesn.createQuery("FROM Transaction WHERE account_number_debit = :deb OR account_number_kredit = :kre");
            query.setString("deb", accNumb);
            query.setString("kre",accNumb);
            transactions = query.list();
        }catch (HibernateException he){
            he.printStackTrace();
        }finally {
            sesn.close();
        }
        return transactions;
    }
}
