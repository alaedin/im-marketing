package com.imm.marketings.controller;

import static com.imm.marketings.utility.ConstantUtils.ADD;
import static com.imm.marketings.utility.ConstantUtils.DELETE;
import static com.imm.marketings.utility.ConstantUtils.SUCCESS_DELETE;
import static com.imm.marketings.utility.ConstantUtils.SUCCESS_GET;
import static com.imm.marketings.utility.ConstantUtils.SUCCESS_SAVE;
import static com.imm.marketings.utility.ConstantUtils.SUCCESS_UPDATE;
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

import com.imm.marketings.entity.Person;
import com.imm.marketings.entity.Role;
import com.imm.marketings.exception.DataResourceException;
import com.imm.marketings.repository.PersonRepository;
import com.imm.marketings.repository.RoleRepository;
import com.imm.marketings.utility.ConstantUtils;
import com.imm.marketings.utility.Utils;
import com.imm.marketings.utility.ValuesObject;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/im-workspace")
public class PersosnController {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private RoleRepository roleRepository ;
	
	private static final String BASED_PATH = "/person";

	private static final String OBJECT_NAME = "person";

	@GetMapping(BASED_PATH)
	private ResponseEntity<?> getAll() {
		ValuesObject<?> persons = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_GET, "Person"))
				.body(personRepository.findAll())
				.build();
		return ResponseEntity.ok(persons);
	}

	@GetMapping(BASED_PATH + "/{id}")
	private ResponseEntity<?> getById(@Valid @PathVariable("id") Long id) {

		ValuesObject<?> persons = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_GET, "Person"))
				.body(personRepository.findById(id))
				.build();
		return ResponseEntity.ok(persons);
	}
	
	@GetMapping(BASED_PATH + "/roleId/{roleId}")
	private ResponseEntity<?> getByRole(@Valid @PathVariable("roleId") Long roleId) {

		Role role = roleRepository.findById(roleId).orElse(null);
		if (role == null) {
			throw new DataResourceException(Utils.message(OBJECT_NAME, ConstantUtils.RESSOURCE_NOT_FOUND,roleId));
		}
		
		
		
		ValuesObject<?> persons = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_GET, "Person"))
				.body(personRepository.findByRoles(role))
				.build();
		return ResponseEntity.ok(persons);
	}
	
	

	@PostMapping(BASED_PATH + "/" + ADD)
	private ResponseEntity<?> add(@Valid @RequestBody Person person) {
		personRepository.save(person);
		ValuesObject<?> persons = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_SAVE, "Person"))
				.body(person)
				.build();
		return ResponseEntity.ok(persons);
	}

	@PutMapping(BASED_PATH + "/" + UPDATE)
	private ResponseEntity<?> update(@Valid @RequestBody Person person) {
		personRepository.save(person);
		ValuesObject<?> persons = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_UPDATE, "Person"))
				.body(person)
				.build();
		return ResponseEntity.ok(persons);
	}

	@DeleteMapping(BASED_PATH + "/" + DELETE)
	private ResponseEntity<?> delete(@Valid @RequestBody Person person) {
		personRepository.delete(person);
		ValuesObject<?> persons = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_DELETE, "Person"))
				.body(person)
				.build();
		return ResponseEntity.ok(persons);
	}
}
