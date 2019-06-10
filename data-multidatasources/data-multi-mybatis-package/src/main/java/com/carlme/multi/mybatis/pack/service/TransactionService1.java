package com.carlme.multi.mybatis.pack.service;

import com.carlme.multi.mybatis.pack.bean.Notice;
import com.carlme.multi.mybatis.pack.mapper.test01.TransactionMapping1;
import com.carlme.multi.mybatis.pack.mapper.test02.TransactionMapping2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class TransactionService1 {
	@Autowired
	private TransactionMapping1 tm1;
	@Autowired
	private TransactionMapping2 tm2;

	@Transactional
	public void savetestBean2() {
		Notice t = getNotice();

		tm2.save(t);
		int i = 1 / 0;
		t.setNoticeName("六老师");
		tm1.save(t);
	}

	private Notice getNotice() {
		Notice t = new Notice();
		t.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		t.setNoticeName("王老师");
		return t;
	}


}
