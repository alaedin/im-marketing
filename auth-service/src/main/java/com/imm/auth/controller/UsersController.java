package com.imm.auth.controller;

import static com.imm.auth.utils.ConstantUtils.ADD;
import static com.imm.auth.utils.ConstantUtils.DELETE;
import static com.imm.auth.utils.ConstantUtils.RESSOURCE_ALREADY_EXISTS;
import static com.imm.auth.utils.ConstantUtils.RESSOURCE_NOT_FOUND;
import static com.imm.auth.utils.ConstantUtils.UPDATE;
import static com.imm.auth.utils.Utils.message;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imm.auth.entity.User;
import com.imm.auth.exception.DataResourceException;
import com.imm.auth.service.UserService;
import com.imm.auth.utils.Response;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/im-workspace")
public class UsersController {

	@Autowired
	private UserService userService;

    @Autowired
	Response<User> response;

	private static final String BASED_PATH = "/users";

	private static final String OBJECT_NAME = "users";

	@GetMapping(BASED_PATH)
	private ResponseEntity<?> getAll() {
		return response.get(userService.findAll(), OBJECT_NAME);
	}

	@GetMapping(BASED_PATH + "/{id}")
	private ResponseEntity<?> getById(@Valid @PathVariable("id") Long id) {
		return response.get(userService.findById(id), OBJECT_NAME);
	}

	@PostMapping(BASED_PATH + "/" + ADD)
	private ResponseEntity<?> add(@Valid @RequestBody User user) {
		if (userService.existsById(user.getId())) {
			throw new DataResourceException(message(OBJECT_NAME, RESSOURCE_ALREADY_EXISTS, user.getId()));
		}
		userService.save(user);
		return response.insert(user, OBJECT_NAME);
	}

	@PutMapping(BASED_PATH + "/" + UPDATE)
	private ResponseEntity<?> update(@Valid @RequestBody User user) {
		if (!userService.existsById(user.getId())) {
			throw new DataResourceException(message(OBJECT_NAME, RESSOURCE_NOT_FOUND, user.getId()));
		}
		userService.save(user);
		return response.update(user, OBJECT_NAME);
	}

	@DeleteMapping(BASED_PATH + "/" + DELETE)
	private ResponseEntity<?> delete(@Valid @RequestBody User user) {
		if (!userService.existsById(user.getId())) {
			throw new DataResourceException(message(OBJECT_NAME, RESSOURCE_NOT_FOUND, user.getId()));
		}
		userService.delete(user);
		return response.delete(user, OBJECT_NAME);
	}



}
