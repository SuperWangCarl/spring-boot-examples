package com.carlme.multi.mybatis.aop.mapper.test02;

import com.carlme.multi.mybatis.aop.annotation.DataSourceType;
import com.carlme.multi.mybatis.aop.bean.Notice;
import com.carlme.multi.mybatis.aop.datautil.DbContextHolder;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionMapping2 {

	@DataSourceType(DbContextHolder.DATA_SOURCE_SLAVE)
	void save(Notice notice);

}
