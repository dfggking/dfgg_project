package com.ads.datatask.impl;

import com.ads.common.util.UUIDUtils;
import com.ads.datatask.DataParser;
import com.ads.entity.Price;
import com.ads.service.PriceService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/14
 */
@Service
public class DataParserImpl implements DataParser {

    private final static Logger LOGGER = LogManager.getLogger(DataParserImpl.class);

    @Autowired
    private PriceService priceService;

    /**
     * 外汇通 数据解析
     */
    @Override
    public void parserWaiHuiTong(String content) {
        JSONObject json = JSON.parseObject(content);
        List<Price> list = new ArrayList<>();
        for (Map.Entry<String, Object> entry : json.entrySet()) {
            Price price = new Price();
            price.setId(UUIDUtils.getUUID());
            price.setSymbolCode(entry.getKey());
            Map info = (Map) entry.getValue();
            price.setBid(new BigDecimal((String) info.get("buyPrice")));
            price.setAsk(new BigDecimal((String) info.get("sellPrice")));
            list.add(price);
        }
        priceService.addBatch(list);
    }


}
