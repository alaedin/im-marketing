package com.imm.marketings.controller;

import static com.imm.marketings.utility.ConstantUtils.ADD;
import static com.imm.marketings.utility.ConstantUtils.DELETE;
import static com.imm.marketings.utility.ConstantUtils.UPDATE;

import javax.annotation.Resource;
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

import com.imm.marketings.utility.Response;
import com.imm.marketings.entity.Appointment;
import com.imm.marketings.entity.AppointmentType;
import com.imm.marketings.entity.Client;
import com.imm.marketings.entity.Person;
import com.imm.marketings.exception.ApiRequestException;
import com.imm.marketings.repository.AppointmentRepository;
import com.imm.marketings.repository.AppointmentTypeRepository;
import com.imm.marketings.repository.ClientRepository;
import com.imm.marketings.repository.PersonRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/im-workspace")
public class AppointmentController {

	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AppointmentTypeRepository appointmentTypeRepository;
	
	private static final String BASED_PATH = "/appointment";

	private static final String OBJECT_NAME =  "appointment";

	@Autowired
	private Response<Appointment> response;
	
    @Resource
    public void setResponse(Response<Appointment> response){this.response = response;}

	@GetMapping(BASED_PATH)
	private ResponseEntity<?> getAll() {
		return response.get(appointmentRepository.findAll(), OBJECT_NAME);
	}

	@GetMapping(BASED_PATH + "/{id}")
	public ResponseEntity<?> getById(@Valid @PathVariable("id") Long id) {
		return response.get(appointmentRepository.findById(id).get(), OBJECT_NAME);
	}

	@GetMapping(BASED_PATH + "/person/{personId}")
	public ResponseEntity<?>  getByPerson(@Valid @PathVariable("personId") Long personId) {
		return response.get(appointmentRepository.findByPerson_id(personId), OBJECT_NAME);
	}

	@PostMapping(BASED_PATH + "/" + ADD)
	public ResponseEntity<?>  add(@RequestBody Appointment appointment) {

		if (appointment.getPerson() == null || appointment.getClient() == null) {
			throw new ApiRequestException("Commercial or client is null");
		}
		Person person = null;
		Client client = null;
		AppointmentType appointmentType = null;

		if (appointment.getClient().getId() == 0) {
			client = appointment.getClient();
			clientRepository.save(client);
		} else
			client = clientRepository.findById(appointment.getClient().getId()).orElse(null);

		if (client == null)
			throw new ApiRequestException("client undifined");

		person = personRepository.findById(appointment.getPerson().getId()).orElse(null);
		if (person == null)
			throw new ApiRequestException("commercial undifined");

		appointmentType = appointmentTypeRepository.findById(appointment.getAppointmentType().getId()).orElse(null);
		if (appointmentType == null)
			throw new ApiRequestException("Appointment Type undifined");

		appointment.setClient(client);
		appointment.setPerson(person);
		appointment.setAppointmentType(appointmentType);

		appointmentRepository.save(appointment);
		return response.insert(appointment, OBJECT_NAME);
	}

	@PutMapping(BASED_PATH + "/" + UPDATE)
	public ResponseEntity<?>  update(@Valid @RequestBody Appointment appointment) {
		appointmentRepository.save(appointment);
		return response.update(appointment, OBJECT_NAME);
	}

	@DeleteMapping(BASED_PATH + "/" + DELETE)
	public ResponseEntity<?> delete(@Valid @RequestBody Appointment appointment) {
		appointmentRepository.delete(appointment);
		return response.delete(appointment, OBJECT_NAME);
	}
}
