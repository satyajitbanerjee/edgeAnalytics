package com.edgeAnalytics.service;

import java.sql.SQLException;
import com.edgeAnalytics.login.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {
	@Autowired
 private DashboardDaoImpl dashboard;
	@Override
	public int getSpeed(String userName) throws ClassNotFoundException, SQLException {
		return dashboard.getSpeed(userName);
	}

}
