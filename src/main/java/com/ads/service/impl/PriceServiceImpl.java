package com.ads.service.impl;

import com.ads.common.base.BaseService;
import com.ads.entity.Price;
import com.ads.service.PriceService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/14
 */
@Service
public class PriceServiceImpl extends BaseService implements PriceService {
    
    private final static Logger LOGGER = LogManager.getLogger(PriceServiceImpl.class);
    
    
    
    /**
     * 批量添加
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addBatch(List<Price> list) {
    
//        for (Price p : list) {
//            hibernateTemplate.save(p);
//        }
    }
}
