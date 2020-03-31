package com.github.mauronunez.course.restapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.github.mauronunez.course.restapi.controller.CourseController;
import com.github.mauronunez.course.restapi.controller.TokenController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class CoursesTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void checkUnauth() throws Exception {
		this.mvc.perform(get("/courses/all")).andExpect(status().is4xxClientError());

	}

	@Test
	public void checkAuth() throws Exception {
		this.mvc.perform(get("/token")).andDo(r -> {
			String token = r.getResponse().getContentAsString();

			this.mvc.perform(get("/courses/all").header("Authorization", "Bearer " + token))
					.andExpect(status().isOk());
		});

	}

}
