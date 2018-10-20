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
     * bitkan网站request URL
     * website http://bitkan.com/price/
     * url http://bitkan.com/price/w_price?categoryId=***
     */
    void bitkanBTC();
    
}
