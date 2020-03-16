package com.edgeAnalytics.login.bean;

public class userMap {
	private String username;
	private String imei;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public userMap(String username, String imei) {
		super();
		this.username = username;
		this.imei = imei;
	}
	public  userMap() {
		
	}
	@Override
	public String toString() {
		return "userMap [username=" + username + ", imei=" + imei + "]";
	}
	
}
