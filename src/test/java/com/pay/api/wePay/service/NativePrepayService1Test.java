package com.pay.api.wePay.service;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.pay.api.util.common.BeanUtil;
import com.pay.api.util.common.NonceStrUtil;
import com.pay.api.wePay.bean.PrepayRequest;
import com.pay.api.wePay.service.NativePrepayService;
import com.pay.api.wePay.util.SignUtil;

public class NativePrepayService1Test {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPrepay() throws IOException {
		PrepayRequest prepayRequest = new PrepayRequest();
		prepayRequest.setNonce_str(NonceStrUtil.createNonceStr());
		prepayRequest.setBody(NonceStrUtil.createNonceStr());
		prepayRequest.setOut_trade_no(NonceStrUtil.createNonceStr());
		prepayRequest.setTotal_fee(1);
		prepayRequest.setSpbill_create_ip("192.168.1.122");
		prepayRequest.setTrade_type("NATIVE");
		prepayRequest.setSign(SignUtil.sign(prepayRequest));
		System.out.println("post的数据是："+BeanUtil.beanToXml(prepayRequest));
		BitMatrix bitMatrix = NativePrepayService.prepay(prepayRequest);
		MatrixToImageWriter.writeToPath(bitMatrix, "png", Paths.get("D:\\1.png"));
	}

	@Test
	public void testPath() throws IOException {

		Path path = Paths.get("D:\\1\\1.txt");
		System.out.println(path.getRoot());
		System.out.println(path.toString());
		System.out.println(path.getFileName());
		System.out.println(path.getNameCount());
		System.out.println(path.getName(path.getNameCount() - 1));

		Path realPath = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
		System.out.println(realPath.getRoot());
		System.out.println(realPath);

	}

}
