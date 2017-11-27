package com.xfdmao.fcat.gate.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.ConfigureRedisAction;

/**
 * Created by xiangfei on 2017/10/16.
 */
@Configuration
public class SessionConfig {
     @Bean
    public   ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }
}
