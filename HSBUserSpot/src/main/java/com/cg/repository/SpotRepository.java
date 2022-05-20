package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.UserSpot;

public interface SpotRepository extends MongoRepository<UserSpot, Integer> {

}
