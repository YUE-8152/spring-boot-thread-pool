package com.yue.threadpool.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ProjectName: cln-school-app
 * @Package: com.cln.cash.base.common.config
 * @ClassName: ThreadPoolConfig
 * @Author: YUE
 * @Description:
 * @Date: 2021/8/18 14:23
 * @Version: 1.0
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(8);
        executor.setMaxPoolSize(10);
        executor.setKeepAliveSeconds(120);
        executor.setQueueCapacity(1000);
        executor.setThreadNamePrefix("SPRING-BOOT-THREAD-POOL-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
