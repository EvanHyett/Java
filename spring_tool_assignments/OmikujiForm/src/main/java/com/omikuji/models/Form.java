package com.omikuji.models;

public class Form {
	private Integer number;
	private String city;
	private String person;
	private String hobby;
	private String livingThing;
	private String description;
	
	public Form (Integer number, String city, String person, String hobby, String livingThing, String description) {
		this.number = number;
		this.city = city;
		this.person = person;
		this.hobby = hobby;
		this.livingThing = livingThing;
		this.description = description;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getLivingThing() {
		return livingThing;
	}

	public void setLivingThing(String livingThing) {
		this.livingThing = livingThing;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
