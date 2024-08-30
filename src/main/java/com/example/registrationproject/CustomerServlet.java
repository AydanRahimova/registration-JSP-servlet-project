package com.example.registrationproject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String option = request.getParameter("option");
        switch (option) {
            case "update":
                request.getRequestDispatcher("update.jsp").forward(request, response);
                break;
            case "add":
                request.getRequestDispatcher("register.jsp").forward(request, response);
                break;
            case "view":
                List<Customer> customers = null;
                try {
                    customers = CustomerDao.getCustomers();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                request.setAttribute("customers", customers);
                request.getRequestDispatcher("view.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

