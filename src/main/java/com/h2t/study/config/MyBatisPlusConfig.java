package com.h2t.study.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * mybatis plus配置类
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/08/02 16:11
 */
@Configuration
@Component
public class MyBatisPlusConfig {
    /**
     * 性能分析拦截器，观察 SQL 执行情况及执行时长
     */
    @Bean
    @Profile({"dev"})
    public PerformanceInterceptor performanceInterceptor(){

        //启用性能分析插件, SQL是否格式化 默认false,此处开启
        return new PerformanceInterceptor().setFormat(true);
    }

    // mybatis-plus分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
