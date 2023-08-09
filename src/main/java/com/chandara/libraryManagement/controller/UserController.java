package com.chandara.libraryManagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandara.libraryManagement.Entity.User;
import com.chandara.libraryManagement.Service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user){
		return ResponseEntity.ok(userService.create(user));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id){
		return ResponseEntity.ok(userService.getUserId(id));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateUser(@PathVariable Long id,@RequestBody User user){
		return ResponseEntity.ok(userService.update(id, user));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		       userService.delete(id);
		return ResponseEntity.ok().build();
	}
}
