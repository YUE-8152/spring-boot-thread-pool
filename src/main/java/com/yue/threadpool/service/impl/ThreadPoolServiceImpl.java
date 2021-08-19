package com.yue.threadpool.service.impl;

import com.yue.threadpool.bean.test.ThreadPoolPo;
import com.yue.threadpool.common.utils.BeanMapUtils;
import com.yue.threadpool.common.utils.DateUtils;
import com.yue.threadpool.dao.test.TestMapper;
import com.yue.threadpool.dao.test.ThreadPoolMapper;
import com.yue.threadpool.service.SysUserService;
import com.yue.threadpool.service.ThreadPoolService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
public class ThreadPoolServiceImpl implements ThreadPoolService {

    @Autowired
    private ThreadPoolTaskExecutor poolTaskExecutor;

    @Autowired
    private ThreadPoolMapper threadPoolMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String insert() {
        List<ThreadPoolPo> list = createThreadPoolPos();
        long startTime = System.currentTimeMillis();
        list.forEach(e -> {
            threadPoolMapper.insert(e);
        });
        long endTime = System.currentTimeMillis();
        return "thread-single-task执行时间" + (endTime - startTime) + "毫秒";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String insertThreadPool() {
        List<ThreadPoolPo> list = createThreadPoolPos();
        long startTime = System.currentTimeMillis();
        int corePoolSize = poolTaskExecutor.getCorePoolSize()-1;
        List<List<ThreadPoolPo>> splitList = BeanMapUtils.averageSplitList(list, corePoolSize);
        List<Thread> threadList = splitList.stream().map(e -> {
            Thread thread = new Thread(() -> {
                e.forEach(m -> {
                    threadPoolMapper.insert(m);
                });
            });
            return thread;
        }).collect(Collectors.toList());
        threadList.forEach(e->{
            poolTaskExecutor.execute(e);
        });

//        splitList.forEach(e->{
//            Thread thread = new Thread(() -> {
//                e.forEach(m->{
//                    threadPoolMapper.insert(m);
//                });
//            });
//        });
//
//        long startTime = System.currentTimeMillis();
//        poolTaskExecutor.execute(() -> {
//            list.forEach(e -> {
//                threadPoolMapper.insert(e);
//            });
//        });
        long endTime = System.currentTimeMillis();
        return "thread-pool-task执行时间" + (endTime - startTime) + "毫秒";
    }

    private List<ThreadPoolPo> createThreadPoolPos() {
        List<ThreadPoolPo> list = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            ThreadPoolPo po = new ThreadPoolPo();
            po.setMerCode("400000");
            po.setChildMerCode("40000001");
            po.setLevelName("级别-" + i + 1);
            po.setCardDeposit("0.00");
            po.setServiceFee("0.00");
            po.setDayLimitTimes(0);
            po.setDayLimitAmount("100.00");
            po.setMonthLimitTimes(1000);
            po.setMonthLimitAmount("3000.00");
            po.setOpenType(1);
            po.setStatus(1);
            po.setCreateTime(DateUtils.getCurrentDateTime());
            po.setCreateUser("YUE");
            po.setUpdateTime(DateUtils.getCurrentDateTime());
            po.setUpdateUser("YUE");
            list.add(po);
        }
        return list;
    }
}
