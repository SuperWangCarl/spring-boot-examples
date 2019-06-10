package com.carlme.multi.mybatis.aop;

import com.carlme.multi.mybatis.aop.bean.Notice;
import com.carlme.multi.mybatis.aop.mapper.test01.TransactionMapping1;
import com.carlme.multi.mybatis.aop.mapper.test02.TransactionMapping2;
import com.carlme.multi.mybatis.aop.service.TransactionService1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiMybatisAopApplicationTests {

	@Autowired
	private TransactionMapping1 tm1;
	@Autowired
	private TransactionMapping2 tm2;
	@Autowired
	private TransactionService1 ts1;

	@Test
	public void savetest() {
		Notice notice = getNotice();
		//存入数据源1中
		tm1.save(notice);
		notice.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		//存入数据源2中
		tm2.save(notice);
	}

	// ########################开始事务测试##########################

	@Test
	public void savetestTransaction() {
		ts1.savetestBean2();
	}

	private Notice getNotice() {
		Notice t = new Notice();
		t.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		t.setNoticeName("老2师");
		return t;
	}

}
