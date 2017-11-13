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

import com.example.restwsdemo.domain.Shoe;
import com.example.restwsdemo.service.ShoeManager;

@Path("shoe")
@Stateless
public class ShoeRESTService {

	@Inject
	private ShoeManager pm;

	@GET
	@Path("/{shoeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Shoe getshoe(@PathParam("shoeId") Integer id) {
		Shoe p = pm.getShoe(id);
		return p;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Shoe> getshoes() {
		return pm.getAllShoes();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addshoe(Shoe shoe) {
		pm.addShoe(shoe);

		return Response.status(201).entity("shoe").build();
	}

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "REST API /shoe is running today!";
	}

	@DELETE
	public Response clearshoes() {
		pm.deleteAllShoes();
		return Response.status(200).build();
	}

}
