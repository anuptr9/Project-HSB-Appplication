package com.cg.service;

import java.util.List;

import com.cg.exception.LocationAlreadyExistsException;
import com.cg.model.AdminLocation;

public interface LocationService {

	public AdminLocation addLocation(AdminLocation admloc) throws LocationAlreadyExistsException;
	public List<AdminLocation> getAllLocations();
	public void deleteLocationBylocId(int locId);
	public AdminLocation updateLocation(AdminLocation admloc);
	
		
}
