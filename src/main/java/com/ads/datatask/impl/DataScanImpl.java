package com.ads.datatask.impl;

import com.ads.common.http.HttpClientUtil;
import com.ads.common.http.HttpResult;
import com.ads.datatask.DataParser;
import com.ads.datatask.DataScan;
import com.ads.entity.Forex;
import com.ads.service.ForexService;
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
    private ForexService forexService;
    
    
    /**
     * 1、新浪外汇采集器
     * url http://finance.sina.com.cn/forex/
     * get http://hq.sinajs.cn/
     * http://hq.sinajs.cn/?rn=1522557866589&list=USDCNY,USDHKD,EURUSD,GBPUSD,AUDUSD,USDCHF,USDCAD,USDJPY,NZDUSD
     *
     */
    @Override
    public void sinaForex() {
//        String url = "http://hq.sinajs.cn/?list=USDCNY,USDHKD,EURUSD,GBPUSD,AUDUSD,USDCHF,USDCAD,USDJPY,NZDUSD,
// EURJPY,GBPJPY,EURGBP,AUDJPY,EURCAD,EURCHF,CHFJPY,AUDCAD";
        
        List<Forex> forexs = forexService.getAll();
        StringBuffer paramList = new StringBuffer();
        for (Forex forex : forexs) {
            paramList.append(forex.getSymbolCode());
            paramList.append(",");
        }
        paramList.deleteCharAt(paramList.length() - 1);
//        System.out.println(paramList);
        String url = "http://hq.sinajs.cn/?list=" + paramList;
        try {
            String result = httpUtil.doGet(url);
            // 解析数据并持久化到Redis
            dataParser.parseSina(result);
            LOGGER.info("sinaForexDataScan采集正常");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 中福ADS 数据采集接口
     * url http://market.forex.com.cn/zhongfuMarketIndex/findAllPriceAjax.do
     */
    @Override
    public void zhongfuMarket() {
        try {
            HttpResult httpResult = httpUtil.doPost("http://market.forex.com.cn/zhongfuMarketIndex/findAllPriceAjax.do");
            int statusCode = 200;
            if (Objects.equals(statusCode, httpResult.getStatusCode())) {
                String resultJson = httpResult.getContent();
                // 解析数据并持久化到Redis
                dataParser.parseZhongfuMarket(resultJson);
                LOGGER.info("zhongfuMarketDataScan采集正常");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * http://market.forex.com.cn/zhongfuMarketIndex/ajaxTable.do?classifyId=001
     */
    @Override
    public void zhongfu() {
        try {
            HttpResult httpResult = httpUtil.doPost("http://market.forex.com.cn/zhongfuMarketIndex/ajaxTable.do?classifyId=001");
            int statusCode = 200;
            if (Objects.equals(statusCode, httpResult.getStatusCode())) {
                String resultJson = httpResult.getContent();
                // 解析数据并持久化到Redis
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
    public void bitkanBTC() {
        try {
            /*
             * 待采集币种
             */
            String[] btcs = new String[]{"btc", "ltc", "etc"};
            
            String param1 = "{\"categoryId\":\"btc\"}";
            HttpResult httpResult1 = httpUtil.doPostJson("http://bitkan.com/price/w_price", param1);
            int statusCode1 = 200;
            if (Objects.equals(statusCode1, httpResult1.getStatusCode())) {
                String resultJson = httpResult1.getContent();
                dataParser.parserBikan("btc", resultJson, 0);
            }
            String param2 = "{\"categoryId\":\"ltc\"}";
            HttpResult httpResult2 = httpUtil.doPostJson("http://bitkan.com/price/w_price", param2);
            int statusCode2 = 200;
            if (Objects.equals(statusCode2, httpResult2.getStatusCode())) {
                String resultJson = httpResult2.getContent();
                dataParser.parserBikan("ltc", resultJson, 1);
            }
            String param3 = "{\"categoryId\":\"etc\"}";
            HttpResult httpResult3 = httpUtil.doPostJson("http://bitkan.com/price/w_price", param3);
            int statusCode = 200;
            if (Objects.equals(statusCode, httpResult3.getStatusCode())) {
                String resultJson = httpResult3.getContent();
                dataParser.parserBikan("etc", resultJson, 6);
            }
            LOGGER.info("bikanBTC采集正常");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
