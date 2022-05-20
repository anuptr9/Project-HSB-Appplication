package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.AdminRoomType;
import com.cg.repository.RoomTypeRepository;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
	
	private RoomTypeRepository typeRepo;
	
	@Autowired
	public RoomTypeServiceImpl(RoomTypeRepository typeRepo) {
		super();
		this.typeRepo = typeRepo;
	}

	@Override
	public AdminRoomType addRoomType(AdminRoomType admtype) {
		AdminRoomType savedRoomType=typeRepo.save(admtype);
		return savedRoomType;
	}
	
	@Override
	public List<AdminRoomType> getAllRoomTypes() {
		return (List<AdminRoomType>)typeRepo.findAll();
	}

	@Override
	public void deleteRoomTypeById(int roomTypeId) {
		typeRepo.deleteById(roomTypeId);
		
	}
	
	@Override
	public AdminRoomType updateRoomType(AdminRoomType admtype) {
		AdminRoomType roomTypeUpdateRecord;
		Optional<AdminRoomType> opt=typeRepo.findById(admtype.getRoomTypeId());
		if(opt.isPresent())
		{
			roomTypeUpdateRecord=opt.get();
			roomTypeUpdateRecord.setLocName(admtype.getLocName());
			typeRepo.save(roomTypeUpdateRecord);
		}
		else
		{
			return new AdminRoomType();
		}
		return roomTypeUpdateRecord;
		
	}
	
}
