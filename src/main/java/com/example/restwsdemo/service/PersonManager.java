package com.example.restwsdemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;

import com.example.restwsdemo.domain.Person;

@Singleton
public class PersonManager {
	
	private List<Person> db = (new ArrayList<>());

	public void addPerson(Person person) {
		db.add(person);
	}

	public void deletePerson(Person person){
		db.remove(person);
 	}
	
	public Person getPerson(Integer id) {
		return new Person("Bolek", 1976);
	}
	
	public List<Person> getAllPersons(){
		return db;
	}
	
	public void deleteAllPersons(){
		db.clear();
	}

}
