package com.github.mauronunez.course.restapi.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.mauronunez.course.restapi.model.Course;

public interface CourseRepository extends PagingAndSortingRepository<Course, String>{

}
