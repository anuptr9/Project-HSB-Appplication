package com.cg.service;

import java.util.List;

import com.cg.exception.DestinationAlreadyExistsException;
import com.cg.model.AdminDestination;

public interface DestinationService {


	public AdminDestination addDestination(AdminDestination admdst) throws DestinationAlreadyExistsException;
	public List<AdminDestination> getAllDestinations();
	public void deleteDestinationByDstId(int dstId);
	public AdminDestination updateDestination(AdminDestination admdst);
}
