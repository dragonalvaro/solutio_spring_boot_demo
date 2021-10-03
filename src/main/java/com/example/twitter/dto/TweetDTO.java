package com.example.twitter.dto;

public class TweetDTO {

	private String id;
	private String twitterId;
	private String user;
	private String text;
	private GeoLocationDTO geoLocation;
	private String userLocation;
	private boolean validated;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTwitterId() {
		return twitterId;
	}

	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public GeoLocationDTO getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(GeoLocationDTO geoLocation) {
		this.geoLocation = geoLocation;
	}

	public String getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

}
