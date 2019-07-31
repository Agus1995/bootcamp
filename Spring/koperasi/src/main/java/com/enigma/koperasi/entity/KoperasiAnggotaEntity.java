package com.enigma.koperasi.entity;

import javax.persistence.*;

@Entity
@Table(name="tb_anggota")
public class KoperasiAnggotaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="nama")
    private String nama;
    @Column(name = "no_hp")
    private String no_hp;

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

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }
}

