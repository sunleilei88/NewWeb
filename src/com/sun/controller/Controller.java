package com.sun.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;

import com.sun.http.HttpPost;
import com.sun.service.InitializeProperties;
import com.sun.xml.BuildXml;

public class Controller extends  HttpServlet  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4991115014836378422L;
	public static Map<String, String[]> SMAP=null;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			InitializeProperties.getProperties(request);
			SMAP=request.getParameterMap();
			Document document=null;
			try {
				document = BuildXml.objectToXml();
				HttpPost.post(document);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}

}
