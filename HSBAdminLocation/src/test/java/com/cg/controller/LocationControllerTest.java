package com.cg.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.model.AdminLocation;
import com.cg.service.LocationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(MockitoExtension.class)
class LocationControllerTest {
	@Autowired
	private MockMvc mockmvc; // class 

	@Mock
	private LocationService ar;
	private AdminLocation pt;
	private List<AdminLocation> ptd;

	@InjectMocks
	private LocationController pc;

	@BeforeEach
	public void setupUp() {
		pt = new AdminLocation(101, "Mumbai");
		mockmvc = MockMvcBuilders.standaloneSetup(pc).build();
		
	}

	@Test
	public void addAdminLocationController() throws JsonProcessingException, Exception {
		when(ar.addLocation(any())).thenReturn(pt);
		mockmvc.perform(post("/api/v1/post")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJSONString(pt)))
				.andExpect(status().isCreated());
		verify(ar, times(1)).addLocation(any());
	}
	
	
	@Test
	public void getAllLocationController() throws JsonProcessingException, Exception {
		when(ar.getAllLocations()).thenReturn(ptd);
		mockmvc.perform(MockMvcRequestBuilders.get("/api/v1/get")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJSONString(pt)))
				.andDo(MockMvcResultHandlers.print()); // print JSON object
				verify(ar, times(1)).getAllLocations();
	}
	
	  private String asJSONString(AdminLocation admloc) throws
	  JsonProcessingException { return new
	  ObjectMapper().writeValueAsString(admloc); }
	

	/*
	 * private String asJSONString(final Object obj) throws JsonProcessingException
	 * { try { return new ObjectMapper().writeValueAsString(obj); } catch (Exception
	 * e) { throw new RuntimeException(e); } }
	 */
}
