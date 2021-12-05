/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo4.hackathon.controller.rest;

import com.usa.ciclo4.hackathon.model.Bike;
import com.usa.ciclo4.hackathon.service.BikeService;
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
@RequestMapping("/api/Bike")

public class BikeRestController {
    
    @Autowired
	private BikeService service;

	@GetMapping("all")
	public List<Bike> getAll() {
		return service.getAll();
	}

}
