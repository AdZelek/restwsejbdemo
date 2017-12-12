package com.example.restwsdemo.domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@XmlRootElement
@Entity
public class Shelf {
	
	private Long Id; 
	private int row;
	private int column;
	private Collection<Shoe> shoes = new HashSet();
	
	public Shelf() {};
	
	
	
	public Shelf(Long id, int row, int column, Collection<Shoe> shoes) {
		super();
		Id = id;
		this.row = row;
		this.column = column;
		this.shoes = shoes;
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
	
	 @OneToMany(mappedBy="shelf")
	 public Collection<Shoe> getShoes() {
	 return shoes;
	 }

	public void setShoes(Collection<Shoe> shoes) {
		this.shoes = shoes;
	}
	 
	
	
	

}
