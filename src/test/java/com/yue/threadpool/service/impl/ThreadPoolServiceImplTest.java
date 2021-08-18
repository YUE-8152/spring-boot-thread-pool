package com.yue.threadpool.service.impl;

import com.yue.threadpool.Tester;
import com.yue.threadpool.service.ThreadPoolService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ProjectName: spring-boot-thread-pool
 * @Package: com.yue.threadpool.service.impl
 * @ClassName: ThreadPoolServiceImplTest
 * @Author: YUE
 * @Description:
 * @Date: 2021/8/18 16:23
 * @Version: 1.0
 */
class ThreadPoolServiceImplTest extends Tester {

    @DubboReference
    private ThreadPoolService threadPoolService;

    @Test
    void insert() {
        String s = threadPoolService.insert();
        System.out.println(s); // 10782
    }

    @Test
    void insertThreadPool() {
        String s = threadPoolService.insertThreadPool();
        System.out.println(s);
    }
}