package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.SpotAlreadyExistsException;
import com.cg.model.AdminSpot;
import com.cg.repository.SpotRepository;

@Service
public class SpotServiceImpl implements SpotService {

	private SpotRepository spotRepo;

	@Autowired
	public SpotServiceImpl(SpotRepository spotRepo) {
		this.spotRepo=spotRepo;
	}
	@Override
	public AdminSpot addSpot(AdminSpot admspot) throws SpotAlreadyExistsException {
		if(spotRepo.existsById(admspot.getSpotId())) 
		{
			throw new SpotAlreadyExistsException();
		}
		AdminSpot savedSpot=spotRepo.save(admspot);
		return savedSpot;
	}

	@Override
	public List<AdminSpot> getAllSpots() {
		return (List<AdminSpot>)spotRepo.findAll();
	}

	@Override
	public void deleteSpotBySpotId(int spotId) {
		spotRepo.deleteById(spotId);
		
	}

	@Override
	public AdminSpot updateSpot(AdminSpot admspot) {
		AdminSpot spotUpdateRecord;
		Optional<AdminSpot> opt=spotRepo.findById(admspot.getSpotId());
		if(opt.isPresent())
		{
			spotUpdateRecord=opt.get();
			spotUpdateRecord.setLocName(admspot.getSpotName());
			spotRepo.save(spotUpdateRecord);
		}
		else
		{
			return new AdminSpot();
		}
		return spotUpdateRecord;
	}
}
