package com.edgeAnalytics.service;

import java.sql.SQLException;

public interface LoginService {
	public boolean getCredentials(String userName,String password) throws ClassNotFoundException,SQLException;
}
