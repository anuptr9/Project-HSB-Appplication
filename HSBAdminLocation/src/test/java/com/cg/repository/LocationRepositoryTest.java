package com.cg.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.model.AdminLocation;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class LocationRepositoryTest {

	@Autowired
	private LocationRepository locRepo;
	
	
	@Test
	void givenLocationShouldReturnLocationObject() {
		//user Input
		AdminLocation d1= new AdminLocation(101, "Mumbai");
		locRepo.save(d1); // data is saved into database
		
		AdminLocation d2=locRepo.findById(d1.getLocId()).get();
		assertNotNull(d2); // To check if is returning the location object
		assertEquals(d1.getLocName(), d2.getLocName());
	}
	@Test
	public void getAllmustReturnAllLocation() {
		
		AdminLocation d3=new AdminLocation(2, "New Delhi");
		AdminLocation d4=new AdminLocation(3,"Chennai");
		locRepo.save(d3);
		locRepo.save(d4);
		List<AdminLocation> locList=(List<AdminLocation>) locRepo.findAll();
		assertEquals("New Delhi", locList.get(1).getLocName());
		//assertEquals(4, locList.size());
	}


}
