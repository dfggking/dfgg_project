package com.ads.controller;

import com.ads.common.base.BaseController;
import com.ads.common.redis.RedisDataSource;
import com.ads.service.ForexService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.ShardedJedis;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据采集API
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
    
    public final static String GD11X5_SERVER = "gd11x5";
    public final static String LN11X5_SERVER = "ln11x5";
    public final static String JX11X5_SERVER = "jx11x5";
    public final static String CQSSC_SERVER = "cqssc";
    public final static String JL11X5_SERVER = "jl11x5";
    
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
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = redisDataSource.getRedisClient();
            resultMap.put(STATUS, "1");
            resultMap.put(RESULT_DATA, shardedJedis.hgetAll("sinaForex_new"));
            redisDataSource.returnResource(shardedJedis);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultMap;
    }
    
    @RequestMapping(value = BIKAN_BTC_SERVER)
    @ResponseBody
    public Map<String, Object> bikanBtc(){
        Map<String, Object> resultMap = new HashMap<>(16);
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = redisDataSource.getRedisClient();
            resultMap.put(STATUS, "1");
            resultMap.put(RESULT_DATA, shardedJedis.hgetAll("bikanBTC_new"));
            redisDataSource.returnResource(shardedJedis);
        }catch (Exception e){
            e.printStackTrace();
        }
       
        return resultMap;
    }
    
    @RequestMapping(value = GD11X5_SERVER)
    @ResponseBody
    public Map<String, Object> gd11x5(){
        Map<String, Object> resultMap = new HashMap<>(16);
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = redisDataSource.getRedisClient();
            resultMap.put("code", "gd11x5_new");
            resultMap.put("data", shardedJedis.hgetAll("gd11x5_new").get("data"));
            redisDataSource.returnResource(shardedJedis);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultMap;
    }
    
    @RequestMapping(value = LN11X5_SERVER)
    @ResponseBody
    public Map<String, Object> ln11x5(){
        Map<String, Object> resultMap = new HashMap<>(16);
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = redisDataSource.getRedisClient();
            resultMap.put("code", "ln11x5_new");
            resultMap.put("data", shardedJedis.hgetAll("ln11x5_new").get("data"));
            redisDataSource.returnResource(shardedJedis);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultMap;
    }
    
    @RequestMapping(value = JX11X5_SERVER)
    @ResponseBody
    public Map<String, Object> jx11x5(){
        Map<String, Object> resultMap = new HashMap<>(16);
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = redisDataSource.getRedisClient();
            resultMap.put("code", "jx11x5_new");
            resultMap.put("data", shardedJedis.hgetAll("jx11x5_new").get("data"));
            redisDataSource.returnResource(shardedJedis);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultMap;
    }
    
    @RequestMapping(value = CQSSC_SERVER)
    @ResponseBody
    public Map<String, Object> cqssc(){
        Map<String, Object> resultMap = new HashMap<>(16);
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = redisDataSource.getRedisClient();
            resultMap.put("code", "cqssc_new");
            resultMap.put("data", shardedJedis.hgetAll("cqssc_new").get("data"));
            redisDataSource.returnResource(shardedJedis);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultMap;
    }
    
    @RequestMapping(value = JL11X5_SERVER)
    @ResponseBody
    public Map<String, Object> jl11x5(){
        Map<String, Object> resultMap = new HashMap<>(16);
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = redisDataSource.getRedisClient();
            resultMap.put("code", "jl11x5_new");
            resultMap.put("data", shardedJedis.hgetAll("jl11x5_new").get("data"));
            redisDataSource.returnResource(shardedJedis);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultMap;
    }
    
    
}
