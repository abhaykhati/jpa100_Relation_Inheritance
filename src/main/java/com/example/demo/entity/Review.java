package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Review")
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "description")
	private String description;

	@ManyToOne  // in ManyToOne relationship hibernate default fetching is eager using left outer join it is true in case of oneToOne relationship as well
	private Course course;
	
	@Column(name = "rating", nullable = true)
	private Long rating;
	
	public Review(Long rating,String description) {
		this.rating=rating;
		this.description=description;
	}
	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}



	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	/*
	 * public void setId(Long id) { this.id = id; }
	 */

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "\n Review [   id=" + id + ", description=" + description + "rating=  " + rating + "]";

	}

}
