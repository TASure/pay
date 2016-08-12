package com.pay.api.util.common;

import java.util.UUID;

public class NonceStrUtil {
	
	public static String createNonceStr(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
