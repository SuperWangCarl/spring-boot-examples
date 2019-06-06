package com.carlme.mybatis;

import com.carlme.mybatis.bean.Notice;
import com.carlme.mybatis.mapper.NoticeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

	@Autowired
	NoticeMapper noticeMapper;
	@Test
	public void contextLoads() {
		Notice notice = noticeMapper.getById("18fdaa43a3f94845be12229ccfcbe12f");
		System.out.println(notice);
	}

}
