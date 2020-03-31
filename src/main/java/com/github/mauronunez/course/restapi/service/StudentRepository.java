package com.github.mauronunez.course.restapi.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.mauronunez.course.restapi.model.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, String>{

}
