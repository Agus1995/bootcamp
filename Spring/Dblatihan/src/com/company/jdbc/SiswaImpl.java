package com.company.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SiswaImpl implements  SiswaDao{
    private DBUtil dbUtil;
    Koneksi koneksi = new Koneksi();
    public SiswaImpl() {
        try {
            dbUtil = new DBUtil(koneksi.connectDB());
        }catch (SQLException | ClassNotFoundException se){
            se.printStackTrace();
        }
    }
    @Override
    public List<Siswa> getAllStudent() {
        List<Siswa>list = new ArrayList<>();
        try {
            list = dbUtil.getAllStudent();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
