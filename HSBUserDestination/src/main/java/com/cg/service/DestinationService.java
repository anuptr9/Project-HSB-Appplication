package com.cg.service;

import java.util.List;

import com.cg.model.UserDestination;

public interface DestinationService {
	public UserDestination addDestination(UserDestination admdst);
	public List<UserDestination> getAllDestinations();
	public void deleteDestinationByDstId(int dstId);
	public UserDestination updateDestination(UserDestination admdst);
}
