package com.doyd.core.weixin.utils;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class WinxinUtil {

	public static CloseableHttpClient httpClient=HttpClientBuilder.create().build();
	
}
