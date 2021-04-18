package com.revature.controller;

import com.revature.model.Client;
import com.revature.service.ClientService;

import io.javalin.Javalin;
import io.javalin.http.ExceptionHandler;
import io.javalin.http.Handler;

public class ClientController implements Controller{

	private ClientService clientService;
	
	public ClientController() {
		this.clientService = new ClientService();
	}
	private Handler getClients = ctx -> {
		ctx.html("<h1>getClients Handler</h1>");
	};
	
	private Handler getClientsById = ctx -> {
		String id = ctx.pathParam("id");
		//ctx.html("<h1>getPiratesByID Handler</h1>" + "\n" + "<p>id is " + " </p");
		
		Client client = clientService.getClientById(id);
		
		ctx.json(client); //Takes any Java Object and serialization it into JSON
		// Serialization means taking an object and converting it into some sendable data
		
		ctx.status(200); //200 means successful in general
	};
	
	private Handler addClient = ctx -> {
		Client client = ctx.bodyAsClass(Client.class);
		
		ctx.json(client);
	};
	
	@Override
	public void mapEndPoints(Javalin app) {
		
		app.get("/clients", getClients);
		app.get("/clients/:id", getClientsById); //id is a 'path parameter'
		app.post("/pirates", addClient);
	}
}

