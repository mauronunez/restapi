package com.github.mauronunez.course.restapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.mauronunez.course.restapi.model.Course;

@RestController
@RequestMapping("/courses")
public class CourseController extends CommonController<String, Course>{
}
