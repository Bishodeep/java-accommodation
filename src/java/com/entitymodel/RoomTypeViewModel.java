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
public class RoomTypeViewModel {
    protected int id;
	    protected String typename;
	    protected int available;
	    public RoomTypeViewModel(int id,String typename,int available) {
	    	this.typename=typename;
	    	this.available=available;
	    	this.id=id;
	    }
	    public RoomTypeViewModel(String typename,int available) {
	    	this.typename=typename;
	    	this.available=available;
	    }
	    public int getId() {
	        return id;
	    }
	 
	    public void setId(int id) {
	        this.id = id;
	    }
	    public String getType() {
	        return typename;
	    }
	 
	    public void setName(String name) {
	        this.typename = name;
	    }
	    public int getAvailable() {
	        return available;
	    }
	 
	    public void setAvailable(int available) {
	        this.available = available;
	    }
}
