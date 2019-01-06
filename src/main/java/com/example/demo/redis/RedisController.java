package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
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
    public @ResponseBody
    String env(String para) {
        redisClient.opsForValue().set("testenv", para);
        String redisStr = redisClient.opsForValue().get("testenv");
        return redisStr;
    }
    @RequestMapping("/connectionset.html")
    public @ResponseBody String connectionSet(final String key, final String value) {
        redisClient.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.set(key.getBytes(),value.getBytes());
                return null;
            }
        });
        return "success";
    }

}
