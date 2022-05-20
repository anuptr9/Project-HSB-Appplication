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

import com.cg.model.UserLocation;
import com.cg.service.LocationService;

@RestController
@RequestMapping("/api/loc")
public class LocationController {

private LocationService locService;
	
	@Autowired
	public LocationController(LocationService locService) {
		super();
		this.locService = locService;
	}
	
	@PostMapping("/post")
	public ResponseEntity<UserLocation> addLocation(@RequestBody UserLocation usrloc) {
		UserLocation saveLocation=locService.addLocation(usrloc);
		return new ResponseEntity<>(saveLocation, HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<UserLocation>> getAllLocations() {
		return new ResponseEntity<List<UserLocation>>((List<UserLocation>)locService.getAllLocations(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{locId}")
	public ResponseEntity<Void> deleteLocationById(@PathVariable int locId) {
		locService.deleteLocationBylocId(locId);
		return ResponseEntity.noContent().build();
	}
	@PutMapping("/put")
	public UserLocation updateLocation(@RequestBody UserLocation usrloc)
	{
		return locService.updateLocation(usrloc);
	}
	
	@GetMapping("/get/{locId}")
    public ResponseEntity <UserLocation> getlocName(@PathVariable int locId)
    {

        return ResponseEntity.ok().body(locService.findByLocId(locId));

    }
}
