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
     * https://tvc4.forexpros.com/e6da7627478c36c2df0784dca86630c5/1552703924/6/6/28/quotes?symbols=Bitfinex:BTC/USD,Bitfinex:ETH/USD,ZB_COM:LTC/USD,,Bittrex:BCH/BTC
     */
    @Override
    public void bitkanBTC() {
        try {
            String content = httpUtil.doGet("https://tvc4.forexpros.com/e6da7627478c36c2df0784dca86630c5/1552703924/6/6/28/quotes?symbols=Bitfinex:BTC/USD,Bitfinex:ETH/USD,ZB_COM:LTC/USD,,Bittrex:BCH/BTC");
            dataParser.parserBikan(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
