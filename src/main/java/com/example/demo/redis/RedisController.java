package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/strredis")
public class RedisController {
    @Autowired
    private StringRedisTemplate redisClient;
    @RequestMapping("/setget.hmtl")
    public @ResponseBody String env(String para) {
        redisClient.opsForValue().set("testenv",para);
        String redisStr = redisClient.opsForValue().get("testenv");
        return redisStr;
    }
}
