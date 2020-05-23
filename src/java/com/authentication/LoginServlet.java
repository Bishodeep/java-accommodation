/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.authentication;

import com.authentication.dataaccesslayer.AuthenticationImplementation;
import com.entitymodel.UserViewModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bishodeep
 */
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("/index");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession(true);
        AuthenticationImplementation auth = new AuthenticationImplementation();
        UserViewModel userModel = auth.AuthenticateUser(username, password);
        if (userModel != null) {
            session.setAttribute("username", userModel.getName());
            session.setAttribute("roleId", userModel.getRoleId());
            session.setAttribute("roleName", userModel.getRole());
            session.setAttribute("userid", userModel.getId());
            session.setAttribute("isAuthenticated", true);
            if (userModel.getRoleId() == 2) {
                response.sendRedirect("user");
            } else {
                response.sendRedirect("admin");
            }

        } else {
            request.setAttribute("message", "Login failed !!");
            request.setAttribute("hasMessage", true);
            response.sendRedirect("/index");
        }
    }
}
