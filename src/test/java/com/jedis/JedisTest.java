package com.jedis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.List;

/**
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2018/3/1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JedisTest {

    @Autowired
    private ShardedJedisPool shardedJedisPool;
    
    @Test
    public void getRedisClient(){
    
        ShardedJedis shardedJedis = shardedJedisPool.getResource();
//        System.out.println(shardedJedis.get("dfgg"));
    
    }
    
//    public static void main(String[] args) {
//        // 连接本地Redis服务
//        Jedis jedis = new Jedis("localhost");
//        System.out.println(jedis.ping());
//        jedis.set("dfgg", "king22");
//        String result = jedis.get("dfgg");
//        System.out.println(result);
//
//        jedis.lpush("list1", "a", "b", "c");
//
//        List<String> list = jedis.lrange("list1", 0, 2);
//        for (String s : list) {
//            System.out.println(s);
//        }
//    }
}
