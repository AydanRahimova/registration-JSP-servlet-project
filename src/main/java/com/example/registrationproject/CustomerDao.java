package com.example.registrationproject;

import jakarta.servlet.http.HttpServletRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    static final String URL = "jdbc:postgresql://localhost:5432/matrix161";
    static final String USER = "postgres";
    static final String PASSWORD = "2810";
    static Connection CONNECTION;


    public static void connect() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try {
            CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String registerCustomer(Customer customer) throws ClassNotFoundException {
        String INSERT_USER_SQL = "INSERT INTO customerjsp"
                + "(first_name, last_name,email, phone, birth_date,fin) VALUES "
                + "(?,?,?,?,?,?);";
        connect();
        try {
            if (fillCustomer(customer, INSERT_USER_SQL) > 0) {
                Customer.customers.add(customer);
                return "Data was successfully added";
            } else {
                return "Try again,data is not added";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static String updateCustomer(Customer customer) throws ClassNotFoundException {

        String UPDATE_USER_SQL = "UPDATE customerjsp SET first_name = ?, last_name=?,email = ?,phone=?,birth_date=? WHERE fin=?;";
        connect();
        try {
            if (fillCustomer(customer, UPDATE_USER_SQL) > 0) {
                return "Data was successfully updated";
            } else {
                return "Customer with " + customer.getFIN() + " is not found";
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Customer fillBlank(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String FIN = request.getParameter("FIN");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String birthDate = request.getParameter("birthDate");

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setFIN(FIN);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setBirthDate(Date.valueOf(birthDate));
        return customer;
    }


    private static int fillCustomer(Customer customer, String USER_SQL) throws SQLException {
        PreparedStatement preparedStatement = CONNECTION.prepareStatement(USER_SQL);
        preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getLastName());
        preparedStatement.setString(3, customer.getEmail());
        preparedStatement.setString(4, customer.getPhone());
        preparedStatement.setDate(5, customer.getBirhtDate());
        preparedStatement.setString(6, customer.getFIN());

        return preparedStatement.executeUpdate();
    }


    public static List<Customer> getCustomers() throws ClassNotFoundException {
        String GET_USER_SQL = "SELECT * FROM customerjsp";
        ResultSet rs;
        List<Customer> customers = new ArrayList<>();
        connect();
        try {
            Statement statement = CONNECTION.createStatement();
            rs = statement.executeQuery(GET_USER_SQL);
            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String FIN = rs.getString("fin");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                Date birthDate = rs.getDate("birth_date");


                Customer customer = new Customer();
                customer.setFirstName(firstName);
                customer.setLastName(lastName);
                customer.setFIN(FIN);
                customer.setEmail(email);
                customer.setPhone(phone);
                customer.setBirthDate(birthDate);
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

}
