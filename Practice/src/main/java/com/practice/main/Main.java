package com.practice.main;

public class Main {
	
	public static void main(String[] args) {
		Mahasiswa siswa = new Mahasiswa();
		siswa.nim = "1234";
		siswa.firstName = "Budi";
		siswa.lastName = "Sucipto";
		siswa.alamat = "Jalan Pancoran Barat No. 43";
		
		System.out.println("| " + padRight("NIM", 8) + "| " + padRight("Full Name", 15) + "| " + padRight("Alamat", 30) + "|");
		System.out.println("| " + padRight(siswa.nim, 8) + "| " + padRight(siswa.getFullName(), 15) + "| " + padRight(siswa.alamat, 30) + "|");
	}
	
	public static String padRight(String inputString, int length){
		return String.format("%1$-" + length + "s", inputString);
	}
}
