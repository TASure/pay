package com.pay.api.wePay.util;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.pay.api.util.codec.MD5;
import com.pay.api.util.common.BeanUtil;
import com.pay.api.util.common.NonceStrUtil;
import com.pay.api.wePay.bean.PrepayRequest;

public class SignTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSign() {
		PrepayRequest prepayRequest=new PrepayRequest();
		prepayRequest.setAppid(NonceStrUtil.createNonceStr());
		prepayRequest.setTotal_fee(2500);
		prepayRequest.setBody(NonceStrUtil.createNonceStr());
		Map<String,String> map=BeanUtil.beanToMap(prepayRequest);
		System.out.println(SignUtil.sign(map));
	}
	
	@Test
	public void test1(){
		String str="appid=wx9ce24065b83285bd&bank_type=CFT&fee_type=CNY&is_subscribe=Y&mch_id=1339440201&nonce_str=8cbc408089ab7a94ae4c772b37361b97&openid=o1e4Kw8ugr61jIFLjwzX-_Ze5i7g&out_trade_no=316&result_code=SUCCESS&return_code=SUCCESS&time_end=20160808155205&trade_type=JSAPI&transaction_id=4003482001201608080865245530&key=0f7f5112e11b4e9d8b51ce2558322f15";
		System.out.println(MD5.md5Hex(str));
		System.out.println(SignUtil.class.getClassLoader().getResource("pay/wePay/cert/apiclient_cert.p12").getPath());
	}

	@Test
	public void testCreateLinkString() {
		PrepayRequest prepayRequest=new PrepayRequest();
		prepayRequest.setAppid(NonceStrUtil.createNonceStr());
		prepayRequest.setTotal_fee(2500);
		prepayRequest.setBody(NonceStrUtil.createNonceStr());
		Map<String,String> map=BeanUtil.beanToMap(prepayRequest);
		System.out.println(SignUtil.createLinkString(map));
	}

}
