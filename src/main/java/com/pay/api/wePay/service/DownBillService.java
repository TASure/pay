package com.pay.api.wePay.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.pay.api.wePay.bean.DownloadBillRequest;
import com.pay.api.wePay.util.HttpRequestUtil;

/**
 * 查询账单
 * 
 * @author 田露
 * @time 2016年8月11日上午11:25:14
 */
public class DownBillService {

	public static BufferedReader downloadBill(DownloadBillRequest downloadBillRequest) {
		try {
			return new BufferedReader(
					new InputStreamReader(HttpRequestUtil.downloadBill(downloadBillRequest), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
