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

import com.cg.model.AdminRoomType;
import com.cg.service.RoomTypeService;

@RestController
@RequestMapping("/api/v1")
public class RoomTypeController {

	private RoomTypeService typeService;
	
	@Autowired
	public  RoomTypeController(RoomTypeService typeService) {
		super();
		this.typeService = typeService;
	}
	
	@PostMapping("/post")
	public ResponseEntity<AdminRoomType> addRoomType(@RequestBody AdminRoomType admtype) {
		AdminRoomType saveRoomType=typeService.addRoomType(admtype);
		return new ResponseEntity<>(saveRoomType, HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<AdminRoomType>> getAllRoomTypes() {
		return new ResponseEntity<List<AdminRoomType>>((List<AdminRoomType>)typeService.getAllRoomTypes(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{roomTypeId}")
	public ResponseEntity<Void> deleteLocationById(@PathVariable int locId) {
		typeService.deleteRoomTypeById(locId);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/put")
	public AdminRoomType updateLocation(@RequestBody AdminRoomType admtype)
	{
		return typeService.updateRoomType(admtype);
	}

}
