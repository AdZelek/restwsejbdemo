package com.example.restwsdemo.service;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.example.restwsdemo.domain.Shoe;
import com.example.restwsdemo.domain.Shoe_;

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
	
	public Shoe getShoe(Long id) {
		return em.find(Shoe.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Shoe> getAllShoes(){
		return em.createNamedQuery("shoe.getAll").getResultList();
	}
	
	
	public void deleteShoe(Long id) {
		em.remove(new ShoeManager().getShoe(id));
    }
	
	@SuppressWarnings("unchecked") 
	public List<Shoe> findBySize(int size){
		return em.createNamedQuery("shoe.findBySize").setParameter("size", size).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getShoeOfClientByNumberCart(int numberCart ){		
		return em.createNamedQuery("shoeClilent.findByNumberCart").setParameter("numberCart", numberCart).getResultList();
	}
	
	
	public void deleteAllShoes(){
		em.createNamedQuery("shoe.deleteAll").executeUpdate();
		
	}
	
	
	public List<Shoe> getByPrice(Double price)
	{
		CriteriaBuilder qb = em.getCriteriaBuilder();
		CriteriaQuery<Shoe> c = qb.createQuery(Shoe.class);
		Root<Shoe> s = c.from(Shoe.class);
		Predicate condition = qb.lt(s.get(Shoe_.price), price);
		c.where(condition); 
		
	    TypedQuery<Shoe> q = em.createQuery(c);
	    List<Shoe> result = q.getResultList();

	    return result;
	}

}
