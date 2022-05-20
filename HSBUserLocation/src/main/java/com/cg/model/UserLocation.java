package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="UserLocation")
public class UserLocation {
	@Id
	private int locId;
	private String locName;
	
	public UserLocation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserLocation(int locId, String locName) {
		super();
		this.locId = locId;
		this.locName = locName;
	}
	public int getLocId() {
		return locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	public String getLocName() {
		return locName;
	}
	public void setLocName(String locName) {
		this.locName = locName;
	}
	@Override
	public String toString() {
		return "UserLocation [locId=" + locId + ", locName=" + locName + "]";
	}
	
}
