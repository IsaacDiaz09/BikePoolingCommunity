/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo4.hackathon.service;

import com.usa.ciclo4.hackathon.model.Bike;
import com.usa.ciclo4.hackathon.repository.BikeRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP USER
 */
@Service
public class BikeService {
    
    @Autowired
    private BikeRepository repo;

	public boolean deleteAll() {
		return repo.deleteAll();
	}

	public Optional<Bike> getById(Integer id) {
		return repo.getById(id);
	}

	public List<Bike> getAll() {
		return repo.getAll();
	}

	public Bike createBike(Bike bike) {		
		return repo.save(bike);
	}

	public Bike updateBike(Bike bike) {
		if (repo.getById(bike.getIdBike()).isPresent()) {
			Bike bikeUpdate = repo.getById(bike.getIdBike()).get();

			if (!Objects.isNull(bike.getSerialNumber())) {
				bikeUpdate.setSerialNumber(bike.getSerialNumber());
			}

			if (!Objects.isNull(bike.getStatus())) {
				bikeUpdate.setStatus(bike.getStatus());
			}


			if (!Objects.isNull(bike.getBrand())) {
				bikeUpdate.setBrand(bike.getBrand());
			}

			if (!Objects.isNull(bike.getImage())) {
				bikeUpdate.setImage(bike.getImage());
			}

			if (!Objects.isNull(bike.getCondition())) {
				bikeUpdate.setCondition(bike.getCondition());
			}


			return repo.save(bikeUpdate);
		}
		return new Bike();

	}

	public boolean delete(Integer id) {
		return repo.delete(id);
	}
}
