package com.imm.marketings.service;

import java.util.List;
import java.util.Set;

import com.imm.marketings.entity.Client;

public interface ClientService {

	void create(Client client);

	void update(Client event);

	void delete(Client event);

	void delete(long id);

	Client findById(long eventId);

	List<Client> findAll();

	Set<Client> findWhereNotExistsInAppointment();

}
