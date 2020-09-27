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

import com.imm.marketings.entity.HouseType;
import com.imm.marketings.exception.DataResourceException;
import com.imm.marketings.repository.HouseTypeRepository;
import com.imm.marketings.utility.Response;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/im-workspace")
public class HouseTypeController {

	@Autowired
	private HouseTypeRepository houseTypeRepository;

	@Autowired
	Response<HouseType> response;

	private static final String BASED_PATH = "/house-type";
	
	private static final String OBJECT_NAME =  "House type";

	@GetMapping(BASED_PATH)
	private ResponseEntity<?> getAll() {
		return response.get(houseTypeRepository.findAll(), OBJECT_NAME);
	}

	@GetMapping(BASED_PATH + "/{id}")
	private ResponseEntity<?> getById(@Valid @PathVariable("id") Long id) {
		return response.get(houseTypeRepository.findById(id), OBJECT_NAME);
	}

	@PostMapping(BASED_PATH + "/" + ADD)
	private ResponseEntity<?> add(@Valid @RequestBody HouseType houseType) {
		if (houseTypeRepository.existsById(houseType.getId())) {
			throw new DataResourceException(message(OBJECT_NAME,RESSOURCE_ALREADY_EXISTS, houseType.getId()));
		}
		houseTypeRepository.save(houseType);
		return response.insert(houseType, OBJECT_NAME);
	}

	@PutMapping(BASED_PATH + "/" + UPDATE)
	private ResponseEntity<?> update(@Valid @RequestBody HouseType houseType) {
		if (!houseTypeRepository.existsById(houseType.getId())) {
			throw new DataResourceException(message(OBJECT_NAME,RESSOURCE_NOT_FOUND, houseType.getId()));
		}
		houseTypeRepository.save(houseType);
		return response.update(houseType, OBJECT_NAME);
	}

	@DeleteMapping(BASED_PATH + "/" + DELETE)
	private ResponseEntity<?> delete(@Valid @RequestBody HouseType houseType) {
		if (!houseTypeRepository.existsById(houseType.getId())) {
			throw new DataResourceException(message(OBJECT_NAME,RESSOURCE_NOT_FOUND, houseType.getId()));
		}
		houseTypeRepository.delete(houseType);
		return response.delete(houseType, OBJECT_NAME);
	}
}
