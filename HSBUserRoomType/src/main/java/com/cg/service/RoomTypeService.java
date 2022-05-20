package com.cg.service;

import java.util.List;

import com.cg.model.UserRoomType;

public interface RoomTypeService {

	public UserRoomType addRoomType(UserRoomType admtype);
	public List<UserRoomType> getAllRoomTypes();
	public void deleteRoomTypeById(int roomTypeId);
	public UserRoomType updateRoomType(UserRoomType admtype);
}
