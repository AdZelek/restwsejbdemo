package com.example.restwsdemo.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@XmlRootElement
@Entity
@NamedQueries({
	@NamedQuery(name = "shoe.getAll", query = "Select s from Shoe s"),
	@NamedQuery(name="shoe.deleteAll", query="Delete from Shoe"),
	@NamedQuery(name = "shoe.findBySize", query = "Select s from Shoe s where s.size = :size"),
	@NamedQuery(name = "shoeClilent.findByNumberCart",
	query = "Select c.firstName, c.surname, c.numberCart, s.name, s.price from Shoe s JOIN s.clients c where c.numberCart = :numberCart")

})
	public class Shoe {
		
		private Long id; 
		private String name;
		private Integer size;
		private double price;
		private Barcode barcode;
		
		
		private Collection<Client> clients = new ArrayList<>();
		
		
		private Shelf shelf;
		
		public Shoe() {};
		
		public Shoe(String name, Integer size, double price, Barcode barcode, Shelf shelf, Collection<Client> clients) {
			this.name = name;
			this.size = size;
			this.price = price;
			this.barcode = barcode;
			this.shelf = shelf;
			this.clients = clients;
		}


		@OneToOne
		public Barcode getBarcode() {
			return barcode;
		}
		public void setBarcode(Barcode barcode) {
			this.barcode = barcode;
		}

		@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		public Collection<Client> getClients() {
				return clients;
			}
			public void setClients(Collection<Client> clients) {
				this.clients = clients;
			}

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) 
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public Integer getSize() {
			return size;
		}
		public void setSize(Integer size) {
			this.size = size;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	
		@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		public Shelf getShelf() {
			return shelf;
		}
		public void setShelf(Shelf shelf) {
			this.shelf = shelf;
		}
	}
