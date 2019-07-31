package com.sti.bootcamp.looping;

public class Triangle implements Shape {

    private double a;
    private double t;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }

    public double luas(){
        double luas = a * t;
        return luas;

    }
}
