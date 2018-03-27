package com.ads.service;

import com.ads.entity.Forex;

import java.util.List;
import java.util.Map;

/**
 * 外汇表service
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/15
 */
public interface ForexService {
    
    /**
     * 获取所有外汇信息
     * @return List
     */
    List getAllForex();
    
    /**
     * zhongnfuMarket 用于ADS数据采集
     */
    void zfMarket();
    
    /**
     * 批量增加 外汇信息
     * @param list
     */
    void addBatch(List<Forex> list);
}
