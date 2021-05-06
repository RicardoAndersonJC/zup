package com.ricardo.anderson.zupblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.anderson.zupblog.entity.User;
import com.ricardo.anderson.zupblog.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
@Validated
public class UserController {
	public UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping
	public List<User> index() {
		return userService.findAll();
	}

	@GetMapping("{id}")
	public User getUser(@PathVariable Long id) {

		return userService.findById(id);
	}
	
	@PostMapping
	public User postUser(@RequestBody @Validated User user ) {
		return userService.saveUser(user);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> delUser(@PathVariable Long id) {
		 userService.delUser(id);
		 return ResponseEntity.noContent().build();
	}
	@PutMapping("{id}")
	public User putUser(@PathVariable Long id, @RequestBody User user ) {
		 
		return userService.putUser(id,user);
	}
}
