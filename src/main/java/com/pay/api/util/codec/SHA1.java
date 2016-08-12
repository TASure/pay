package com.pay.api.util.codec;

import org.apache.commons.codec.digest.DigestUtils;

public class SHA1 {
	
	/**
	 * 对字符串进行sha1加密
	 * @param str
	 * @return
	 */
	public static String sha1Hex(String str){
		return DigestUtils.sha1Hex(str);
	}

}
