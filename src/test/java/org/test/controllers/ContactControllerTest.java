package org.test.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ContactControllerTest {

	private static MockMvc mvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context)
				.build();
	}

	@Test
	public void testPostContact() throws Exception {
		mvc.perform(post("/contacts")
				.contentType(MediaType.APPLICATION_JSON)
				.content(TestUtils.dummySaveContactrequest()))
		.andExpect(status().isOk())
		.andExpect(content().json(TestUtils.dummyContactresponse()));

	}
	
	@Test
	public void testGetAllContact() throws Exception {
		
		mvc.perform(get("/contacts")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().json(TestUtils.dummyAllContactsResponse()));

	}

}
