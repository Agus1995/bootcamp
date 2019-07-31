package com.practice.main;

public class MahasiswaImpl implements IMahasiswa {

	Mahasiswa siswa = new Mahasiswa();

	@Override
	public String getFullName() {
		return siswa.getFullName();
	}

	@Override
	public void setFullName(String firstName, String lastName) {
		siswa.firstName = firstName;
		siswa.lastName = lastName;
	}
}
