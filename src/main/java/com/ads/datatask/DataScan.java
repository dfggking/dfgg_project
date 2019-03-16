package com.ads.datatask;

import java.util.List;
import java.util.Map;

/**
 * 数据采集 接口
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/14
 */
public interface DataScan {
    
    /**
     * 1、新浪外汇采集器
     */
    void sinaForex();

    /**
     * 2、BTC采集器
     * https://tvc4.forexpros.com/e6da7627478c36c2df0784dca86630c5/1552703924/6/6/28/quotes?symbols=Bitfinex:BTC/USD,Bitfinex:ETH/USD,ZB_COM:LTC/USD,,Bittrex:BCH/BTC
     */
    void bitkanBTC();
    
}
