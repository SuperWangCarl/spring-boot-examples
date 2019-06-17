package com.carlme.multi.mybatisplus.service;

import com.baomidou.mybatisplus.service.IService;
import com.carlme.multi.mybatisplus.persistence.po.CommonNotice;

/**
 * <p>
 * 通知公告 服务类
 * </p>
 *
 * @author carlme
 * @since 2019-06-06
 */
public interface CommonNoticeService extends IService<CommonNotice> {

	/**
	 * 数据保存到master中
	 * @param commonNotice
	 * @return
	 */
	boolean saveMaster(CommonNotice commonNotice);

	/**
	 * 数据保存到slave中
	 * @param commonNotice
	 * @return
	 */
	boolean saveSlave(CommonNotice commonNotice);
}
