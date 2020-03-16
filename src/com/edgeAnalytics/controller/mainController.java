package com.edgeAnalytics.controller;

import com.edgeAnalytics.service.*;


import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edgeAnalytics.login.bean.*;

@Controller
@RequestMapping("/edgeAnalytics")
public class mainController{
	@Autowired
	LoginService loginService;
	@Autowired
	DashboardService dashboardservice;
	@RequestMapping(value="/login",method=RequestMethod.GET)
    public String loginForm(Model model) {
		model.addAttribute("login", new login());
    	return "signin";
    }
    
    @RequestMapping("/logout")
    public String logOut(HttpServletRequest request) {
    	HttpSession session=request.getSession();
    	session.invalidate();
    	return "redirect: /edgeAnalytics/index.jsp";
    }
    
    @RequestMapping(value="/loginChecker",method=RequestMethod.POST)
    public String login(@RequestParam("username") String Username,@RequestParam("password") String Password,HttpServletRequest request) {
    	
    	try {
    		
    		if(loginService.getCredentials(Username, Password)) {
				HttpSession session=request.getSession();
				session.setAttribute("username",Username);
				return "redirect: /edgeAnalytics/Admin/menu.jsp";
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return "login";  	
    	
    }

    @RequestMapping(value="/getSpeed")
    public String getSpeed(HttpServletRequest request,Model model) {
    	HttpSession session=request.getSession();
    	String userName=(String) session.getAttribute("username");
    	try {System.out.println(userName);
			int speed1=dashboardservice.getSpeed(userName);
			model.addAttribute("speeds", speed1);
			request.setAttribute("speeds", speed1);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect: /edgeAnalytics/Admin/viewAll.jsp";
    	
    }
    
   
}