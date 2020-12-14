package com.formacionbdi.springboot.app.users.models.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Person{

	private String name;
	private String lastname;
	private int age;
	private Date birthdate;
	private String posibleMuerte;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getPosibleMuerte() {
		return posibleMuerte;
	}
	public void setPosibleMuerte(String posibleMuerte) {
		this.posibleMuerte = posibleMuerte;
	}

}
