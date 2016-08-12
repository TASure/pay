package com.pay.api.wePay.util;



import org.junit.Before;
import org.junit.Test;

import com.pay.api.util.common.BeanUtil;
import com.pay.api.util.common.NonceStrUtil;
import com.pay.api.wePay.bean.PrepayRequest;
import com.pay.api.wePay.bean.PrepayResult;

public class PrepayHttpRequestTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRequest() {
		PrepayRequest prepayRequest = new PrepayRequest();
		prepayRequest.setNonce_str(NonceStrUtil.createNonceStr());
		prepayRequest.setBody(NonceStrUtil.createNonceStr());
		prepayRequest.setOut_trade_no(NonceStrUtil.createNonceStr());
		prepayRequest.setTotal_fee(2500);
		prepayRequest.setSpbill_create_ip("192.168.1.122");
		prepayRequest.setTrade_type("NATIVE");
		prepayRequest.setSign(SignUtil.sign(prepayRequest));
		PrepayResult prepayResult=HttpRequestUtil.prepayRequest(prepayRequest);
		System.out.println(BeanUtil.beanToXml(prepayResult));
	}

}
