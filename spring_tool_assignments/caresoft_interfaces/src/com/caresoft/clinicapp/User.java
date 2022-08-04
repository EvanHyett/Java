package com.caresoft.clinicapp;

public class User {
    protected Integer id;
    protected int pin;
    
    // TO DO: Getters and setters
	// Implement a constructor that takes an ID
    
//    Constructor
    public User(Integer id) {
    	this.id = id;
    }
    
//    Getters
    protected Integer getId() {
    	return id;
    }
    
    protected int getPin() {
    	return pin;
    }
    
//    Setters
    protected void setId(Integer id) {
    	this.id = id;
    }
    
    protected void setPin(int pin) {
    	this.pin = pin;
    }
}