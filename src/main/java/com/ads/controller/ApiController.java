package com.ads.controller;

import com.ads.common.base.BaseController;
import com.ads.common.redis.RedisDataSource;
import com.ads.datatask.DataScan;
import com.ads.service.ForexService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.ShardedJedis;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

/**
 * 外汇API接口
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2018/2/27
 */
@Controller
@RequestMapping(value = "api")
public class ApiController extends BaseController {
    
    private final static Logger LOGGER = LogManager.getLogger(ApiController.class);
    
    /**
     * 来自新浪外汇数据接口
     */
    public final static String SINA_FOREX_SERVER = "sinaForex";
    /**
     * website http://bitkan.com/price/
     */
    public final static String BIKAN_BTC_SERVER = "bitkanBTC";
    
    @Autowired
    private ForexService forexService;
    @Autowired
    private RedisDataSource redisDataSource;
    
    /**
     * 1、来自新浪外汇数据接口
     * @return
     */
    @RequestMapping(value = SINA_FOREX_SERVER)
    @ResponseBody
    public Map<String, Object> sinaforex(){
        Map<String, Object> resultMap = new HashMap<>(16);
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        resultMap.put(STATUS, "1");
        resultMap.put(RESULT_DATA, shardedJedis.hgetAll("sinaForex"));
        return resultMap;
    }
    
    @RequestMapping(value = BIKAN_BTC_SERVER)
    @ResponseBody
    public Map<String, Object> bikanBtc(){
        Map<String, Object> resultMap = new HashMap<>(16);
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        resultMap.put(STATUS, "1");
        resultMap.put(RESULT_DATA, shardedJedis.hgetAll("bikanBTC"));
        return resultMap;
    }
}
