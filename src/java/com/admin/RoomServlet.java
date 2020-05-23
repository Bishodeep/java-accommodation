/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin;

import com.authorization.AuthorizationServlet;
import com.dataaccesslayer.RoomImplementation;
import com.entitymodel.RoomTypeViewModel;
import com.entitymodel.RoomViewModel;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bishodeep
 */
public class RoomServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomImplementation rooms = new RoomImplementation();
        List<RoomTypeViewModel> listRooms = rooms.GetRoomtype();
        request.setAttribute("listRoom", listRooms);
        AuthorizationServlet.getPage(request, response, "addroom").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int typename = Integer.parseInt(request.getParameter("type"));
        String location = request.getParameter("location");
        String description = request.getParameter("description");
        int charge = Integer.parseInt(request.getParameter("charge"));
        RoomViewModel roomModel = new RoomViewModel(typename, true, location, charge, description);
        RoomImplementation rooms = new RoomImplementation();
        if (rooms.InserRoom(roomModel)) {
            response.sendRedirect("admin");
        } else {

            response.sendRedirect("addroom");
        }
    }
}
