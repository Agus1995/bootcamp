import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

//import javax.imageio.spi.ServiceRegistry;
import java.util.ArrayList;
import java.util.List;


public class Main {
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure();

        config.addAnnotatedClass(Customer.class);
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(serviceRegistry);

        Main main = new Main();
        List<Customer> customers = main.listCustomer();
        for (Customer c: customers) {
            System.out.println(c.getCustomerNumber());
            System.out.println(c.getFirstName());
            System.out.println(c.getLastName());
            System.out.println(c.getUsername());
            System.out.println(c.getBirthDate());

        }


        List<Account> accounts = main.listAccount();
        for (Account c: accounts) {
            System.out.println(c.getCustomer().getUsername());
            System.out.println(c.getFirstName());
            System.out.println(c.getLastName());
            System.out.println(c.getUsername());
            System.out.println(c.getBirthDate());

        }
    }

    private List<Account> listAccount(){

    }

    private List<Customer> listCustomer(){

        Session sesn = factory.openSession();
        List<Customer> users = new ArrayList<Customer>();

        try {
            Query query =(Query) sesn.createQuery("From Customer");
            users = query.list();
        }catch (HibernateException he){
            he.printStackTrace();
        }finally {
            sesn.close();
        }
        return users;
    }
}
