package com.example.restwsdemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restwsdemo.domain.Shoe;

@Stateless
public class ShoeManager {
	
	
	@PersistenceContext
	EntityManager em;

	public void addShoe(Shoe shoe) {
		em.persist(shoe);
	}
	
	public Shoe updateShoe(Shoe shoe){
		return em.merge(shoe);
	}
	
	public Shoe getShoe(Long Id) {
		return em.find(Shoe.class, Id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Shoe> getAllShoes(){
		return em.createNamedQuery("shoe.getAll").getResultList();
	}
	
	public void deleteShoe(Shoe shoe) {
        em.remove(shoe);
    }
	
//	public void deleteAllShoes(){
//		em.createNamedQuery("shoe.deleteAll").executeUpdate();
//	}

}
