package com.practice.main;

public class Mahasiswa {
	String nim;
	String firstName;
	String lastName;
	String alamat;
	
	public Mahasiswa(){
	}
	
	public String getFullName(){
		return firstName + " " + lastName;
	}
}
