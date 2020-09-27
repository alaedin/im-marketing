package com.imm.marketings.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imm.marketings.entity.Client;
import com.imm.marketings.repository.ClientRepository;
import com.imm.marketings.repository.PhoneRepository;
import com.imm.marketings.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	

	@Autowired
	private ClientRepository clientRepository;
	
	
	@Override
	public void create(Client client) {
		clientRepository.save(client);
	}

	 @Override
	    public void update(Client event) {
	        clientRepository.save(event);
	    }

	    @Override
	    public void delete(Client event) {
	        clientRepository.delete(event);
	    }

	    @Override
	    public void delete(long id) {
	        if (clientRepository.findById(id).isPresent())
	            clientRepository.deleteById(id);
	    }

	    @Override
	    public Client findById(long eventId) {
	        return clientRepository.findById(eventId).isPresent() ? clientRepository.findById(eventId).get() : null;
	    }

	    @Override
	    public List<Client> findAll(){
	        return clientRepository.findAll();
	    }
}
