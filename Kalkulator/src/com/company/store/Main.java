package com.company.store;

import java.util.Scanner;

public class Main {
    static  IKalkulator service = new KalkulatorImpl();

    public static void main(String[] args) {


        Kalkulator k1 = new Kalkulator();
        k1.setAngka1(9);
        k1.setAngka2(4);
        service.addAngka(k1);

        Kalkulator k2 = new Kalkulator();
        k2.setAngka1(6);
        k2.setAngka2(5);
        service.addAngka(k2);

        for (Kalkulator kal : service.getListAngka()){
            System.out.println(kal.getAngka1());
            System.out.println(kal.getAngka2());
            System.out.println();
            System.out.println();

            double hTambah = service.tambah(kal.getAngka1(),kal.getAngka2());
            double hKurang = service.kurang(kal.getAngka1(),kal.getAngka2());
            double hKali = service.kali(kal.getAngka1(),kal.getAngka2());
            double hBagi = service.bagi(kal.getAngka1(),kal.getAngka2());

            System.out.println(hTambah);
            System.out.println(hKurang);
            System.out.println(hKali);
            System.out.println(hBagi);

            System.out.println();
            System.out.println();
        }


/*        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan angka 1 : ");
        double a = input.nextDouble();
        System.out.print("Masukkan angka 2 : ");
        double b = input.nextDouble();

        System.out.println("Tambah     :" + service.tambah(a,b));
        System.out.println("Kurang     :" + service.kurang(a,b));
        System.out.println("Kali       :"+ service.kali(a,b));
        System.out.println("Bagi       :" + service.bagi(a,b));*/


    }
}