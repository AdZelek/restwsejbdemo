package com.example.restwsdemo.rest;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restwsdemo.domain.Shelf;
import com.example.restwsdemo.service.ShelfManager;

@Path("shelf")
@Stateless
public class ShelfRESTService {

	

	@Inject
	private ShelfManager sm;
	

	@GET
	@Path("/{ShelfId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Shelf getShelf(@PathParam("ShelfId") Long id) {
		Shelf s = sm.getShelf(id);
		return s; 
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Shelf> getAllShelfs() {
		return sm.getAllShelfs();
	}


	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addShelf(Shelf shelf){
		sm.addShelf(shelf);
		return Response.status(201).entity("Shelf").build(); 
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "REST API /Shelf is running today!";
	}

	@DELETE
	public Response clearPersons(){
		return Response.status(200).build();
	}
	
	@DELETE
	@Path("/usun/{id}")
	public void deleteShoe(@PathParam("id") Long id){
		sm.deleteShelf(sm.getShelf(id)); 
	}

}
