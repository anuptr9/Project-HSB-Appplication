package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="UserRooms")
public class UserRooms {

	private String locName;
	private String dstName;
	private String spotName;
	private String roomType;
	@Id
	private int roomNo;
	public UserRooms() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRooms(String locName, String dstName, String spotName, String roomType, int roomNo) {
		super();
		this.locName = locName;
		this.dstName = dstName;
		this.spotName = spotName;
		this.roomType = roomType;
		this.roomNo = roomNo;
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
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	@Override
	public String toString() {
		return "UserRooms [locName=" + locName + ", dstName=" + dstName + ", spotName=" + spotName + ", roomType="
				+ roomType + ", roomNo=" + roomNo + "]";
	}
	
}
