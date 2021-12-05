package com.usa.ciclo4.hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.usa.ciclo4.hackathon.model.User;
import com.usa.ciclo4.hackathon.service.UserService;

@SpringBootApplication
public class HackathonApplication implements CommandLineRunner {

	@Autowired
	private UserService service;

	public static void main(String[] args) {
		SpringApplication.run(HackathonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.deleteAll();
		User user = new User();
		user.setName("Isaac");
		user.setEmail("ivvidp12@gmail.com");
		user.setPassword("diminombre");
		user.setAge(19);
		user.setCellPhone("3175137055");
		user.setGender("M");
		user.setAddress("Cra 4 Falsa SpringField");
		user.setSocialMedia("facebook.com");
		service.createUser(user);
	}

}
