package com.sti.bootcamp.controller;

public class Main {
    public static double hitung(double absen, double uts, double uas){
        double nabsen = 0.2 * absen;
        double nuts = uts*0.3;
        double nuas = uas*0.5;
        double nakhir = nabsen+nuts+nuas;
        return nakhir;
    }

    public static String grade(double hasil){

        String grade;

        if(hasil>=85){
            grade = "A";
        }else if(hasil>=75){
            grade =  "B";
        }else if(hasil>=60){
            grade = "C";
        }else {
            grade = "D";
        }
        return grade;
    }

    public static void main (String[] args){
        double abs = 100;
        double uts = 80;
        double uas = 80;

        double hasil = hitung(abs,uts,uas);

        String akhir = grade(hasil);

        System.out.println(hasil);
        System.out.println(akhir);

    }
}
