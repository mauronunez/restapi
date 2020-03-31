package com.github.mauronunez.course.restapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.mauronunez.course.restapi.model.Course;
import com.github.mauronunez.course.restapi.service.CourseRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RestapiDataTests {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CourseRepository repository;


    @Test
	public void exampleTest() throws Exception {
    	Course course=new Course();
    	course.setCode("0001");
    	course.setName("0001");
    	entityManager.persist(course);
    	entityManager.flush();
    	
    	Course found=repository.findById(course.getCode()).orElse(null);
    	Assertions.assertNotNull(found);
    	
    	
	}

}
