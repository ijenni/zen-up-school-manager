package fr.zenup.school_manager.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import fr.zenup.school_manager.dto.SchoolClassDto;
import fr.zenup.school_manager.dto.SchoolClassRequestDto;
import fr.zenup.school_manager.service.SchoolClassService;

@WebMvcTest(value = SchoolClassController.class)
public class SchoolClassControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SchoolClassService schoolClassService;

	@Test
	void addSchoolClassTest() throws Exception {

		String mockSchoolClassRequest = "{\"name\" : \"Les tigres\",\"grade\" : \"CE1\"}";
		SchoolClassDto mockSchoolClass = SchoolClassDto.builder().id(1L).name("The tigers").grade("CE1").build();

		when(schoolClassService.add(any(SchoolClassRequestDto.class))).thenReturn(mockSchoolClass);

		RequestBuilder requestBuilder = MockMvcRequestBuilders //
				.post("/api/school-classes") //
				.accept(MediaType.APPLICATION_JSON) //
				.content(mockSchoolClassRequest) //
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(CREATED.value(), response.getStatus());

		// Use jackson to parse response content and compare to mockSchoolClass
//		assertEquals(mockSchoolClass.toString(), response.getContentAsString());
	}
}
