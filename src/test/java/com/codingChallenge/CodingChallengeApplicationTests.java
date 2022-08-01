package com.codingChallenge;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.codingChallenge.businessLocation.BusinessLocation;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class CodingChallengeApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void businessLocationExampleTest() throws Exception {

		BusinessLocation exampleBusinessLocation = new BusinessLocation("XBHBY", "Habay", "Habay", "BF");
		final String expectedResponseContent = objectMapper.writeValueAsString(exampleBusinessLocation);

		this.mvc.perform(get("/betriebsstelle/XBHBY")).andExpect(status().isOk())
				.andExpect(content().json(expectedResponseContent));

	}

	@Test
	public void businessLocationNotFoundTest() throws Exception {

		this.mvc.perform(get("/betriebsstelle/X")).andExpect(status().isBadRequest());

	}

}
