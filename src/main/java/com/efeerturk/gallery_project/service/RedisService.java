package com.efeerturk.gallery_project.service;


import com.efeerturk.gallery_project.enums.MessageType;
import com.efeerturk.gallery_project.exception.BaseException;
import com.efeerturk.gallery_project.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.time.Duration;


@Service
@RequiredArgsConstructor
@Slf4j
public class RedisService {
    private final RedisTemplate<String,Object>redisTemplate;
    private final ObjectMapper objectMapper;
    public void setValue(String key, Object value,long timeoutCache){
        try {
            String jsonValue=objectMapper.writeValueAsString(value);
            redisTemplate.opsForValue().set(key,jsonValue, Duration.ofMinutes(timeoutCache));
            log.info("It was written to Redis {}",key);
        }catch (Exception e){
            log.error("redis write error details : {}",e.getMessage());
            throw new BaseException(new ErrorMessage(MessageType.REDIS_WRITE_ERROR,key.toString()));
        }
    }
    public <T> T getValue(String key, TypeReference<T>typeReference){
        try{
            Object rValue=redisTemplate.opsForValue().get(key);
            if (rValue!=null){
                return objectMapper.readValue(rValue.toString(),typeReference);
            }else {
                return null;
            }
        }catch (Exception e){
            log.error("redis read error details : {}",e.getMessage());
            throw new BaseException(new ErrorMessage(MessageType.REDIS_READ_ERROR,key.toString()));
        }
    }
    public void deleteValue(String key){
        try {
            redisTemplate.delete(key);
            log.info("deleted from Redis : {}",key);
        }catch (Exception e){
            log.error("redis delete error details : {}",e.getMessage());
            throw new BaseException(new ErrorMessage(MessageType.REDIS_DELETE_ERROR,key.toString()));
        }
    }
}
