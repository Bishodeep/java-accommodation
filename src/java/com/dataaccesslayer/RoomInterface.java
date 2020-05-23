/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataaccesslayer;

import com.entitymodel.RoomTypeViewModel;
import com.entitymodel.RoomViewModel;
import com.entitymodel.StudentRoomViewModel;
import java.util.List;

/**
 *
 * @author Bishodeep
 */
public interface RoomInterface {
    public boolean InserRoom(RoomViewModel roomModel);
    public  List<RoomViewModel> GetRooms();
    public RoomViewModel GetRoomId(int id);
    public  RoomViewModel GetUserRoom(int userid);
    public  boolean UpdatePayment(int id);
    public  List<StudentRoomViewModel> GetStudentRooms();
    public boolean UpdateRoom(RoomViewModel roomModel);
    public  boolean RemoveRoom(int id);
    public  boolean BookRoom(int roomid, int userid);
    public  boolean InsertRoomtype(RoomTypeViewModel roomtypeModel);
    public List<RoomTypeViewModel> GetRoomtype();
    public  RoomTypeViewModel GetRoomtypeId(int id);
    public  boolean UpdateRoomtype(RoomTypeViewModel roomTypeModel);
    public  boolean RemoveRoomtype(int id);
}
