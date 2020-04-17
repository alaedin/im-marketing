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

import com.imm.entity.AppointmentType;
import com.imm.repository.AppointmentTypeRepository;
import com.imm.utility.ValuesObject;

@RestController
@RequestMapping("/im-workspace")
public class AppointmentTypeController {

	@Autowired
	private AppointmentTypeRepository appointmentTypeRepository;
	private static final String BASED_PATH = "/appointment-type";

	@GetMapping(BASED_PATH)
	private ResponseEntity<?> getAll() {
		ValuesObject<?> appointmentTypes = ValuesObject.builder()
				.outCode(0)
				.message(successMessage(SUCCESS_GET, " Appointment type "))
				.body(appointmentTypeRepository.findAll())
				.build();
		return ResponseEntity.ok(appointmentTypes);
	}

	@GetMapping(BASED_PATH + "/{id}")
	private ResponseEntity<?> getById(@Valid @PathVariable("id") Long id) {

		ValuesObject<?> appointmentTypes = ValuesObject.builder()
				.outCode(0)
				.message(successMessage(SUCCESS_GET, " Appointment type "))
				.body(appointmentTypeRepository.findById(id))
				.build();
		return ResponseEntity.ok(appointmentTypes);
	}

	@PostMapping(BASED_PATH + "/" + ADD)
	private ResponseEntity<?> add(@Valid @RequestBody AppointmentType appointmentType) {
		appointmentTypeRepository.save(appointmentType);
		ValuesObject<?> appointmentTypes = ValuesObject.builder()
				.outCode(0)
				.message(successMessage(SUCCESS_SAVE, " Appointment type "))
				.body(appointmentType)
				.build();
		return ResponseEntity.ok(appointmentTypes);
	}

	@PutMapping(BASED_PATH + "/" + UPDATE)
	private ResponseEntity<?> update(@Valid @RequestBody AppointmentType appointmentType) {
		appointmentTypeRepository.save(appointmentType);
		ValuesObject<?> appointmentTypes = ValuesObject.builder()
				.outCode(0)
				.message(successMessage(SUCCESS_UPDATE, " Appointment type "))
				.body(appointmentType)
				.build();
		return ResponseEntity.ok(appointmentTypes);
	}

	@DeleteMapping(BASED_PATH + "/" + DELETE)
	private ResponseEntity<?> delete(@Valid @RequestBody AppointmentType appointmentType) {
		appointmentTypeRepository.delete(appointmentType);
		ValuesObject<?> appointmentTypes = ValuesObject.builder()
				.outCode(0)
				.message(successMessage(SUCCESS_DELETE, " Appointment type "))
				.body(appointmentType)
				.build();
		return ResponseEntity.ok(appointmentTypes);
	}
}
