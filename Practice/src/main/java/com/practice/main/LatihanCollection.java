package com.practice.main;

import java.util.ArrayList;
import java.util.List;

public class LatihanCollection {
	
	static int[] no = new int[5];
	static List<Mahasiswa> listSiswa = new ArrayList<>();
	Mahasiswa[] lstSiswa = new Mahasiswa[2];
	
	public static void main(String[] args) {
		no[0] = 1;
		no[1] = 2;
		no[2] = 3;
		no[3] = 4;
		no[4] = 5;
		
		System.out.println("No - : " + no[0]);
		System.out.println("No - : " + no[4]);
		
		Mahasiswa siswa = new Mahasiswa();
		siswa.nim = "1234";
		siswa.firstName = "Budi";
		siswa.lastName = "Sucipto";
		siswa.alamat = "Jalan Pancoran Barat No. 43";
		listSiswa.add(siswa);
		
		Mahasiswa kelas = new Mahasiswa();
		kelas.nim = "1233";
		kelas.firstName = "Susi";
		kelas.lastName = "Susanti";
		kelas.alamat = "Jalan Pancoran Barat No. 43";
		listSiswa.add(kelas);
		
		System.out.println("NIM : " + listSiswa.get(0).nim);
		System.out.println("Nama : " + listSiswa.get(0).getFullName());
		System.out.println("Alamat : " + listSiswa.get(0).alamat);		
		System.out.println("==================");
		System.out.println("NIM : " + listSiswa.get(0).nim);
		System.out.println("Nama : " + listSiswa.get(0).getFullName());
		System.out.println("Alamat : " + listSiswa.get(0).alamat);		
	}
}
