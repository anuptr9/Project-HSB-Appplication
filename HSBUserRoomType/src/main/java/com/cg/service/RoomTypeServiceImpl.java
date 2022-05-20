package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.UserRoomType;
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
	public UserRoomType addRoomType(UserRoomType admtype) {
		UserRoomType savedRoomType=typeRepo.save(admtype);
		return savedRoomType;
	}
	
	@Override
	public List<UserRoomType> getAllRoomTypes() {
		return (List<UserRoomType>)typeRepo.findAll();
	}

	@Override
	public void deleteRoomTypeById(int roomTypeId) {
		typeRepo.deleteById(roomTypeId);
		
	}
	
	@Override
	public UserRoomType updateRoomType(UserRoomType admtype) {
		UserRoomType roomTypeUpdateRecord;
		Optional<UserRoomType> opt=typeRepo.findById(admtype.getRoomTypeId());
		if(opt.isPresent())
		{
			roomTypeUpdateRecord=opt.get();
			roomTypeUpdateRecord.setLocName(admtype.getLocName());
			typeRepo.save(roomTypeUpdateRecord);
		}
		else
		{
			return new UserRoomType();
		}
		return roomTypeUpdateRecord;
		
	}
	
}
