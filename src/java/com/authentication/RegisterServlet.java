/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.authentication;

import com.authentication.dataaccesslayer.AuthenticationImplementation;
import com.entitymodel.RegistrationViewModel;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bishodeep
 */
public class RegisterServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher resDispatcher = request.getRequestDispatcher("Register.html");
        resDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("studentname");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        int contact = Integer.parseInt(request.getParameter("contact"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RegistrationViewModel registerModel = new RegistrationViewModel(name, age, address, contact, username, password);
        AuthenticationImplementation auth = new AuthenticationImplementation();
        if (auth.RegisterUser(registerModel)) {
            response.sendRedirect("/index");
        } else {
            request.setAttribute("message", "Registration failed !!");
            request.setAttribute("hasMessage", true);
            response.sendRedirect("register");
        }
    }
}
