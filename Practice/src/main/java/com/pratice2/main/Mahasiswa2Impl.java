package com.pratice2.main;

import java.util.ArrayList;
import java.util.List;

public class Mahasiswa2Impl implements IMahasiswa2 {

	// Initiate list mahasiswa
	private List<Mahasiswa2> listMhs = new ArrayList<>();

	@Override
	public double getAverage(double tugas1, double tugas2, double upm, double uas) {
		return (tugas1 + tugas2 + upm + uas) / 4;
	}

	@Override
	public String getGrade(double average) {
		if (average > 90) {
			return "A";
		} else if (average >= 80) {
			return "B";
		} else if (average > 70) {
			return "C";
		} else if (average > 60) {
			return "D";
		} else {
			return "E";
		}
	}

	@Override
	public void tambahData(Mahasiswa2 siswa) {
		listMhs.add(siswa);
	}

	@Override
	public List<Mahasiswa2> getListMahasiswa() {
		return listMhs;
	}

	@Override
	public void hapusDataSiswa(String nim) {
		int i = 0;
		boolean found = false;
		for (Mahasiswa2 mahasiswa2 : listMhs) {			
			if (mahasiswa2.getNim() == nim) {
				found = true;
				break;
			}	
			i += 1;
		}
		
		if (found){
			listMhs.remove(i);
		}		
	}
}
