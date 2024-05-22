package com.example.exam20.controller;

import com.example.exam20.dao.EmployeeDAO;
import com.example.exam20.entity.Employee;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
    EmployeeDAO dao = null;
    Employee employee = null;
    @Override
    public void init() throws ServletException {
        dao = new EmployeeDAO();
        employee = new Employee();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewFrom(req, resp);
                    break;
                case "/add":
                    addEmployee(req, resp);
                    break;
                case "/delete":
                    deleteEmployee(req, resp);
                    break;
                default:
                    getAllEmployees(req,resp);
                    break;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);

        }
    }



    private void  getAllEmployees(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<Employee> list = dao.getAllEmployees();
        req.setAttribute("listEmployee", list);

        RequestDispatcher dispatcher = req.getRequestDispatcher("employee.jsp");
        dispatcher.forward(req, resp);
    }
    private void addEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String cmnd = req.getParameter("cmnd");
        String name = req.getParameter("name");
        String bird = req.getParameter("bird");
        String address = req.getParameter("address");
        String position = req.getParameter("position");
        String work_room = req.getParameter("work_room");

        employee.setCmnd(cmnd);
        employee.setName(name);
        employee.setBird(bird);
        employee.setAddress(address);
        employee.setPosition(position);
        employee.setWork_room(work_room);

        dao.addEmployee(employee);
        RequestDispatcher rd = req.getRequestDispatcher("employee.jsp");
        rd.forward(req, resp);

    }

    private void showNewFrom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("add-employee.jsp");
        dispatcher.forward(req, resp);
    }

    private void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        dao.deleteEmployee();
        RequestDispatcher dispatcher = req.getRequestDispatcher("employee.jsp");
        dispatcher.forward(req, resp);
    }
}
