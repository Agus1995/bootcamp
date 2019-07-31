package com.pratice2.main;

import java.util.List;

public interface IMahasiswa2 {
	double getAverage(double tugas1, double tugas2, double upm, double uas);
	
	String getGrade(double average);
	
	void tambahData(Mahasiswa2 siswa);
	
	List<Mahasiswa2> getListMahasiswa();
	
	void hapusDataSiswa(String nim);
}
