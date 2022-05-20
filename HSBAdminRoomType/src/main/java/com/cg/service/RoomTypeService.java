package com.cg.service;

import java.util.List;

import com.cg.model.AdminRoomType;

public interface RoomTypeService {

	public AdminRoomType addRoomType(AdminRoomType admtype);
	public List<AdminRoomType> getAllRoomTypes();
	public void deleteRoomTypeById(int roomTypeId);
	public AdminRoomType updateRoomType(AdminRoomType admtype);
}
