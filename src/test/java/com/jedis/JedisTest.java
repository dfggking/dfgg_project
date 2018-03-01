package com.jedis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2018/3/1
 */
public class JedisTest {
    
    public static void main(String[] args) {
        // 连接本地Redis服务
        Jedis jedis = new Jedis("localhost");
//        System.out.println(jedis.ping());
//        jedis.set("dfgg", "king22");
//        String result = jedis.get("dfgg");
//        System.out.println(result);
    
//        jedis.lpush("list1", "a", "b", "c");
//
//        List<String> list = jedis.lrange("list1", 0, 2);
//        for (String s : list) {
//            System.out.println(s);
//        }
        
    }
}
