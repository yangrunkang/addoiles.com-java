package com.addoiles.db.redis.sub;


import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

/**
 * Description: redis
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/18 17:48
 */
@Service
public class RedisSub implements MessageListener{

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("channel:" + new String(message.getChannel()) + ",message:" + new String(message.getBody()) + ",pattern" + new String(pattern));
    }


}
