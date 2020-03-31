package com.github.mauronunez.course.restapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.mauronunez.course.restapi.model.Student;

@RestController
@RequestMapping("/students")
public class StudentController extends CommonController<String, Student>{
}
