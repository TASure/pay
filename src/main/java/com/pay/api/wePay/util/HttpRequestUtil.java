package com.pay.api.wePay.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.UnsupportedCharsetException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;

import com.pay.api.util.common.BeanUtil;
import com.pay.api.wePay.bean.CloseOrderRequest;
import com.pay.api.wePay.bean.CloseOrderResult;
import com.pay.api.wePay.bean.DownloadBillRequest;
import com.pay.api.wePay.bean.PrepayRequest;
import com.pay.api.wePay.bean.PrepayResult;
import com.pay.api.wePay.bean.QueryOrderRequest;
import com.pay.api.wePay.bean.QueryOrderResult;
import com.pay.api.wePay.bean.QueryRefundRequest;
import com.pay.api.wePay.bean.QueryRefundResult;
import com.pay.api.wePay.bean.RefundRequest;
import com.pay.api.wePay.bean.RefundResult;
import com.pay.api.wePay.config.SecurityConfig;

public class HttpRequestUtil {

	/**
	 * 统一下单
	 * 
	 * @param prepayRequest
	 * @return
	 */
	public static PrepayResult prepayRequest(PrepayRequest prepayRequest) {

		try {
			HttpPost httpPost = new HttpPost(SecurityConfig.prepay_url);
			httpPost.setConfig(RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(30000).build());
			StringEntity entity = new StringEntity(BeanUtil.beanToXml(prepayRequest), "UTF-8");
			httpPost.setEntity(entity);

			CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
			CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpPost);
			HttpEntity httpEntity = closeableHttpResponse.getEntity();
			PrepayResult prepayResult = (PrepayResult) BeanUtil.inputStreamToBean(httpEntity.getContent(),
					new PrepayResult());
			return prepayResult;
		} catch (UnsupportedCharsetException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询订单
	 * 
	 * @param queryOrderRequest
	 * @return
	 */
	public static QueryOrderResult queryOrderRequest(QueryOrderRequest queryOrderRequest) {
		try {
			HttpPost httpPost = new HttpPost(SecurityConfig.query_order_url);
			httpPost.setConfig(RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(30000).build());
			StringEntity stringEntity = new StringEntity(BeanUtil.beanToXml(queryOrderRequest), "UTF-8");
			httpPost.setEntity(stringEntity);

			CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
			CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpPost);
			HttpEntity httpEntity = closeableHttpResponse.getEntity();
			QueryOrderResult queryOrderResult = (QueryOrderResult) BeanUtil.inputStreamToBean(httpEntity.getContent(),
					new QueryOrderResult());
			return queryOrderResult;
		} catch (UnsupportedCharsetException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 查询账单
	 * 
	 * @param downloadBillRequest
	 * @return
	 */
	public static InputStream downloadBill(DownloadBillRequest downloadBillRequest) {
		try {
			HttpPost httpPost = new HttpPost(SecurityConfig.download_bill_url);
			httpPost.setConfig(RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(30000).build());
			StringEntity stringEntity = new StringEntity(BeanUtil.beanToXml(downloadBillRequest));
			httpPost.setEntity(stringEntity);
			CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
			CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpPost);
			HttpEntity httpEntity = closeableHttpResponse.getEntity();
			return httpEntity.getContent();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 关闭订单
	 * 
	 * @param closeOrderRequest
	 * @return
	 */
	public static CloseOrderResult closeOrder(CloseOrderRequest closeOrderRequest) {
		try {
			HttpPost httpPost = new HttpPost(SecurityConfig.close_order_url);
			httpPost.setConfig(RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(30000).build());
			StringEntity stringEntity = new StringEntity(BeanUtil.beanToXml(closeOrderRequest));
			httpPost.setEntity(stringEntity);
			CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
			CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpPost);
			HttpEntity httpEntity = closeableHttpResponse.getEntity();
			CloseOrderResult closeOrderResult = (CloseOrderResult) BeanUtil.inputStreamToBean(httpEntity.getContent(),
					new CloseOrderResult());
			return closeOrderResult;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 申请退款
	 * 
	 * @param refundRequest
	 * @return
	 */
	public static RefundResult refund(RefundRequest refundRequest) {

		try {
			HttpPost httpPost = new HttpPost(SecurityConfig.refund_url);
			httpPost.setConfig(RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(30000).build());
			StringEntity stringEntity = new StringEntity(BeanUtil.beanToXml(refundRequest));
			httpPost.setEntity(stringEntity);
			CloseableHttpClient closeableHttpClient = createHttpsClient();
			CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpPost);
			HttpEntity httpEntity = closeableHttpResponse.getEntity();
			RefundResult refundResult = (RefundResult) BeanUtil.inputStreamToBean(httpEntity.getContent(),
					new RefundResult());
			return refundResult;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 查询退款
	 * 
	 * @param queryRefundRequest
	 * @return
	 */
	public static QueryRefundResult queryRefund(QueryRefundRequest queryRefundRequest) {
		try {
			HttpPost httpPost = new HttpPost(SecurityConfig.query_refund_url);
			httpPost.setConfig(RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(30000).build());
			StringEntity stringEntity = new StringEntity(BeanUtil.beanToXml(queryRefundRequest));
			httpPost.setEntity(stringEntity);
			CloseableHttpClient closeableHttpClient = createHttpsClient();
			CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpPost);
			HttpEntity httpEntity = closeableHttpResponse.getEntity();
			// BufferedReader bufferedReader=new BufferedReader(new
			// InputStreamReader(httpEntity.getContent(), "UTF-8"));
			// String line=null;
			// while((line=bufferedReader.readLine())!=null){
			// System.out.println(line);
			// }
			QueryRefundResult queryRefundResult = (QueryRefundResult) BeanUtil
					.inputStreamToBean(httpEntity.getContent(), new QueryRefundResult());
			return queryRefundResult;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 创建HTTPS连接
	 * 
	 * @return
	 */
	private static CloseableHttpClient createHttpsClient() {

		try {
			// 加载证书
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			FileInputStream fileInputStream = new FileInputStream(new File(
					HttpRequestUtil.class.getClassLoader().getResource("pay/wePay/cert/apiclient_cert.p12").getPath()));
			keyStore.load(fileInputStream, SecurityConfig.mch_id.toCharArray());

			// 创建HTTPS连接
			SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, SecurityConfig.mch_id.toCharArray())
					.build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
			CloseableHttpClient closeableHttpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			return closeableHttpClient;
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		}

		return null;
	}

}
