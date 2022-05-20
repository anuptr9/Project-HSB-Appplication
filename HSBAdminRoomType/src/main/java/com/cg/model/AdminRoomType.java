package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="AdminRoomType")
public class AdminRoomType {
private String locName;
private String dstName;
private String spotName;
private String roomType;
@Id
private int roomTypeId;
public AdminRoomType() {
	super();
	// TODO Auto-generated constructor stub
}
public AdminRoomType(String locName, String dstName, String spotName, String roomType, int roomTypeId) {
	super();
	this.locName = locName;
	this.dstName = dstName;
	this.spotName = spotName;
	this.roomType = roomType;
	this.roomTypeId = roomTypeId;
}
public String getLocName() {
	return locName;
}
public void setLocName(String locName) {
	this.locName = locName;
}
public String getDstName() {
	return dstName;
}
public void setDstName(String dstName) {
	this.dstName = dstName;
}
public String getSpotName() {
	return spotName;
}
public void setSpotName(String spotName) {
	this.spotName = spotName;
}
public String getRoomType() {
	return roomType;
}
public void setRoomType(String roomType) {
	this.roomType = roomType;
}
public int getRoomTypeId() {
	return roomTypeId;
}
public void setRoomTypeId(int roomTypeId) {
	this.roomTypeId = roomTypeId;
}
@Override
public String toString() {
	return "AdminRoomType [locName=" + locName + ", dstName=" + dstName + ", spotName=" + spotName + ", roomType="
			+ roomType + ", roomTypeId=" + roomTypeId + "]";
}

}
