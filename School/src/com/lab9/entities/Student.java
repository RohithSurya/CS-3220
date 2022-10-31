package com.lab9.entities;

import java.time.LocalDateTime;

public class Student {
	static int idSeed = 1;
	private Integer id;
	private String name;
	private int year;
	private String parent;
	private String email;
	private Group group;
	

	public Student(String name, int year, String parent, String email, Group group) {
		super();
		this.id = ++idSeed;
		this.name = name;
		this.year = year;
		this.parent = parent;
		this.email = email;
		this.group = group;
	}
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getAge() {
		return LocalDateTime.now().getYear() - year;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + year + ", parent=" + parent + ", email=" + email + "]";
	}
	
	
	
	
}