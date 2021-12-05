/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo4.hackathon.repository;

import com.usa.ciclo4.hackathon.model.Raiting;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP USER
 */
@Repository
public class RaitingRepository {
    
    @Autowired
	private IRaitingRepository repo;

	public boolean deleteAll() {
		repo.deleteAll();
		List<Raiting> raitings = (List<Raiting>) repo.findAll();
		return raitings.size() == 0;
	}

	public Optional<Raiting> getById(Integer id) {
		return repo.findById(id);
	}

	public List<Raiting> getAll() {
		return (List<Raiting>) repo.findAll();
	}

	public Raiting save(Raiting raiting) {
		return repo.save(raiting);
	}

	public boolean delete(Integer id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
}
