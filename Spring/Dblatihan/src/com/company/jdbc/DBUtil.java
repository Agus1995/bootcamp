package com.company.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtil{
    private Connection connect = null;
    private Statement statement= null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet= null;

    public DBUtil(Connection connection){
        connect = connection;
    }

    public List<Siswa> getAllStudent() throws Exception{
        List<Siswa> list = new ArrayList<>();

        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT id, nama, no_hp, kelas FROM siswa");
            while (resultSet.next()){
                Siswa siswa = new Siswa();

                siswa.setId(resultSet.getInt("id"));
                siswa.setNama(resultSet.getString("nama"));
                siswa.setNo_hp(resultSet.getString("no_hp"));
                siswa.setKelas(resultSet.getString("kelas"));

                list.add(siswa);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

}
