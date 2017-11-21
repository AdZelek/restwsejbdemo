package com.example.restwsdemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Id;

@XmlRootElement
@Entity
public class Barcode {
	private long Id ; 
	private long code;

	
	public Barcode(long id, long code) {
		super();
		this.code = code;
	}
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) 
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	
	

}
