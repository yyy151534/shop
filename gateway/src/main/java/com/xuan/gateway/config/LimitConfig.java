package com.xuan.gateway.config;


import com.xuan.gateway.resolver.HostAddrKeyResolver;
import com.xuan.gateway.resolver.UriKeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LimitConfig {

    /**
     *根据主机去限流使用
     * @return
     */
//    @Bean
//    public HostAddrKeyResolver hostAddrKeyResolver() {
//        return new HostAddrKeyResolver();
//    }

    /**
     *根据uri去限流使用
     * @return
     */
    @Bean
    public UriKeyResolver uriKeyResolver() {
        return new UriKeyResolver();
    }
}
