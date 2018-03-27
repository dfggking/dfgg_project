package com.ads.service.impl;

import com.ads.common.base.BaseService;
import com.ads.entity.Forex;
import com.ads.service.ForexService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/15
 */
@Service
public class ForexServiceImpl extends BaseService implements ForexService {
    private final static Logger LOGGER = LogManager.getLogger(ForexServiceImpl.class);
    
    /**
     * 获取所有外汇信息
     * @return List
     */
    @Override
    public List getAllForex() {
//        hibernateTemplate
        return null;
    }
    
    /**
     * zhongnfuMarket 用于ADS数据采集
     */
    @Override
    public void zfMarket() {
    
    }
    
    /**
     * 批量增加 外汇信息
     * @param list
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addBatch(List<Forex> list) {
        for (Forex f : list) {
            hibernateTemplate.save(f);
        }
    }
}
