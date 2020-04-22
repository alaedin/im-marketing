package com.imm.controller;

import static com.imm.utility.ConstantUtils.ADD;
import static com.imm.utility.ConstantUtils.DELETE;
import static com.imm.utility.ConstantUtils.SUCCESS_DELETE;
import static com.imm.utility.ConstantUtils.SUCCESS_GET;
import static com.imm.utility.ConstantUtils.SUCCESS_SAVE;
import static com.imm.utility.ConstantUtils.SUCCESS_UPDATE;
import static com.imm.utility.ConstantUtils.UPDATE;
import static com.imm.utility.Utils.message;

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

import com.imm.entity.Phone;
import com.imm.repository.PhoneRepository;
import com.imm.utility.ValuesObject;


@RestController
@RequestMapping("/im-workspace")
public class PhoneController {

	@Autowired
	private PhoneRepository phoneRepository;
	private static final String BASED_PATH = "/phone";

	@GetMapping(BASED_PATH)
	private ResponseEntity<?> getAll() {
		ValuesObject<?> phones = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_GET, "Phone"))
				.body(phoneRepository.findAll())
				.build();
		return ResponseEntity.ok(phones);
	}

	@GetMapping(BASED_PATH + "/{id}")
	private ResponseEntity<?> getById(@Valid @PathVariable("id") Long id) {

		ValuesObject<?> phones = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_GET, "Phone"))
				.body(phoneRepository.findById(id))
				.build();
		return ResponseEntity.ok(phones);
	}

	@PostMapping(BASED_PATH + "/" + ADD)
	private ResponseEntity<?> add(@Valid @RequestBody Phone phone) {
		phoneRepository.save(phone);
		ValuesObject<?> phones = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_SAVE, "Phone"))
				.body(phone)
				.build();
		return ResponseEntity.ok(phones);
	}

	@PutMapping(BASED_PATH + "/" + UPDATE)
	private ResponseEntity<?> update(@Valid @RequestBody Phone phone) {
		phoneRepository.save(phone);
		ValuesObject<?> phones = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_UPDATE, "Phone"))
				.body(phone)
				.build();
		return ResponseEntity.ok(phones);
	}

	@DeleteMapping(BASED_PATH + "/" + DELETE)
	private ResponseEntity<?> delete(@Valid @RequestBody Phone phone) {
		phoneRepository.delete(phone);
		ValuesObject<?> phones = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_DELETE, "Phone"))
				.body(phone)
				.build();
		return ResponseEntity.ok(phones);
	}
}
