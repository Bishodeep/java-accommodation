/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.room;

import com.dataaccesslayer.RoomImplementation;
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
public class BookingServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int roomid = Integer.parseInt(request.getParameter("id"));
        HttpSession sessionuser = request.getSession(false);
        int studentid = (int) sessionuser.getAttribute("userid");
        RoomImplementation room = new RoomImplementation();
        if (room.BookRoom(roomid, studentid)) {
            RequestDispatcher resDispatcher = request.getRequestDispatcher("user");
            request.setAttribute("message", "Booking successfull check you room details");
            resDispatcher.forward(request, response);
        } else {
            RequestDispatcher resDispatcher = request.getRequestDispatcher("user");
            request.setAttribute("message", "You already have a book in your name");
            resDispatcher.forward(request, response);
        }
    }
}
