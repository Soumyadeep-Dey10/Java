package com.Hibernate.Hibernate1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

//POJO class or Bean Class

//entity allows to store the object of this class inside the DB

//@Entity(name = "student_table") // creates a table in the DB named as “student_table”
@Entity

//@Table(name = "student_table") //this changes only the table name in the DB and not the entity name
public class Student {

//ID specifies we are getting a primary key
	@Id
	private int id;
	
//	@Column(name = "student_name") //column name in table will be student_name not "name" 
	private StudentName name;
	
//	@Transient //it will ignore the marks column and this marks column will not be stored into the DB table
	private int marks;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id =  id;
	}
	
	public StudentName getName() {
		return name;
	}
	public void setName(StudentName name) {
		this.name = name;
	}
	
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}
	
}
