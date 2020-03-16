package com.edgeAnalytics.login.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.edgeAnalytics.login.bean.login;
@Repository
public class LoginDaoImpl implements LoginDao{
	@Autowired
	private JdbcTemplate template;

	boolean result=false;
	@Override
	public boolean getCredentials(String userName, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql= "select * from login";
		List<login> login1= template.query(sql, new BeanPropertyRowMapper<>(login.class));
		
		boolean credentials = false;
		for (login login2 : login1) {
			System.out.println(login2);
			if((login2.getUsername()).equals(userName)) {
				if((login2.getPassword()).equals(password))
				credentials= true;break;
			}
			else {credentials=false;}
		}

			return credentials;
		
	}

}
