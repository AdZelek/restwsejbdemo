package com.example.restwsdemo.domain;

import java.util.List;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Shoe.class)
public class Shoe_ {
		
		public static volatile SingularAttribute<Shoe, String> name;
		public static volatile SingularAttribute<Shoe, Integer> size;
		public static volatile SingularAttribute<Shoe, Double>  price;
	    public static volatile SingularAttribute<Shoe, Barcode> barcode;
	    public static volatile SingularAttribute<Shoe, Shelf> shelf;
	    public static volatile SingularAttribute<Shoe, List<Client>> clients;
}
		