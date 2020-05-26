package com.xuan.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedisUtils
 * @Description redis
 * @Author xuan
 * @Date 2019/7/29 15:45
 **/
@Slf4j
@Component
public class RedisUtils {
    @Autowired
    public RedisTemplate<String, Object> redisTemplate;

    /**
     * @Author xuan
     * @Description 加分布式锁
     * @Date 2019/7/30 9:10
     * @Param [lockName, expire]
     * @return long
     **/
    public long getLock(final String lockName, final long expire) {
        Boolean obj = null;
        try{
            obj = redisTemplate.execute((RedisConnection connection) -> {
                byte[] lockBytes = lockName.getBytes();
                Boolean locked = connection.set(lockBytes, lockBytes, Expiration.seconds(expire), RedisStringCommands.SetOption.SET_IF_ABSENT);
                connection.close();
                return locked;
            });
        }catch (Exception e) {
            log.error("setNX redis error, key:{}, err:{}", lockName, e.getLocalizedMessage());
        }
        return obj != null && obj ? 1L : 0L;
    }

    /**
     * @Author xuan
     * @Description 解锁
     * @Date 2019/7/30 9:11
     * @Param [lockName]
     * @return void
     **/
    public void unLock(String lockName) {
        try {
            this.delete(lockName);
        } catch (Exception e) {
            log.info("解锁异常,锁名称为：{}",lockName);
            log.info(e.getMessage());
        }
    }

    public long delete(final String key) {
        long obj = 0L;
        try {
            obj = Optional.ofNullable(redisTemplate.execute((RedisConnection connection) -> {
                Long del = connection.del(key.getBytes());
                connection.close();
                return del;
            })).orElse(0L);
        }catch (Exception e) {
            log.info(e.getMessage());
        }
        return obj;
    }

    public long hdelete(String key,String hashKey){
        long obj = 0L;
        try {
            obj = Optional.ofNullable(redisTemplate.execute((RedisConnection connection) -> {
                Long del = connection.hDel(key.getBytes(),hashKey.getBytes());
                connection.close();
                return del;
            })).orElse(0L);
        }catch (Exception e) {
            log.info(e.getMessage());
        }
        return obj;
    }

    /**
     * @Author xuan
     * @Description 存放对象到redis
     * @Date 2019/7/30 9:11
     * @Param [key, value]
     * @return long
     **/
    public long set(String key, Object value) {
        Boolean obj = null;
        try{
            obj = redisTemplate.execute((RedisConnection connection) -> {
                final byte[] byteKey = redisTemplate.getStringSerializer().serialize(key);
                Boolean flag = connection.set(byteKey, Byte2ObjectUtils.objectToByte(value));
                connection.close();
                return flag;
            });
        }catch (Exception e) {
            log.info(e.getMessage());
        }
        return obj != null && obj ? 1L : 0L;
    }

    public long hset(String key,String hashKey,Object value,long time){
        Boolean obj = null;
        Byte2ObjectUtils.objectToByte(value);
        try{
            obj=redisTemplate.execute((RedisConnection connection)->{
                byte[] keyByte=redisTemplate.getStringSerializer().serialize(key);
                byte[] hashKeyByte=redisTemplate.getStringSerializer().serialize(hashKey);
                Boolean flag=connection.hSet(keyByte,hashKeyByte,Byte2ObjectUtils.objectToByte(value));
                return flag;
            });

        }catch (Exception e) {
            e.printStackTrace();
        }
        return obj != null && obj ? 1L : 0L;
    }


    public boolean expire(String key,long time){
        try {
            if(time>0){
                return redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * @Author xuan
     * @Description time为秒
     **/
    public long set(String key, Object value, Long time) {
        Boolean obj = null;
        try{
            obj = redisTemplate.execute((RedisConnection connection) -> {
                final byte[] byteKey = redisTemplate.getStringSerializer().serialize(key);
                Boolean flag = connection.set(byteKey, Byte2ObjectUtils.objectToByte(value), Expiration.seconds(time), RedisStringCommands.SetOption.SET_IF_ABSENT);
                connection.close();
                return flag;
            });
        }catch (Exception e) {
            log.info(e.getMessage());
        }
        return obj != null && obj ? 1L : 0L;
    }
    /**
     * @Author xuan
     * @Description 通过key获取redis中的对象
     * @Date 2019/7/30 9:12
     * @Param [key]
     * @return java.lang.Object
     **/
    public Object get(String key) {
        try{
            final byte[] redisKey = redisTemplate.getStringSerializer().serialize(key);
            return redisTemplate.execute((RedisConnection connection) -> {
                byte[] listValue = connection.get(redisKey);
                Object obj = null;
                if (listValue != null) {
                    obj = Byte2ObjectUtils.byteToObject(listValue);
                }
                return obj;
            });
        }catch (Exception e) {
            log.info(e.getMessage());
        }
        return null;
    }

    public Object hget(String key,String hashKey){
        try{
            final byte[] redisKey = redisTemplate.getStringSerializer().serialize(key);
            final byte[] redisHashKey = redisTemplate.getStringSerializer().serialize(hashKey);
            return redisTemplate.execute((RedisConnection connection) -> {
                byte[] listValue = connection.hGet(redisKey,redisHashKey);
                Object obj = null;
                if (listValue != null) {
                    obj = Byte2ObjectUtils.byteToObject(listValue);
                }
                return obj;
            });
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
