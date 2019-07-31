package com.sti.bootcamp.looping;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args){
        Triangle tri = new Triangle();
        Square squ = new Square();

        tri.setA(7);
        tri.setT(4);
        squ.setSisi(30);

        List<Shape> list = new ArrayList<>();

        list.add(tri);
        list.add(squ);

        printall(list);
    }

    public static void printall(List<Shape> luasbangun){
        for (Shape x :luasbangun){
            System.out.println(x.luas());
        }
/*
        double total = tr.luas() + squ.luas();

        System.out.println("Luas Segitiga :" + tr .luas());
        System.out.println("Luas Persegi :" + squ.luas());
        System.out.println("Luas total :" + total);
*/
    }
}
