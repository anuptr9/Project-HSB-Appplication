package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//AdminLocation Model Class
@Document(collection="AdminLocation")
public class AdminLocation {

	@Id
	private int locId;
	private String locName;
	
	public AdminLocation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminLocation(int locId, String locName) {
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
		return "AdminLocation [locId=" + locId + ", locName=" + locName + "]";
	}

	
}
