package com.ads.controller;

import com.ads.common.base.BaseController;
import com.ads.service.ForexService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务API接口
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2018/2/27
 */
@Controller
@RequestMapping(value = "api")
public class ApiController extends BaseController {
    
    private final static Logger LOGGER = LogManager.getLogger(ApiController.class);
    
    /**
     * 外汇对外服务接口
     */
    public final static String FOREX_SERVER = "forex";
    
    private ForexService forexService;
    
    @RequestMapping(value = FOREX_SERVER)
    @ResponseBody
    public Map<String, Object> forex(){
        
        
        forexService.getAllForex();
        
        Map<String, Object> resultMap = new HashMap<>(16);
        return resultMap;
    }
    
    
}
