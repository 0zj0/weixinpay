package com.doyd.core.weixin.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


public class HttpHelper {
	/**
	 * Post xml方法
	 * 
	 * @param URL
	 * @param XML
	 * @return
	 */
	public static String post(String URL, String XML) {
		// 创建HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		// HttpClient
		CloseableHttpClient client = httpClientBuilder.build();
		HttpPost post = new HttpPost(URL);
		String info = null;
		try {
			StringEntity entity = new StringEntity(XML, "UTF-8");
			post.addHeader("Content-Type", "text/xml");
			post.setEntity(entity);
			client.execute(post);
			HttpResponse response = client.execute(post);
			HttpEntity httpEntity = response.getEntity();
			if (httpEntity != null) {
				info = EntityUtils.toString(httpEntity, "UTF-8");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 释放资源
			if (client != null) {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			post.releaseConnection();
		}
		return info;
	}

	/**
	 * 获取真实IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
