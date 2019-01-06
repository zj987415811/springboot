package com.example.demo.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.io.UnsupportedEncodingException;

/**
 * Created by zhoujin on  2018-12-28
 **/

public class MyRedisChannelListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] channel = message.getChannel();
        byte[] bs = message.getBody();
        try{
            String content = new String(bs,"UTF-8");
            String p = new String(channel,"UTF-8");
            System.out.println("get "+content+" from "+ p);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    @Bean
    MessageListenerAdapter listenerAdapter() {
        return new MessageListenerAdapter(new MyRedisChannelListener());
    }
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter,new PatternTopic("new.*"));
        return container;
    }
}
