package com.usa.ciclo4.hackathon.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo4.hackathon.model.User;

@Repository
public class UserRepository {

	@Autowired
	private IUserRepository repo;

	public boolean deleteAll() {
		repo.deleteAll();
		List<User> users = (List<User>) repo.findAll();
		return users.size() == 0;
	}

	public Optional<User> getById(Integer id) {
		return repo.findById(id);
	}

	public List<User> getAll() {
		return (List<User>) repo.findAll();
	}

	public User save(User user) {
		return repo.save(user);
	}

	public boolean delete(Integer id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}

}
