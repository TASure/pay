package com.pay.api.util.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	
	/**
	 * 获取当前系统日期的毫秒数
	 * @return
	 */
	public static String getMillisecond(){
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
	}
	
	/**
	 * 获取当前系统的秒数
	 * @return
	 */
	public static String getSecond(){
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	

}
