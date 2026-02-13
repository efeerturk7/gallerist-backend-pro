package com.efeerturk.gallery_project.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/redis")
@RequiredArgsConstructor
public class RedisTestController {
    private final RedisService redisService;
    @PostMapping("/set")
    public String set(@RequestParam String key,@RequestParam String value){
        redisService.save(key,value);
        return "Successful Key :"+key+" Value : "+value;
    }
    @PostMapping("/setTtl")
    public String setWithTtl(@RequestParam String key,@RequestParam String value,Long time){
        redisService.saveWithTimeout(key,value,time);
        return "Successful Key : "+key+" Value : "+value+" Expired Time : "+time;
    }
    @GetMapping("/get")
    public Object get(@RequestParam String key){
        Object value=redisService.get(key);
        return (value!=null?value:"Not Found Data or Expired time");
    }
    @PostMapping("/list-add")
    public String addToList(@RequestParam String key,@RequestParam String value){
        redisService.addToList(key,value);
        return "Add List :"+value;
    }
    @GetMapping("/list-get")
    public List<Object> getList(@RequestParam String key){
        return redisService.getListMembers(key);
    }
    @PostMapping("/set-add")
    public String addToSet(@RequestParam String key,@RequestParam String value){
        redisService.addToSet(key,value);
        return "Add to Set : "+value;
    }
    @GetMapping("/set-get/{key}")
    public Set<Object>getSet(@PathVariable(name = "key") String key){
        return redisService.getSetMembers(key);
    }
    @PostMapping("/save-hash")
    public String saveToHash(@RequestParam String key,@RequestParam String field,@RequestParam Object value){
        redisService.saveToHash(key,field,value);
        return "succesfull";

    }
    @GetMapping("/hash-get")
    public Object getFromHash(@RequestParam String key,@RequestParam String field){
        return redisService.getFromHash(key, field);
    }
    @GetMapping("/getAllHash/{key}")
    public Map<Object,Object> getAllHash(@PathVariable (name = "key") String key){
        return redisService.getAllHash(key);
    }
    @DeleteMapping("/delete")
    public String deleteFromHash(@RequestParam String key,@RequestParam String field){
        redisService.deleteFromHash(key, field);
        return "successful";
    }
    public String publishMessage(@RequestParam String message){
        redisService.publish("gallerist-kanal",message);
        return "The message published : "+message;
    }


}
