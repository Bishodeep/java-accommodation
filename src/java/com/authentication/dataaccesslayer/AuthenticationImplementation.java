/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.authentication.dataaccesslayer;

import com.dataaccesslayer.DatabaseConfiguration;
import com.entitymodel.RegistrationViewModel;
import com.entitymodel.UserViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bishodeep
 */
public class AuthenticationImplementation implements AuthenticationInterface {

    @Override
    public UserViewModel AuthenticateUser(String username, String password) {
        UserViewModel userModel = null;
        try {
            Connection con = DatabaseConfiguration.SetDatabaseConfig();
            PreparedStatement queryUser = con.prepareStatement("select * from Users where Name=? and Password=? ");
            queryUser.setString(1, username);
            queryUser.setString(2, password);
            ResultSet user = queryUser.executeQuery();
            if (user.next()) {
                String userNameDb = user.getString("Name");
                int roleIdDb = user.getInt("RoleId");
                int userid = user.getInt("Id");
                PreparedStatement queryRoles = con.prepareStatement("select * from Roles where Id=? ");
                queryRoles.setInt(1, roleIdDb);
                ResultSet role = queryRoles.executeQuery();
                if (role.next()) {
                    String roleNameDb = role.getString("Name");
                    userModel = new UserViewModel(userid, userNameDb, roleIdDb, roleNameDb);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return userModel;
    }

    @Override
    public boolean RegisterUser(RegistrationViewModel registerModel) {
        try {
            Connection con = DatabaseConfiguration.SetDatabaseConfig();
            PreparedStatement queryRoles = con.prepareStatement("select *  from Roles where Name=?");
            queryRoles.setString(1, "student");
            ResultSet role = queryRoles.executeQuery();
            int userRoleId = 0;
            if (role.next()) {
                userRoleId = role.getInt("Id");
            }
            PreparedStatement queryUseCheck = con.prepareStatement("select *  from Users where Name=? and Password=?");
            queryUseCheck.setString(1, registerModel.getUsername());
            queryUseCheck.setString(2, registerModel.getPassword());
            ResultSet userCheck = queryUseCheck.executeQuery();
            if (userCheck.next()) {
                return false;
            }
            PreparedStatement queryUser = con
                    .prepareStatement("insert into Users(Id,Name,Password,RoleId) values(?,?, ?,?)");
            queryUser.setString(1, null);
            queryUser.setString(2, registerModel.getUsername());
            queryUser.setString(3, registerModel.getPassword());
            queryUser.setInt(4, userRoleId);
            queryUser.executeUpdate();
            PreparedStatement queryUserGet = con.prepareStatement("select *  from Users where Name=? and Password=?");
            queryUserGet.setString(1, registerModel.getUsername());
            queryUserGet.setString(2, registerModel.getPassword());
            ResultSet user = queryUserGet.executeQuery();
            if (user.next()) {
                PreparedStatement queryStudent = con.prepareStatement("insert into "
                        + "StudentDetails(Id,Name,Age,Address,Contact"
                        + ",UserId)"
                        + " values(?,?,?,?,?,?)");
                queryStudent.setString(1, null);
                queryStudent.setString(2, registerModel.getName());
                queryStudent.setInt(3, registerModel.getAge());
                queryStudent.setString(4, registerModel.getAddress());
                queryStudent.setInt(5, registerModel.getContact());
                queryStudent.setInt(6, user.getInt("Id"));
                queryStudent.execute();
                queryStudent.close();
            }
            queryUser.close();
            con.close();
            return true;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;

        }
    }

}
