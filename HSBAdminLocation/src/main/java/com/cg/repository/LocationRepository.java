package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.AdminLocation;
//Extending Mango repo
public interface LocationRepository extends MongoRepository<AdminLocation, Integer> {

}
