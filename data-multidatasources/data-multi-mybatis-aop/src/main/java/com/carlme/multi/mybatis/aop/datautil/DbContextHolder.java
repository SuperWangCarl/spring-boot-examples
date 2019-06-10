package com.carlme.multi.mybatis.aop.datautil;

import org.apache.commons.lang3.StringUtils;

public class DbContextHolder {

	public static final String DATA_SOURCE_MASTER = "master";
	public static final String DATA_SOURCE_SLAVE = "slave";

	private static final ThreadLocal contextHolder = new ThreadLocal();

	/**
	 * 设置当前使用的数据源
	 * @param dbType
	 */
	public static void setDbType(String dbType) {
		contextHolder.set(dbType);
	}

	/**
	 * 获取当前使用的哪个数据源
	 * @return
	 */
	public static String getDbType() {
		String str = (String) contextHolder.get();
		if (StringUtils.isEmpty(str))
			str = DATA_SOURCE_MASTER;
		return str;
	}

	public static void clearDbType() {
		contextHolder.remove();
	}

}
