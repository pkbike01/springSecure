package com.springsecure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecure.model.User;
import com.springsecure.service.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServices userService;
	
	
	
	
	
	//All user
	@GetMapping
	public List<User> getAllUser(){
		return this.userService.getAllUser();
		
	}
	
	//return single user
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username")String username) {
		return this.userService.getOneuser(username);
	}
	
	@PostMapping("/")
	public User addUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
}

