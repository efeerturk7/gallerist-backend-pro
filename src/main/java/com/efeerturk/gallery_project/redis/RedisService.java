package com.efeerturk.gallery_project.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class RedisService {
    private final RedisTemplate<String,Object>redisTemplate;
    public void save(String key,Object value){
        redisTemplate.opsForValue()
                .set(key,value);
    }
    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }
    public void delete(String key){
        redisTemplate.delete(key);
    }
    public void saveWithTimeout(String key,Object value,Long timeoutInMinutes){
        redisTemplate.opsForValue()
                .set(key,value, Duration.ofMinutes(timeoutInMinutes));
    }
    public void addToList(String key,Object value){
        redisTemplate.opsForList().rightPush(key,value);
    }
    public List<Object>getListMembers(String key){
        return redisTemplate.opsForList().range(key,0,-1);
    }
    public void addToSet(String key,Object value){
        redisTemplate.opsForSet().add(key,value);
    }
    public Set<Object>getSetMembers(String key){
        return redisTemplate.opsForSet().members(key);
    }
    public void saveToHash(String key,String field,Object value){
        redisTemplate.opsForHash().put(key,field,value);
    }
    public Object getFromHash(String key,String field){
        return redisTemplate.opsForHash().get(key,field);
    }
    public Map<Object,Object>getAllHash(String key){
        return redisTemplate.opsForHash().entries(key);
    }
    public void deleteFromHash(String key,String field){
        redisTemplate.opsForHash().delete(key,field);
    }
    public void addTOSortedSet(String key,Object value,double score){
        redisTemplate.opsForZSet().add(key, value, score);
    }
    public Double incrementScore(String key,Object value,double delta){
        return redisTemplate.opsForZSet().incrementScore(key, value, delta);
    }
    public Set<Object>getTopList(String key,long start,long end){
        return redisTemplate.opsForZSet().reverseRange(key, start, end);
    }
    public void publish(String channel,String message){
        redisTemplate.convertAndSend(channel,message);
    }
}
