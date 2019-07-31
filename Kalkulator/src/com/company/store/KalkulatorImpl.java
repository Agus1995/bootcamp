package com.company.store;

import java.util.ArrayList;
import java.util.List;

public class KalkulatorImpl implements IKalkulator {

    private List<Kalkulator> list = new ArrayList<>();

    @Override
    public double tambah(double a1, double a2) {
        double hasil = a1 + a2;
        return hasil;
    }

    @Override
    public double kurang(double a1, double a2) {
        double hasil = a1 - a2;
        return hasil;
    }

    @Override
    public double kali(double a1, double a2) {
        double hasil = a1 * a2;
        return hasil;
    }

    @Override
    public double bagi(double a1, double a2) {
        double hasil = a1 / a2;
        return hasil;
    }
    @Override
    public List<Kalkulator> getListAngka() {
        return list;
    }

    @Override
    public void addAngka(Kalkulator kalkulator) {
        list.add(kalkulator);
    }
}
