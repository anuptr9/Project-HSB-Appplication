package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.UserDestination;

public interface DestinationRepository extends MongoRepository<UserDestination, Integer> {

}
