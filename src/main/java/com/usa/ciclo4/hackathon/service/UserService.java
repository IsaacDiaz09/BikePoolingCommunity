package com.usa.ciclo4.hackathon.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.usa.ciclo4.hackathon.model.User;
import com.usa.ciclo4.hackathon.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public boolean deleteAll() {
		return repo.deleteAll();
	}

	public Optional<User> getById(Integer id) {
		return repo.getById(id);
	}

	public List<User> getAll() {
		return repo.getAll();
	}

	public User createUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
		String encryptedPassword = encoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		return repo.save(user);
	}

	public User updateUser(User user) {
		if (repo.getById(user.getId()).isPresent()) {
			User userUpdate = repo.getById(user.getId()).get();

			if (!Objects.isNull(user.getName())) {
				userUpdate.setName(user.getName());
			}

			if (!Objects.isNull(user.getEmail())) {
				userUpdate.setEmail(user.getEmail());
			}

			if (!Objects.isNull(user.getPassword())) {
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
				String encryptedPassword = encoder.encode(user.getPassword());
				user.setPassword(encryptedPassword);
				userUpdate.setPassword(encryptedPassword);
			}

			if (!Objects.isNull(user.getAge())) {
				userUpdate.setAge(user.getAge());
			}

			if (!Objects.isNull(user.getCellPhone())) {
				userUpdate.setCellPhone(user.getCellPhone());
			}

			if (!Objects.isNull(user.getGender())) {
				userUpdate.setGender(user.getGender());
			}

			if (!Objects.isNull(user.getAddress())) {
				userUpdate.setGender(user.getAddress());
			}

			if (!Objects.isNull(user.getSocialMedia())) {
				userUpdate.setSocialMedia(user.getSocialMedia());
			}

			return repo.save(userUpdate);
		}
		return new User();

	}

	public boolean delete(Integer id) {
		return repo.delete(id);
	}

}
