package com.edgeAnalytics.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgeAnalytics.login.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao dao;
	@Override
	public boolean getCredentials(String userName, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return dao.getCredentials(userName, password);
	}

}

