package com.cg.service;

import java.util.List;

import com.cg.model.UserSpot;

public interface SpotService {

	public UserSpot addSpot(UserSpot admspot);
	public List<UserSpot> getAllSpots();
	public void deleteSpotBySpotId(int spotId);
	public UserSpot updateSpot(UserSpot admspot);
}
