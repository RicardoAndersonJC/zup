package com.ricardo.anderson.zupblog.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.ricardo.anderson.zupblog.controller.util.UtilController;
import com.ricardo.anderson.zupblog.dto.UserDto;
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
	public ResponseEntity<List<UserDto>> index() {
		List<User> users = userService.findAll();
		return ResponseEntity.ok(users.stream().map(UserDto::fromEntity).collect(Collectors.toList()));
	}

	@GetMapping("{id}")
	public ResponseEntity<UserDto> show(@PathVariable Long id) {
		User user = userService.findById(id);
		return ResponseEntity.ok(UserDto.fromEntity(user));
	}

	@PostMapping
	public ResponseEntity<UserDto> store(@RequestBody @Validated UserDto userDto) {
		User user  = userService.save(userDto.toEntity());
		return ResponseEntity.created(UtilController.generatedUri(user.getId())).body(UserDto.fromEntity(user));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}")
	public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto userDto) {
		User user = userService.update(id, userDto.toEntity());
		return ResponseEntity.ok(UserDto.fromEntity(user));
	}
}
