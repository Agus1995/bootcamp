package com.company.Latihan;

public class Main {
    public static void main(String[] args) {

        Mahasiswa siswa = new Mahasiswa();
        siswa.nim = "12344";
        siswa.firstname="Agus";
        siswa.lastname="W";
        siswa.alamat="Karawang";

        System.out.println(siswa.nim);
        System.out.println(siswa.getFullName());
        System.out.println(siswa.alamat);

        IMahasiswa siswaservice = new MahasiswaImpl();

        siswaservice.setFullName("Agus", "Wiwwww");
        System.out.println(siswaservice.getFullName());
    }
}
