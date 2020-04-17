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

import com.imm.entity.Appointment;
import com.imm.repository.AppointmentRepository;
import com.imm.utility.ValuesObject;


@RestController
@RequestMapping("/im-workspace")
public class AppointmentController {

	@Autowired
	private AppointmentRepository appointmentRepository;
	private static final String BASED_PATH = "/appointment";

	@GetMapping(BASED_PATH)
	private ResponseEntity<?> getAll() {
		ValuesObject<?> appointments = ValuesObject.builder()
				.outCode(0)
				.message(successMessage(SUCCESS_GET, " Appointment"))
				.body(appointmentRepository.findAll())
				.build();
		return ResponseEntity.ok(appointments);
	}

	@GetMapping(BASED_PATH + "/{id}")
	private ResponseEntity<?> getById(@Valid @PathVariable("id") Long id) {

		ValuesObject<?> appointments = ValuesObject.builder()
				.outCode(0)
				.message(successMessage(SUCCESS_GET, " Appointment"))
				.body(appointmentRepository.findById(id))
				.build();
		return ResponseEntity.ok(appointments);
	}

	@PostMapping(BASED_PATH + "/" + ADD)
	private ResponseEntity<?> add(@Valid @RequestBody Appointment appointment) {
		appointmentRepository.save(appointment);
		ValuesObject<?> appointments = ValuesObject.builder()
				.outCode(0)
				.message(successMessage(SUCCESS_SAVE, " Appointment"))
				.body(appointment)
				.build();
		return ResponseEntity.ok(appointments);
	}

	@PutMapping(BASED_PATH + "/" + UPDATE)
	private ResponseEntity<?> update(@Valid @RequestBody Appointment appointment) {
		appointmentRepository.save(appointment);
		ValuesObject<?> appointments = ValuesObject.builder()
				.outCode(0)
				.message(successMessage(SUCCESS_UPDATE, " Appointment"))
				.body(appointment)
				.build();
		return ResponseEntity.ok(appointments);
	}

	@DeleteMapping(BASED_PATH + "/" + DELETE)
	private ResponseEntity<?> delete(@Valid @RequestBody Appointment appointment) {
		appointmentRepository.delete(appointment);
		ValuesObject<?> appointments = ValuesObject.builder()
				.outCode(0)
				.message(successMessage(SUCCESS_DELETE, " Appointment"))
				.body(appointment)
				.build();
		return ResponseEntity.ok(appointments);
	}
}
