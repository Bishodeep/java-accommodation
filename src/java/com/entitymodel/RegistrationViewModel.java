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
public class RegistrationViewModel {
     protected String name;
	    protected int age;
	    protected String address;
	    protected int contact;
	    protected String username;
	    protected String password;
	    
	    public RegistrationViewModel(String name, int age, String address,int contact, String username,String password) {
	    	this.name=name;
	    	this.age=age;
	    	this.address=address;
	    	this.contact=contact;
	    	this.username=username;
	    	this.password=password;
	    }
	    public int getAge() {
	        return age;
	    }
	 
	    public void setAge(int age) {
	        this.age = age;
	    }
	    public int getContact() {
	        return contact;
	    }
	 
	    public void setContact(int contact) {
	        this.contact = contact;
	    }
	 
	    public String getUsername() {
	        return username;
	    }
	 
	    public void setUsername(String name) {
	        this.username = name;
	    }
	    public String getAddress() {
	        return address;
	    }
	 
	    public void setAdddress(String address) {
	        this.address = address;
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
}
