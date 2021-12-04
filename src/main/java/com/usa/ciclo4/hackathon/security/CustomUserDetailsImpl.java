package com.usa.ciclo4.hackathon.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.usa.ciclo4.hackathon.model.User;
import com.usa.ciclo4.hackathon.repository.IUserRepository;

public class CustomUserDetailsImpl implements UserDetailsService {

	@Autowired
	private IUserRepository repo;

	/**
	 * Busca un usuario por su email para poder autenticarlo
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = repo.findByEmail(email);
		if (user.isEmpty()) {
			throw new UsernameNotFoundException("Usuario no encontrado, email = " + email);
		}

		return new CustomUserDetails(user.get());
	}
}
