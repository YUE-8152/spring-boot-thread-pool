package com.yue.threadpool.controller.test;

import com.yue.threadpool.common.core.Result;
import com.yue.threadpool.service.SysUserService;
import com.yue.threadpool.service.ThreadPoolService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: springboot-authority
 * @Package: com.yue.base.controller.test
 * @ClassName: TestController
 * @Author: YUE
 * @Description:
 * @Date: 2021/5/10 15:38
 * @Version: 1.0
 */
@RestController
@RequestMapping("/thread")
public class ThreadPoolController {
    @DubboReference
    private ThreadPoolService threadPoolService;

    @PostMapping("/single")
    public Result insert() {
        return Result.success(threadPoolService.insert());
    }

    @PostMapping("/pool")
    public Result insertThreadPool() {
        return Result.success(threadPoolService.insertThreadPool());
    }
}
