package com.imm.marketings.controller;

import static com.imm.marketings.utility.ConstantUtils.ADD;
import static com.imm.marketings.utility.ConstantUtils.DELETE;
import static com.imm.marketings.utility.ConstantUtils.UPDATE;

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

import com.imm.marketings.entity.Appointment;
import com.imm.marketings.repository.AppointmentRepository;
import com.imm.marketings.utility.Response;


@RestController
@RequestMapping("/im-workspace")
public class AppointmentController {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	private static final String BASED_PATH = "/appointment";

	@Autowired
	Response<Appointment> response;
	
	@GetMapping(BASED_PATH)
	private ResponseEntity<?> getAll() {
		return response.get(appointmentRepository.findAll(), "appointment");
	}

	@GetMapping(BASED_PATH + "/{id}")
	private ResponseEntity<?> getById(@Valid @PathVariable("id") Long id) {
		return response.get(appointmentRepository.findById(id), "appointment");
	}

	@PostMapping(BASED_PATH + "/" + ADD)
	private ResponseEntity<?> add(@Valid @RequestBody Appointment appointment) {
		appointmentRepository.save(appointment);
		return response.insert(appointment, "appointment");
	}

	@PutMapping(BASED_PATH + "/" + UPDATE)
	private ResponseEntity<?> update(@Valid @RequestBody Appointment appointment) {
		appointmentRepository.save(appointment);
		return response.update(appointment, "appointment");
	}

	@DeleteMapping(BASED_PATH + "/" + DELETE)
	private ResponseEntity<?> delete(@Valid @RequestBody Appointment appointment) {
		appointmentRepository.delete(appointment);
		return response.delete(null, "appointment");
	}
}
