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
    
}
