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

import com.cg.exception.DestinationAlreadyExistsException;
import com.cg.model.AdminDestination;
import com.cg.repository.DestinationRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DestinationServiceTest {

	@Mock
	private DestinationRepository dr;
	
	@InjectMocks
	private DestinationServiceImpl dsi;
	
	
	@Test
	public void TestAddLocation() throws DestinationAlreadyExistsException {
		AdminDestination d1=new AdminDestination("India Gate", "Mumbai", 1); //user input
		when(dr.save(any())).thenReturn(d1);
		dsi.addDestination(d1);
		verify(dr,times(1)).save(any());
		
	}

	@Test
	public void testGetAllDestination() {
		AdminDestination d1= new AdminDestination("India Gate", "Mumbai", 1); //User Input
		AdminDestination d2=new AdminDestination("Nariman Point", "Mumbai", 2); //user input
		//AdminLocation d3=new AdminLocation(3,"Juhu Beach"); //user Input
		dr.save(d1);
		dr.save(d2); //saving the info to database
		
		List<AdminDestination> dList= new ArrayList<>(); //creating List object
		dList.add(d1);
		dList.add(d2);
		
		
		when(dr.findAll()).thenReturn(dList);
		List<AdminDestination> dList1=dsi.getAllDestinations();
		assertEquals(dList, dList1);
		verify(dr,times(1)).save(d1);
		verify(dr,times(1)).findAll();
	}

}
