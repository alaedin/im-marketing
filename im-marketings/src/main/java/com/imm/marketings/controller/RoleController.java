package com.imm.marketings.controller;


import static com.imm.marketings.utility.ConstantUtils.ADD;
import static com.imm.marketings.utility.ConstantUtils.DELETE;
import static com.imm.marketings.utility.ConstantUtils.RESSOURCE_ALREADY_EXISTS;
import static com.imm.marketings.utility.ConstantUtils.RESSOURCE_NOT_FOUND;
import static com.imm.marketings.utility.ConstantUtils.UPDATE;
import static com.imm.marketings.utility.Utils.message;

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

import com.imm.marketings.entity.Role;
import com.imm.marketings.exception.DataResourceException;
import com.imm.marketings.service.RoleService;
import com.imm.marketings.utility.Response;



@RestController
@RequestMapping("/im-workspace")
@CrossOrigin(origins = "*")
public class RoleController {

	@Autowired
	private RoleService roleService;

    @Autowired
	Response<Role> response;

	private static final String BASED_PATH = "/role";

	private static final String OBJECT_NAME = "role";

	@GetMapping(BASED_PATH)
	private ResponseEntity<?> getAll() {
		return response.get(roleService.findAll(), OBJECT_NAME);
	}

	@GetMapping(BASED_PATH + "/{id}")
	private ResponseEntity<?> getById(@Valid @PathVariable("id") Long id) {
		return response.get(roleService.findById(id), OBJECT_NAME);
	}
	
	@GetMapping(BASED_PATH + "/roleName/{roleName}")
	private ResponseEntity<?> getByRoleName(@Valid @PathVariable("roleName") String roleName) {
		return response.get(roleService.findByRoleName(roleName), OBJECT_NAME);
	}

	@PostMapping(BASED_PATH + "/" + ADD)
	private ResponseEntity<?> add(@Valid @RequestBody Role role) {
		if (role.getId()!= null && roleService.existsById(role.getId())) {
			throw new DataResourceException(message(OBJECT_NAME, RESSOURCE_ALREADY_EXISTS, role.getId()));
		}
		roleService.save(role);
		return response.insert(role, OBJECT_NAME);
	}

	@PutMapping(BASED_PATH + "/" + UPDATE)
	private ResponseEntity<?> update(@Valid @RequestBody Role role) {
		if (!roleService.existsById(role.getId())) {
			throw new DataResourceException(message(OBJECT_NAME, RESSOURCE_NOT_FOUND, role.getId()));
		}
		roleService.save(role);
		return response.update(role, OBJECT_NAME);
	}

	@DeleteMapping(BASED_PATH + "/" + DELETE)
	private ResponseEntity<?> delete(@Valid @RequestBody Role role) {
		if (!roleService.existsById(role.getId())) {
			throw new DataResourceException(message(OBJECT_NAME, RESSOURCE_NOT_FOUND, role.getId()));
		}
		roleService.delete(role);
		return response.delete(role, OBJECT_NAME);
	}


}
