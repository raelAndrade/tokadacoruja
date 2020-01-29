package br.com.tokadacoruja.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.tokadacoruja.domain.Role;
import br.com.tokadacoruja.domain.User;
import br.com.tokadacoruja.repositories.RoleRepository;
import br.com.tokadacoruja.repositories.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;	
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public UserService(UserRepository userRepository, 
			RoleRepository roleRepository, 
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = bCryptPasswordEncoder;
	}
	
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	
	public User findUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setActive(true);
		List<Role> userRole = roleRepository.findAll();		
		for (Role role : userRole) {
			if(role.equals(user.getRoles())){
				user.setRoles(new HashSet<Role>(Arrays.asList(role)));
			}
		}		
		return userRepository.save(user);
	}

}
