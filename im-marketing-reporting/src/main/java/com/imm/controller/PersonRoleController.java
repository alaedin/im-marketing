package com.imm.controller;

import static com.imm.utility.ConstantUtils.ADD;
import static com.imm.utility.ConstantUtils.DELETE;
import static com.imm.utility.ConstantUtils.SUCCESS_DELETE;
import static com.imm.utility.ConstantUtils.SUCCESS_GET;
import static com.imm.utility.ConstantUtils.SUCCESS_SAVE;
import static com.imm.utility.ConstantUtils.SUCCESS_UPDATE;
import static com.imm.utility.ConstantUtils.UPDATE;
import static com.imm.utility.Utils.successMessage;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imm.entity.PersonRole;
import com.imm.repository.PersonRoleRepository;
import com.imm.utility.ValuesObject;

@RestController
@RequestMapping("/im-workspace")
public class PersonRoleController {

	@Autowired
	private PersonRoleRepository personRoleRepository;
	private static final String BASED_PATH = "/person-role";

	@GetMapping(BASED_PATH)
	private ResponseEntity<?> getAll() {
		ValuesObject<?> persons = ValuesObject.builder()
				.outCode(0)
				.message(successMessage(SUCCESS_GET, "Person role"))
				.body(personRoleRepository.findAll())
				.build();
		return ResponseEntity.ok(persons);
	}

	@GetMapping(BASED_PATH + "/{id}")
	private ResponseEntity<?> getById(@Valid @PathVariable("id") Long id) {

		ValuesObject<?> persons = ValuesObject.builder()
				.outCode(0)
				.message(successMessage(SUCCESS_GET, "Person role"))
				.body(personRoleRepository.findById(id))
				.build();
		return ResponseEntity.ok(persons);
	}

	@PostMapping(BASED_PATH + "/" + ADD)
	private ResponseEntity<?> add(@Valid @RequestBody PersonRole personRole) {
		personRoleRepository.save(personRole);
		ValuesObject<?> persons = ValuesObject.builder()
				.outCode(0)
				.message(successMessage(SUCCESS_SAVE, "Person role"))
				.body(personRole)
				.build();
		return ResponseEntity.ok(persons);
	}

	@PutMapping(BASED_PATH + "/" + UPDATE)
	private ResponseEntity<?> update(@Valid @RequestBody PersonRole personRole) {
		personRoleRepository.save(personRole);
		ValuesObject<?> persons = ValuesObject.builder()
				.outCode(0)
				.message(successMessage(SUCCESS_UPDATE, "Person role"))
				.body(personRole)
				.build();
		return ResponseEntity.ok(persons);
	}

	@DeleteMapping(BASED_PATH + "/" + DELETE)
	private ResponseEntity<?> delete(@Valid @RequestBody PersonRole personRole) {
		personRoleRepository.delete(personRole);
		ValuesObject<?> persons = ValuesObject.builder()
				.outCode(0)
				.message(successMessage(SUCCESS_DELETE, "Person role"))
				.body(personRole)
				.build();
		return ResponseEntity.ok(persons);
	}
}
