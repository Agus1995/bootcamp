package model;

//import jdk.nashorn.internal.ir.annotations.Reference;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_transaction")
public class Transaction  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "transaction_type")
    private Transactiontype transactiontype;

    @Column(name = "account_number_debit")
    private String accountNumberDebit;
    @Column(name = "account_number_kredit")
    private String getAccountNumberKredit;
    @Column(name = "amount")
    private double amount;

/*    @Column(name = "transaction_type")
    private String TransactionType;*/

    @CreationTimestamp
   // @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Timestamp date;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Transactiontype getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(Transactiontype transactiontype) {
        this.transactiontype = transactiontype;
    }

    public String getAccountNumberDebit() {
        return accountNumberDebit;
    }

    public void setAccountNumberDebit(String accountNumberDebit) {
        this.accountNumberDebit = accountNumberDebit;
    }

    public String getGetAccountNumberKredit() {
        return getAccountNumberKredit;
    }

    public void setGetAccountNumberKredit(String getAccountNumberKredit) {
        this.getAccountNumberKredit = getAccountNumberKredit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

  /*  public String getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }*/

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
