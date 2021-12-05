/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.usa.ciclo4.hackathon.repository;

import com.usa.ciclo4.hackathon.model.Bike;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author HP USER
 */
public interface IBikeRepository extends CrudRepository<Bike,Integer>{
    
}
