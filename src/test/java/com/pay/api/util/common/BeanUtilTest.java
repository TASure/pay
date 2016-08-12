package com.pay.api.util.common;

import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.pay.api.util.common.BeanUtil;
import com.pay.api.util.common.NonceStrUtil;
import com.pay.api.wePay.bean.PayResult;
import com.pay.api.wePay.bean.PrepayRequest;

public class BeanUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testObjectToMap() {
		PrepayRequest prepayRequest = new PrepayRequest();
		prepayRequest.setAppid(NonceStrUtil.createNonceStr());
		prepayRequest.setTotal_fee(2500);
		prepayRequest.setBody(NonceStrUtil.createNonceStr());
		Map<String, String> map = BeanUtil.beanToMap(prepayRequest);
		Set<String> set = map.keySet();
		for (String str : set) {
			System.out.println(str + "=" + map.get(str));
		}

	}

	@Test
	public void testMapToObject() {
		PrepayRequest prepayRequest = new PrepayRequest();
		prepayRequest.setAppid(NonceStrUtil.createNonceStr());
		prepayRequest.setTotal_fee(2500);
		prepayRequest.setBody(NonceStrUtil.createNonceStr());
		Map<String, String> map = BeanUtil.beanToMap(prepayRequest);
		PrepayRequest prepayRequest2 = BeanUtil.mapToBean(map, PrepayRequest.class);
		System.out.println(prepayRequest2.getTotal_fee());
	}

	@Test
	public void testBeanToJson() {
		PrepayRequest prepayRequest = new PrepayRequest();
		prepayRequest.setAppid(NonceStrUtil.createNonceStr());
		prepayRequest.setTotal_fee(2500);
		prepayRequest.setBody(NonceStrUtil.createNonceStr());
		System.out.println(BeanUtil.beanToJson(prepayRequest));
	}

	@Test
	public void testJsonToBen() {
		PrepayRequest prepayRequest = new PrepayRequest();
		prepayRequest.setAppid(NonceStrUtil.createNonceStr());
		prepayRequest.setTotal_fee(2500);
		prepayRequest.setBody(NonceStrUtil.createNonceStr());
		String json = BeanUtil.beanToJson(prepayRequest);
		prepayRequest = BeanUtil.jsonToBen(json, PrepayRequest.class);
		System.out.println(prepayRequest.getAppid() + "  " + prepayRequest.getTotal_fee());

	}

	@Test
	public void testBeanToXml() {
		PayResult payResult=new PayResult();
		payResult.setAppid(NonceStrUtil.createNonceStr());
		payResult.setCoupon_fee_$n(25);
		payResult.setCoupon_type_$n("6");
		String xml=BeanUtil.beanToXml(payResult);
		System.out.println(xml);
		System.out.println(xml.replace('$', '_'));
		payResult=BeanUtil.jsonToBen(BeanUtil.beanToJson(payResult), PayResult.class);
	
		System.out.println(payResult.getCoupon_fee_$n());
	}

	@Test
	public void testXmlToBean() {
		PrepayRequest prepayRequest = new PrepayRequest();
		prepayRequest.setAppid(NonceStrUtil.createNonceStr());
		prepayRequest.setTotal_fee(2500);
		prepayRequest.setBody(NonceStrUtil.createNonceStr());
		String xml = BeanUtil.beanToXml(prepayRequest);
		System.out.println(xml);
		prepayRequest = (PrepayRequest) BeanUtil.xmlToBean(xml, prepayRequest);
		System.out.println(prepayRequest.getTotal_fee());
	}

}
