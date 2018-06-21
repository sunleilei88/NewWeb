package com.sun.xml;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import sun.security.util.Resources;

public class ParseXmlModel {
	
	public static Map modelxml=new HashMap();
	
	// 解析XML模板
	public Map getModel() throws ParserConfigurationException,
			DocumentException, SAXException, IOException {
		SAXReader saxReader = new SAXReader();
		// 将获取的xml 转化为document 文档
		String url = BuildXml.class.getClassLoader().getResource("").getPath()+"../../channel/test/test1.xml";
		String fileurl = URLDecoder.decode(url, "UTF-8");  
		Document document = saxReader.read(new File(fileurl));
		// 获取根元素
		Element root = document.getRootElement().element("send");
		System.out.println("解析XML模板开始-----------------------");
		// 迭代输出
		for (Iterator iter = root.elementIterator(); iter.hasNext();) { // 获取根目录下的元素
			Element e = (Element) iter.next();
			modelxml.put(e.attribute("name").getValue(),"");
		}
		System.out.println("解析XML模板结束-----------------------");
		return modelxml;
	}
}
