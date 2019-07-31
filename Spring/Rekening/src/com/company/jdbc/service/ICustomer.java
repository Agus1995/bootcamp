package com.company.jdbc.service;

import com.company.jdbc.entity.Customer;

public interface ICustomer {
    void addCustomer(Customer customer);
    Customer getById(String id);
}
