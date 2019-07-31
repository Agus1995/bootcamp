package com.company.Latihan;

import java.util.ArrayList;
import java.util.List;

public class LatihanCollection {
    static int[] no = new int[5];
    static List<Mahasiswa> listsiswa = new ArrayList<>();

    public static void main(String[] args) {
        no[0] = 1;
        no[1] = 2;
        no[2] = 3;
        no[3] = 4;
        no[4] = 5;

        System.out.println(no[0]);
        System.out.println(no[4]);

        Mahasiswa siswa = new Mahasiswa();
        siswa.nim = "33333";
        siswa.firstname = "Aku";
        siswa.lastname = "sknck";
        siswa.alamat = "karawang";

        listsiswa.add(siswa);

        Mahasiswa kelas = new Mahasiswa();
        kelas.nim = "0900";
        kelas.firstname = "paijo";
        kelas.lastname = "otong";
        kelas.alamat = "jogja";

        listsiswa.add(kelas);

        System.out.println("NIM     :" + listsiswa.get(0).nim);
        System.out.println("Name    :" + listsiswa.get(0).getFullName());
        System.out.println("Alamat  :" + listsiswa.get(0).alamat);

        System.out.println();
        System.out.println();

        System.out.println("NIM     :" + listsiswa.get(1).nim);
        System.out.println("Name    :" + listsiswa.get(1).getFullName());
        System.out.println("Alamat  :" + listsiswa.get(1).alamat);

    }
}
