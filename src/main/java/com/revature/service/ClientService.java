package com.revature.service;

import com.revature.dao.ClientRepository;
import com.revature.exceptions.BadParameterException;
import com.revature.exceptions.ClientNotFoundException;
import com.revature.model.Client;

public class ClientService {

	private ClientRepository clientRepository;
	
	public ClientService() {
		this.clientRepository = new ClientRepository();
	}
	
	// Normally we use the no-args in the normal functioning of our application
	// But when we're testing, we need this constructor to "inject" our mock object into this service
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	public Client getClientById(String stringId) throws BadParameterException, ClientNotFoundException {
		try {
			int id = Integer.parseInt(stringId);
			
			Client client = clientRepository.getClientById(id);
			
			if (client == null) {
				throw new ClientNotFoundException("Client with id of " + id + " was not found");
			}
			
			return client;
		} catch (NumberFormatException e) {
			throw new BadParameterException("Client id must be an int. User provided " + stringId);
		}
	}
	
}