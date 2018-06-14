package com.sun.http;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.dom4j.Document;

import com.sun.service.InitializeProperties;

public class HttpPost {

	public static void post(Document document) throws IOException {

		URL url = new URL(InitializeProperties.NEWWORK_URL);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url
				.openConnection();

		httpURLConnection.setDoInput(true);
		httpURLConnection.setDoOutput(true); // 设置该连接是可以输出的
		httpURLConnection.setRequestMethod("POST"); // 设置请求方式
		httpURLConnection.setRequestProperty("charset", "utf-8");

		OutputStream ops = httpURLConnection.getOutputStream();
		ops.write(document.asXML().getBytes());
		ops.flush();
		ops.close();
		
//		PrintWriter pw = new PrintWriter(new BufferedOutputStream(
//				httpURLConnection.getOutputStream()));
//		httpURLConnection.getInputStream()
//		// 发送数据给服务器
//		pw.write(document.asXML());
//		pw.flush();
//		pw.close();

		BufferedReader br = new BufferedReader(new InputStreamReader(
				httpURLConnection.getInputStream(), "utf-8"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		// 读取返回数据
		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}

		System.out.println(sb.toString());
	}
}
