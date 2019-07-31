package com.company.store;

import java.util.List;

public interface ITransaksi {

    void addTransaction(Transaksi trans);

    List<Transaksi> getListTrans();
}
