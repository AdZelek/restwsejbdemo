package com.example.restwsdemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;

import com.example.restwsdemo.domain.Shoe;

@Singleton
public class ShoeManager {
	
	private List<Shoe> db = (new ArrayList<>());

	public void addShoe(Shoe shoe) {
		db.add(shoe);
	}

	public void deleteShoe(Shoe shoe){
		db.remove(shoe);
 	}
	
	public Shoe getShoe(Integer id) {
		return new Shoe("Addidas 1231", 35, 199.99);
	}
	
	public List<Shoe> getAllShoes(){
		return db;
	}
	
	public void deleteAllShoes(){
		db.clear();
	}

}
