package com.example.restwsdemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Client {
	
	private long id; 
	private String firstName;
	private String surname;
	private int numberCart;
	
	public Client()
	{};

	
	public Client(String firstName, String surname, int number_cart) {
		super();
		this.firstName = firstName;
		this.surname = surname;
		this.numberCart = number_cart;
	}
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) 
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public int getNumberCart() {
		return numberCart;
	}

	public void setNumberCart(int number_cart) {
		this.numberCart = number_cart;
	}
	

	
}
