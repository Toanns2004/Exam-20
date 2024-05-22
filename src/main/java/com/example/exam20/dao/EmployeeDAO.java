package com.example.exam20.dao;

import com.example.exam20.db.DBConnection;
import com.example.exam20.entity.Employee;
import jakarta.servlet.annotation.WebServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private static Connection con = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    private static final String INSERT = "insert into employee values(?,?,?,?,?.?)";
    private static final String SELECT_ALL = "select * from employee";
    private static final String DELETE = "DELETE FROM employee";
    public List<Employee> getAllEmployees() throws SQLException {
         List<Employee> employees = new ArrayList<>();
        con = DBConnection.getMySQLConnection();
        ps = con.prepareStatement(SELECT_ALL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String cmnd = rs.getString("cmnd");
            String name = rs.getString("name");
            String bird = rs.getString("bird_day");
            String address = rs.getString("address");
            String position = rs.getString("position");
            String work_room = rs.getString("work_room");
            employees.add(new Employee(cmnd,name,bird,address,position,work_room));
        }
        return employees;
    }
    public void addEmployee(Employee emp) throws SQLException {
        con = DBConnection.getMySQLConnection();
        ps = con.prepareStatement(INSERT);
        ps.setString(1,emp.getCmnd());
        ps.setString(2,emp.getName());
        ps.setString(3, emp.getBird());
        ps.setString(4, emp.getAddress());
        ps.setString(5, emp.getPosition());
        ps.setString(6, emp.getWork_room());
        ps.execute();

        if (con!= null) con.close();

        if (ps!= null) ps.close();
    }

    public void deleteEmployee() throws SQLException {
        con = DBConnection.getMySQLConnection();
        ps = con.prepareStatement(DELETE);
        ps.execute();
    }

}
