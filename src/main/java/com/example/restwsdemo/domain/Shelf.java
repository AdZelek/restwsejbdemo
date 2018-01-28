package com.example.restwsdemo.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.xml.bind.annotation.XmlRootElement;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@XmlRootElement
@Entity
@NamedQueries({
	@NamedQuery(name = "shelf.getAll", query = "Select s from Shelf s"),
})
public class Shelf {
	
	private Long Id; 
	private int row;
	private int column;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "shelf")
	private Set<Shoe> shoes = new HashSet<Shoe>();
	
	
	public Shelf() {};
	
	public Shelf(Long id, int row, int column) {
		super();
		Id = id;
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
	 
	public void addShoe(Shoe shoe) {
		this.shoes.add(shoe);
	
}
	

}
