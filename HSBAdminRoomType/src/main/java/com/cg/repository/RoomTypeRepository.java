package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.AdminRoomType;

public interface RoomTypeRepository extends MongoRepository<AdminRoomType, Integer> {

}
