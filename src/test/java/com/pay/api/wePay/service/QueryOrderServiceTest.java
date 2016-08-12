package com.pay.api.wePay.service;


import org.junit.Before;
import org.junit.Test;

import com.pay.api.util.common.BeanUtil;
import com.pay.api.wePay.bean.QueryOrderRequest;
import com.pay.api.wePay.bean.QueryOrderResult;
import com.pay.api.wePay.util.SignUtil;

public class QueryOrderServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testOrderQueryRequest() {
		
		QueryOrderRequest queryOrderRequest=new QueryOrderRequest();
		queryOrderRequest.setOut_trade_no("337");
		queryOrderRequest.setSign(SignUtil.sign(queryOrderRequest));
		
		QueryOrderResult queryOrderResult=QueryOrderService.queryOrderRequest(queryOrderRequest);
		System.out.println(BeanUtil.beanToXml(queryOrderResult));
		
	}

}
