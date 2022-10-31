package com.lab9.entities;

import java.util.List;
import java.util.stream.Collectors;

import com.lab9.entities.Student;

public class Group {
	
	static int idSeed = 1;
	
	private Integer id;
	private String name;
	private List<Student> students;
	
	public Group() {
		this.id=++idSeed;
	}
	
	public Group(String name, List<Student> students) {
		this.id = ++idSeed;
		this.name = name;
		this.students = students;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public String getStudentNames() {
		String[] allStudentNames = students.stream().map(st->st.getName()).collect(Collectors.toList()).toArray(new String[students.size()]);
		return String.join(", ", allStudentNames);
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", students=" + students + "]";
	}
	
	
	
}
