package com.imm.marketings.controller;

import static com.imm.marketings.utility.ConstantUtils.ADD;
import static com.imm.marketings.utility.ConstantUtils.DELETE;
import static com.imm.marketings.utility.ConstantUtils.SUCCESS_DELETE;
import static com.imm.marketings.utility.ConstantUtils.SUCCESS_GET;
import static com.imm.marketings.utility.ConstantUtils.SUCCESS_SAVE;
import static com.imm.marketings.utility.ConstantUtils.SUCCESS_UPDATE;
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

import com.imm.marketings.entity.PersonAppointment;
import com.imm.marketings.repository.PersonAppointmentRepository;
import com.imm.marketings.utility.ValuesObject;

@RestController
@RequestMapping("/im-workspace")
public class PersonAppointmentController {

	@Autowired
	private PersonAppointmentRepository personAppointmentRepository;
	private static final String BASED_PATH = "/person-appointment";

	@GetMapping(BASED_PATH)
	private ResponseEntity<?> getAll() {
		ValuesObject<?> persons = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_GET, "Person Appointment"))
				.body(personAppointmentRepository.findAll())
				.build();
		return ResponseEntity.ok(persons);
	}

	@GetMapping(BASED_PATH + "/{id}")
	private ResponseEntity<?> getById(@Valid @PathVariable("id") Long id) {

		ValuesObject<?> persons = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_GET, "Person Appointment"))
				.body(personAppointmentRepository.findById(id))
				.build();
		return ResponseEntity.ok(persons);
	}

	@PostMapping(BASED_PATH + "/" + ADD)
	private ResponseEntity<?> add(@Valid @RequestBody PersonAppointment personAppointment) {
		personAppointmentRepository.save(personAppointment);
		ValuesObject<?> persons = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_SAVE, "Person Appointment"))
				.body(personAppointment)
				.build();
		return ResponseEntity.ok(persons);
	}

	@PutMapping(BASED_PATH + "/" + UPDATE)
	private ResponseEntity<?> update(@Valid @RequestBody PersonAppointment personAppointment) {
		personAppointmentRepository.save(personAppointment);
		ValuesObject<?> persons = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_UPDATE, "Person Appointment"))
				.body(personAppointment)
				.build();
		return ResponseEntity.ok(persons);
	}

	@DeleteMapping(BASED_PATH + "/" + DELETE)
	private ResponseEntity<?> delete(@Valid @RequestBody PersonAppointment personAppointment) {
		personAppointmentRepository.delete(personAppointment);
		ValuesObject<?> persons = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_DELETE, "Person Appointment"))
				.body(personAppointment)
				.build();
		return ResponseEntity.ok(persons);
	}
}
