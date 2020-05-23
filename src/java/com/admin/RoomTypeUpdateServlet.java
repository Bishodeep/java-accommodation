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
public class RoomTypeUpdateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RoomImplementation room = new RoomImplementation();
        RoomTypeViewModel roomTypeModel = room.GetRoomtypeId(id);
        request.setAttribute("Room", roomTypeModel);
        AuthorizationServlet.getPage(request, response, "roomtypeupdate").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String roomtype = request.getParameter("type");
        int roomavailable = Integer.parseInt(request.getParameter("available"));
        int roomid = Integer.parseInt(request.getParameter("id"));
        RoomTypeViewModel roomTypeModel = new RoomTypeViewModel(roomid, roomtype, roomavailable);
        RoomImplementation room = new RoomImplementation();
        if (room.UpdateRoomtype(roomTypeModel)) {
            response.sendRedirect("admin");
        } else {
            response.sendRedirect("roomtypeupdate");
        }
    }
}
