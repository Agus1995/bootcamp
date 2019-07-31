package com.pratice2.main;

public class MahasiswaMain {

	public static void main(String[] args) {
		IMahasiswa2 siswaService = new Mahasiswa2Impl();
		
		Mahasiswa2 siswa = new Mahasiswa2();
		siswa.setNim("2017001");
		siswa.setName("Budi Sucipto");
		siswa.setAlamat("Tangerang");
		siswa.setTugas1(70);
		siswa.setTugas2(90);
		siswa.setUpm(80);
		siswa.setUas(80);
		
		double rataSiswa = siswaService.getAverage(siswa.getTugas1(), siswa.getTugas2(), siswa.getUpm(), siswa.getUas());
		
		System.out.println("==== Data Mahasiswa ====");
		System.out.println("NIM : " + siswa.getNim());
		System.out.println("Nama : " + siswa.getName());
		System.out.println("Alamat : " + siswa.getAlamat());
		System.out.println("Tugas 1 : " + siswa.getTugas1());
		System.out.println("Tugas 2 : " + siswa.getTugas2());
		System.out.println("UPM : " + siswa.getUpm());
		System.out.println("UAS : " + siswa.getUas());
		System.out.println("Rata-rata : " + rataSiswa);
		System.out.println("Grade : " + siswaService.getGrade(rataSiswa));
		
	}

}
