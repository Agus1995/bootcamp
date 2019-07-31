package model;



import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_account")
public class Account {
    @Id
    private String account_number;
    private String account_name;
    private double balance;

    @CreationTimestamp

    private Timestamp open_date;

    @ManyToOne
    @JoinColumn(name="customer_number", referencedColumnName = "customer_number")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Timestamp getOpen_date() {
        return open_date;
    }

    public void setOpen_date(Timestamp open_date) {
        this.open_date = open_date;
    }

}
