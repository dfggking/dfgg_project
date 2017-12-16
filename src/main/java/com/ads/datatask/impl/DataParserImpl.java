package com.ads.datatask.impl;

import com.ads.common.util.UUIDUtils;
import com.ads.datatask.DataParser;
import com.ads.entity.Price;
import com.ads.service.PriceService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
        JSONObject dataJsonObject = JSON.parseObject(content);
        JSONArray dataList = dataJsonObject.getJSONArray("list");
        List<Price> list = new ArrayList<>();
        for (Object entry : dataList) {
            Map<String, String> forex = (Map<String, String>)entry;
            Price price = new Price();
            price.setId(UUIDUtils.getUUID());
            price.setSymbolCode(forex.get("symbolCode"));
            price.setSymbolId(forex.get("symbolId"));
            price.setSymbolName((String) forex.get("symbolName"));
            price.setClose(new BigDecimal(forex.get("close")));
            price.setOpen(new BigDecimal(forex.get("open")));
            price.setLow(new BigDecimal(forex.get("low")));
            price.setHigh(new BigDecimal(forex.get("high")));
            price.setPltd(new BigDecimal(forex.get("pltd")));
            price.setRatio(new BigDecimal(forex.get("ratio")));
            price.setBuyPrice(new BigDecimal(forex.get("buyPrice")));
            price.setSellPrice(new BigDecimal(forex.get("sellPrice")));
            price.setCreatedTime(new Timestamp(System.currentTimeMillis()));
            price.setFromAddress("外汇通");
            price.setFromName("外汇通");
            list.add(price);
        }
        priceService.addBatch(list);
    }


}
