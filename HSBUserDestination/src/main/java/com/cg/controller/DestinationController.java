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

import com.cg.model.UserDestination;
import com.cg.service.DestinationService;

@RestController
@RequestMapping("/api/v1")
public class DestinationController {

	private DestinationService dstService;
		
		@Autowired
		public DestinationController(DestinationService dstService) {
			super();
			this.dstService = dstService;
		}
		
		@PostMapping("/post")
		public ResponseEntity<UserDestination> addDestination(@RequestBody UserDestination admdst) {
			UserDestination saveDestination=dstService.addDestination(admdst);
			return new ResponseEntity<>(saveDestination, HttpStatus.CREATED);
		}
		
		@GetMapping("/get")
		public ResponseEntity<List<UserDestination>> getAllDestinations() {
			return new ResponseEntity<List<UserDestination>>((List<UserDestination>)dstService.getAllDestinations(), HttpStatus.OK);
		}
		
		@DeleteMapping("/delete/{dstId}")
		public ResponseEntity<Void> deleteLocationById(@PathVariable int dstId) {
			dstService.deleteDestinationByDstId(dstId);
			return ResponseEntity.noContent().build();
		}
		
		@PutMapping("/put")
		public UserDestination updateDestination(@RequestBody UserDestination admdst)
		{
			return dstService.updateDestination(admdst);
		}
}
