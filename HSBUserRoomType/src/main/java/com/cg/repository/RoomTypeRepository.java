package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.UserRoomType;

public interface RoomTypeRepository extends MongoRepository<UserRoomType, Integer> {

}
