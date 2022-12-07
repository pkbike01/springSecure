package com.springsecure.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springsecure.model.User;

@Service
public class UserServices {
	//ArrayList
	List<User> list = new ArrayList<>();
	
	//constructor
	public UserServices() {
		list.add(new User("abc","pank","abc@gmail.com"));
		list.add(new User("xyz","pank","xyz@gmail.com"));
	}
	
	//get all User
	public List<User> getAllUser(){
		return this.list;
	}
	
	//get single User
	public User getOneuser(String username) {
		return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
		
		}
	//add new user
	public User addUser(User user) {
		return user;
	}
	
	
	
	
	

}