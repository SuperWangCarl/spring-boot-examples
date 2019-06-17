package com.carlme.multi.mybatisplus;

import com.carlme.multi.mybatisplus.persistence.po.CommonNotice;
import com.carlme.multi.mybatisplus.service.CommonNoticeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiMybatisPlusApplicationTests {

	@Autowired
	private CommonNoticeService commonNoticeService;
	@Test
	public void contextLoads() {
		CommonNotice commonNotice = new CommonNotice();
		commonNotice.setId("1111111111");
		commonNotice.setNoticeName("master");
		commonNoticeService.saveMaster(commonNotice);
		commonNotice.setNoticeName("slave");
		commonNoticeService.saveSlave(commonNotice);
	}

}
