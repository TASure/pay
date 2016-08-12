package com.pay.api.wePay.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;

import com.pay.api.wePay.bean.DownloadBillRequest;
import com.pay.api.wePay.util.SignUtil;

public class DownBillServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDownloadBill() {
		try {
			DownloadBillRequest downloadBillRequest=new DownloadBillRequest();
			downloadBillRequest.setBill_date("20160810");
			downloadBillRequest.setBill_type("ALL");
			downloadBillRequest.setSign(SignUtil.sign(downloadBillRequest));
			BufferedReader bufferedReader=DownBillService.downloadBill(downloadBillRequest);
			String line=null;
			while((line=bufferedReader.readLine())!=null){
				System.out.println(line);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
