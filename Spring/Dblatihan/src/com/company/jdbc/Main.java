package com.company.jdbc;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static SiswaDao siswaDao = new SiswaImpl();

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        printAll(siswaDao.getAllStudent());
    }

    private static void printAll (List<Siswa> siswas){
        try {
            System.out.println("get all data");
            for (Siswa siswa: siswas){
                System.out.println(siswa.getId());
                System.out.println(siswa.getNama());
                System.out.println(siswa.getKelas());
                System.out.println(siswa.getNo_hp());

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
