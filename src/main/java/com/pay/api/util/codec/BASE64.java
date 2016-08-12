package com.pay.api.util.codec;

import org.apache.commons.codec.binary.Base64;

public class BASE64 {
	
	/**
	 * 对字符串进行base64加密
	 * @param str
	 * @return
	 */
	public static String encodeBase64(String str){
		return Base64.encodeBase64String(str.getBytes());
	}
	
	/**
	 * 对字符串进行base64解密
	 * @param str
	 * @return
	 */
	public static String decodeBase64(String str){
		return new String(Base64.decodeBase64(str));
	}

}
