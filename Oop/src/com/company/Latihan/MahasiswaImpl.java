package com.company.Latihan;

public class MahasiswaImpl implements IMahasiswa {

    Mahasiswa siswa = new Mahasiswa();


    @Override
    public String getFullName() {
        return siswa.getFullName();
    }

    @Override
    public void setFullName(String firstname, String lastname) {
        siswa.firstname = firstname;
        siswa.lastname = lastname;
    }
}
