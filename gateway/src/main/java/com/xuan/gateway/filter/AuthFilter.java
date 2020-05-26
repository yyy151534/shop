package com.xuan.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.xuan.common.enums.ErrorCodeEnum;
import com.xuan.common.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;


/**
 * 权限过滤器
 */
@Slf4j
@Configuration
public class AuthFilter implements GlobalFilter, Order {

    private final String TOKEN = "token";

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 过滤器顺序
     */
    @Override
    public int value() {
        return 1;
    }

    /**
     * 过滤器主逻辑
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        // 获取访问路径
        String url = ((LinkedHashSet<URI>) Objects.requireNonNull(exchange.getAttribute("org.springframework.cloud.gateway.support.ServerWebExchangeUtils.gatewayOriginalRequestUrl")))
                .iterator()
                .next()
                .getPath();
        // 查询是否在忽略列表中
        log.info("gateway path: {}", url);
//        if (SaasConstants.WhiteUri.FILTER_URIS.contains(url)) {
//            return chain.filter(exchange.mutate().request(request).build());
//        }

        // 检查用户header中携带的token
//        HttpHeaders headers = request.getHeaders();
//        List<String> headerValue = headers.get(TOKEN);
//        if (CollectionUtils.isEmpty(headerValue)) {
//            response.setStatusCode(HttpStatus.OK);
//            DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(getResponse(ErrorCodeEnum.TOKEN_NOT_FOUND));
//            exchange.getResponse().getHeaders().set("Content-Type","application/json;charset=UTF-8");
//            return exchange.getResponse().writeWith(Flux.just(buffer));
//            //throw new SaasException(ErrorCode.NO_COOKIE);
//        }
//        // 拿token
//        String token = headerValue.get(0);
//        if (token == null) {
//            response.setStatusCode(HttpStatus.OK);
//            DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(getResponse(ErrorCodeEnum.TOKEN_NOT_FOUND));
//            exchange.getResponse().getHeaders().set("Content-Type","application/json;charset=UTF-8");
//            return exchange.getResponse().writeWith(Flux.just(buffer));
//        }
//
//        LoginCacheVo loginCacheDTO = (LoginCacheVo)redisUtils.get(token);
//        if(loginCacheDTO==null){
//            response.setStatusCode(HttpStatus.OK);
//            DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(getResponse(ErrorCode.LOGIN_TOKEN_ACCESS_TIME_OUT_PLEASE_TRY_RELOGIN));
//            exchange.getResponse().getHeaders().set("Content-Type","application/json;charset=UTF-8");
//            return exchange.getResponse().writeWith(Flux.just(buffer));
//        }
        // 权限校验暂时未做
//        if(!DataSourceConstants.Name.PLATFORM_DATA_SOURCE.equals(TenantUtils.getTenant())){
//
//            //判断权限 按钮权限时才能做到控制权限
//            AuthUtils.setCurrentUser(loginCacheDTO);
//            if(!loginCacheDTO.getUrls().contains(url)){
//                throw new SaasException(ErrorCode.UNAUHORIZATION);
//            }
//        }
        // 校验通过，放行
        return chain.filter(exchange.mutate().request(request).build());
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    private byte[] getResponse(ErrorCodeEnum errorCodeEnum){
        Map<String, String> map = new HashMap<>();
        map.put("code", errorCodeEnum.getCode()+"");
        map.put("msg", errorCodeEnum.getMsg());
        byte[] bytes = JSON.toJSONString(map).getBytes(StandardCharsets.UTF_8);
        return bytes;
    }
}
