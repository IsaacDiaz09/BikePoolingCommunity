/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo4.hackathon.service;

import com.usa.ciclo4.hackathon.model.Community;
import com.usa.ciclo4.hackathon.repository.CommunityRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author HP USER
 */
public class CommunityService {
    
    @Autowired
    private CommunityRepository repo;

	public boolean deleteAll() {
		return repo.deleteAll();
	}

	public Optional<Community> getById(Integer id) {
		return repo.getById(id);
	}

	public List<Community> getAll() {
		return repo.getAll();
	}

	public Community createCommunity(Community community) {		
		return repo.save(community);
	}

	public Community updateCommunity(Community community) {
		if (repo.getById(community.getIdCommunity()).isPresent()) {
			Community communityUpdate = repo.getById(community.getIdCommunity()).get();

			if (!Objects.isNull(community.getTypeCommunity())) {
				communityUpdate.setTypeCommunity(community.getTypeCommunity());
			}

			return repo.save(communityUpdate);
		}
		return new Community();

	}

	public boolean deleteCommunity(Integer id) {
		return repo.delete(id);
	}
}
