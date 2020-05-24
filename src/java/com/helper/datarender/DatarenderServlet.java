/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helper.datarender;

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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bishodeep
 */
public class DatarenderServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String formType = request.getParameter("datatype");
        int id = 0;
        if (request.getParameter("id") != null) {
            id = Integer.parseInt(request.getParameter("id"));
        }

        RoomImplementation room = new RoomImplementation();
        switch (formType) {
            case "rooms":
                List<RoomViewModel> listRooms = room.GetRooms();
                //request.setAttribute("accommodationTypes", listRoomType);
                String htmlString = "";
                for (RoomViewModel item : listRooms) {
                    htmlString += "<tr>\n"
                            + "<td>" + item.getTypeName() + "</td>\n"
                            + "<td>" + item.getLocation() + "</td>\n"
                            + "<td>" + item.getMonthlyCharge() + "</td>\n"
                            + "<td>" + item.getAvailable() + "</td>\n"
                            + "<td>" + item.getDescription() + "</td>\n"
                            + "<td><a class=\"btn btn-primary\"	href=\"booking?id=" + item.getId() + "\">Book now</a></td>\n";
                }
                htmlString += "</tr>\n";
                response.getWriter().write(htmlString);
                break;
            case "userroom":
                HttpSession sessionuser = request.getSession(false);
                int studentid = (int) sessionuser.getAttribute("userid");
                RoomViewModel roomModel = room.GetUserRoom(studentid);
                String htmlStringUserroom = "";
                htmlStringUserroom += "<tr>\n <td>Type of Room:</td>\n"
                        + "<td>" + roomModel.getTypeName() + "</td> <\tr>\n"
                        + "<tr><td>Location:</td> <td>" + roomModel.getLocation() + "</td> "
                        + "<\tr>\n"
                        + "<tr><td>Type of Room:</td>\n <td>" + roomModel.getTypeName() + "</td><\tr>\n"
                        + "<tr><td>Description:</td><td>" + roomModel.getDescription() + "</td><\tr>\n"
                        + "<tr><td colspan=\"2\"><a class=\"btn btn-primary\"href=\"payment\"/>Pay Rent now</a></td><\tr>\n";
                response.getWriter().write(htmlStringUserroom);
                break;
            case "roomtype":
                List<RoomTypeViewModel> listRoomType = room.GetRoomtype();
                String htmlStringRoomtype = "";
                for (RoomTypeViewModel item : listRoomType) {
                    htmlStringRoomtype += "<tr>\n"
                            + "<td>" + item.getType() + "</td>\n"
                            + "<td>" + item.getAvailable() + "</td>\n"
                            + "<td><a class=\"btn btn-success\"	href=\"roomtypeupdate?id=" + item.getId() + "\">Edit</a>"
                            + "<a class=\"btn btn-danger\"href=\"roomtypedelete?id=" + item.getId() + "\">Delete</a></td>\n";
                }
                htmlStringRoomtype += "</tr>\n";
                response.getWriter().write(htmlStringRoomtype);
                break;
            case "adminrooms":
                List<RoomViewModel> listRoomsAdmin = room.GetRooms();
                //request.setAttribute("accommodationTypes", listRoomType);
                String htmlStringRoomAdmin = "";
                for (RoomViewModel item : listRoomsAdmin) {
                    htmlStringRoomAdmin += "<tr>\n"
                            + "<td>" + item.getTypeName() + "</td>\n"
                            + "<td>" + item.getLocation() + "</td>\n"
                            + "<td>" + item.getMonthlyCharge() + "</td>\n"
                            + "<td>" + item.getAvailable() + "</td>\n"
                            + "<td>" + item.getDescription() + "</td>\n"
                            + "<td><a class=\"btn btn-success\"	href=\"updateroom?id=" + item.getId() + "\">Edit</a><a class=\"btn btn-danger\"	href=\"roomdelete?id=" + item.getId() + "\">Delete</a></td>\n";
                }
                htmlStringRoomAdmin += "</tr>\n";
                response.getWriter().write(htmlStringRoomAdmin);
                break;
            case "assignroom":
                List<StudentRoomViewModel> userRooms = room.GetStudentRooms();
                String htmlStringAssigns = "";
                for (StudentRoomViewModel item : userRooms) {
                    htmlStringAssigns += "<tr>\n"
                            + "<td>" + item.getName() + "</td>\n"
                            + "<td>" + item.getRoomType() + "</td>\n"
                            + "<td>" + item.getDescription() + "</td>\n"
                            + "<td>" + item.getPayment() + "</td>\n";
                }
                htmlStringAssigns += "</tr>\n";
                response.getWriter().write(htmlStringAssigns);
                break;
            case "updateroomtype":
                RoomTypeViewModel roomTypeModel = room.GetRoomtypeId(id);
                String htmlStringupdateRoomType = "";
                htmlStringupdateRoomType += "<input type=\"text\" class=\"form-control\" name=\"id\"\n"
                        + "                                   placeholder=\"Enter type of room\" hidden value=\"" + roomTypeModel.getId() + "\">\n"
                        + "                            <div class=\"form-group row\">\n"
                        + "                                <label for=\"type\" class=\"col-sm-2 col-form-label\"> Type</label>\n"
                        + "                                <div class=\"col-sm-7\">\n"
                        + "                                    <input type=\"text\" class=\"form-control\" name=\"type\"\n"
                        + "                                           placeholder=\"Enter type of room\" value=\"" + roomTypeModel.getType() + "\" >\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "\n"
                        + "                            <div class=\"form-group row\">\n"
                        + "                                <label for=\"available\" class=\"col-sm-2 col-form-label\">\n"
                        + "                                    Available Number</label>\n"
                        + "                                <div class=\"col-sm-7\">\n"
                        + "                                    <input type=\"text\" class=\"form-control\" name=\"available\"\n"
                        + "                                           placeholder=\"Enter number of room available.\"\n"
                        + "                                          value=\"" + roomTypeModel.getAvailable() + "\" >\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "\n"
                        + "                            <button type=\"submit\" class=\"btn btn-primary\"\n"
                        + "                                    style=\"align-items: center;\">Edit</button>";
                response.getWriter().write(htmlStringupdateRoomType);
                break;
            case "updateroom":
                RoomViewModel roomupdateModel = room.GetRoomId(id);
                List<RoomTypeViewModel> roomTypes = room.GetRoomtype();
                String htmlUpdateRoom = "<input type=\"text\" class=\"form-control\" name=\"id\"\n"
                        + "                                   placeholder=\"Enter type of room\" hidden value=\"" + roomupdateModel.getId() + "\">\n"
                        + "                            <div class=\"form-group row\">\n"
                        + "                                <label for=\"location\" class=\"col-sm-2 col-form-label\">\n"
                        + "                                    Select a Type:&nbsp; </label>\n"
                        + "                                <div class=\"col-sm-7\">\n"
                        + "                                    <select name=\"type\" class=\"form-control\">\n";

                for (RoomTypeViewModel type : roomTypes) {
                    htmlUpdateRoom = htmlUpdateRoom + " <option value=\"" + type.getId() + "\">" + type.getType() + "</option>";
                }
                htmlUpdateRoom = htmlUpdateRoom + "                                    </select>\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"form-group row\">\n"
                        + "                                <label for=\"location\" class=\"col-sm-2 col-form-label\">\n"
                        + "                                    Location</label>\n"
                        + "                                <div class=\"col-sm-7\">\n"
                        + "                                    <input type=\"text\" class=\"form-control\" name=\"location\"\n"
                        + "                                           placeholder=\"Enter location of room.\" value=\"" + roomupdateModel.getLocation() + "\" >\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"form-group row\">\n"
                        + "                                <label for=\"charge\" class=\"col-sm-2 col-form-label\">\n"
                        + "                                    Monthly Charge</label>\n"
                        + "                                <div class=\"col-sm-7\">\n"
                        + "                                    <input type=\"text\" class=\"form-control\" name=\"charge\"\n"
                        + "                                           placeholder=\"Enter monthly charge.\" value=\"" + roomupdateModel.getMonthlyCharge() + "\">\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"form-group row\">\n"
                        + "                                <label for=\"description\" class=\"col-sm-2 col-form-label\">\n"
                        + "                                    Description</label>\n"
                        + "                                <div class=\"col-sm-7\">\n"
                        + "                                    <input type=\"text\" class=\"form-control\" name=\"description\"\n"
                        + "                                           placeholder=\"Enter description.\" value=\"" + roomupdateModel.getDescription() + "\">\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                            <button type=\"submit\" class=\"btn btn-primary\"\n"
                        + "                                    style=\"align-items: center;\">Add</button>";
                response.getWriter().write(htmlUpdateRoom);
                break;
            case "typeDropdown":
                List<RoomTypeViewModel> typeDw = room.GetRoomtype();
                String typeDwstring = "";
                for (RoomTypeViewModel type : typeDw) {
                    typeDwstring = typeDwstring + " <option value=\"" + type.getId() + "\">" + type.getType() + "</option>";
                }
                response.getWriter().write(typeDwstring);
                break;
            default:
                break;

        }

    }
}
