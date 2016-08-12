package com.pay.api.wePay.service;

import org.junit.Before;
import org.junit.Test;

import com.pay.api.util.common.BeanUtil;
import com.pay.api.util.common.NonceStrUtil;
import com.pay.api.wePay.bean.RefundRequest;
import com.pay.api.wePay.bean.RefundResult;
import com.pay.api.wePay.util.SignUtil;

public class RefundServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRefund() {

		RefundRequest refundRequest = new RefundRequest();

		refundRequest.setOut_trade_no("331");
		refundRequest.setOut_refund_no(NonceStrUtil.createNonceStr());
		refundRequest.setTotal_fee(1);
		refundRequest.setRefund_fee(1);
		refundRequest.setSign(SignUtil.sign(refundRequest));
		RefundResult refundResult = RefundService.refund(refundRequest);
		System.out.println(BeanUtil.beanToXml(refundResult));
	}

}
