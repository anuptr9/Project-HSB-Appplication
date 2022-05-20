package com.cg.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.model.AdminDestination;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class DestinationRepositoryTest {

	@Autowired
	private DestinationRepository dstRepo;
	
	
	@Test
	void givenDestinationShouldReturnDestinationObject() {
		//user Input
		AdminDestination d1= new AdminDestination("Mumbai", "India Gate", 1);
		dstRepo.save(d1); // data is saved into database
		
		AdminDestination d2=dstRepo.findById(d1.getDstId()).get();
		assertNotNull(d2); // To check if is returning the location object
		assertEquals(d1.getDstName(), d2.getDstName());
	}
	@Test
	public void getAllmustReturnAllDestination() {
		
		AdminDestination d3=new AdminDestination("New Delhi", "Shahi Bowli", 2);
		AdminDestination d4=new AdminDestination("Jaipur", "Hawa Mahal", 3);
		dstRepo.save(d3);
		dstRepo.save(d4);
		List<AdminDestination> locList=(List<AdminDestination>) dstRepo.findAll();
		assertEquals("Mumbai", locList.get(1).getLocName());
		//assertEquals(4, locList.size());
	}


}
