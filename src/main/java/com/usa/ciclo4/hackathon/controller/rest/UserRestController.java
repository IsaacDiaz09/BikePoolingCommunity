package com.usa.ciclo4.hackathon.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usa.ciclo4.hackathon.model.User;
import com.usa.ciclo4.hackathon.service.UserService;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/user/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserRestController {

    @Autowired
    private UserService service;

    @GetMapping("all")
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getOptional(@PathVariable("id") int idUser) {

        return service.getById(idUser);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        try {
			return service.createUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return new User();
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idUser) {
        return service.deleteUser(idUser);
    }
}
