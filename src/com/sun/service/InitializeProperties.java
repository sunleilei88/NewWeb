package com.sun.service;

import java.util.Properties; 
import java.io.InputStream; 
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

/** 
* 读取Properties文件
*/ 
public final class InitializeProperties{ 

	public static String NEWWORK_URL;

	public static void getProperties(HttpServletRequest request) {
		 Properties prop = new Properties(); 
         InputStream in = request.getServletContext().getResourceAsStream("/WEB-INF/classes/config.properties");
         try { 
             prop.load(in); 
             setNEWWORK_URL(prop.getProperty("NEWWORK_URL").trim()); 
         } catch (IOException e) { 
             e.printStackTrace(); 
         } 
	}

	public static String getNEWWORK_URL() {
		return NEWWORK_URL;
	}

	public static void setNEWWORK_URL(String nEWWORK_URL) {
		NEWWORK_URL = nEWWORK_URL;
	}
}