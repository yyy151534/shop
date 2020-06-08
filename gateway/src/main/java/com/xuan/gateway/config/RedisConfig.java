package com.xuan.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Objects;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate redisTemplate (RedisTemplate<String, String> template) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(Objects.requireNonNull(template.getConnectionFactory()));
        return redisTemplate;
    }
}
