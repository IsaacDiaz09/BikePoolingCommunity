/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo4.hackathon.repository;

import com.usa.ciclo4.hackathon.model.Bike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP USER
 */
@Repository
public class BikeRepository {
    
    @Autowired
	private IBikeRepository repo;

	public boolean deleteAll() {
		repo.deleteAll();
		List<Bike> bikes = (List<Bike>) repo.findAll();
		return bikes.size() == 0;
	}

	public Optional<Bike> getById(Integer id) {
		return repo.findById(id);
	}

	public List<Bike> getAll() {
		return (List<Bike>) repo.findAll();
	}

	public Bike save(Bike bike) {
		return repo.save(bike);
	}

	public boolean delete(Integer id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
    
}
