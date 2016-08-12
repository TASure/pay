package com.pay.api.wePay.service;

import com.pay.api.wePay.bean.CloseOrderRequest;
import com.pay.api.wePay.bean.CloseOrderResult;
import com.pay.api.wePay.util.HttpRequestUtil;
import com.pay.api.wePay.util.SignUtil;

public class CloseOrderService {

	public static CloseOrderResult closeOrder(CloseOrderRequest closeOrderRequest) {
		CloseOrderResult closeOrderResult = HttpRequestUtil.closeOrder(closeOrderRequest);
		if (!(closeOrderRequest.getSign().equals(SignUtil.sign(closeOrderRequest)))) {
			return null;
		}
		return closeOrderResult;
	}

}
