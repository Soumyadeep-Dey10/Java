package com.Hibernate.Hibernate1;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	private int rollno;
	private String name;
	private int marks;
	
//	@OneToOne //define one to one relationship means one student will have one laptop
//	private Laptop laptop;
	
//	@OneToMany //one student will have multiple laptops, so extra laptop_student table will be created
	
//	@OneToMany(mappedBy = "student") //mentions that mapping is done by student variable or object in Laptop class, so it does not creates a extra table
	
	@ManyToMany(mappedBy = "student", fetch = FetchType.EAGER) //create one extra table not two extra tables
	private List<Laptop> laptop = new ArrayList<Laptop>();
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
	
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + marks + "]";
	}
	
	
}
