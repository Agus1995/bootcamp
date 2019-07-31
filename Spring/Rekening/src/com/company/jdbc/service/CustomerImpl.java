package com.company.jdbc.service;

import com.company.jdbc.config.DBConnection;
import com.company.jdbc.dao.CustomerData;
import com.company.jdbc.entity.Customer;

import java.sql.SQLException;

public class CustomerImpl implements ICustomer {
    private CustomerData customerData;
    private static Customer customer = new Customer();
    DBConnection dbConnection = new DBConnection();
    public CustomerImpl(){
        try {
            customerData = new CustomerData(dbConnection.koneksiDB());
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }


    @Override
    public void addCustomer(Customer customer) {

        try {
            customerData.addCustomer(customer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Customer getById(String id) {
        try {
            customer = customerData.getById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return customer;
    }
}
