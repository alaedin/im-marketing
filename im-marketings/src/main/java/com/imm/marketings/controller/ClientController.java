package com.imm.marketings.controller;

import static com.imm.marketings.utility.ConstantUtils.ADD;
import static com.imm.marketings.utility.ConstantUtils.DELETE;
import static com.imm.marketings.utility.ConstantUtils.RESSOURCE_ALREADY_EXISTS;
import static com.imm.marketings.utility.ConstantUtils.RESSOURCE_NOT_FOUND;
import static com.imm.marketings.utility.ConstantUtils.SUCCESS_DELETE;
import static com.imm.marketings.utility.ConstantUtils.SUCCESS_GET;
import static com.imm.marketings.utility.ConstantUtils.SUCCESS_SAVE;
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

import com.imm.marketings.entity.Client;
import com.imm.marketings.entity.Phone;
import com.imm.marketings.exception.ApiRequestException;
import com.imm.marketings.repository.PhoneRepository;
import com.imm.marketings.service.ClientService;
import com.imm.marketings.utility.ValuesObject;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/im-workspace")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private PhoneRepository phoneRepository;

	
	
	private static final String BASED_PATH = "/client";

	private static final String OBJECT_NAME = "client";

	@GetMapping(BASED_PATH)
	private ResponseEntity<?> getAll() {
		ValuesObject<?> persons = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_GET, OBJECT_NAME))
				.body(clientService.findAll())
				.build();
		return ResponseEntity.ok(persons);
	}

	@GetMapping(BASED_PATH + "/{id}")
	private ResponseEntity<?> getById(@Valid @PathVariable("id") Long id) {

		ValuesObject<?> persons = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_GET, OBJECT_NAME))
				.body(clientService.findById(id))
				.build();
		return ResponseEntity.ok(persons);
	}
	
	

	
	

	@PostMapping(BASED_PATH + "/" + ADD)
	private ResponseEntity<?> add(@Valid @RequestBody Client client) {
		if (client.getId()!= 0 && clientService.findById(client.getId())!= null)
			throw new ApiRequestException(message(OBJECT_NAME, RESSOURCE_ALREADY_EXISTS, client.getId()));
		Phone phone = client.getPhone();
		if (phone== null) {
			throw new ApiRequestException("phone number required");
		}
		if (phone.getId()== 0 ) {
			phone = phoneRepository.save(client.getPhone());
			client.setPhone(phone);
		}
		clientService.create(client);
		ValuesObject<?> persons = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_SAVE, OBJECT_NAME))
				.body(client)
				.build();
		return ResponseEntity.ok(persons);
	}

	@PutMapping(BASED_PATH + "/" + UPDATE)
	private ResponseEntity<?> update(@Valid @RequestBody Client client) {
		if (client.getId()== 0 || clientService.findById(client.getId())== null)
			throw new ApiRequestException(message(OBJECT_NAME, RESSOURCE_NOT_FOUND, client.getId()));
		clientService.create(client);
		ValuesObject<?> persons = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_UPDATE, OBJECT_NAME))
				.body(client)
				.build();
		return ResponseEntity.ok(persons);
	}

	@DeleteMapping(BASED_PATH + "/" + DELETE)
	private ResponseEntity<?> delete(@Valid @RequestBody Client client) {
		clientService.delete(client);
		ValuesObject<?> clients = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_DELETE, OBJECT_NAME))
				.body(client)
				.build();
		return ResponseEntity.ok(clients);
	}

	@DeleteMapping(BASED_PATH + "/" + DELETE+ "/{id}")
	private ResponseEntity<?> delete(@Valid @PathVariable long id) {
		clientService.delete(id);
		ValuesObject<?> clients = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_DELETE, OBJECT_NAME))
				.body("")
				.build();
		return ResponseEntity.ok(clients);
	}

	@GetMapping(BASED_PATH + "/appointment" )
	private ResponseEntity<?>getNotExistsInAppointment(){
		
		ValuesObject<?> clients = ValuesObject.builder()
				.outCode(0)
				.message(message(SUCCESS_GET, OBJECT_NAME))
				.body(clientService.findWhereNotExistsInAppointment())
				.build();
		return ResponseEntity.ok(clients);
	}
}
