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

import com.example.restwsdemo.domain.Barcode;
import com.example.restwsdemo.service.BarcodeManager;

@Path("barcode")
@Stateless
public class BarcodeRESTService {

	
	@Inject
	private BarcodeManager bm;
	

	@GET
	@Path("/{BarcodeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Barcode getBarcode(@PathParam("BarcodeId") Long id) {
		Barcode b = bm.getBarcode(id);
		return b; 
	}


	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBarcode(Barcode barcode){
		bm.addBarcode(barcode);
		return Response.status(201).entity("Barcode").build(); 
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "REST API /Barcode is running today!";
	}

	@DELETE
	public Response clearBarcodes(){
			return Response.status(200).build();
	}
	@DELETE
	@Path("/usun/{id}")
	public void deleteShoe(@PathParam("id") Long id){
		bm.deleteBarcode(bm.getBarcode(id)); 
	}

}
