package com.pay.api.util.codec;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {
	
	/**
	 * 对字符串进行MD5加密
	 * @param str
	 * @return
	 */
	public static  String md5Hex(String str){
		return DigestUtils.md5Hex(str);
	}
	
}
