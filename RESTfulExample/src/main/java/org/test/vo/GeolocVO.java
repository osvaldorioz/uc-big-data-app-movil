package org.test.vo;

public class GeolocVO {
	private String lat;
	private String lon;
	private Integer idPerson;
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public Integer getIdPerson() {
		return idPerson;
	}
	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}
	
	public String toString() {
		return idPerson + " " + lat + " " + lon;
	}
}
