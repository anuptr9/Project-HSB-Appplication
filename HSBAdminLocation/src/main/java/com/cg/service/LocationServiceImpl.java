package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.LocationAlreadyExistsException;
import com.cg.model.AdminLocation;
import com.cg.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	
	private LocationRepository locRepo;
	
	@Autowired
	public LocationServiceImpl(LocationRepository locRepo) {
		super();
		this.locRepo=locRepo;
		// TODO Auto-generated constructor stub
	}

	@Override
	public AdminLocation addLocation(AdminLocation admloc) throws LocationAlreadyExistsException {
		if(locRepo.existsById(admloc.getLocId())) 
		{
			throw new LocationAlreadyExistsException();
		}
		AdminLocation savedLocation=locRepo.save(admloc);
		return savedLocation;
	}
	
	@Override
	public List<AdminLocation> getAllLocations() {
		return (List<AdminLocation>)locRepo.findAll();
	}

	@Override
	public void deleteLocationBylocId(int locId) {
		locRepo.deleteById(locId);
	}

	@Override
	public AdminLocation updateLocation(AdminLocation admloc) {
		AdminLocation locUpdateRecord;
		Optional<AdminLocation> opt=locRepo.findById(admloc.getLocId());
		if(opt.isPresent())
		{
			locUpdateRecord=opt.get();
			locUpdateRecord.setLocName(admloc.getLocName());
			locRepo.save(locUpdateRecord);
		}
		else
		{
			return new AdminLocation();
		}
		return locUpdateRecord;
	}
}
