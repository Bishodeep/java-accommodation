/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entitymodel;

/**
 *
 * @author Bishodeep
 */
public class UserViewModel {
    protected int userid;
	    protected String username;
	    protected String password;
	    protected int roleid;
	    protected String rolename;
	    public UserViewModel(String username,int roleid,String rolename) {
	    	this.username=username;
	    	this.roleid=roleid;
	    	this.rolename=rolename;
	    }
	    public UserViewModel(int id,String username,int roleid,String rolename) {
	    	this.username=username;
	    	this.roleid=roleid;
	    	this.rolename=rolename;
	    	this.userid=id;
	    }
	    public int getId() {
	        return userid;
	    }
	 
	    public void setId(int userid) {
	        this.userid = userid;
	    }
	    public int getRoleId() {
	        return roleid;
	    }
	 
	    public void setRoleId(int roleId) {
	        this.roleid = roleId;
	    }
	    public String getName() {
	        return username;
	    }
	 
	    public void setName(String name) {
	        this.username = name;
	    }
	    public String getPassword() {
	        return password;
	    }
	 
	    public void setPassword(String name) {
	        this.password = name;
	    }
	    
	    public String getRole() {
	        return rolename;
	    }
	 
	    public void setRole(String name) {
	        this.rolename = name;
	    }
}
