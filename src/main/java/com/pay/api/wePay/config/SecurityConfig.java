package com.pay.api.wePay.config;

public class SecurityConfig {

	public final static String appid = "";// 公众账号ID

	public final static String mch_id = "";// 商户号

	public final static String key = "";// 商户支付密钥

	public final static String prepay_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";// 微信统一下单URL

	public final static String notify_url = "http://sqmd.yunxun168.com/recharge/wepay";// 支付完成通知地址

	public final static String query_order_url = "https://api.mch.weixin.qq.com/pay/orderquery";// 查询订单URL

	public final static String download_bill_url = "https://api.mch.weixin.qq.com/pay/downloadbill";// 下载订单URL

	public final static String close_order_url = "https://api.mch.weixin.qq.com/pay/closeorder";// 关闭订单URL

	public final static String refund_url = "https://api.mch.weixin.qq.com/secapi/pay/refund";// 申请退款URL

	public final static String query_refund_url = "https://api.mch.weixin.qq.com/pay/refundquery";// 查询退款URL

	public final static int native_wight = 300;// native支付二维码宽度

	public final static int native_height = 300;// native支付二维码高度

}
