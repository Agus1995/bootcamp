package dao;

import model.WalletAccount;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;

public class WalletAccountData {

    private static SessionFactory factory;
    private static Session session;
    private static ServiceRegistry serviceRegistry;

    public WalletAccountData(){
        Configuration config = new Configuration();
        config.configure();

        config.addAnnotatedClass(WalletAccount.class);
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(serviceRegistry);
    }

    public void registerWallet(WalletAccount walletAccount){
        Session sesn = factory.openSession();
        try {
            Transaction tx = sesn.beginTransaction();
            sesn.save(walletAccount);
            sesn.flush();
            tx.commit();
        }catch (HibernateException he){
            he.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public WalletAccount getData(String walletId, String accNumb){
        Session sesn = factory.openSession();
        WalletAccount walletAccount = new WalletAccount();
        try {
            Query query = sesn.createQuery("FROM WalletAccount WHERE account_number = :acc AND wallet_id = :wal");
            query.setParameter("acc", accNumb);
            query.setParameter("wal", walletId);
            walletAccount = (WalletAccount) query.setMaxResults(1).uniqueResult();
        }catch (HibernateException he){
            he.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return walletAccount;
    }

    public List<WalletAccount> getByIdWallet(String walletId){
        Session sesn = factory.openSession();
        List<WalletAccount> walletAccount = new ArrayList<WalletAccount>();
        try {
            Query query = sesn.createQuery("FROM WalletAccount WHERE wallet_id = :wal");
            query.setParameter("wal", walletId);
            walletAccount = query.list();
        }catch (HibernateException he){
            he.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return walletAccount;
    }

    public List<WalletAccount> getByAccunt(String accNumb){
        Session sesn = factory.openSession();
        List<WalletAccount> walletAccounts = new ArrayList<WalletAccount>();
        try {
            Query query =sesn.createQuery("FROM WalletAccount WHERE account_number = :acc");
            query.setParameter("acc", accNumb);
            walletAccounts = query.list();
        }catch (HibernateException he){
            he.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return walletAccounts;
    }

    public void unRegWallet(String walletId,String accNumb){

        Session sesn = factory.openSession();
        sesn.beginTransaction();
        Query query = sesn.createQuery("DELETE FROM WalletAccount where account_number = :acc AND wallet_id = :wlt");
        query.setParameter("acc", accNumb);
        query.setParameter("wlt", walletId);
        query.executeUpdate();
        sesn.getTransaction().commit();
    }
}
