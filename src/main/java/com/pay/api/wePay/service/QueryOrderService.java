package com.pay.api.wePay.service;

import com.pay.api.wePay.bean.QueryOrderRequest;
import com.pay.api.wePay.bean.QueryOrderResult;
import com.pay.api.wePay.util.HttpRequestUtil;
import com.pay.api.wePay.util.SignUtil;

/**
 * 查询订单
 * 
 * @author 田露
 * @time 2016年8月11日上午10:45:49
 */
public class QueryOrderService {

	public static QueryOrderResult queryOrderRequest(QueryOrderRequest queryOrderRequest) {

		QueryOrderResult queryOrderResult = HttpRequestUtil.queryOrderRequest(queryOrderRequest);

		if (!(queryOrderResult.getSign().equals(SignUtil.sign(queryOrderResult)))) {
			return null;
		}
		return queryOrderResult;
	}

}
