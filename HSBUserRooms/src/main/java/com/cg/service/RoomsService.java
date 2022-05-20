package com.cg.service;

import java.util.List;

import com.cg.model.UserRooms;

public interface RoomsService {
	
	public UserRooms addRoomNo(UserRooms admroomno);
	public List<UserRooms> getAllRooms();
	public void deleteRoomByNo(int roomNo);
	public UserRooms updateRoomNo(UserRooms admroomno);

}
