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

import com.example.restwsdemo.domain.Person;
import com.example.restwsdemo.service.PersonManager;

@Path("person")
@Stateless
public class PersonRESTService {

	@Inject
	private PersonManager pm;

	@GET
	@Path("/{personId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson(@PathParam("personId") Integer id) {
		Person p = pm.getPerson(id);
		return p;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getPersons() {
		return pm.getAllPersons();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPerson(Person person) {
		pm.addPerson(person);

		return Response.status(201).entity("Person").build();
	}

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "REST API /person is running today!";
	}

	@DELETE
	public Response clearPersons() {
		pm.deleteAllPersons();
		return Response.status(200).build();
	}

}
