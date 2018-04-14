package com.ads.common.redis.impl;

import com.ads.common.redis.RedisDataSource;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;


/**
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2018/3/25
 */
@Repository("redisDataSource")
public class RedisDataSourceImpl implements RedisDataSource {
    private final static Logger LOGGER = LogManager.getLogger(RedisDataSource.class);
    
    @Autowired
    private ShardedJedisPool shardedJedisPool;
    
    /**
     * 获取Redis实例
     * @return ShardedJedis
     */
    @Override
    public ShardedJedis getRedisClient() {
        ShardedJedis shardedJedis = shardedJedisPool.getResource();
        return shardedJedis;
    }
    
    /**
     * 回收
     *
     * @param shardedJedis
     */
    @Override
    public void returnResource(ShardedJedis shardedJedis) {
        shardedJedis.close();
    }
    
    /**
     * 回收
     *
     * @param shardedJedis
     * @param broken
     */
    @Override
    public void returnResource(ShardedJedis shardedJedis, boolean broken) {
        shardedJedis.close();
    }
    
    
}
