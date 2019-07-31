package com.sti.bootcamp.looping;

public class Square implements Shape {

    private double sisi;

    public double getSisi() {
        return sisi;
    }

    public void setSisi(double sisi) {
        this.sisi = sisi;
    }

    public double luas(){
        double luas = sisi * sisi;
        return luas;

    }
}
