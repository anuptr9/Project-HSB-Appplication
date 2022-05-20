package com.cg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.exception.LocationAlreadyExistsException;
import com.cg.model.AdminLocation;
import com.cg.repository.LocationRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class LocationServiceTest {

	@Mock
	private LocationRepository lr;
	
	@InjectMocks
	private LocationServiceImpl lsi;
	
	
	@Test
	public void TestAddLocation() throws LocationAlreadyExistsException {
		AdminLocation d1=new AdminLocation(1, "Mumbai"); //user input
		when(lr.save(any())).thenReturn(d1);
		lsi.addLocation(d1);
		verify(lr,times(1)).save(any());
		
	}

	@Test
	public void testGetAllLocation() {
		AdminLocation d1= new AdminLocation(1, "Mumbai"); //User Input
		AdminLocation d2=new AdminLocation(2, "New Delhi"); //user input
		//AdminLocation d3=new AdminLocation(3,"Chennai"); //user Input
		lr.save(d1);
		lr.save(d2); //saving the info to database
		//lr.save(d3); //data saved in database
		List<AdminLocation> dList= new ArrayList<>(); //creating List object
		dList.add(d1);
		dList.add(d2);
		//dList.add(d3);
		
		when(lr.findAll()).thenReturn(dList);
		List<AdminLocation> dList1=lsi.getAllLocations();
		assertEquals(dList, dList1);
		verify(lr,times(1)).save(d1);
		verify(lr,times(1)).findAll();
	}
}
