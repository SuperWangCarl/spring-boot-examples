package com.carlme.multi.mybatis.aop.datautil;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

	/**
	 * 配置获取的是哪个数据源
	 *
	 * @return
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		return DbContextHolder.getDbType();
	}

}
