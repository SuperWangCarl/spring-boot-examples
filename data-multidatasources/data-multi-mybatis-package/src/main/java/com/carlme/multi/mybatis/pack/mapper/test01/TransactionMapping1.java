package com.carlme.multi.mybatis.pack.mapper.test01;

import com.carlme.multi.mybatis.pack.bean.Notice;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionMapping1 {

	void save(Notice notice);

}
