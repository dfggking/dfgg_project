package com.ads.service;

import com.ads.entity.Forex;

import java.util.List;

/**
 * 外汇表service
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/15
 */
public interface ForexService {
    
    /**
     * 批量增加 外汇信息
     * @param list
     */
    void addBatch(List<Forex> list);
}
