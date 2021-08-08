package com.takeuchi.herokudemogradle.controllers;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.takeuchi.herokudemogradle.model.MyUser;
import com.takeuchi.herokudemogradle.repository.MyUserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	private final MyUserRepository repository;

	UserController(MyUserRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/users")
	public ResponseEntity<List<MyUser>> getUsers() {
		//userがいなければINSERT
		String email = "test@test.com";
		MyUser user = repository.findByEmail(email).orElse(new MyUser(null, "takeuchi", "test@test.com", 18, 1));
		repository.save(user);
		
		List<MyUser> users = repository.findAll();
		return new ResponseEntity<List<MyUser>>(users, new HttpHeaders(), HttpStatus.OK);
	}
}
