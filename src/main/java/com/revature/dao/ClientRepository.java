package com.revature.dao;

import com.revature.model.Client;

public class ClientRepository {

	public Client getClientById(int id) {
		if (id == 1) {
			return new Client(1000, "Edward", "Thatch");
		}
		
		return null;
	}
	// Perform database operations such as retrieving a pirate, updating a pirate's data, 
	// adding a new pirate, etc.
}