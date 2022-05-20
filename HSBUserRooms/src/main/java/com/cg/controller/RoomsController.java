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

import com.cg.model.UserRooms;
import com.cg.service.RoomsService;

@RestController
@RequestMapping("/api/v1")
public class RoomsController {

		private RoomsService roomService;
		
		@Autowired
		public  RoomsController(RoomsService roomService) {
			super();
			this.roomService = roomService;
		}
		
		@PostMapping("/post")
		public ResponseEntity<UserRooms> addRoomNo(@RequestBody UserRooms admroomno) {
			UserRooms saveRoomNo=roomService.addRoomNo(admroomno);
			return new ResponseEntity<>(saveRoomNo, HttpStatus.CREATED);
		}
		
		@GetMapping("/get")
		public ResponseEntity<List<UserRooms>> getAllRoomNo() {
			return new ResponseEntity<List<UserRooms>>((List<UserRooms>)roomService.getAllRooms(), HttpStatus.OK);
		}
		
		@DeleteMapping("/delete/{roomNo}")
		public ResponseEntity<Void> deleteRoomByNo(@PathVariable int roomNo) {
			roomService.deleteRoomByNo(roomNo);
			return ResponseEntity.noContent().build();
		}
		
		@PutMapping("/put")
		public UserRooms updateRoomNo(@RequestBody UserRooms admroomno)
		{
			return roomService.updateRoomNo(admroomno);
		}
}
