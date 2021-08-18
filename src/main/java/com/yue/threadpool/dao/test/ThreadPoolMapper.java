package com.yue.threadpool.dao.test;

import com.yue.threadpool.bean.test.ThreadPoolPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ThreadPoolMapper {
    int deleteById(Integer id);

    int insert(ThreadPoolPo record);

    ThreadPoolPo selectById(Integer id);

    int updateById(ThreadPoolPo record);

    Map<String,Object> selectOpenCardFeeById(Integer id);

    int insertBatch(List<ThreadPoolPo> list);
}