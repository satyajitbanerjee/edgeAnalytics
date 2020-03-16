package com.edgeAnalytics.login.dao;

import java.sql.SQLException;

public interface DashboardDao {

	public int getSpeed(String userName) throws ClassNotFoundException,SQLException;
        
}
