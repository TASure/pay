package com.pay.api.wePay.service;

import com.pay.api.wePay.bean.RefundRequest;
import com.pay.api.wePay.bean.RefundResult;
import com.pay.api.wePay.util.HttpRequestUtil;
import com.pay.api.wePay.util.SignUtil;

/**
 * 申请退款
 * 
 * @author 田露
 * @time 2016年8月11日下午4:56:54
 */
public class RefundService {

	public static RefundResult refund(RefundRequest refundRequest) {

		RefundResult refundResult = HttpRequestUtil.refund(refundRequest);

		if (!(refundResult.getSign().equals(SignUtil.sign(refundResult)))) {
			return null;
		}

		return refundResult;
	}

}
