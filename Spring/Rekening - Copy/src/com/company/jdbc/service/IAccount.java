package com.company.jdbc.service;

import com.company.jdbc.entity.Account;
import java.util.List;

public interface IAccount {
    void addAccount(Account account);

    void updateTfplus(String accNumb, double newBalance, String code);

    void updateTfmin(String accNumb, double newBalance, String code);

    Account getById(String id);

    List<Account> getByCode(String code);

  //  void topUp(int id, String accNumb, double newBalance, String code);
}
