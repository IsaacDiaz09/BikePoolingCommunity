package com.usa.ciclo4.hackathon.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usa.ciclo4.hackathon.model.User;
import com.usa.ciclo4.hackathon.service.UserService;

@RestController
@RequestMapping("/api/users/")
public class UserRestController {

	@Autowired
	private UserService service;

	@GetMapping("all")
	public List<User> getAll() {
		return service.getAll();
	}

}
