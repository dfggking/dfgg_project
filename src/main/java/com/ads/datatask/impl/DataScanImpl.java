package com.ads.datatask.impl;

import com.ads.common.http.HttpClientUtil;
import com.ads.common.http.HttpResult;
import com.ads.datatask.DataParser;
import com.ads.datatask.DataScan;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * 数据采集实现类
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/14
 */
@Service
public class DataScanImpl implements DataScan {
    private final static Logger LOGGER = LogManager.getLogger(DataScanImpl.class);
    @Autowired
    private HttpClientUtil httpUtil;
    @Autowired
    private DataParser dataParser;
    @Autowired
    private CacheManager cacheManager;
    
    /**
     * 中福ADS 数据采集接口
     * url http://market.forex.com.cn/zhongfuMarketIndex/findAllPriceAjax.do
     */
    @Override
    public String zhongfuMarketDataScan() {
        try {
            HttpResult httpResult = httpUtil.doPost("http://market.forex.com.cn/zhongfuMarketIndex/findAllPriceAjax.do");
            int statusCode = 200;
            if (Objects.equals(statusCode, httpResult.getStatusCode())) {
                String resultJson = httpResult.getContent();
                LOGGER.info("zhongfuMarketDataScan采集正常");
                
                return resultJson;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "接口异常";
    }
    
    /**
     * http://market.forex.com.cn/zhongfuMarketIndex/ajaxTable.do?classifyId=001
     */
    @Override
    public void zhongfuDataScan() {
        try {
            HttpResult httpResult = httpUtil.doPost("http://market.forex.com.cn/zhongfuMarketIndex/ajaxTable.do?classifyId=001");
            int statusCode = 200;
            if (Objects.equals(statusCode, httpResult.getStatusCode())) {
                String resultJson = httpResult.getContent();
                dataParser.parserWaiHuiTong(resultJson);
                LOGGER.info("zhongfuDataScan采集正常");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * website http://bitkan.com/price/
     * url http://bitkan.com/price/w_price?categoryId=***
     */
    @Override
    public List<Map<String, Object>> bitkanDataScan() {
        try {
            /*
             * 待采集币种
             */
            String[] btcs = new String[]{"btc", "ltc", "etc"};
            List<Map<String, Object>> result = new ArrayList<>();
            
            String param1 = "{\"categoryId\":\"btc\"}";
            HttpResult httpResult1 = httpUtil.doPostJson("http://bitkan.com/price/w_price", param1);
            int statusCode1 = 200;
            if (Objects.equals(statusCode1, httpResult1.getStatusCode())) {
                String resultJson = httpResult1.getContent();
                result.add(dataParser.parserBikan("btc", resultJson, 37));
            }
            String param2 = "{\"categoryId\":\"ltc\"}";
            HttpResult httpResult2 = httpUtil.doPostJson("http://bitkan.com/price/w_price", param2);
            int statusCode2 = 200;
            if (Objects.equals(statusCode2, httpResult2.getStatusCode())) {
                String resultJson = httpResult2.getContent();
                result.add(dataParser.parserBikan("ltc", resultJson, 31));
            }
            String param3 = "{\"categoryId\":\"etc\"}";
            HttpResult httpResult3 = httpUtil.doPostJson("http://bitkan.com/price/w_price", param3);
            int statusCode = 200;
            if (Objects.equals(statusCode, httpResult3.getStatusCode())) {
                String resultJson = httpResult3.getContent();
                result.add(dataParser.parserBikan("etc", resultJson, 29));
            }
            LOGGER.info("parserBikan采集正常");
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
