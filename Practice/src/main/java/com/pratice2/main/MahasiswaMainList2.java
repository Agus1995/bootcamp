package com.pratice2.main;

public class MahasiswaMainList2 {

	public static void main(String[] args) {
		// Iniate object interface
		IMahasiswa2 siswaService = new Mahasiswa2Impl();

		// Add data mahasiswa
		Mahasiswa2 siswa1 = new Mahasiswa2();
		siswa1.setNim("2017001");
		siswa1.setName("Budi Sucipto");
		siswa1.setAlamat("Tangerang");
		siswa1.setTugas1(70);
		siswa1.setTugas2(90);
		siswa1.setUpm(80);
		siswa1.setUas(80);
		siswaService.tambahData(siswa1);

		// Add data mahasiswa
		Mahasiswa2 siswa2 = new Mahasiswa2();
		siswa2.setNim("2017002");
		siswa2.setName("Susi Susanti");
		siswa2.setAlamat("Tangerang");
		siswa2.setTugas1(70);
		siswa2.setTugas2(80);
		siswa2.setUpm(80);
		siswa2.setUas(70);
		siswaService.tambahData(siswa2);

		// Add data mahasiswa
		Mahasiswa2 siswa3 = new Mahasiswa2();
		siswa3.setNim("2017003");
		siswa3.setName("Alan Budi Kusuma");
		siswa3.setAlamat("Tangerang");
		siswa3.setTugas1(70);
		siswa3.setTugas2(60);
		siswa3.setUpm(80);
		siswa3.setUas(70);
		siswaService.tambahData(siswa3);

		// Print Header Table
		System.out.println("| " + padRight("No", 3) + "| " + padRight("NIM", 8) + "| " + padRight("Full Name", 20)
				+ "| " + padRight("Tugas", 3) + "|" + padRight("UPM", 3) + "|" + padRight("UAS", 3) + "|"
				+ padRight("Rata-rata", 3) + "|" + padRight("Grade", 3) + "|");

		// Initiate Number of Row
		int i = 1;

		// hapus data
		siswaService.hapusDataSiswa("2017003");
		
		// Looping data
		for (Mahasiswa2 mahasiswa2 : siswaService.getListMahasiswa()) {

			// Get nilai rata-rata
			double rataSiswa = siswaService.getAverage(mahasiswa2.getTugas1(), mahasiswa2.getTugas2(),
					mahasiswa2.getUpm(), mahasiswa2.getUas());

			// print data mahasiswa
			System.out.println("|" + padRight("" + i, 3) + "| " + padRight(mahasiswa2.getNim(), 8) + "| "
					+ padRight(mahasiswa2.getName(), 20) + "| "
					+ padRight("" + ((mahasiswa2.getTugas1() + mahasiswa2.getTugas2()) / 2), 3) + "|"
					+ padRight("" + mahasiswa2.getUpm(), 3) + "|" + padRight("" + mahasiswa2.getUas(), 3) + "|"
					+ padRight("" + rataSiswa, 3) + "|" + padRight("" + siswaService.getGrade(rataSiswa), 3) + "|");

			// next row number
			i += 1;
		}
	}

	public static String padRight(String inputString, int length) {
		return String.format("%1$-" + length + "s", inputString);

	}
}
