package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.AdminDestination;

public interface DestinationRepository extends MongoRepository<AdminDestination, Integer> {

}
