package com.enigma.koperasi.entity;

import javax.persistence.*;

@Entity
@Table(name="tb_barang")
public class KoperasiBarangEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nama_barang")
    private String nama_barang;
    @Column (name = "harga")
    private int harga;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
