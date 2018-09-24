package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue
	private Long id;

	@Column( name = "name",nullable=false)
	private String name;

	@OneToOne(fetch=FetchType.LAZY)
	private Passport passport;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name = "student_course",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id"))
	List<Course> courses=new ArrayList<>();
	
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Student(String string) {
	}

	public Student() {
	}

	public Long getId() {
		return id;
	}

	/*
	 * public void setId(Long id) { this.id = id; }
	 */

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\n Student [id=" + id + ", name=" + name + "]";
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}

}
