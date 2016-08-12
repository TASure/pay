package com.pay.api.wePay.service;

import org.junit.Before;
import org.junit.Test;

import com.pay.api.util.common.BeanUtil;
import com.pay.api.wePay.bean.QueryRefundRequest;
import com.pay.api.wePay.bean.QueryRefundResult;
import com.pay.api.wePay.util.SignUtil;

public class QueryRefundServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testQueryRefund() {
		QueryRefundRequest queryRefundRequest=new QueryRefundRequest();
		queryRefundRequest.setOut_trade_no("337");
		queryRefundRequest.setSign(SignUtil.sign(queryRefundRequest));
		QueryRefundResult queryRefundResult=QueryRefundService.queryRefund(queryRefundRequest);
		System.out.println(BeanUtil.beanToXml(queryRefundResult));
	}

}
