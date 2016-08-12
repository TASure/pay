package com.pay.api.wePay.bean;

import com.pay.api.util.common.NonceStrUtil;
import com.pay.api.wePay.config.SecurityConfig;

public class DownloadBillRequest {

	private String appid = SecurityConfig.appid;// 公众账号ID

	private String mch_id = SecurityConfig.mch_id;// 商户号

	private String device_info;// 设备号

	private String nonce_str = NonceStrUtil.createNonceStr();// 随机字符串

	private String sign;// 签名

	private String bill_date;// 对账单日期

	private String bill_type;// 账单类型

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

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
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

	public String getBill_date() {
		return bill_date;
	}

	public void setBill_date(String bill_date) {
		this.bill_date = bill_date;
	}

	public String getBill_type() {
		return bill_type;
	}

	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}

}
