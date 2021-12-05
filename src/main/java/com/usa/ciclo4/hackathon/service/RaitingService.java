/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo4.hackathon.service;

import com.usa.ciclo4.hackathon.model.Raiting;
import com.usa.ciclo4.hackathon.repository.RaitingRepository;
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
public class RaitingService {
    
    
    @Autowired
    private RaitingRepository repo;

	public boolean deleteAll() {
		return repo.deleteAll();
	}

	public Optional<Raiting> getById(Integer id) {
		return repo.getById(id);
	}

	public List<Raiting> getAll() {
		return repo.getAll();
	}

	public Raiting createRaiting(Raiting raiting) {		
		return repo.save(raiting);
	}

	public Raiting updateRaiting(Raiting raiting) {
		if (repo.getById(raiting.getIdRaiting()).isPresent()) {
			Raiting raitingUpdate = repo.getById(raiting.getIdRaiting()).get();

			if (!Objects.isNull(raiting.getScore())) {
				raitingUpdate.setScore(raiting.getScore());
			}

			if (!Objects.isNull(raiting.getMessage())) {
				raitingUpdate.setMessage(raiting.getMessage());
			}


			if (!Objects.isNull(raiting.getCondition())) {
				raitingUpdate.setCondition(raiting.getCondition());
			}

			return repo.save(raitingUpdate);
		}
		return new Raiting();

	}

	public boolean deleteRaiting(Integer id) {
		return repo.delete(id);
	}
}
