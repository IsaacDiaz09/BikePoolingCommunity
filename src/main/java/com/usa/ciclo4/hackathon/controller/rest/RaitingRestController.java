/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo4.hackathon.controller.rest;

import com.usa.ciclo4.hackathon.model.Raiting;
import com.usa.ciclo4.hackathon.model.User;
import com.usa.ciclo4.hackathon.service.RaitingService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP USER
 */
@RestController
@RequestMapping("/api/Raiting")
public class RaitingRestController {

    @Autowired
    private RaitingService service;

    @GetMapping("all")
    public List<Raiting> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Raiting> getOptional(@PathVariable("id") int idRaiting) {

        return service.getById(idRaiting);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Raiting save(@RequestBody Raiting raiting) {
        return service.createRaiting(raiting);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Raiting update(@RequestBody Raiting raiting) {
        return service.updateRaiting(raiting);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idRaiting) {
        return service.deleteRaiting(idRaiting);
    }
}
