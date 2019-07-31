package com.company.jdbc;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Siswa> siswas = new ArrayList<>();

        Siswa siswa = new Siswa();
        siswa.setNama("Agus");
        siswas.add(siswa);

        Siswa sis = new Siswa();
        sis.setNama("paijo");
        siswas.add(sis);
        System.out.println(siswas.size());
        update2(siswas);
        System.out.println(siswas.size());

        /*siswa.setNama("enigma");
        System.out.println(siswa.getNama());
        update1(siswa,"terserah");
        System.out.println(siswa.getNama());*/
    }
    public static void update(String data, String newVal){
        data = newVal;
    }
    public static void update1(Siswa data, String newValie){
        data.setNama(newValie);
    }
    public static void update2(List<Siswa> siswaa){
        Siswa si = new Siswa();
        si.setNama("cahyono");
        siswaa.add(si);
        siswaa.remove(0);
    }


}
