package com.example.restwsdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
//import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restwsdemo.domain.Client;
import com.example.restwsdemo.domain.Shelf;
import com.example.restwsdemo.domain.Shoe;
import com.example.restwsdemo.service.ClientManager;
import com.example.restwsdemo.service.ShelfManager;
import com.example.restwsdemo.service.ShoeManager;

@Path("shoe")
@Stateless
public class ShoeRESTService {

	
	@EJB
	ShoeManager sm;
	
	@EJB
	ClientManager cm;
	
	@EJB
	ShelfManager shm;
	


	@GET
	@Path("/{shoeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Shoe getShoe(@PathParam("shoeId") Long id) {
		Shoe s = sm.getShoe(id); 
		return s;
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Shoe> getAllShoes() {
		return sm.getAllShoes(); 
				
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addShoe(Shoe shoe){
		sm.addShoe(shoe);
		return Response.status(201).entity("Shoe").build(); 
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "REST API /shoe is running today!";
	}

	@Path("/delete/{id}")
	@DELETE
	public void deleteShoe(@PathParam("id") Long id){
	  sm.deleteShoe(id); 
	 // Response.status(200).entity(response).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@DELETE
	@Path("/deleteAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response clearShoes(){
		sm.deleteAllShoes();
		//em.createNamedQuery("shoe.deleteAll").executeUpdate();
	return Response.status(200).build();
	}
	
	@GET
	@Path("/query/size/{size}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Shoe> getShoe(@PathParam("size") int size){
		return sm.findBySize(size);
	}
	
	@GET
	@Path("/query/shoeClients/{cNumberCart}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getShoeClients(@PathParam("cNumberCart") int numberCart){
		
		List<Object[]> rawClients = sm.getShoeOfClientByNumberCart(numberCart);
		JsonArrayBuilder clients = Json.createArrayBuilder();
		
		for(Object[] rawClient: rawClients){
			
			String fName = (String) rawClient[0];
			String sName = (String) rawClient[1];
			int numberCartC = (Integer) rawClient[2];
			double priceShoe = (Double) rawClient[4];
			String nameShoe = (String) rawClient[3];
	
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
	@Path("/addClients")
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
		
		sm.addShoe(s);
		sm.addShoe(s2);
		
		return Response.status(200).build();
	}
	

	@GET
	@Path("/manytoone")
	@Produces(MediaType.TEXT_PLAIN)
	public String testRelations(){
		
		Shoe s = new Shoe();
		Shoe s2 = new Shoe();
		s.setName("Nike v120");
		s.setSize(39);
		s.setPrice(199.99);
		s2.setName("Nike m220");
		s2.setSize(35);
		
		Shelf sh1 = new Shelf();
		Shelf sh2= new Shelf();
		sh1.setColumn(1);
		sh1.setRow(2); 
		sh2.setColumn(10);
		sh2.setRow(20);
		
		List<Shoe> shoes = new ArrayList<>();
		shoes.add(s);
		shoes.add(s2);
		
		s.setShelf(sh1);
		s2.setShelf(sh1);
	
		sm.addShoe(s);
		sm.addShoe(s2);
		
		sh1.addShoe(s);
		sh1.addShoe(s2);
		shm.addShelf(sh1);
		//shm.addShelf(sh2);
	
		return "ManyToOne";
	}
	@GET
	@Path("/lazy/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getShoeLazy(@PathParam("id") Long id){
		Shoe s = sm.getShoe(id);
		if (s==null) return ("empty");
		else if(s.getShelf()==null) return (" Name:" +s.getName()+"\n Shelf: empty\n");
		else return(" Name:" +s.getName()+"\n Shelf \n"
					+ " Column:" + s.getShelf().getColumn()+ " Row:"+ s.getShelf().getRow());
	}

	
	
	
	@GET
	@Path("/ltPrice/{price}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Shoe> getShoeByPrice(@PathParam("price") Double price){
		return sm.getByPrice(price);
	}

}
