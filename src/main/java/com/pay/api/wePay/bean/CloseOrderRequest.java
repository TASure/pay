package com.pay.api.wePay.bean;

import com.pay.api.util.common.NonceStrUtil;
import com.pay.api.wePay.config.SecurityConfig;

public class CloseOrderRequest {

	private String appid = SecurityConfig.appid;// 公众账号ID

	private String mch_id = SecurityConfig.mch_id;// 商户号

	private String out_trade_no;// 商户订单号

	private String nonce_str = NonceStrUtil.createNonceStr();// 随机字符串

	private String sign;// 签名

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
