package com.yue.threadpool.service.impl;

import com.yue.threadpool.dao.test.TestMapper;
import com.yue.threadpool.service.SysUserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ProjectName: springboot-authority
 * @Package: com.yue.base.service.impl.mp
 * @ClassName: SysUserServiceImpl
 * @Author: YUE
 * @Description:
 * @Date: 2021/5/10 15:34
 * @Version: 1.0
 */
@DubboService
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private TestMapper mapper;

    @Override
    public List selectList() {
        return mapper.selectAll();
    }
}
