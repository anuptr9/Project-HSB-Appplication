package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="UserSpot")
public class UserSpot {
	private String locName;
	private String dstName;
	private String spotName;
	@Id
	private int spotId;
	@Override
	public String toString() {
		return "UserSpot [locName=" + locName + ", dstName=" + dstName + ", spotName=" + spotName + ", spotId=" + spotId
				+ "]";
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
	public int getSpotId() {
		return spotId;
	}
	public void setSpotId(int spotId) {
		this.spotId = spotId;
	}
	public UserSpot(String locName, String dstName, String spotName, int spotId) {
		super();
		this.locName = locName;
		this.dstName = dstName;
		this.spotName = spotName;
		this.spotId = spotId;
	}
	public UserSpot() {
		super();
		// TODO Auto-generated constructor stub
	}

}
