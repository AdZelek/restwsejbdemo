package com.example.restwsdemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restwsdemo.domain.Barcode;

@Stateless
public class BarcodeManager {
	
	
	//private List<Shoe> db = (new ArrayList<>());
	
	@PersistenceContext
	EntityManager em;

	public void addBarcode(Barcode barcode) {
		em.persist(barcode);
	}
	
	public Barcode updateBarcode(Barcode barcode){
		return em.merge(barcode);
	}
	
//	public Barcode findBarcode(Long Id){
//		 return em.find(Barcode.class, Id);
//	}
	
	public Barcode getBarcode(Long id) {
		
		return em.find(Barcode.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Barcode> getAllBarcodes(){
		return em.createNamedQuery("barcode.getAll").getResultList();
	}
	
	public void deleteAllBarcodes(){
		em.createNamedQuery("barcode.deleteAll").executeUpdate();
	}

}
