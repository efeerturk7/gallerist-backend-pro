package com.efeerturk.gallery_project.redis;

import org.jspecify.annotations.Nullable;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class RedisMessageSubscriber implements MessageListener {
    @Override
    public void onMessage(Message message, byte @Nullable [] pattern) {
        String incomingMessage=new String(message.getBody());
        System.out.println("Incoming message : "+incomingMessage);

    }
}
