package com.example.restwsdemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restwsdemo.domain.Barcode;
import com.example.restwsdemo.domain.Shelf;

@Stateless
public class ShelfManager {
	
	
	//private List<Shelf> db = (new ArrayList<>());
	
	@PersistenceContext
	EntityManager em;

	public void addShelf(Shelf shelf) {
		em.persist(shelf);
	}
	
	public Shelf updateShelf(Shelf shelf){
		return em.merge(shelf);
	}
	
	public Shelf getShelf(Long id) {
		return em.find(Shelf.class, id);
	}
	
	public void deleteShelf(Shelf shelf) {
        em.remove(shelf);
    }
	
//	
//	
//	@SuppressWarnings("unchecked")
//	public List<Shelf> getAllShelfs(){
//		return em.createNamedQuery("Shelf.getAll").getResultList();
//	}
//	
//	public void deleteAllShelfs(){
//		em.createNamedQuery("Shelf.deleteAll").executeUpdate();
//	}

}
