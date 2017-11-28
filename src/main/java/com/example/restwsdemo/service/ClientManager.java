package com.example.restwsdemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restwsdemo.domain.Barcode;
import com.example.restwsdemo.domain.Client;

@Stateless
public class ClientManager {
	
	
	@PersistenceContext
	EntityManager em;

	public void addClient(Client client) {
		em.persist(client);
	}
	
	public Client updateClient(Client client){
		return em.merge(client);
	}
	
	public Client getClient(Long id) {
		return em.find(Client.class, id);
	}
	
	public void deleteClient(Client client) {
        em.remove(client);
    }
	
	@SuppressWarnings("unchecked")
	public List<Client> getAllClients(){
		return em.createNamedQuery("client.getAll").getResultList();
	}
	
	public void deleteAllClients(){
		em.createNamedQuery("client.deleteAll").executeUpdate();
	}

}
