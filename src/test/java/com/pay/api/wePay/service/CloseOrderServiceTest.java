package com.pay.api.wePay.service;

import org.junit.Before;
import org.junit.Test;

import com.pay.api.util.common.BeanUtil;
import com.pay.api.wePay.bean.CloseOrderRequest;
import com.pay.api.wePay.bean.CloseOrderResult;
import com.pay.api.wePay.util.SignUtil;

public class CloseOrderServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCloseOrder() {
		CloseOrderRequest closeOrderRequest=new CloseOrderRequest();
		closeOrderRequest.setOut_trade_no("3399");
		closeOrderRequest.setSign(SignUtil.sign(closeOrderRequest));
		CloseOrderResult closeOrderResult=CloseOrderService.closeOrder(closeOrderRequest);
		System.out.println(BeanUtil.beanToXml(closeOrderResult));
		System.out.println(SignUtil.sign(closeOrderResult));
	}

}
