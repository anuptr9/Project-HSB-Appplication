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

import com.cg.exception.DestinationAlreadyExistsException;
import com.cg.model.AdminDestination;
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
		public ResponseEntity<AdminDestination> addDestination(@RequestBody AdminDestination admdst) throws DestinationAlreadyExistsException {
			AdminDestination saveDestination=dstService.addDestination(admdst);
			return new ResponseEntity<>(saveDestination, HttpStatus.CREATED);
		}
		
		@GetMapping("/get")
		public ResponseEntity<List<AdminDestination>> getAllDestinations() {
			return new ResponseEntity<List<AdminDestination>>((List<AdminDestination>)dstService.getAllDestinations(), HttpStatus.OK);
		}
		
		@DeleteMapping("/delete/{dstId}")
		public ResponseEntity<Void> deleteLocationById(@PathVariable int dstId) {
			dstService.deleteDestinationByDstId(dstId);
			return ResponseEntity.noContent().build();
		}
		
		@PutMapping("/put")
		public AdminDestination updateDestination(@RequestBody AdminDestination admdst)
		{
			return dstService.updateDestination(admdst);
		}

}
