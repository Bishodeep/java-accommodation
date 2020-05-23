/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin;

import com.dataaccesslayer.RoomImplementation;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bishodeep
 */
public class RoomDeleteServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int roomid = Integer.parseInt(request.getParameter("id"));
        RoomImplementation room = new RoomImplementation();
        if (room.RemoveRoom(roomid)) {
            response.sendRedirect("admin");
        } else {
            response.sendRedirect("admin");
        }
    }
}
