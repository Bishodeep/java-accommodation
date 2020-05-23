/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.room;

import com.authorization.AuthorizationServlet;
import com.dataaccesslayer.RoomImplementation;
import com.entitymodel.RoomViewModel;
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
public class UserRoomServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessionuser = request.getSession(false);
        int studentid = (int) sessionuser.getAttribute("userid");
        RoomImplementation room = new RoomImplementation();
        RoomViewModel roomModel = room.GetUserRoom(studentid);
        request.setAttribute("room", roomModel);
        AuthorizationServlet.getPage(request, response, "userroom").forward(request, response);
    }
}
