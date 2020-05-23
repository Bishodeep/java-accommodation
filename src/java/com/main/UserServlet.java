/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import com.authorization.AuthorizationServlet;
import com.dataaccesslayer.RoomImplementation;
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
public class UserServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomImplementation room = new RoomImplementation();
        List<RoomViewModel> listRooms = room.GetRooms();
        request.setAttribute("listRoom", listRooms);
        AuthorizationServlet.getPage(request, response, "user").forward(request, response);
    }
}
