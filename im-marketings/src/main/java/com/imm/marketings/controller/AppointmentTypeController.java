package com.imm.marketings.controller;

import static com.imm.marketings.utility.ConstantUtils.ADD;
import static com.imm.marketings.utility.ConstantUtils.DELETE;
import static com.imm.marketings.utility.ConstantUtils.SUCCESS_DELETE;
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

import com.imm.marketings.entity.Appointment;
import com.imm.marketings.entity.AppointmentType;
import com.imm.marketings.repository.AppointmentTypeRepository;
import com.imm.marketings.utility.Response;
import com.imm.marketings.utility.ValuesObject;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/im-workspace")
public class AppointmentTypeController {

	@Autowired
	private AppointmentTypeRepository appointmentTypeRepository;

	private static final String BASED_PATH = "/appointment-type";

	@Autowired
	Response<Appointment> response;

	@GetMapping(BASED_PATH)
	private ResponseEntity<?> getAll() {
		return response.get(appointmentTypeRepository.findAll(), "Appointment type ");

	}

	@GetMapping(BASED_PATH + "/{id}")
	private ResponseEntity<?> getById(@Valid @PathVariable("id") Long id) {
		return response.get(appointmentTypeRepository.findById(id), "Appointment type ");

		
	}

	@PostMapping(BASED_PATH + "/" + ADD)
	private ResponseEntity<?> add(@Valid @RequestBody AppointmentType appointmentType) {
		appointmentTypeRepository.save(appointmentType);
		return response.get(appointmentType, "appointment type ");

	}

	@PutMapping(BASED_PATH + "/" + UPDATE)
	private ResponseEntity<?> update(@Valid @RequestBody AppointmentType appointmentType) {
		appointmentTypeRepository.save(appointmentType);
		ValuesObject<?> appointmentTypes = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_UPDATE, " Appointment type "))
				.body(appointmentType)
				.build();
		return ResponseEntity.ok(appointmentTypes);
	}

	@DeleteMapping(BASED_PATH + "/" + DELETE)
	private ResponseEntity<?> delete(@Valid @RequestBody AppointmentType appointmentType) {
		appointmentTypeRepository.delete(appointmentType);
		ValuesObject<?> appointmentTypes = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_DELETE, " Appointment type "))
				.body(appointmentType)
				.build();
		return ResponseEntity.ok(appointmentTypes);
	}
}
