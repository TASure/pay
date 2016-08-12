package com.pay.api.wePay.service;

import com.pay.api.wePay.bean.QueryRefundRequest;
import com.pay.api.wePay.bean.QueryRefundResult;
import com.pay.api.wePay.util.HttpRequestUtil;
import com.pay.api.wePay.util.SignUtil;

/**
 * 查询退款
 * 
 * @author 田露
 * @time 2016年8月12日上午11:05:25
 */
public class QueryRefundService {

	public static QueryRefundResult queryRefund(QueryRefundRequest queryRefundRequest) {

		QueryRefundResult queryRefundResult = HttpRequestUtil.queryRefund(queryRefundRequest);

		if (!(queryRefundResult.getSign().equals(SignUtil.sign(queryRefundResult)))) {
			return null;
		}

		return queryRefundResult;
	}

}
