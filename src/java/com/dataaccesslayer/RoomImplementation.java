/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataaccesslayer;

import com.entitymodel.RoomTypeViewModel;
import com.entitymodel.RoomViewModel;
import com.entitymodel.StudentRoomViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bishodeep
 */
public class RoomImplementation implements RoomInterface {

    @Override
    public boolean InserRoom(RoomViewModel roomModel) {
        try {
            Connection con = DatabaseConfiguration.SetDatabaseConfig();
            PreparedStatement queryRoomGet = con.prepareStatement("select * from accommodationtypes where Id=?");
            queryRoomGet.setInt(1, roomModel.getTypeID());
            ResultSet room = queryRoomGet.executeQuery();
            if (room.next()) {
                String typename = room.getString("Name");
                PreparedStatement queryRoom = con.prepareStatement("insert into accommodationdetails values(?,?,?,?,?,?,?)");
                queryRoom.setString(1, null);
                queryRoom.setInt(2, roomModel.getTypeID());
                queryRoom.setString(3, roomModel.getLocation());
                queryRoom.setInt(4, roomModel.getMonthlyCharge());
                queryRoom.setString(5, typename);
                queryRoom.setBoolean(6, roomModel.getAvailable());
                queryRoom.setString(7, roomModel.getDescription());
                queryRoom.execute();
                queryRoom.close();
            }

            con.close();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    @Override
    public List<RoomViewModel> GetRooms() {
        try {
            List<RoomViewModel> listroomTypeModel = new ArrayList<>();
            Connection con = DatabaseConfiguration.SetDatabaseConfig();
            PreparedStatement queryRoomGet = con.prepareStatement("select * from accommodationdetails");
            ResultSet rooms = queryRoomGet.executeQuery();
            while (rooms.next()) {
                String location = rooms.getString("Location");
                String description = rooms.getString("Description");
                boolean available = rooms.getBoolean("Available");
                String typename = rooms.getString("TypeName");
                int charge = rooms.getInt("MonthlyCharge");
                int id = rooms.getInt("Id");
                int typeid = rooms.getInt("TypeId");
//				PreparedStatement queryRoomavailable = con.prepareStatement(
//						"select * from room_details where id=?");
//				queryRoomavailable.setInt(1, id);
//				ResultSet roomavailable = queryRoomavailable.executeQuery();

//				if (roomavailable.next()) {
//					int available = roomavailable.getInt("available");
//					boolean isAvailable = true;
//					if (available <= 0) {
//						isAvailable = false;
//						return false;
//					}
//				}
                RoomViewModel roomTypeModel = new RoomViewModel(id, typeid, typename, available, location, charge, description);
                listroomTypeModel.add(roomTypeModel);
            }
            con.close();
            return listroomTypeModel;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    @Override
    public RoomViewModel GetRoomId(int id) {
        try {
            RoomViewModel roomTypeModel = null;
            Connection con = DatabaseConfiguration.SetDatabaseConfig();
            PreparedStatement queryRoomGet = con.prepareStatement("select * from accommodationdetails where Id=?");
            queryRoomGet.setInt(1, id);
            ResultSet rooms = queryRoomGet.executeQuery();
            if (rooms.next()) {
                String location = rooms.getString("Location");
                String description = rooms.getString("Description");
                boolean available = rooms.getBoolean("Available");
                String typename = rooms.getString("TypeName");
                int charge = rooms.getInt("MonthlyCharge");
                int idroom = rooms.getInt("Id");
                int typeid = rooms.getInt("TypeId");
                roomTypeModel = new RoomViewModel(idroom, typeid, typename, available, location, charge, description);
            }
            return roomTypeModel;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    @Override
    public RoomViewModel GetUserRoom(int userid) {
        try {
            RoomViewModel roomTypeModel = null;
            Connection con = DatabaseConfiguration.SetDatabaseConfig();
            PreparedStatement queryStudent = con.prepareStatement("select * from studentdetails where UserId=?");
            queryStudent.setInt(1, userid);
            ResultSet student = queryStudent.executeQuery();
            if (student.next()) {
                PreparedStatement queryStudentRoom = con
                        .prepareStatement("select * from userrooms where StudentId=?");
                queryStudentRoom.setInt(1, student.getInt("Id"));
                ResultSet room = queryStudentRoom.executeQuery();
                if (room.next()) {
                    PreparedStatement queryRoomGet = con.prepareStatement("select * from accommodationdetails where Id=?");
                    queryRoomGet.setInt(1, room.getInt("RoomId"));
                    ResultSet rooms = queryRoomGet.executeQuery();
                    if (rooms.next()) {
                        String location = rooms.getString("Location");
                        String description = rooms.getString("Description");
                        boolean available = rooms.getBoolean("Available");
                        String typename = rooms.getString("TypeName");
                        int charge = rooms.getInt("MonthlyCharge");
                        int idroom = rooms.getInt("Id");
                        int typeid = rooms.getInt("TypeId");
                        roomTypeModel = new RoomViewModel(idroom, typeid, typename, available, location, charge,
                                description);
                    }
                }
            }

            return roomTypeModel;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    @Override
    public boolean UpdatePayment(int id) {
        try {
            Connection con = DatabaseConfiguration.SetDatabaseConfig();
            PreparedStatement queryRoomCheck = con
                    .prepareStatement("select * from UserRoom where UserId=?");
            queryRoomCheck.setInt(1, id);
            ResultSet roomcheck = queryRoomCheck.executeQuery();
            if (roomcheck.next()) {
                PreparedStatement queryRoom = con.prepareStatement("update UserRoom"
                        + " set Payment=1 where Id=?");
                queryRoom.setInt(1, roomcheck.getInt("Id"));
                boolean updated = queryRoom.executeUpdate() > 0;
                return updated;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<StudentRoomViewModel> GetStudentRooms() {
        try {
            List<StudentRoomViewModel> studentRooms = new ArrayList<StudentRoomViewModel>();
            Connection con = DatabaseConfiguration.SetDatabaseConfig();
            PreparedStatement queryRoomGet = con.prepareStatement("select sd.Name,rd.TypeName,rd.Description,sr.Payment from userrooms as sr left join accommodationdetails as rd on sr.RoomId =rd.Id left join studentdetails as sd on sr.StudentId =sd.Id;");
            ResultSet rooms = queryRoomGet.executeQuery();
            if (rooms.next()) {
                String name = rooms.getString("Name");
                String description = rooms.getString("Description");
                String roomType = rooms.getString("TypeName");
                boolean payment = rooms.getBoolean("Payment");
                StudentRoomViewModel studentRoom = new StudentRoomViewModel(name, description, roomType, payment);
                studentRooms.add(studentRoom);
            }
            return studentRooms;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    @Override
    public boolean UpdateRoom(RoomViewModel roomModel) {
        try {
            Connection con = DatabaseConfiguration.SetDatabaseConfig();
            PreparedStatement queryRoomGet = con.prepareStatement("select * from accommodationtypes where Id=?");
            queryRoomGet.setInt(1, roomModel.getTypeID());
            ResultSet room = queryRoomGet.executeQuery();
            if (room.next()) {
                String typename = room.getString("Name");

                PreparedStatement queryRoom = con.prepareStatement(
                        "update accommodationdetails set TypeName=?, Available=?,Location=?,MonthlyCharge=?,"
                        + "Description=?,TypeId=? where Id=?");
                queryRoom.setString(1, typename);
                queryRoom.setBoolean(2, true);
                queryRoom.setString(3, roomModel.getLocation());
                queryRoom.setInt(4, roomModel.getMonthlyCharge());
                queryRoom.setString(5, roomModel.getDescription());
                queryRoom.setInt(6, roomModel.getTypeID());
                queryRoom.setInt(7, roomModel.getId());
                boolean rowUpdated = queryRoom.executeUpdate() > 0;

                queryRoom.close();
                con.close();
                return rowUpdated;
            }
            return false;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    @Override
    public boolean RemoveRoom(int id) {
        try {
            Connection con = DatabaseConfiguration.SetDatabaseConfig();
            PreparedStatement queryRoom = con.prepareStatement("delete from accommodationdetails  where Id=?");
            queryRoom.setInt(1, id);
            boolean deleted = queryRoom.executeUpdate() > 0;
            return deleted;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    @Override
    public boolean BookRoom(int roomid, int userid) {
        try {
            Connection con = DatabaseConfiguration.SetDatabaseConfig();

            PreparedStatement queryStudent = con.prepareStatement("select * from studentdetails where UserId=?");
            queryStudent.setInt(1, userid);
            ResultSet student = queryStudent.executeQuery();
            if (student.next()) {
                PreparedStatement queryRoomCheck = con
                        .prepareStatement("select * from userrooms where StudentId=?");
                queryRoomCheck.setInt(1, student.getInt("Id"));
                ResultSet roomcheck = queryRoomCheck.executeQuery();
                if (roomcheck.next()) {
                    return false;
                }
                PreparedStatement queryRoomavailable = con.prepareStatement(
                        "select d.TypeId,d.Location,t.Available from accommodationdetails as d left join accommodationtypes as t on d.TypeId =t.Id where d.Id=?");
                queryRoomavailable.setInt(1, roomid);
                ResultSet roomavailable = queryRoomavailable.executeQuery();

                if (roomavailable.next()) {
                    int available = roomavailable.getInt("Available");
                    int rommTypeId = roomavailable.getInt("TypeId");
                    boolean isAvailable = true;
                    if (available <= 0) {
                        isAvailable = false;
                        return false;
                    }
                    PreparedStatement queryRoom = con
                            .prepareStatement("insert into userrooms(Id,StudentId,RoomId) values(?,?,?)");
                    queryRoom.setString(1, null);
                    queryRoom.setInt(3, roomid);
                    queryRoom.setInt(2, student.getInt("Id"));
                    queryRoom.execute();
                    PreparedStatement queryRoomdetails = con
                            .prepareStatement("update accommodationdetails set Available=? where Id=?");

                    queryRoomdetails.setBoolean(1, isAvailable);
                    queryRoomdetails.setInt(2, roomid);
                    boolean rowUpdated = queryRoomdetails.executeUpdate() > 0;
                    PreparedStatement queryRoomtype = con
                            .prepareStatement("update accommodationtypes set Available=? where Id=?");

                    queryRoomtype.setInt(1, available - 1);
                    queryRoomtype.setInt(2, rommTypeId);
                    boolean rowUpdatedtype = queryRoomtype.executeUpdate() > 0;
                    queryRoomdetails.close();
                    queryRoom.close();
                }
                queryRoomavailable.close();

                return true;
            }

            queryStudent.close();
            con.close();
            return false;

        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    @Override
    public boolean InsertRoomtype(RoomTypeViewModel roomtypeModel) {
        try {
            Connection con = DatabaseConfiguration.SetDatabaseConfig();
            PreparedStatement queryRoom = con.prepareStatement("insert into accommodationtypes values(?,?,?)");
            queryRoom.setString(1, null);
            queryRoom.setString(2, roomtypeModel.getType());
            queryRoom.setInt(3, roomtypeModel.getAvailable());
            queryRoom.execute();
            queryRoom.close();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RoomTypeViewModel> GetRoomtype() {
        try {
            List<RoomTypeViewModel> listroomTypeModel = new ArrayList<>();
            Connection con = DatabaseConfiguration.SetDatabaseConfig();
            PreparedStatement queryRoomGet = con.prepareStatement("select * from accommodationtypes");
            ResultSet rooms = queryRoomGet.executeQuery();
            while (rooms.next()) {
                String typename = rooms.getString("Name");
                int available = rooms.getInt("Available");
                int id = rooms.getInt("Id");
                RoomTypeViewModel roomTypeModel = new RoomTypeViewModel(id, typename, available);
                listroomTypeModel.add(roomTypeModel);
            }
            rooms.close();
            con.close();
            return listroomTypeModel;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    @Override
    public RoomTypeViewModel GetRoomtypeId(int id) {
        try {
            RoomTypeViewModel roomTypeModel = null;
            Connection con = DatabaseConfiguration.SetDatabaseConfig();
            PreparedStatement queryRoomGet = con.prepareStatement("select * from accommodationtypes where Id=?");
            queryRoomGet.setInt(1, id);
            ResultSet room = queryRoomGet.executeQuery();
            if (room.next()) {
                String typename = room.getString("Name");
                int available = room.getInt("Available");
                int idroom = room.getInt("Id");
                roomTypeModel = new RoomTypeViewModel(idroom, typename, available);
            }
            return roomTypeModel;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean UpdateRoomtype(RoomTypeViewModel roomTypeModel) {
        try {
            Connection con = DatabaseConfiguration.SetDatabaseConfig();
            PreparedStatement queryRoom = con
                    .prepareStatement("update accommodationtypes set Name=?, Available=? where Id=?");
            queryRoom.setInt(3, roomTypeModel.getId());
            queryRoom.setString(1, roomTypeModel.getType());
            queryRoom.setInt(2, roomTypeModel.getAvailable());
            boolean rowUpdated = queryRoom.executeUpdate() > 0;
            queryRoom.close();
            con.close();
            return rowUpdated;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    @Override
    public boolean RemoveRoomtype(int id) {
        try {
            Connection con = DatabaseConfiguration.SetDatabaseConfig();
            PreparedStatement queryRoom = con.prepareStatement("delete from accommodationtypes  where Id=?");
            queryRoom.setInt(1, id);
            boolean deleted = queryRoom.executeUpdate() > 0;
            return deleted;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
}
