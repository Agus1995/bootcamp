package com.company.store;

import java.util.ArrayList;
import java.util.List;

public class TransaksiImpl implements ITransaksi{

    private List<Transaksi> list = new ArrayList<>();

    @Override
    public void addTransaction(Transaksi trans) {
        list.add(trans);
    }

    @Override
    public List<Transaksi> getListTrans() {
        return list;
    }
}
