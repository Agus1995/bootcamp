package com.company.ujian2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Mahasiswa> list = new ArrayList<>();

    public static void main(String[] args) {
        Mahasiswa mhs1 = new Mahasiswa();

        mhs1.setNim("2017001");
        mhs1.setName("Agus");
        mhs1.setAlamat("Karawang");
        mhs1.setTugas1(80);
        mhs1.setTugas2(90);
        mhs1.setUpm(80);
        mhs1.setUas(80);
        list.add(mhs1);

        Mahasiswa mhs2 = new Mahasiswa();

        mhs2.setNim("2017001");
        mhs2.setName("Agus");
        mhs2.setAlamat("Karawang");
        mhs2.setTugas1(80);
        mhs2.setTugas2(90);
        mhs2.setUpm(80);
        mhs2.setUas(80);
        list.add(mhs2);

        Mahasiswa mhs3 = new Mahasiswa();

        mhs3.setNim("2017001");
        mhs3.setName("Agus");
        mhs3.setAlamat("Karawang");
        mhs3.setTugas1(80);
        mhs3.setTugas2(90);
        mhs3.setUpm(80);
        mhs3.setUas(80);
        list.add(mhs3);

        IMahasiswa service = new MahasiswaImpl();

        double hasil = service.rata(mhs1.getTugas1(), mhs1.getTugas2(), mhs1.getUpm(), mhs1.getUas());
        String grade = service.grade(hasil);

        System.out.println(list.get(0).getNim());
        System.out.println(list.get(0).getName());
        System.out.println(list.get(0).getAlamat());
        System.out.println(list.get(0).getTugas1());
        System.out.println(list.get(0).getTugas2());
        System.out.println(list.get(0).getUpm());
        System.out.println(list.get(0).getUas());

        System.out.println(hasil);
        System.out.println(grade);



    }
}
