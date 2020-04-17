package com.imm.controller;

import static com.imm.utility.ConstantUtils.ADD;
import static com.imm.utility.ConstantUtils.DELETE;
import static com.imm.utility.ConstantUtils.SUCCESS_GET;
import static com.imm.utility.ConstantUtils.SUCCESS_SAVE;
import static com.imm.utility.ConstantUtils.SUCCESS_UPDATE;
import static com.imm.utility.ConstantUtils.UPDATE;

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

import com.imm.entity.Address;
import com.imm.repository.AddressRepository;
import com.imm.utility.ValuesObject;

@RestController
@RequestMapping("/im-workspace")
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;
	private static final String BASED_PATH = "/address";

	@GetMapping(BASED_PATH)
	private ResponseEntity<?> getAll() {

		ValuesObject<?> addresses = ValuesObject.builder()
				.outCode(0)
				.message(SUCCESS_GET + "address")
				.body(addressRepository.findAll())
				.build();
		return ResponseEntity.ok(addresses);
	}

	@GetMapping(BASED_PATH + "/{id}")
	private ResponseEntity<?> getById(@Valid @PathVariable("id") Long id) {

		ValuesObject<?> addresses = ValuesObject.builder()
				.outCode(0)
				.message(SUCCESS_GET + "address")
				.body(addressRepository.findById(id))
				.build();
		return ResponseEntity.ok(addresses);
	}

	@PostMapping(BASED_PATH + "/" + ADD)
	private ResponseEntity<?> add(@Valid @RequestBody Address address) {
		addressRepository.save(address);
		ValuesObject<?> addresses = ValuesObject.builder()
				.outCode(0)
				.message(SUCCESS_SAVE + "address")
				.body(address)
				.build();
		return ResponseEntity.ok(addresses);
	}

	@PutMapping(BASED_PATH + "/" + UPDATE)
	private ResponseEntity<?> update(@Valid @RequestBody Address address) {
		addressRepository.save(address);
		ValuesObject<?> addresses = ValuesObject.builder()
				.outCode(0)
				.message(SUCCESS_UPDATE + "address")
				.body(address).build();
		return ResponseEntity.ok(addresses);
	}

	@DeleteMapping(BASED_PATH + "/" + DELETE)
	private ResponseEntity<?> delete(@Valid @RequestBody Address address) {
		addressRepository.delete(address);
		ValuesObject<?> addresses = ValuesObject.builder()
				.outCode(0)
				.message(SUCCESS_UPDATE + "address")
				.body(address).build();
		return ResponseEntity.ok(addresses);
	}
}
