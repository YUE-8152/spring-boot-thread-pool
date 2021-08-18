package com.yue.threadpool.controller.test;

import com.yue.threadpool.common.core.Result;
import com.yue.threadpool.service.SysUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/test")
public class TestController {
    @DubboReference
    private SysUserService sysUserService;

    @GetMapping("/list")
    public Result selectList(){
        return Result.success(sysUserService.selectList());
    }
}
