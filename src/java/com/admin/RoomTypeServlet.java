/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin;

import com.authorization.AuthorizationServlet;
import com.dataaccesslayer.RoomImplementation;
import com.entitymodel.RoomTypeViewModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bishodeep
 */
public class RoomTypeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AuthorizationServlet.getPage(request, response, "roomtype").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String typename = request.getParameter("type");
        int available = Integer.parseInt(request.getParameter("available"));
        RoomTypeViewModel roomTypeModel = new RoomTypeViewModel(typename, available);
        RoomImplementation room = new RoomImplementation();
        if (room.InsertRoomtype(roomTypeModel)) {
            response.sendRedirect("admin");
        } else {
            System.out.print(room);
            response.sendRedirect("roomtype");
        }
    }
}
