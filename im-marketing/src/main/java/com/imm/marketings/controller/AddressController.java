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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imm.marketings.entity.Address;
import com.imm.marketings.exception.DataResourceException;
import com.imm.marketings.repository.AddressRepository;
import com.imm.marketings.utility.Response;

@RestController
@RequestMapping("/im-workspace")
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	Response<Address> response;
	
	private static final String BASED_PATH = "/address";

	private static final String OBJECT_NAME =  "address";

	@GetMapping(BASED_PATH)
	private ResponseEntity<?> getAll() {
		return response.get(addressRepository.findAll(), OBJECT_NAME);
	}

	@GetMapping(BASED_PATH + "/{id}")
	private ResponseEntity<?> getById(@Valid @PathVariable("id") Long id) {
		return response.get(addressRepository.findById(id), OBJECT_NAME);
	}

	@PostMapping(BASED_PATH + "/" + ADD)
	private ResponseEntity<?> add(@Valid @RequestBody Address address) {
		if (addressRepository.existsById(address.getId())) {
			throw new DataResourceException(message(OBJECT_NAME,RESSOURCE_ALREADY_EXISTS, address.getId()));
		}
		addressRepository.save(address);
		return response.insert(address, OBJECT_NAME);
	}

	@PutMapping(BASED_PATH + "/" + UPDATE)
	private ResponseEntity<?> update(@Valid @RequestBody Address address) {
		if (!addressRepository.existsById(address.getId())) {
			throw new DataResourceException(message(OBJECT_NAME,RESSOURCE_NOT_FOUND, address.getId()));
		}
		addressRepository.save(address);
		return response.update(address, OBJECT_NAME);
	}

	@DeleteMapping(BASED_PATH + "/" + DELETE)
	private ResponseEntity<?> delete(@Valid @RequestBody Address address) {
		if (!addressRepository.existsById(address.getId())) {
			throw new DataResourceException(message(OBJECT_NAME,RESSOURCE_NOT_FOUND, address.getId()));
		}
		addressRepository.delete(address);
		return response.delete(address, OBJECT_NAME);
	}
}
