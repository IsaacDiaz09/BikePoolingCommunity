package com.usa.ciclo4.hackathon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@JsonIgnoreProperties({ "id", "password" })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "El campo es requerido")
	private String name;

	@Column(unique = true)
	@Email(message = "El formato del email es invalido")
	private String email;

	@Column(length = 60)
	@Size(min = 7, message = "La contraseña debe tener al menos 8 caracteres")
	private String password;

	@Min(value = 1, message = "La edad no puede ser negativa")
	@NotNull(message="El campo es requerido")
	private Integer age;

	@NotEmpty(message = "El campo es requerido")
	private String cellPhone;

	@Column(length = 1)
	private String gender;

	@NotEmpty(message = "El campo es requerido")
	private String address;

	private String socialMedia;

	// private List<Bike> listBike;

	// relacion 1-muchos
	// private List<User> friends;
}
