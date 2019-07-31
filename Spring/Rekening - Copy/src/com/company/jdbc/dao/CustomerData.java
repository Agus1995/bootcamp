package com.company.jdbc.dao;

import com.company.jdbc.entity.Customer;

import java.sql.*;

public class CustomerData {
    private Connection connect = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
    private static Customer cst = new Customer();

    public CustomerData(Connection connection){
        connect = connection;
    }

    public void addCustomer(Customer customer){
        String query = "INSERT INTO tb_customer (customer_number, first_name, last_name, birth_date) " +
                " VALUES (?,?,?,?)";
        try {
            statement = connect.prepareStatement(query);
            ((PreparedStatement) statement).setString(1,customer.getCustomer_number());
            ((PreparedStatement) statement).setString(2,customer.getFirst_name());
            ((PreparedStatement) statement).setString(3,customer.getLast_name());
            ((PreparedStatement) statement).setString(4,customer.getBirth_date());
            ((PreparedStatement) statement).executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getById(String id){
     //   int idnew = Integer.parseInt(id);
        try {
           String query = "SELECT * FROM tb_customer WHERE customer_number=?";
           PreparedStatement stmt = connect.prepareStatement(query);
           stmt.setString(1,id);
           resultSet = stmt.executeQuery();

            while (resultSet.next()){
                cst.setCustomer_number(resultSet.getString("customer_number"));
                cst.setFirst_name(resultSet.getString("first_name"));
                cst.setLast_name(resultSet.getString("last_name"));
                cst.setBirth_date(resultSet.getString("birth_date"));
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
        return cst;
    }
}
