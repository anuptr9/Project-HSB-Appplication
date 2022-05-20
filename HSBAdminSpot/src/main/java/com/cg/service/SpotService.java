package com.cg.service;

import java.util.List;

import com.cg.exception.SpotAlreadyExistsException;
import com.cg.model.AdminSpot;

public interface SpotService {

	public AdminSpot addSpot(AdminSpot admspot) throws SpotAlreadyExistsException;
	public List<AdminSpot> getAllSpots();
	public void deleteSpotBySpotId(int spotId);
	public AdminSpot updateSpot(AdminSpot admspot);
}
