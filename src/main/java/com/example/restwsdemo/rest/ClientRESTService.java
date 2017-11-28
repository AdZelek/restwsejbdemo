package com.example.restwsdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restwsdemo.domain.Client;
import com.example.restwsdemo.domain.Shoe;
import com.example.restwsdemo.service.BarcodeManager;
import com.example.restwsdemo.service.ClientManager;

@Path("client")
@Stateless
public class ClientRESTService {

	
	@Inject
	private ClientManager pm;
	

	@GET
	@Path("/{ClientId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Client getClient(@PathParam("ClientId") Long id) {
		Client c = pm.getClient(id); 
		return c; 
	}

//	@GET
//	@Path("/all")
//	@Produces(MediaType.APPLICATION_JSON)
//	@SuppressWarnings("unchecked")
//	public List<Client> getAllClients() {
//		return pm.createNamedQuery("Client.getAll").getResultList();
//	}


	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addClient(Client client){
		pm.addClient(client);
		return Response.status(201).entity("Client").build(); 
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "REST API /Client is running today!";
	}

	@DELETE
	public Response clearPersons(){
			return Response.status(200).build();
	}
	@DELETE
	@Path("/usun/{id}")
	public void deleteShoe(@PathParam("id") Long id){
		pm.deleteClient(pm.getClient(id)); 
	}
	
	

	

}
