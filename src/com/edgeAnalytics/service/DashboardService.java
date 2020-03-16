package com.edgeAnalytics.service;

import java.sql.SQLException;

public interface DashboardService {

	public int getSpeed(String userName) throws ClassNotFoundException,SQLException;
}
