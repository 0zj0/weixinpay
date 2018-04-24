package com.doyd.core.weixin.utils;

import java.util.Map;

import com.doyd.core.utils.MD5Util;

public class SignUtil {

	/**
	 * 通过appid，mch_id，nonce_str，out_trade_no 生成签名
	 * 
	 * @Title: createSign  
	 * @param params
	 * @param key
	 * @return String
	 * @author zj
	 * @date 2018年4月24日下午2:55:12
	 */
	public static String createSign(Map<String, Object> params,String key){
		StringBuilder sb= new StringBuilder();
		sb.append("appid="+params.get("appid")+"&");
		sb.append("mch_id="+params.get("mch_id")+"&");
		sb.append("nonce_str="+params.get("nonce_str")+"&");
		sb.append("out_trade_no="+params.get("out_trade_no")+"&");
		sb.append("key="+key);
		return MD5Util.MD5Encode(sb.toString(), "utf-8").toUpperCase();
	}
	
}
