package com.sun.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.service.InitializeProperties;

public class Controller extends  HttpServlet  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4991115014836378422L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			InitializeProperties.getProperties(request);
//			HttpPost();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}

}
