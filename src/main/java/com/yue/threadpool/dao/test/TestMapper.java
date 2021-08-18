package com.yue.threadpool.dao.test;

import com.yue.threadpool.bean.test.SysUserPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ProjectName: wx-mp-base
 * @Package: com.yx.mp.base.mapper.test
 * @ClassName: TestMapper
 * @Author: YUE
 * @Description:
 * @Date: 2021/4/21 10:16
 * @Version: 1.0
 */
@Mapper
public interface TestMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(SysUserPo record);

    SysUserPo selectByPrimaryKey(Integer userId);

    List<SysUserPo> selectAll();

    int updateByPrimaryKey(SysUserPo record);
}
