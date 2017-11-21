package com.example.restwsdemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Id;

@XmlRootElement
@Entity
public class Shelf {
	
	private Long Id; 
	private int row;
	private int column;
	
	public Shelf(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) 
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
	
	
	

}
