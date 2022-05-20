package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.UserSpot;
import com.cg.repository.SpotRepository;

@Service
public class SpotServiceImpl implements SpotService {

	private SpotRepository spotRepo;

	@Autowired
	public SpotServiceImpl(SpotRepository spotRepo) {
		this.spotRepo=spotRepo;
	}
	@Override
	public UserSpot addSpot(UserSpot admspot) {
		UserSpot savedSpot=spotRepo.save(admspot);
		return savedSpot;
	}

	@Override
	public List<UserSpot> getAllSpots() {
		return (List<UserSpot>)spotRepo.findAll();
	}

	@Override
	public void deleteSpotBySpotId(int spotId) {
		spotRepo.deleteById(spotId);
		
	}

	@Override
	public UserSpot updateSpot(UserSpot admspot) {
		UserSpot spotUpdateRecord;
		Optional<UserSpot> opt=spotRepo.findById(admspot.getSpotId());
		if(opt.isPresent())
		{
			spotUpdateRecord=opt.get();
			spotUpdateRecord.setLocName(admspot.getSpotName());
			spotRepo.save(spotUpdateRecord);
		}
		else
		{
			return new UserSpot();
		}
		return spotUpdateRecord;
	}
}
