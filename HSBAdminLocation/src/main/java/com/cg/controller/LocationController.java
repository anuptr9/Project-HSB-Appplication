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

import com.cg.exception.LocationAlreadyExistsException;
import com.cg.model.AdminLocation;
import com.cg.service.LocationService;

@RestController
@RequestMapping("/api/v1")
public class LocationController {
	
	private LocationService locService;
	
	@Autowired
	public LocationController(LocationService locService) {
		super();
		this.locService = locService;
	}
	//To post data over postman
	@PostMapping("/post")
	public ResponseEntity<AdminLocation> addLocation(@RequestBody AdminLocation admloc) throws LocationAlreadyExistsException {
		AdminLocation saveLocation=locService.addLocation(admloc);
		return new ResponseEntity<>(saveLocation, HttpStatus.CREATED);
	}
	//To receive data in postman
	@GetMapping("/get")
	public ResponseEntity<List<AdminLocation>> getAllLocations() {
		return new ResponseEntity<List<AdminLocation>>((List<AdminLocation>)locService.getAllLocations(), HttpStatus.OK);
	}
	//For deleting in postman
	@DeleteMapping("/delete/{locId}")
	public ResponseEntity<Void> deleteLocationById(@PathVariable int locId) {
		locService.deleteLocationBylocId(locId);
		return ResponseEntity.noContent().build();
	}
	//for updating operation in postman
	@PutMapping("/put")
	public AdminLocation updateLocation(@RequestBody AdminLocation admloc)
	{
		return locService.updateLocation(admloc);
	}

}

