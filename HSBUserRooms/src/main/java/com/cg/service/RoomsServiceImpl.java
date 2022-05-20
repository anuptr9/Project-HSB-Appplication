package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.UserRooms;
import com.cg.repository.RoomsRepository;

@Service
public class RoomsServiceImpl implements RoomsService{
	private RoomsRepository roomRepo;
	
	@Autowired
	public RoomsServiceImpl(RoomsRepository roomRepo) {
		super();
		this.roomRepo = roomRepo;
	}
	
	@Override
	public UserRooms addRoomNo(UserRooms admroomno) {
		UserRooms savedRoomNo=roomRepo.save(admroomno);
		return savedRoomNo;
	}

	@Override
	public List<UserRooms> getAllRooms() {
		return (List<UserRooms>)roomRepo.findAll();
	}

	@Override
	public void deleteRoomByNo(int roomNo) {
		roomRepo.deleteById(roomNo);	
	}

	@Override
	public UserRooms updateRoomNo(UserRooms admroomno) {
		UserRooms roomNoUpdateRecord;
		Optional<UserRooms> opt=roomRepo.findById(admroomno.getRoomNo());
		if(opt.isPresent())
		{
			roomNoUpdateRecord=opt.get();
			roomNoUpdateRecord.setRoomNo(admroomno.getRoomNo());
			roomRepo.save(roomNoUpdateRecord);
		}
		else
		{
			return new UserRooms();
		}
		return roomNoUpdateRecord;
	}
}
