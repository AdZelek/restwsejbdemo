package com.example.restwsdemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Client {
	
	private int id; 
	private String firstName;
	private String surname;
	private int number_cart;
	
	public Client(String firstName, String surname, int number_cart) {
		super();
		this.firstName = firstName;
		this.surname = surname;
		this.number_cart = number_cart;
	}
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getNumber_cart() {
		return number_cart;
	}

	public void setNumber_cart(int number_cart) {
		this.number_cart = number_cart;
	}
	

	
}
