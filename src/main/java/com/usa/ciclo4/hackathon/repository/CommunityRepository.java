/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo4.hackathon.repository;

import com.usa.ciclo4.hackathon.model.Community;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author HP USER
 */
public class CommunityRepository {
    
    @Autowired
	private ICommunityRepository repo;

	public boolean deleteAll() {
		repo.deleteAll();
		List<Community> community = (List<Community>) repo.findAll();
		return community.size() == 0;
	}

	public Optional<Community> getById(Integer id) {
		return repo.findById(id);
	}

	public List<Community> getAll() {
		return (List<Community>) repo.findAll();
	}

	public Community save(Community community) {
		return repo.save(community);
	}

	public boolean delete(Integer id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
}
