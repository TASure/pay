package com.pay.api.wePay.service;

import org.junit.Before;
import org.junit.Test;

import com.pay.api.util.common.BeanUtil;
import com.pay.api.util.common.NonceStrUtil;
import com.pay.api.wePay.bean.PrepayRequest;
import com.pay.api.wePay.bean.PrepayResult;
import com.pay.api.wePay.util.SignUtil;

public class PrepayServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPrepay() {
		PrepayRequest prepayRequest = new PrepayRequest();
		prepayRequest.setNonce_str(NonceStrUtil.createNonceStr());
		prepayRequest.setBody(NonceStrUtil.createNonceStr());
		prepayRequest.setOut_trade_no(NonceStrUtil.createNonceStr());
		prepayRequest.setTotal_fee(1);
		prepayRequest.setSpbill_create_ip("192.168.1.122");
		prepayRequest.setTrade_type("NATIVE");
		prepayRequest.setSign(SignUtil.sign(prepayRequest));
		System.out.println("post的数据是："+BeanUtil.beanToXml(prepayRequest));
		PrepayResult prepayResult=PrepayService.prepay(prepayRequest);
		System.out.println("接收到的数据是："+BeanUtil.beanToXml(prepayResult));
	}

}
