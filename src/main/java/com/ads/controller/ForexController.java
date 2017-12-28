package com.ads.controller;

import com.ads.common.base.BaseController;
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
     * 最新外汇价格信息
     */
    private final static String REAL_TIME_FOREX = "realTimeForex";
    
    private final static String FOREX_LIST = "list";
    
    @Autowired
    private ForexService forexService;
    
    /**
     * 获取最新外汇价格
     * @return
     */
    @RequestMapping(value = REAL_TIME_FOREX)
    @ResponseBody
    public Map realTimeForex(){
        Map resultMap = new HashMap(16);
        
//        forexService.getRealTimeForex();
        
        return resultMap;
    }
}
