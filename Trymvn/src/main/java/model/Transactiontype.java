package model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Transactiontype")
@Table(name = "tb_transaction_type")
public class Transactiontype {
    @Id
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    @Column(name = "transaction_type")
    private String transaction_type;
    private String description;

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
