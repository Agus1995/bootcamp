,package com.company.ujian2;

public class MahasiswaImpl implements IMahasiswa {

    Mahasiswa mhs = new Mahasiswa();

    @Override
    public double rata(double tugas1, double tugas2, double upm, double uas) {

        double hasil = (tugas1+tugas2+upm+uas);
        return hasil;
    }

    @Override
    public String grade(double nilai) {
        double hasil = nilai;

        if (hasil>90){
            return "A";
        }
        else if (hasil>=85){
            return "B";
        }
        else if (hasil>=70){
            return "C";
        }
        else if (hasil>=65){
            return "C";
        }else {
            return "C";
        }
    }
}
