package com.xfdmao.fcat.user;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * ${DESCRIPTION}
 *
 * @author xiangfei
 * @create 2017-05-25 12:44
 */
@SpringBootApplication
@ServletComponentScan("com.xfdmao.fcat.user.config.druid")
@EnableEurekaClient
@EnableDiscoveryClient  //激活eureka中的DiscoveryClient实现
@EnableAsync
@EnableRedisHttpSession(redisFlushMode = RedisFlushMode.IMMEDIATE)
@EnableCaching
public class UserBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(UserBootstrap.class).web(true).run(args);    }
}
 