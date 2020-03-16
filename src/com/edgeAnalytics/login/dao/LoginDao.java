package com.edgeAnalytics.login.dao;

import java.sql.SQLException;

public interface LoginDao {

	public boolean getCredentials(String userName,String password) throws ClassNotFoundException,SQLException;

}

