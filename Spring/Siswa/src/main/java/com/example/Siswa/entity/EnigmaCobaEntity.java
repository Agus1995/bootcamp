package com.example.Siswa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class EnigmaCobaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private String nama;
    private String alamat;
    private int jumlah_Guru;
    private String telefon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getJumlah_Guru() {
        return jumlah_Guru;
    }

    public void setJumlah_Guru(int jumlah_Guru) {
        this.jumlah_Guru = jumlah_Guru;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
