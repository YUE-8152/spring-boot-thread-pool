package com.yue.threadpool.common.config;

import com.yue.threadpool.common.interceptor.TokenInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @ProjectName: wx-mp-base
 * @Package: com.yx.mp.base.common.config
 * @ClassName: WebMvcConfig
 * @Author: YUE
 * @Description:
 * @Date: 2021/4/21 18:59
 * @Version: 1.0
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    private final Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);
    @Autowired
    private TokenInterceptor tokenInterceptor;

    //解决跨域问题
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600 * 24);
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .excludePathPatterns("/yx/mp/**");//排除路径
    }

    // 添加静态资源文件，外部可以直接访问地址
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
