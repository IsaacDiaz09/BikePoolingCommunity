/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo4.hackathon.controller.rest;

import com.usa.ciclo4.hackathon.model.Raiting;
import com.usa.ciclo4.hackathon.service.RaitingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
