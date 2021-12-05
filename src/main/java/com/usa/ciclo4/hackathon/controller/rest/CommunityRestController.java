/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo4.hackathon.controller.rest;

import com.usa.ciclo4.hackathon.model.Community;
import com.usa.ciclo4.hackathon.service.CommunityService;
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
@RequestMapping("/api/community")
public class CommunityRestController {
    
    @Autowired
    private CommunityService service;

    @GetMapping("all")
    public List<Community> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Community> getOptional(@PathVariable("id") int idCommunity) {

        return service.getById(idCommunity);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Community save(@RequestBody Community community) {
        return service.createCommunity(community);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Community update(@RequestBody Community community) {
        return service.updateCommunity(community);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idCommunity) {
        return service.deleteCommunity(idCommunity);
    }
    
}
