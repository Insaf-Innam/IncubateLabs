package com.hotels.springservice.domain;

public class Hotel {

	private int id;
	private String name;
	private int no;
	private String street;
	private String city;

	public Hotel() {
		super();
	}

	public Hotel(int id, String name, int no, String street, String city) {
		super();
		this.id = id;
		this.name = name;
		this.no = no;
		this.street = street;
		this.city = city;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", no=" + no + ", street=" + street + ", city=" + city + "]";
	}

}
