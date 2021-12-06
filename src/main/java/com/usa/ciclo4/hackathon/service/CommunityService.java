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
import org.springframework.stereotype.Service;

/**
 *
 * @author HP USER
 */
@Service
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

            if (!Objects.isNull(community.getIdCommunity())) {
                communityUpdate.setIdCommunity(community.getIdCommunity());
            }
            if (!Objects.isNull(community.getNameCommunity())) {
                communityUpdate.setNameCommunity(community.getNameCommunity());
            }
            if (!Objects.isNull(community.getNickCommunity())) {
                communityUpdate.setNickCommunity(community.getNickCommunity());
            }
            if (!Objects.isNull(community.getSectorCommunity())) {
				communityUpdate.setSectorCommunity(community.getSectorCommunity());
			}
            return repo.save(communityUpdate);
        }
        return new Community();

    }

    public boolean deleteCommunity(Integer id) {
        return repo.delete(id);
    }
}
