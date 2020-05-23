/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.authorization;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bishodeep
 */
public class AuthorizationServlet extends HttpServlet {
	public static RequestDispatcher getPage(HttpServletRequest request, HttpServletResponse response, String PageName)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("username");
		if (username != null) {
			int userRole = (int) session.getAttribute("roleId");
                    switch (userRole) {
                        case 1:
                        {
                            RequestDispatcher resDispatcher = request.getRequestDispatcher(PageName + ".jsp");
                            return resDispatcher;
                        }
                        case 2:
                        {
                            RequestDispatcher resDispatcher = request.getRequestDispatcher(PageName + ".jsp");
                            return resDispatcher;
                        }
                        default:
                            break;
                    }
			RequestDispatcher resDispatcher = request.getRequestDispatcher("unauthorizedpage.html");
			return resDispatcher;
		} else

		{
			RequestDispatcher resDispatcher = request.getRequestDispatcher("errorpage.html");
			return resDispatcher;
		}

	}
}
