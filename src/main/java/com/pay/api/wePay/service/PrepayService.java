package com.pay.api.wePay.service;

import com.pay.api.wePay.bean.PrepayRequest;
import com.pay.api.wePay.bean.PrepayResult;
import com.pay.api.wePay.util.HttpRequestUtil;
import com.pay.api.wePay.util.SignUtil;

/**
 * 统一下单
 * 
 * @author 田露
 * @time 2016年8月12日上午11:48:10
 */
public class PrepayService {

	public static PrepayResult prepay(PrepayRequest prepayRequest) {
		PrepayResult prepayResult = HttpRequestUtil.prepayRequest(prepayRequest);
		if (!(prepayResult.getSign().equals(SignUtil.sign(prepayResult)))) {
			return null;
		}
		return prepayResult;

	}

}
