package com.imm.controller;

import static com.imm.utility.ConstantUtils.ADD;
import static com.imm.utility.ConstantUtils.DELETE;
import static com.imm.utility.ConstantUtils.UPDATE;

import javax.annotation.Resource;
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
import com.imm.utility.Response;

@RestController
@RequestMapping("/im-workspace")
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;
	
	@Resource
	Response<Address> response;
	
	private static final String BASED_PATH = "/address";

	@GetMapping(BASED_PATH)
	private ResponseEntity<?> getAll() {
		return response.get(addressRepository.findAll(), "address");
	}

	@GetMapping(BASED_PATH + "/{id}")
	private ResponseEntity<?> getById(@Valid @PathVariable("id") Long id) {
		return response.get(addressRepository.findById(id), "address");
	}

	@PostMapping(BASED_PATH + "/" + ADD)
	private ResponseEntity<?> add(@Valid @RequestBody Address address) {
		addressRepository.save(address);
		return response.insert(address, "address");
	}

	@PutMapping(BASED_PATH + "/" + UPDATE)
	private ResponseEntity<?> update(@Valid @RequestBody Address address) {
		addressRepository.save(address);
		return response.update(address, "address");
	}

	@DeleteMapping(BASED_PATH + "/" + DELETE)
	private ResponseEntity<?> delete(@Valid @RequestBody Address address) {
		addressRepository.delete(address);
		return response.delete(null, "address");
	}
}
