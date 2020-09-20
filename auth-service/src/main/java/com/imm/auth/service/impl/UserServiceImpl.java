/**
 * 
 */
package com.imm.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.imm.auth.entity.User;
import com.imm.auth.exception.ApiRequestException;
import com.imm.auth.model.PasswordModel;
import com.imm.auth.repository.UserRepository;
import com.imm.auth.service.UserService;

/**
 * @author alaeddine
 *
 */
@Service
public class UserServiceImpl implements UserService{

	

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User changePassword(PasswordModel passwordModel) {
		User user = userRepository.findById(passwordModel.getId()).orElse(null);

		if (user == null) 
			throw new ApiRequestException("Wrong username!");
		

		boolean matched = passwordEncoder.matches(passwordModel.getOldPassword(), user.getPassword());
		if (!matched) {
			throw new ApiRequestException("Old password didn't match");
		}

		String crytpedPwd = passwordEncoder.encode(passwordModel.getNewPassword());
		user.setPassword(crytpedPwd);

		userRepository.save(user);
		return user;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public boolean existsById(Long id) {
		return userRepository.existsById(id);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

	@Override
	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	@Override
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}
}
