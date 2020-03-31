package com.github.mauronunez.course.restapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.github.mauronunez.course.restapi.controller.TokenController;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TokenController.class)
public class TokenTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() {
	}

	@Test
	public void exampleTest() throws Exception {
		this.mvc.perform(get("/token")).andExpect(status().isOk());
	}

}
