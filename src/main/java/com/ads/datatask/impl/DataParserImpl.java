package com.ads.datatask.impl;

import com.ads.common.redis.RedisDataSource;
import com.ads.common.util.UUIDUtils;
import com.ads.datatask.DataParser;
import com.ads.entity.Price;
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

import java.math.BigDecimal;
import java.sql.Timestamp;
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
            shardedJedis.hmset("sinaForex", itemMap);
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
        JSONObject data = (JSONObject) dataJsonObject.get("data");
        JSONArray marketCoins = data.getJSONArray("tickers");
        Map<String, String> resultMap = new HashMap<>(16);
        
        Map<String, Object> BTCUSD = (Map<String, Object>) marketCoins.get(12);
        String forexPrice1 = BTCUSD.get("last").toString();
        resultMap.put("BTCUSD", forexPrice1.toString());
        Map<String, Object> BTCJPY = (Map<String, Object>) marketCoins.get(7);
        String forexPrice2 = BTCUSD.get("last").toString();
        resultMap.put("BTCJPY", forexPrice2.toString());
        Map<String, Object> BTCUSDT = (Map<String, Object>) marketCoins.get(3);
        String forexPrice3 = BTCUSDT.get("last").toString();
        resultMap.put("BTCUSDT", forexPrice3.toString());
    
        System.out.println(resultMap);
        shardedJedis.hmset("bikanBTC", resultMap);
        redisDataSource.returnResource(shardedJedis);
    }
    
    /**
     * 外汇通 数据解析
     * @param content
     */
    @Override
    public void parseZhongfuMarket(String content) {
    
    }
    
    /**
     * 外汇通 数据解析
     */
    @Override
    public void parserWaiHuiTong(String content) {
        JSONObject dataJsonObject = JSON.parseObject(content);
    
        JSONArray dataList = dataJsonObject.getJSONArray("list");
        List<Price> list = new ArrayList<>();
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        for (Object entry : dataList) {
            Map<String, String> forex = (Map<String, String>)entry;
            
            Price price = new Price();
            price.setId(UUIDUtils.getUUID());
            price.setSymbolCode(forex.get("symbolCode"));
            price.setSymbolId(forex.get("symbolId"));
            price.setSymbolName((String) forex.get("symbolName"));
            price.setClose(new BigDecimal(forex.get("close")));
            price.setOpen(new BigDecimal(forex.get("open")));
            price.setLow(new BigDecimal(forex.get("low")));
            price.setHigh(new BigDecimal(forex.get("high")));
            price.setPltd(new BigDecimal(forex.get("pltd")));
            price.setRatio(new BigDecimal(forex.get("ratio")));
            price.setBuyPrice(new BigDecimal(forex.get("buyPrice")));
            price.setSellPrice(new BigDecimal(forex.get("sellPrice")));
            price.setCreatedTime(new Timestamp(System.currentTimeMillis()));
            price.setFromAddress("外汇通");
            price.setFromName("外汇通");
            
//            shardedJedis.hmset(forex.get("symbolCode"), forex);
//            shardedJedis.hmget(forex.get("symbolCode"));
            list.add(price);
        }
        
//        priceService.addBatch(list);
    }
    
  
    
    
}
