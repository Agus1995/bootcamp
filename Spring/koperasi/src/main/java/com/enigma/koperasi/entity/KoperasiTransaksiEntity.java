package com.enigma.koperasi.entity;

import javax.persistence.*;

@Entity
@Table(name="tb_transaksi")
public class KoperasiTransaksiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String id_barang;
    private String id_bulan;
    private int jumlah;
    private int total_harga;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_barang() {
        return id_barang;
    }

    public void setId_barang(String id_barang) {
        this.id_barang = id_barang;
    }

    public String getId_bulan() {
        return id_bulan;
    }

    public void setId_bulan(String id_bulan) {
        this.id_bulan = id_bulan;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(int total_harga) {
        this.total_harga = total_harga;
    }
}
