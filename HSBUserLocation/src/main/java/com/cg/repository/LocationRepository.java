package com.cg.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.UserLocation;

public interface LocationRepository extends MongoRepository<UserLocation, Integer> {
	public Optional<UserLocation> findByLocId(int locId);
}
