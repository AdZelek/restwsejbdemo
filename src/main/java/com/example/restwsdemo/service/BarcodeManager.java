package com.example.restwsdemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restwsdemo.domain.Barcode;
import com.example.restwsdemo.domain.Shoe;

@Stateless
public class BarcodeManager {
	
	
	@PersistenceContext
	EntityManager em;

	public void addBarcode(Barcode barcode) {
		em.persist(barcode);
	}
	
	public Barcode updateBarcode(Barcode barcode){
		return em.merge(barcode);
	}
	
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

	public void deleteBarcode(Barcode barcode) {
        em.remove(barcode);
    }
}
