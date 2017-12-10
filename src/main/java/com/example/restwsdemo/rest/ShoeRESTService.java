package com.example.restwsdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
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
import com.example.restwsdemo.service.ClientManager;
import com.example.restwsdemo.service.ShoeManager;

@Path("shoe")
@Stateless
public class ShoeRESTService {

	
	@EJB
	ShoeManager pm;
	
	@EJB
	ClientManager cm;
	
	@PersistenceContext
	EntityManager em;
	
	

	@GET
	@Path("/{shoeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Shoe getShoe(@PathParam("shoeId") Long Id) {
		Shoe s = pm.getShoe(Id); 
		return s;
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public List<Shoe> getAllShoes() {
		return em.createNamedQuery("shoe.getAll").getResultList();
	}
	


	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addShoe(Shoe shoe){
		pm.addShoe(shoe);
		return Response.status(201).entity("Shoe").build(); 
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "REST API /shoe is running today!";
	}

	@DELETE
	@Path("/usun/{id}")
	public void deleteShoe(@PathParam("id") Long id){
		pm.deleteShoe(pm.getShoe(id)); 
	}
	
	@DELETE
	public Response clearShoes(){
		em.createNamedQuery("shoe.deleteAll").executeUpdate();
		return Response.status(200).build();
	}
	
	@GET
	@Path("/query/size/{size}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Shoe> getShoe(@PathParam("size") int size){
		return pm.findBySize(size);
	}
	
	@GET
	@Path("/query/shoeClients/{cNumberCart}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBooksAuthor(@PathParam("cNumberCart") int numberCart){
		
		List<Object[]> rawClients = pm.getShoeOfClientByNumberCart(numberCart);
		JsonArrayBuilder clients = Json.createArrayBuilder();
		
		for(Object[] rawClient: rawClients){
			
			String fName = (String) rawClient[0];
			String sName = (String) rawClient[1];
			int numberCartC = (Integer) rawClient[2];
			double priceShoe = (Double) rawClient[4];
			String nameShoe = (String) rawClient[3];
			// c.firstName, c.surname, c.numberCart, s.name, s.price
			clients.add(Json.createObjectBuilder()
					.add("firstName", fName)
					.add("surname", sName)
					.add("numberCart", numberCartC)
					.add("name",nameShoe)
					.add("price", priceShoe));
			
		}
		
		JsonObject json =  Json.createObjectBuilder().add("result", clients).build();
		return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}

	
	

	@GET
	@Path("/dodajC")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addShoeNew() {
		
		Client c1 = new Client();
		Client c2 = new Client();
		Client c3 = new Client();
		List<Client> clients = new ArrayList<>(); 
		List<Client> clients2 = new ArrayList<>(); 
		
		
		c1.setFirstName("Jan");
		c1.setSurname("Jankowski");
		c1.setNumberCart(12345);
		c2.setFirstName("Anna");
		c2.setSurname("Jankowska");
		c2.setNumberCart(23456);
		c3.setFirstName("Adam");
		c3.setSurname("Adamowski");
		c3.setNumberCart(123123);
		clients.add(c1);
		clients.add(c2);
		clients.add(c3);
		clients2.add(c3);
		clients2.add(c2);
		
		cm.addClient(c1);
		cm.addClient(c2);
		cm.addClient(c3);
		
		
		Shoe s = new Shoe();
		Shoe s2 = new Shoe();
		s.setName("Nike v120");
		s.setSize(39);
		s.setPrice(199.99);
		s.setClients(clients);
		s2.setName("Nike m220");
		s2.setSize(35);
		s2.setPrice(299.99);
		s2.setClients(clients2);
		
		
		pm.addShoe(s);
		pm.addShoe(s2);
		
		return Response.status(200).build();
	}
	

}
