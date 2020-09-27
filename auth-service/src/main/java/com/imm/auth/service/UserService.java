package com.imm.auth.service;

import java.util.List;

import com.imm.auth.entity.User;
import com.imm.auth.model.PasswordModel;

/**
 * @author alaeddine
 *
 */
public interface UserService {


	List<User> findAll();

	User findById(long id);

	boolean existsById(Long id);

	void save(User user);

	void delete(User user);

	User changePassword(PasswordModel passwordModel);

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);
}
