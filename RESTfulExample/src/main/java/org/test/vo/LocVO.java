package org.test.vo;

import java.util.List;

public class LocVO {
	private String name;
	private List<GeolocVO> loc;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<GeolocVO> getLoc() {
		return loc;
	}
	public void setLoc(List<GeolocVO> loc) {
		this.loc = loc;
	}
	
}
