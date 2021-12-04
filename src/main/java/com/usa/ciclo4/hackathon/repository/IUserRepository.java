package com.usa.ciclo4.hackathon.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.usa.ciclo4.hackathon.model.User;

public interface IUserRepository extends CrudRepository<User,Integer> {

	/**
	 * Busca un usuario por su email
	 * @param email
	 * @return Optional
	 */
	Optional<User> findByEmail(String email);
}
