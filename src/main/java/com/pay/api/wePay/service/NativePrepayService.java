package com.pay.api.wePay.service;

import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.pay.api.wePay.bean.PrepayRequest;
import com.pay.api.wePay.bean.PrepayResult;
import com.pay.api.wePay.config.SecurityConfig;
import com.pay.api.wePay.util.HttpRequestUtil;
import com.pay.api.wePay.util.SignUtil;

/**
 * native支付
 * 
 * @author 田露
 * @time 2016年8月11日上午10:45:38
 */
public class NativePrepayService {

	public static BitMatrix prepay(PrepayRequest prepayRequest) {

		try {
			PrepayResult prepayResult = HttpRequestUtil.prepayRequest(prepayRequest);
			if (!(prepayResult.getSign().equals(SignUtil.sign(prepayResult)))) {
				return null;
			}
			String code_url = prepayResult.getCode_url();
			HashMap<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			BitMatrix bitMatrix = new MultiFormatWriter().encode(code_url, BarcodeFormat.QR_CODE,
					SecurityConfig.native_wight, SecurityConfig.native_height, hints);
			return bitMatrix;
		} catch (WriterException e) {
			e.printStackTrace();
		}

		return null;
	}

}
