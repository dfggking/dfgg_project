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
     * 中福ADS 数据接口
     * url http://market.forex.com.cn/zhongfuMarketIndex/findAllPriceAjax.do
     */
    void zhongfuMarket();
    
    /**
     * 来自网站request URL
     * website http://market.forex.com.cn
     * url http://market.forex.com.cn/zhongfuMarketIndex/ajaxTable.do
     */
    void zhongfu();
    
    /**
     * bitkan网站request URL
     * website http://bitkan.com/price/
     * url http://bitkan.com/price/w_price?categoryId=***
     */
    List<Map<String, Object>> bitkan();
    
    
}
