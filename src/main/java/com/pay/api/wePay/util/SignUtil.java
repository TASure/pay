package com.pay.api.wePay.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pay.api.util.codec.MD5;
import com.pay.api.util.common.BeanUtil;
import com.pay.api.wePay.config.SecurityConfig;

public class SignUtil {

	/**
	 * 签名
	 * 
	 * @param object
	 * @return
	 */
	public static String sign(Object object) {
		Map<String, String> map = BeanUtil.beanToMap(object);
		Map<String, String> resultMap = parameteFilter(map);

		return MD5.md5Hex(createLinkString(resultMap) + "&key=" + SecurityConfig.key).toUpperCase();
	}

	/**
	 * 验签
	 * 
	 * @param object
	 * @return
	 */
	public static boolean verify(Object object) {
		Map<String, String> map = BeanUtil.beanToMap(object);
		Map<String, String> resultMap = parameteFilter(map);
		String sign = MD5.md5Hex(createLinkString(resultMap) + "&key=" + SecurityConfig.key).toUpperCase();
		if (sign.equals(map.get("sign"))) {
			return true;
		}
		return false;
	}

	/**
	 * 去除集合中空值和签名参数
	 * 
	 * @param map
	 * @return
	 */
	private static Map<String, String> parameteFilter(Map<String, String> map) {
		Map<String, String> resultMap = new HashMap<String, String>();
		if (map == null || map.isEmpty()) {
			return resultMap;
		}
		for (String key : map.keySet()) {
			String value = map.get(key);
			if (value == null || value.isEmpty() || key.equalsIgnoreCase("sign")) {
				continue;
			}
			resultMap.put(key, value);
		}

		return resultMap;
	}

	/**
	 * 将集合中的元素拼接成字符串
	 * 
	 * @param map
	 * @return
	 */
	public static String createLinkString(Map<String, String> map) {
		List<String> keys = new ArrayList<String>(map.keySet());
		Collections.sort(keys);
		StringBuilder resultStr = new StringBuilder();
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = map.get(key);
			if (i == keys.size() - 1) {
				resultStr.append(key + "=" + value);
			} else {
				resultStr.append(key + "=" + value + "&");
			}
		}
		return resultStr.toString();

	}

}
