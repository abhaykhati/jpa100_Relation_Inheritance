package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Course")
@Cacheable
@SQLDelete(sql="update course set is_deleted=true where id=?")
@Where(clause="is_deleted=false")
public class Course {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@OneToMany(mappedBy="course") //in oneToMany relationship hibernate default fetching is lazy it is true in case of Many to Many as well
	private List<Review> reviews=new ArrayList<>();
	
	@UpdateTimestamp
	private LocalDateTime updaed_Date;
	
	@ManyToMany(mappedBy="courses")
	//@JsonIgnore
	List<Student> students=new ArrayList<>();
	
	private boolean isDeleted;
	
	
	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void addStudents(Student students) {
		this.students.add(students);
	}
	

	@CreationTimestamp
	private LocalDateTime created_Date;
	
	public Course() {
	}

	
	public Course(String name) {
		this.name = name;
	}

	public List<Review> getReviews() {
		return reviews;
	}


	public void addReviews(Review reviews) {
		this.reviews.add(reviews);
	}
	
	public void removeReview(Review review) {
		this.reviews.remove(review);
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "\n Course [id=" + id + ", name=" + name + "]";
	}


	
}
