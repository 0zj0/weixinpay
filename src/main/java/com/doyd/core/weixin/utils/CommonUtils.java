package com.doyd.core.weixin.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class CommonUtils {

	public static String mapToXmlStr(Map<String, Object> params) {
		StringBuilder sb = new StringBuilder();
		sb.append("<xml>");
		Iterator<Map.Entry<String, Object>> entries = params.entrySet().iterator();
		while (entries.hasNext()) {
			Entry<String, Object> entry = entries.next();
			sb.append("<" + entry.getKey() + ">" + entry.getValue().toString() + "<" + entry.getKey() + ">");
		}
		sb.append("</xml>");
		return sb.toString();
	}

	public static Map<String, Object> xmlStrToMap(String xml) {
		Map<String, Object> map = new HashMap<>();
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xml); // 将字符串转为XML
			Element rootElt = doc.getRootElement(); // 获取根节点
			@SuppressWarnings("unchecked")
			List<Element> list = rootElt.elements();// 获取根节点下所有节点
			for (Element element : list) { // 遍历节点
				map.put(element.getName(), element.getText()); // 节点的name为map的key，text为map的value
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
