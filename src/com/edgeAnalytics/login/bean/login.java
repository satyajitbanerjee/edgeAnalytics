package com.edgeAnalytics.login.bean;


public class login {
private String username;
private String password;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public login(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}
public login() {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "login [username=" + username + ", password=" + password + "]";
}

}
