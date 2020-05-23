/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import com.authorization.AuthorizationServlet;
import com.dataaccesslayer.RoomImplementation;
import com.entitymodel.RoomTypeViewModel;
import com.entitymodel.RoomViewModel;
import com.entitymodel.StudentRoomViewModel;
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
public class AdminServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RoomImplementation roomAccess = new RoomImplementation();
        List<RoomTypeViewModel> listRoomType = roomAccess.GetRoomtype();
        request.setAttribute("accommodationTypes", listRoomType);

        List<RoomViewModel> listRooms = roomAccess.GetRooms();
        request.setAttribute("accommodations", listRooms);

        List<StudentRoomViewModel> studentRooms = roomAccess.GetStudentRooms();
        request.setAttribute("assignRooms", studentRooms);
        AuthorizationServlet.getPage(request, response, "admin").forward(request, response);
    }

}
