package com.company.ujian;

public class MahasiswaImpl implements IMahasiswa {

    Mahasiswa mhs = new Mahasiswa();

    @Override
    public void hitung(double tugas1,double tugas2, double upm, double uas) {
        double nilaakhir = (tugas1 + tugas2 + upm + uas) / 4;
        mhs.rata = nilaakhir;
        mhs.grade = grade(mhs.rata);
    }

    @Override
    public String grade(double nilai) {
        if (nilai>90){
            return "A";
        }
        else if (nilai>=80){
            return  "B";
        }
        else if (nilai>=70){
            return "C";
        }
        else if (nilai>=60){
            return "D";
        }else {
            return "E";
        }
    }

    @Override
    public void setMahasiswa(String nim, String name, double tugas1, double tugas2, double upm, double uas) {
        mhs.nim = nim;
        mhs.name = name;
        mhs.tugas1 = tugas1;
        mhs.tugas2 = tugas2;
        mhs.upm = upm;
        mhs.uas = uas;

        hitung(mhs.tugas1, mhs.tugas2, mhs.upm, mhs.uas);
    }

    @Override
    public void getMahasiswa() {
     //   return "Nim : " + mhs.nim;
        System.out.println(mhs.grade);


    }
}
