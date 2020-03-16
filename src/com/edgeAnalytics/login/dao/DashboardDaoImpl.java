package com.edgeAnalytics.login.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.edgeAnalytics.login.bean.speed;
import com.edgeAnalytics.login.bean.userMap;



@Repository
public class DashboardDaoImpl implements DashboardDao{
	@Autowired
	private JdbcTemplate template;


	@Override
	public int getSpeed(String userName) throws ClassNotFoundException, SQLException {
		int getSpeed=0;
		String sql="Select * from usermap where username='"+userName+"'";
	
		List<userMap> usermap=template.query(sql, new BeanPropertyRowMapper<>(userMap.class));
		
		String imei3=null;
		for (userMap imei2: usermap )
		{System.out.println(imei2);
			imei3=imei2.getImei();
		System.out.println(imei3);
		}
		String sql1="select speed from tcuspeed where imei='"+imei3+"'";
	
		List<speed> speed1=template.query(sql1,new BeanPropertyRowMapper<>(speed.class));
		for (speed speed2:speed1) {
			getSpeed=speed2.getSpeed();
			System.out.println(getSpeed);
		}
		System.out.println(getSpeed);
		return getSpeed;
		
	}

}
