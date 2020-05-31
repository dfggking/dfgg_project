package com.ads.datatask.impl;

import com.ads.common.redis.RedisDataSource;
import com.ads.datatask.DataParser;
import com.ads.service.PriceService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;

import java.util.*;

/**
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/14
 */
@Service
public class DataParserImpl implements DataParser {

    private final static Logger LOGGER = LogManager.getLogger(DataParserImpl.class);
    
    @Autowired
    private RedisDataSource redisDataSource;
    @Autowired
    private PriceService priceService;
    
    /**
     * 解析sina采集的数据
     * @param result
     */
    @Override
    public void parseSina(String result) {
        // 去掉最后一个因split而生成的空字符串
        String semicolon = result.substring(result.length() - 2, result.length() - 1);
        String semicolonType = ";";
        if (Objects.equals(semicolonType, semicolon)) {
            String[] items = result.substring(0, result.length() - 1).split(";");
            String[] dataItems = Arrays.copyOf(items, items.length - 1);
            Map<String, String> itemMap = new HashMap(16);
            ShardedJedis shardedJedis = redisDataSource.getRedisClient();
            for (String item : dataItems) {
//                System.out.println(item);
                String itemA = item.substring(12, item.length() - 1);
                String[] itemAArray = itemA.split("=\"");
                // 如果能拆分出key/value才存
                if(itemAArray.length >= 2){
                    String key = itemAArray[0];
                    String value = itemAArray[1];
                    if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
                        String[] element = itemAArray[1].split(",");
                        itemMap.put(itemAArray[0], element[1]);
                    }
                }
            }
            // 入 Redis
            shardedJedis.hmset("sinaForex_new", itemMap);
            redisDataSource.returnResource(shardedJedis);
            // 入 DB
//            priceService.addBatch();
        }
    }
    
    /**
     * 币看 数据解析
     * @param content 采集内容
     */
    @Override
    public void parserBikan(String content) {
        
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        JSONObject dataJsonObject = JSON.parseObject(content);
        JSONArray data = (JSONArray) dataJsonObject.get("d");
    
        Map<String, String> resultMap = new HashMap<>(16);
        
        JSONObject BTCUSD = (JSONObject) data.get(0);
        JSONObject vObj = (JSONObject) BTCUSD.get("v");
        String forexPrice1 = (String) vObj.get("lp");
        resultMap.put("BTCUSD", forexPrice1.toString());
    
        JSONObject ETHUSD = (JSONObject) data.get(1);
        JSONObject vObj2 = (JSONObject) ETHUSD.get("v");
        String forexPrice2 = (String) vObj2.get("lp");
        resultMap.put("ETHUSD", forexPrice2.toString());
    
        JSONObject LTCUSD = (JSONObject) data.get(2);
        JSONObject vObj3 = (JSONObject) LTCUSD.get("v");
        String forexPrice3 = (String) vObj3.get("lp");
        resultMap.put("LTCUSD", forexPrice3.toString());
    
    
        JSONObject BCHBTC = (JSONObject) data.get(4);
        JSONObject vObj4 = (JSONObject) BCHBTC.get("v");
        String forexPrice4 = (String) vObj4.get("lp");
        resultMap.put("BCHBTC", forexPrice4.toString());
    
        System.out.println(resultMap);
        shardedJedis.hmset("bikanBTC_new", resultMap);
        redisDataSource.returnResource(shardedJedis);
    }
    
    /**
     * 原始数据格式：{"errorCode":0,"message":"操作成功","result":{"businessCode":0,"message":"操作成功","data":[{"preDrawCode":"06,02,11,05,07","groupCode":6,"preDrawTime":"2019-03-17 11:50:30","preDrawIssue":2019031708,"sumNum":31,"sumBigSmall":0,"sumSingleDouble":0,"behindThree":0,"betweenThree":0,"dragonTiger":1,"lastThree":0},{"preDrawCode":"08,11,01,09,06","groupCode":6,"preDrawTime":"2019-03-17 11:30:30","preDrawIssue":2019031707,"sumNum":35,"sumBigSmall":0,"sumSingleDouble":0,"behindThree":0,"betweenThree":0,"dragonTiger":0,"lastThree":0},{"preDrawCode":"09,11,03,06,02","groupCode":6,"preDrawTime":"2019-03-17 11:10:30","preDrawIssue":2019031706,"sumNum":31,"sumBigSmall":0,"sumSingleDouble":0,"behindThree":0,"betweenThree":0,"dragonTiger":0,"lastThree":1},{"preDrawCode":"07,11,06,04,03","groupCode":6,"preDrawTime":"2019-03-17 10:50:30","preDrawIssue":2019031705,"sumNum":31,"sumBigSmall":0,"sumSingleDouble":0,"behindThree":1,"betweenThree":0,"dragonTiger":0,"lastThree":1},{"preDrawCode":"07,09,03,02,08","groupCode":6,"preDrawTime":"2019-03-17 10:30:30","preDrawIssue":2019031704,"sumNum":29,"sumBigSmall":1,"sumSingleDouble":0,"behindThree":0,"betweenThree":1,"dragonTiger":1,"lastThree":1},{"preDrawCode":"04,02,06,08,03","groupCode":6,"preDrawTime":"2019-03-17 10:10:30","preDrawIssue":2019031703,"sumNum":23,"sumBigSmall":1,"sumSingleDouble":0,"behindThree":0,"betweenThree":0,"dragonTiger":0,"lastThree":0},{"preDrawCode":"11,03,07,06,02","groupCode":6,"preDrawTime":"2019-03-17 09:50:30","preDrawIssue":2019031702,"sumNum":29,"sumBigSmall":1,"sumSingleDouble":0,"behindThree":0,"betweenThree":1,"dragonTiger":0,"lastThree":1},{"preDrawCode":"06,07,03,08,05","groupCode":6,"preDrawTime":"2019-03-17 09:30:30","preDrawIssue":2019031701,"sumNum":29,"sumBigSmall":1,"sumSingleDouble":0,"behindThree":1,"betweenThree":1,"dragonTiger":0,"lastThree":0}]}}
     * @param content
     */
    @Override
    public void parserGd11x5(String content) {
        Map<String, String> resultMap = parseCai(content);
        System.out.println(resultMap);
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        shardedJedis.hmset("gd11x5_new", resultMap);
        redisDataSource.returnResource(shardedJedis);
    }
    
    @Override
    public void parserLn11x5(String jsonLn11x5) {
        Map<String, String> resultMap = parseCai(jsonLn11x5);
        System.out.println(resultMap);
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
    
        shardedJedis.hmset("ln11x5_new", resultMap);
        redisDataSource.returnResource(shardedJedis);
    }
    
    @Override
    public void parserJx11x5(String jsonJx11x5) {
        Map<String, String> resultMap = parseCai(jsonJx11x5);
        System.out.println(resultMap);
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
    
        shardedJedis.hmset("jx11x5_new", resultMap);
        redisDataSource.returnResource(shardedJedis);
    }
    
    @Override
    public void parserCqssc(String jsonCqssc) {
        Map<String, String> resultMap = parseCai(jsonCqssc);
        System.out.println(resultMap);
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
    
        shardedJedis.hmset("cqssc_new", resultMap);
        redisDataSource.returnResource(shardedJedis);
    }
    
    @Override
    public void parserJl11x5(String jsonJl11x5) {
        Map<String, String> resultMap = parseCai(jsonJl11x5);
        System.out.println(resultMap);
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
    
        shardedJedis.hmset("jl11x5_new", resultMap);
        redisDataSource.returnResource(shardedJedis);
    }
    
    
    private Map<String, String> parseCai(String content){
        JSONObject originJson = JSON.parseObject(content);
        JSONObject resultJson = (JSONObject) originJson.get("result");
        JSONArray dateArray = (JSONArray) resultJson.get("data");
    
        // 返回值
        Map<String, String> resultMap = new HashMap<>(16);
        List<JSONObject> dataList = new ArrayList();
        for (Object obj:dateArray) {
            JSONObject item = (JSONObject) obj;
            JSONObject data = new JSONObject();
            data.put("expect", "20" + item.get("preDrawIssue").toString()); // 期数
            data.put("opencode", item.get("preDrawCode").toString()); // 开奖号码
            data.put("opentime", item.get("preDrawTime").toString());
            dataList.add(data);
        }
        resultMap.put("data", dataList.toString());
    
        return resultMap;
    }
}
