package com.usa.ciclo4.hackathon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@JsonIgnoreProperties({"id","password"})
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@Column(unique=true)
	private String email;
	
	@Column(length=60)
	private String password;
	
	private Integer age;

	private String cellPhone;
	
	@Column(length=1)
	private String gender;
	
	private String address;
	
	private String socialMedia;
        
        //private List<Bike> listBike;
	
	// relacion 1-muchos
	//private List<User> friends;
}
