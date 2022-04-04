package com.zensar.webapp.rest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.RestController;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloRestControllerTest{
	
	@Autowired //To enable auto
	private MockMvc mock;
	
	@Test
	public void getmessageTest() throws Exception {
		mock	
		      .perform(MockMvcRequestBuilders.get("/greet"))
		      .andExpect(MockMvcResultMatchers.status().isOk())
		      .andExpect(MockMvcResultMatchers.content().string("Welcome to hello"));
		
	}
	
	@Test
	public void createMessage() throws Exception {
		mock	
		      .perform(MockMvcRequestBuilders.post("/greet").content("Welcome"))
		      .andExpect(MockMvcResultMatchers.status().isCreated())
		      .andExpect(MockMvcResultMatchers.content().string("Message Created Welcome"));
		
	}

}
