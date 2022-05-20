package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.SpotAlreadyExistsException;
import com.cg.model.AdminSpot;
import com.cg.service.SpotService;

@RestController
@RequestMapping("/api/v1")
public class SpotController {

	private SpotService spotService;

	@Autowired
	public SpotController(SpotService spotService) {
	super();
	this.spotService = spotService;
	}
	
	@PostMapping("/post")
	public ResponseEntity<AdminSpot> addSpot(@RequestBody AdminSpot admspot) throws SpotAlreadyExistsException{
		AdminSpot saveSpot=spotService.addSpot(admspot);
		return new ResponseEntity<>(saveSpot, HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<AdminSpot>> getAllSpots() {
		return new ResponseEntity<List<AdminSpot>>((List<AdminSpot>)spotService.getAllSpots(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{spotId}")
	public ResponseEntity<Void> deleteSpotById(@PathVariable int spotId) {
		spotService.deleteSpotBySpotId(spotId);
		return ResponseEntity.noContent().build();
	}
	@PutMapping("/put")
	public AdminSpot updateSpot(@RequestBody AdminSpot admspot)
	{
		return spotService.updateSpot(admspot);
	}

	
}
