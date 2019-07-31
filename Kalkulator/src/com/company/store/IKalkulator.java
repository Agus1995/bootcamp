package com.company.store;

import java.util.List;

public interface IKalkulator {

    double tambah(double a1, double a2);
    double kurang(double a1, double a2);
    double kali(double a1, double a2);
    double bagi(double a1, double a2);

    List<Kalkulator> getListAngka();
    void addAngka(Kalkulator kalkulator);


}
