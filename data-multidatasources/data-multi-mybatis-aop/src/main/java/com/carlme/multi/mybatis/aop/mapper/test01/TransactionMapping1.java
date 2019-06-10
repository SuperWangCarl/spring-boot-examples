package com.carlme.multi.mybatis.aop.mapper.test01;

import com.carlme.multi.mybatis.aop.bean.Notice;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionMapping1 {

	void save(Notice notice);

}
