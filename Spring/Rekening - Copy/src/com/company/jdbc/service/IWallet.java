package com.company.jdbc.service;

import com.company.jdbc.entity.Wallet;

import java.util.List;

public interface IWallet {
    void addWallet(Wallet wallet);
    Wallet searchLast();

    Wallet getById(int id);

    List<Wallet> getByCode(String code);

    boolean getAccountWallet(int id, String accName);

    void registerWallet(int id, String accNumb);

    void unReg(int id, String accNumb);


}
