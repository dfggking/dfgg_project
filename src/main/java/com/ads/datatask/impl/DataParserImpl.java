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
        shardedJedis.hmset("bikanBTC", resultMap);
        redisDataSource.returnResource(shardedJedis);
    }

    
  
    
    
}
