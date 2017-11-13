package com.example.restwsdemo.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	
	private String firstName;
	private int yob;
	
	public Person() {
	}

	public Person(String firstName, int yob) {
		this.firstName = firstName;
		this.yob = yob;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getYob() {
		return yob;
	}
	public void setYob(int yob) {
		this.yob = yob;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + yob;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (yob != other.yob)
			return false;
		return true;
	}

}
