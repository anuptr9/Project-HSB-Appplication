package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="AdminDestination")
public class AdminDestination {
	private String locName;
	private String dstName;
	@Id
	private int dstId;
	public AdminDestination() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminDestination(String locName, String dstName, int dstId) {
		super();
		this.locName = locName;
		this.dstName = dstName;
		this.dstId = dstId;
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
	public int getDstId() {
		return dstId;
	}
	public void setDstId(int dstId) {
		this.dstId = dstId;
	}
	@Override
	public String toString() {
		return "AdminDestination [locName=" + locName + ", dstName=" + dstName + ", dstId=" + dstId + "]";
	}

}
