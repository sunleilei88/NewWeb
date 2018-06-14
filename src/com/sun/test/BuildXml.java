package com.sun.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;

import com.sun.controller.Controller;

public class BuildXml {
	
	public static Map modelxml=new HashMap();
	
	public static void main(String[] args) {
		try {
			ParseXmlModel parseXml=new ParseXmlModel();
			modelxml = parseXml.getModel();
			objectToXml();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 将对象组装成xml格式文件并保存
	public static void objectToXml() throws Exception {
		ParseXmlModel parseXml=new ParseXmlModel();
		modelxml = parseXml.getModel();
		Element root = DocumentHelper.createElement("channel");
		Document document = DocumentHelper.createDocument(root);
		// 给元素添加属性
		root.addAttribute("name", "sun");
		System.out.println("组装xml开始-----------------------");
		for(Object key: modelxml.keySet()){
			// 添加子节点:add之后就返回这个元素
			Element element = root.addElement("field");
			// 给元素添加属性key-value
			element.addAttribute("name", key.toString());
			element.setText(Controller.SMAP.get(key)[0]);
		}
		System.out.println("组装xml结束-----------------------");
		// 输出到控制台
		XMLWriter xmlWriter = new XMLWriter();
		xmlWriter.write(document);
		
	}
	
}
