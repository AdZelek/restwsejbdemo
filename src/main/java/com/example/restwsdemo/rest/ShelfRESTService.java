package com.example.restwsdemo.rest;

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

import com.example.restwsdemo.domain.Shelf;
import com.example.restwsdemo.service.ShelfManager;

@Path("Shelf")
@Stateless
public class ShelfRESTService {

	
	@PersistenceContext
	EntityManager pm;
	

	@GET
	@Path("/{ShelfId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Shelf getShelf(@PathParam("ShelfId") Long id) {
		return pm.find(Shelf.class, id);
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public List<Shelf> getAllShelfs() {
		return pm.createNamedQuery("Shelf.getAll").getResultList();
	}


	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addShelf(Shelf shelf){
		pm.persist(shelf);
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
		pm.createNamedQuery("Shelf.deleteAll").executeUpdate();
		return Response.status(200).build();
	}

}
