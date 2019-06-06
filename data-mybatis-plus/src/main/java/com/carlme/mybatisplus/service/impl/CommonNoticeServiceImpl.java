package com.carlme.mybatisplus.service.impl;

import com.carlme.mybatisplus.persistence.po.CommonNotice;
import com.carlme.mybatisplus.persistence.mapper.CommonNoticeMapper;
import com.carlme.mybatisplus.service.CommonNoticeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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

}
