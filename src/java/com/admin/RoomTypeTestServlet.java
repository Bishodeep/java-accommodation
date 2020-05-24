/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin;

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
public class RoomTypeTestServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String formType = request.getParameter("formtype");
        RoomImplementation room = new RoomImplementation();
        if (formType == "room") {
            List<RoomViewModel> listRooms = room.GetRooms();
            //request.setAttribute("accommodationTypes", listRoomType);
            String htmlString = "";
            for (RoomViewModel item : listRooms) {
                htmlString += "<tr>\n"
                        + "<td>" + item.getTypeName() + "</td>\n"
                        + "<td>" + item.getLocation() + "</td>\n"
                        + "<td>" + item.getMonthlyCharge() + "</td>\n"
                        + "<td>" + item.getAvailable() + "</td>\n";
            }
            htmlString += "</tr>\n";
            response.getWriter().write(htmlString);
        } else {
            List<RoomViewModel> listRooms = room.GetRooms();
            //request.setAttribute("accommodationTypes", listRoomType);
            String htmlString = "";
            for (RoomViewModel item : listRooms) {
                htmlString += "<tr>\n"
                        + "<td>test</td>\n"
                        + "<td>test</td>\n"
                        + "<td>test</td>\n"
                        + "<td>test</td>\n";
            }
            htmlString += "</tr>\n";
            response.getWriter().write(htmlString);
        }

    }
}
