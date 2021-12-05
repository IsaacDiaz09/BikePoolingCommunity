package com.usa.ciclo4.hackathon.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "raiting")
public class Raiting implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3176428004223357741L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRaiting;

	private String message;

	private Integer score;

	private String condition;

}
