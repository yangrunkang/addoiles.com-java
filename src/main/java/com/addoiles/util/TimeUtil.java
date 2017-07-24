package com.addoiles.util;

/**
 * 时间与时区工具类
 *
 * All rights Reserved, Designed By
 * Copyright:   Copyright(C) 2016
 * Company:     .
 * author:      liubing
 * Createdate:  2016年9月9日上午11:13:29
 */
public class TimeUtil {

	private TimeUtil(){}

	/**
	 * 系统Unix时间戳,精确到秒
	 * @return
	 */
	public static Integer currentTime() {
		return (int)(System.currentTimeMillis()/1000);
	}

}
