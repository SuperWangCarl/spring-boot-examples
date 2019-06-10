package com.carlme.multi.mybatis.pack.mapper.test02;

import com.carlme.multi.mybatis.pack.bean.Notice;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionMapping2 {

	void save(Notice notice);

}
