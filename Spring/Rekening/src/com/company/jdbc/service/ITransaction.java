package com.company.jdbc.service;

import com.company.jdbc.entity.Transaction;

import java.util.List;

public interface ITransaction {
    boolean getCode(String code);

    void addDebitTransaction(Transaction transaction);
    void addCreditTransaction (Transaction transaction);
    List<Transaction> getTransaction(String code);

}
