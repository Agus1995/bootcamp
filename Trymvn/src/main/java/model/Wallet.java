package model;

import javax.persistence.*;

@Entity
@Table(name = "tb_wallet")
public class Wallet {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String description;
    private String customer_number;


    public String getCustomer_number() {
        return customer_number;
    }


    public void setCustomer_number(String customer_number) {
        this.customer_number = customer_number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
