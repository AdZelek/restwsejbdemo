package com.example.restwsejbdemo;

import static com.jayway.restassured.RestAssured.*;

import javax.ws.rs.core.MediaType;

import org.junit.BeforeClass;
import org.junit.Test;

import com.example.restwsdemo.domain.Shoe;
import com.jayway.restassured.RestAssured;


public class ShoeServiceIT {
	private static final String SHOE_NAME = "Nike"; 
	private static final int SHOE_SIZE = 38; 
	

	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restejbjpademo/api";
	}

	@Test
	public void addShoe() {
		Shoe shoe = new Shoe();
		shoe.setName(SHOE_NAME);
		shoe.setSize(SHOE_SIZE);
		given().contentType(MediaType.APPLICATION_JSON).body(shoe).when().post("/shoe/").then().assertThat()
				.statusCode(201);
	}

	@Test
	public void getShoe() {
		Shoe shoe = new Shoe();
		shoe.setName(SHOE_NAME);
		shoe.setSize(SHOE_SIZE);
		given().contentType(MediaType.APPLICATION_JSON).body(shoe).when().post("/shoe/").then().assertThat()
				.statusCode(201);
	}

		
	}
	


