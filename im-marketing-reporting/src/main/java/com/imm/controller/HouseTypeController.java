package com.imm.controller;

import static com.imm.utility.ConstantUtils.*;
import static com.imm.utility.Utils.*;


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
import com.imm.utility.ValuesObject;

@RestController
@RequestMapping("/im-workspace")
public class HouseTypeController {


		@Autowired
		private HouseTypeRepository houseTypeRepository;
		private static final String BASED_PATH = "/house-type";

		@GetMapping(BASED_PATH)
		private ResponseEntity<?> getAll() {
			ValuesObject<?> houseTypes = ValuesObject.builder()
					.outCode(0)
					.message(successMessage(SUCCESS_GET , " House type "))
					.body(houseTypeRepository.findAll())
					.build();
			return ResponseEntity.ok(houseTypes);
		}

		@GetMapping(BASED_PATH + "/{id}")
		private ResponseEntity<?> getById(@Valid @PathVariable("id") Long id) {

			ValuesObject<?> houseTypes = ValuesObject.builder()
					.outCode(0)
					.message(successMessage(SUCCESS_GET , " House type "))
					.body(houseTypeRepository.findById(id))
					.build();
			return ResponseEntity.ok(houseTypes);
		}

		@PostMapping(BASED_PATH + "/" + ADD)
		private ResponseEntity<?> add(@Valid @RequestBody HouseType hoseType) {
			houseTypeRepository.save(hoseType);
			ValuesObject<?> houseTypes = ValuesObject.builder()
					.outCode(0)
					.message(successMessage(SUCCESS_SAVE , " House type "))
					.body(hoseType)
					.build();
			return ResponseEntity.ok(houseTypes);
		}

		@PutMapping(BASED_PATH + "/" + UPDATE)
		private ResponseEntity<?> update(@Valid @RequestBody HouseType hoseType) {
			houseTypeRepository.save(hoseType);
			ValuesObject<?> houseTypes = ValuesObject.builder()
					.outCode(0)
					.message(successMessage(SUCCESS_UPDATE , " House type "))
					.body(hoseType)
					.build();
			return ResponseEntity.ok(houseTypes);
		}

		@DeleteMapping(BASED_PATH + "/" + DELETE)
		private ResponseEntity<?> delete(@Valid @RequestBody HouseType hoseType) {
			houseTypeRepository.delete(hoseType);
			ValuesObject<?> houseTypes = ValuesObject.builder()
					.outCode(0)
					.message(successMessage(SUCCESS_DELETE , " House type "))
					.body(hoseType)
					.build();
			return ResponseEntity.ok(houseTypes);
		}
}
