package com.enigma.koperasi.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_bulanan")
public class KoperasiBulananEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String bulan;
    private int total_transaksi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public int getTotal_transaksi() {
        return total_transaksi;
    }

    public void setTotal_transaksi(int total_transaksi) {
        this.total_transaksi = total_transaksi;
    }
}
