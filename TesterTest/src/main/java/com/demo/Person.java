package com.demo;

public class Person {

	private String firstName;
	private String lastName;
	
	public Person() {
		
	}
	
	public Person(String x, String y) {
		setFirstName(x);
		setLastName(y);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
