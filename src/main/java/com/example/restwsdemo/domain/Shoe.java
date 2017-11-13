package com.example.restwsdemo.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
	public class Shoe {
		public String name;
		public int size;
		public double price;
		
		
		public Shoe() {
			
		}
		public Shoe(String name, int size, double price) {
			this.name = name;
			this.size = size;
			this.price = price;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
