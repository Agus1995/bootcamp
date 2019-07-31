package com.company.ujian;

public interface IMahasiswa {
    void hitung(double tugas1, double tugas2, double upm, double uas);

    String grade(double nilai);

    void setMahasiswa(String nim, String name, double tugas1, double tugas2, double upm, double uas);



    void  getMahasiswa();


}
