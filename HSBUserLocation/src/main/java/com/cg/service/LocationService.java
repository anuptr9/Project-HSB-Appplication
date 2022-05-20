package com.cg.service;

import java.util.List;

import com.cg.model.UserLocation;

public interface LocationService {

	public UserLocation addLocation(UserLocation usrloc);
	public List<UserLocation> getAllLocations();
	public void deleteLocationBylocId(int userId);
	public UserLocation updateLocation(UserLocation usrloc);
	public UserLocation findByLocId(int locId);
}
