package io.pivotal.tg;

import junit.framework.TestCase;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DojoApplication.class)
@WebAppConfiguration
public abstract class DojoApplicationTests extends TestCase{

	protected MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(),
			Charset.forName("utf8"));

	protected MockMvc mockMvc;

	@Autowired
	protected WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception {
		mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	protected void verifyDisciplineTechniques(int expectedEntries) throws Exception {
		mockMvc.perform(get("/techniques"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$", Matchers.hasSize(expectedEntries)));
	}
}
