package com.example.demo.repository;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {



}
