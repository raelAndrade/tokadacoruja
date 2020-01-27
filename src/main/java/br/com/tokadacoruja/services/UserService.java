package br.com.tokadacoruja.services;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.tokadacoruja.domain.User;
import br.com.tokadacoruja.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	/*@Autowired
	private BCryptPasswordEncoder passwordEncoder;*/
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	/*public void save(User user) {
		user.setPwd(passwordEncoder.encode(user.getPwd()));
		userRepository.save(user);
	}*/
	
	public void save(User user) {
		userRepository.save(user);
	}

}
