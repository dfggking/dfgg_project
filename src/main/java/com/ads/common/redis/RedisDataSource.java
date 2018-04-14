package com.ads.common.redis;

import redis.clients.jedis.ShardedJedis;

/**
 * redis资源类
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2018/3/25
 */
public interface RedisDataSource {
    /**
     * 获取Redis实例
     * @return ShardedJedis
     */
    ShardedJedis getRedisClient();
    
    /**
     * 回收
     * @param shardedJedis
     */
    void returnResource(ShardedJedis shardedJedis);
    
    /**
     * 回收
     * @param shardedJedis
     * @param broken
     */
    void returnResource(ShardedJedis shardedJedis, boolean broken);
}
