package com.company.ujian;


import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<MahasiswaImpl> list = new ArrayList<>();

    public static void main(String[] args) {
        MahasiswaImpl siswa1 = new MahasiswaImpl();
        siswa1.setMahasiswa("2017001", "Budi Sucipto", 70, 90,80,80);
        list.add(siswa1);

        MahasiswaImpl siswa2 = new MahasiswaImpl();
        siswa2.setMahasiswa("2017002", "Susi susanti", 80, 80, 80, 80);
        list.add(siswa2);

        MahasiswaImpl siswa3 = new MahasiswaImpl();
        siswa3.setMahasiswa("2017003","singodimejo",80,80,80,80);

        list.add(siswa3);







    }
}
