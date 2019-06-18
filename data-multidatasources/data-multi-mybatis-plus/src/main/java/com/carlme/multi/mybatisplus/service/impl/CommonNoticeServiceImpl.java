package com.carlme.multi.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.carlme.multi.mybatisplus.persistence.mapper.CommonNoticeMapper;
import com.carlme.multi.mybatisplus.persistence.po.CommonNotice;
import com.carlme.multi.mybatisplus.service.CommonNoticeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 通知公告 服务实现类
 * </p>
 *
 * @author carlme
 * @since 2019-06-06
 */
@Service
public class CommonNoticeServiceImpl extends ServiceImpl<CommonNoticeMapper, CommonNotice> implements CommonNoticeService {


	@Override
	public boolean saveMaster(CommonNotice commonNotice) {
		return insert(commonNotice);
	}

	@Override
	@DS("slave")
	public boolean saveSlave(CommonNotice commonNotice) {
		return insert(commonNotice);
	}
}
