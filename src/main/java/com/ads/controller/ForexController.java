package com.ads.controller;

import com.ads.common.base.BaseController;
import com.ads.datatask.DataScan;
import com.ads.service.ForexService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 外汇数据 Controller
 *
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/27
 */
@Controller
@RequestMapping(value = "forex")
public class ForexController extends BaseController {
    private final static Logger LOGGER = Logger.getLogger(ForexController.class);
    /**
     * 外汇网站数据接口
     */
    private final static String ZFMARKET_FOREX_DATA = "zfMarket";
    /**
     * 外汇网站BTC接口
     */
    private final static String BTC_FOREX_DATA = "btcMarket";
    /**
     * 最新外汇价格信息
     */
    private final static String REAL_TIME_FOREX = "realTimeForex";
    
    private final static String FOREX_LIST = "list";
    
    @Autowired
    private ForexService forexService;
    @Autowired
    private DataScan ds;
    
    /**
     * 外汇网站数据接口
     * @return
     */
    @RequestMapping(value = ZFMARKET_FOREX_DATA)
    @ResponseBody
    public Map zfMarket(){
        Map resultMap = new HashMap(16);
        resultMap.put("result", ds.zhongfuMarketDataScan());
        return resultMap;
    }
    
    @RequestMapping(value = BTC_FOREX_DATA)
    @ResponseBody
    public Map btcMarket() {
        Map resultMap = new HashMap(16);
        resultMap.put("result", ds.bitkanDataScan());
        return resultMap;
    }
    
    /**
     * 获取最新外汇价格
     * @return
     */
    @RequestMapping(value = REAL_TIME_FOREX)
    @ResponseBody
    public Map realTimeForex(){
        Map resultMap = new HashMap(16);
        return resultMap;
    }
}
