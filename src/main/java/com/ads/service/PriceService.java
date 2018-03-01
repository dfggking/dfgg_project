package com.ads.service;

import com.ads.entity.Price;

import java.util.List;

/**
 * 价格 service
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/14
 */
public interface PriceService {

    /**
     * 批量添加
     * @param list
     */
    void addBatch(List<Price> list);
}
