/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo4.hackathon.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author HP USER
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="bikes")
public class Bike {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idBike;
    
    private String serialNumber;
    
    private String status;
    
    private String brand;
    
    private String image;
    
    private String condition;
    
    private String category;
     
    
   // private List<Raiting> listRaiting;
}
