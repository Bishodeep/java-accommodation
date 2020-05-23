/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.room;

import com.dataaccesslayer.RoomImplementation;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class PaymentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        int id = (int) session.getAttribute("userid");
        try {
            RoomImplementation room = new RoomImplementation();
            boolean payment = room.UpdatePayment(id);
            if (payment) {
                RequestDispatcher resDispatcher = request.getRequestDispatcher("user");
                request.setAttribute("message", "Payment successfull !!");
                resDispatcher.forward(request, response);
            } else {
                RequestDispatcher resDispatcher = request.getRequestDispatcher("user");
                request.setAttribute("message", "Payment unsuccessful !!");
                resDispatcher.forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(PaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
