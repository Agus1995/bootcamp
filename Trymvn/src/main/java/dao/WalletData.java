package dao;
import model.Account;
import model.Customer;
import model.Wallet;
import model.WalletAccount;
import org.hibernate.*;
import org.hibernate.query.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class WalletData {
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    public  WalletData(){
        Configuration config = new Configuration();
        config.configure();
        config.addResource("query.hbm.xml");

        config.addAnnotatedClass(Wallet.class);
        config.addAnnotatedClass(WalletAccount.class);
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(serviceRegistry);

    }
    public List<Wallet> listWallet() {
        Session sesn = factory.openSession();
        List<Wallet> wallets = new ArrayList<Wallet>();
        try {
            Query query = sesn.createQuery("from Wallet");
            wallets = query.list();

        } catch (HibernateException he) {
            he.printStackTrace();
        }finally {
            sesn.close();
        }
        return wallets;
    }


    public List<WalletAccount> listRegistered(List<Account> accounts){
        Session sesn = factory.openSession();
        List<WalletAccount> wallets = new ArrayList<WalletAccount>();
        List<String> acc = new ArrayList<String>();

        for (Account account : accounts) {
            acc.add(account.getAccount_number());
        }
        try {
            Query query = sesn.createQuery("FROM WalletAccount account WHERE account.account_number IN :acc");
            query.setParameterList("acc", acc);
            wallets = query.getResultList();
        } catch (HibernateException he) {
            he.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sesn.close();
        }
        return wallets;
    }

    public Wallet getByIdWallet(int Id){
        Session sesn = factory.openSession();

        Wallet wallet = new Wallet();
        try {
        Query query = sesn.createQuery("FROM Wallet WHERE id = ?");
        query.setInteger(1,Id);
        wallet = (Wallet) query.uniqueResult();

    }catch (ObjectNotFoundException e){
            e.fillInStackTrace();
        } finally {
            sesn.close();
        }
        return wallet;
    }
    public void addWallet(Wallet wallet){
        Session sesn = factory.openSession();
        try {
            Transaction tx = sesn.beginTransaction();
            sesn.save(wallet);
            sesn.flush();
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<Wallet> getAll(String cusNumb){
        Session sesn = factory.openSession();
        List<Wallet> wallets = new ArrayList<Wallet>();

        try {
            org.hibernate.Query query = sesn.createQuery("from Wallet");
            wallets = query.list();
        }catch (HibernateException he){
            he.printStackTrace();
        }finally {
            sesn.close();
        }
        return wallets;
    }

    public Wallet getByIdCusNumb(String id, String cusNumb){
        Session sesn = factory.openSession();
        Wallet wallet = new Wallet();
        try {
            Query query = sesn.createQuery("FROM Wallet WHERE id = :id AND customer_number = :cus");
            query.setString("id", id);
            query.setString("cus", cusNumb);
            wallet = (Wallet) query.uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return wallet;
    }
    public void deleteWallet(String cusNumb, String WalletId){

        Session sesn = factory.openSession();
        sesn.beginTransaction();
        Query query = sesn.createQuery("DELETE FROM Wallet where customer_number = :acc AND id = :wlt");
        query.setParameter("acc", cusNumb);
        query.setParameter("wlt", WalletId);
        query.executeUpdate();
        sesn.getTransaction().commit();
    }


}