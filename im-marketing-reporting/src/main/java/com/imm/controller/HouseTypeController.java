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

import com.imm.entity.HouseType;
import com.imm.repository.HouseTypeRepository;
import com.imm.utility.Response;

@RestController
@RequestMapping("/im-workspace")
public class HouseTypeController {


		@Autowired
		private HouseTypeRepository houseTypeRepository;
	
		@Resource
		Response<HouseType> response;
		
		private static final String BASED_PATH = "/house-type";

		@GetMapping(BASED_PATH)
		private ResponseEntity<?> getAll() {
			return response.get(houseTypeRepository.findAll(), "House type ");
		}

		@GetMapping(BASED_PATH + "/{id}")
		private ResponseEntity<?> getById(@Valid @PathVariable("id") Long id) {
			return response.get(houseTypeRepository.findById(id), "House type ");
		}

		@PostMapping(BASED_PATH + "/" + ADD)
		private ResponseEntity<?> add(@Valid @RequestBody HouseType houseType) {
			houseTypeRepository.save(houseType);
			return response.insert(houseType, "House type ");
		}

		@PutMapping(BASED_PATH + "/" + UPDATE)
		private ResponseEntity<?> update(@Valid @RequestBody HouseType houseType) {
			houseTypeRepository.save(houseType);
			return response.update(houseType, "House type ");
		}

		@DeleteMapping(BASED_PATH + "/" + DELETE)
		private ResponseEntity<?> delete(@Valid @RequestBody HouseType houseType) {
			houseTypeRepository.delete(houseType);
			return response.delete(houseType, "House type ");
		}
}
