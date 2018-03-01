package com.ads.controller;

import com.ads.common.base.BaseController;
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
    
    private final static Logger LOGGER = Logger.getLogger(ApiController.class);
    
    @RequestMapping(value = "price")
    @ResponseBody
    public Map<String, Object> price(){
        
        Map<String, Object> resultMap = new HashMap<>(16);
        return resultMap;
    }
}
